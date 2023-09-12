"""
Copyright (C) 2020  Centre for Argument Technology (http://arg.tech)
              2023  Giacomo Bergami <giacomobergami@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
"""

from dgdl.antlr import *
from . import utility
from .BaseDGDLBuilder import BaseDGDLBuilder
from dgdl.elements import Conditional
from dgdl.elements.effects import *
from dgdl.elements.requirements import *

class RuleInteractionBuilder(BaseDGDLBuilder):

    ''' Base class for building Rules and Interactions. They share a common
        RuleBody type for effects but need specific respective implementations
        for how to handle their delcarations'''

    def __init__(self):
        self.current_effect_target = None
        self.conditionals = []
        self.current_conditional = None

        self.conditional_requirements = []
        self.current_conditional_requirement = {}

        # self.current_conditional_negated = False

    def enterRuleBody(self, ctx):
        self.current_effect_target = self.add_effect

    def enterConditional(self, ctx):
        self.current_conditional = Conditional()
        self.current_effect_target = self.current_conditional.add_effect

    def enterCondelseif(self, ctx):
        elseif = Conditional()
        self.current_effect_target = elseif.add_effect
        self.current_conditional.add_elseif(elseif)

    def enterCondelse(self, ctx):
        self.current_effect_target = self.current_conditional.add_else_effect

    def exitConditional(self, ctx):
        self.add_conditional(self.current_conditional)

    def enterCondition(self, ctx):
        pass
        # if ctx.NEG() is not None:
        # if ctx.NEG().getText() == '!':
        # self.current_conditional_negated = True

    def exitCondition(self, ctx):
        pass
        # self.current_conditional_negated = False

    def enterRoleInspection(self, ctx):
        playerID = ctx.playerID().getText()
        role = ctx.role().getText()
        self.current_conditional.add_requirement(InRoleRequirement(False, playerID, role))

    def enterStoreComparison(self, ctx: dgdlParser.StoreComparisonContext):
        c1, c2 = ctx.store1().getText(), ctx.store2().getText()
        p1, p2 = ctx.user1().getText(), ctx.user2().getText()
        self.current_conditional.add_requirement(tuple([c1,p1,ctx.comparison().getText(),c2,p2]))

    def enterStoreInspection(self, ctx):
        storepos = ctx.storepos().getText()
        content = ctx.commitment()
        if content is not None:
            if content.content() is not None:
                content = utility.parse_content(content.content())
            else:
                raise Exception("Unsupported argument!")
        # content = [c.getText() for c in content.contentVar()] + [s.getText() for s in content.STRINGLITERAL()]
        storeID = ctx.storeName().getText()

        user = ctx.user()
        if user is not None:
            user = user.getText()

        storetime = None
        if ctx.INITIAL() is not None:
            storetime = "initial"
        if ctx.PAST() is not None:
            storetime = "past"
        if ctx.CURRENT() is not None:
            storetime = "current"

        inspect = InspectRequirement(storepos[0]=='!', storepos, content, storeID, user, storetime)
        self.current_conditional.add_requirement(inspect)

    def enterEvent(self, ctx):
        eventpos = ctx.eventpos().getText()
        moveID = ctx.moveID().getText()
        content = utility.parse_content(ctx.content())
        user = ctx.user()
        if user is not None:
            user = user.getText()
        event = EventRequirement(eventpos[0]=='!', eventpos, moveID, content, user)
        self.current_conditional.add_requirement(event)

    def enterMove(self, ctx):
        action = ctx.moveaction().getText()
        time = ctx.movetime().getText()
        id = ctx.moveID().getText()

        addressee = ctx.addressee()
        content = ctx.content()
        user = ctx.user()

        if addressee is not None:
            addressee = addressee.getText()

        content = utility.parse_content(content)
        # if content is not None:
        #     content = [c.getText() for c in content.contentVar()] + [c.getText() for c in content.runtimeVar()]

        if user is not None:
            user = user.getText()

        self.current_effect_target(MoveEffect(action, time, id, addressee, content, user))

    def enterStoreOp(self, ctx):
        action = ctx.storeaction().getText()
        content = utility.parse_content(ctx.content())
        # content = [c.getText() for c in content.contentVar()] + [s.getText() for s in content.STRINGLITERAL()]
        id = ctx.storeName().getText()
        is_variable = ctx.DOLLAR() is not None
        self.current_effect_target(StoreOpEffect(action, content, id, is_variable))

    def enterStatusUpdate(self, ctx):
        status = ctx.status().getText()
        id = ctx.sysgame().getText()
        self.current_effect_target(StatusUpdateEffect(status, id))

    def enterAssignment(self, ctx):
        user = ctx.user().getText()
        role = ctx.role().getText()
        self.current_effect_target(AssignEffect(user, role))

    def enterUnassignment(self, ctx):
        user = ctx.user().getText()
        role = ctx.role().getText()
        self.current_effect_target(UnassignEffect(user, role))

    def enterSave(self, ctx):
        content = ctx.storeContent()
        content = [c.getText() for c in content.contentVar()] + [s.getText() for s in content.STRINGLITERAL()]
        variable = ctx.runtimeVar().identifier().getText()
        self.current_effect_target(SaveEffect(content, variable))

    def enterUriTest(self, ctx):
        id = ctx.extUriID().getText()
        uri = URITestRequirement(self.current_conditional_negated, id)
        self.current_conditional.add_requirement(uri)

    # Methods to be overridden by child classes
    def add_effect(self, effect):
        return

    def add_conditional(self, conditional):
        return
