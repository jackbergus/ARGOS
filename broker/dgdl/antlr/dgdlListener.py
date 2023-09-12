# Generated from dgdl/antlr/dgdl.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .dgdlParser import dgdlParser
else:
    from dgdlParser import dgdlParser

# This class defines a complete listener for a parse tree produced by dgdlParser.
class dgdlListener(ParseTreeListener):

    # Enter a parse tree produced by dgdlParser#system.
    def enterSystem(self, ctx:dgdlParser.SystemContext):
        pass

    # Exit a parse tree produced by dgdlParser#system.
    def exitSystem(self, ctx:dgdlParser.SystemContext):
        pass


    # Enter a parse tree produced by dgdlParser#systemID.
    def enterSystemID(self, ctx:dgdlParser.SystemIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#systemID.
    def exitSystemID(self, ctx:dgdlParser.SystemIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#game.
    def enterGame(self, ctx:dgdlParser.GameContext):
        pass

    # Exit a parse tree produced by dgdlParser#game.
    def exitGame(self, ctx:dgdlParser.GameContext):
        pass


    # Enter a parse tree produced by dgdlParser#gameID.
    def enterGameID(self, ctx:dgdlParser.GameIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#gameID.
    def exitGameID(self, ctx:dgdlParser.GameIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#composition.
    def enterComposition(self, ctx:dgdlParser.CompositionContext):
        pass

    # Exit a parse tree produced by dgdlParser#composition.
    def exitComposition(self, ctx:dgdlParser.CompositionContext):
        pass


    # Enter a parse tree produced by dgdlParser#turns.
    def enterTurns(self, ctx:dgdlParser.TurnsContext):
        pass

    # Exit a parse tree produced by dgdlParser#turns.
    def exitTurns(self, ctx:dgdlParser.TurnsContext):
        pass


    # Enter a parse tree produced by dgdlParser#turnSize.
    def enterTurnSize(self, ctx:dgdlParser.TurnSizeContext):
        pass

    # Exit a parse tree produced by dgdlParser#turnSize.
    def exitTurnSize(self, ctx:dgdlParser.TurnSizeContext):
        pass


    # Enter a parse tree produced by dgdlParser#ordering.
    def enterOrdering(self, ctx:dgdlParser.OrderingContext):
        pass

    # Exit a parse tree produced by dgdlParser#ordering.
    def exitOrdering(self, ctx:dgdlParser.OrderingContext):
        pass


    # Enter a parse tree produced by dgdlParser#maxTurns.
    def enterMaxTurns(self, ctx:dgdlParser.MaxTurnsContext):
        pass

    # Exit a parse tree produced by dgdlParser#maxTurns.
    def exitMaxTurns(self, ctx:dgdlParser.MaxTurnsContext):
        pass


    # Enter a parse tree produced by dgdlParser#runTimeVar.
    def enterRunTimeVar(self, ctx:dgdlParser.RunTimeVarContext):
        pass

    # Exit a parse tree produced by dgdlParser#runTimeVar.
    def exitRunTimeVar(self, ctx:dgdlParser.RunTimeVarContext):
        pass


    # Enter a parse tree produced by dgdlParser#roleList.
    def enterRoleList(self, ctx:dgdlParser.RoleListContext):
        pass

    # Exit a parse tree produced by dgdlParser#roleList.
    def exitRoleList(self, ctx:dgdlParser.RoleListContext):
        pass


    # Enter a parse tree produced by dgdlParser#role.
    def enterRole(self, ctx:dgdlParser.RoleContext):
        pass

    # Exit a parse tree produced by dgdlParser#role.
    def exitRole(self, ctx:dgdlParser.RoleContext):
        pass


    # Enter a parse tree produced by dgdlParser#participants.
    def enterParticipants(self, ctx:dgdlParser.ParticipantsContext):
        pass

    # Exit a parse tree produced by dgdlParser#participants.
    def exitParticipants(self, ctx:dgdlParser.ParticipantsContext):
        pass


    # Enter a parse tree produced by dgdlParser#minplayers.
    def enterMinplayers(self, ctx:dgdlParser.MinplayersContext):
        pass

    # Exit a parse tree produced by dgdlParser#minplayers.
    def exitMinplayers(self, ctx:dgdlParser.MinplayersContext):
        pass


    # Enter a parse tree produced by dgdlParser#maxplayers.
    def enterMaxplayers(self, ctx:dgdlParser.MaxplayersContext):
        pass

    # Exit a parse tree produced by dgdlParser#maxplayers.
    def exitMaxplayers(self, ctx:dgdlParser.MaxplayersContext):
        pass


    # Enter a parse tree produced by dgdlParser#player.
    def enterPlayer(self, ctx:dgdlParser.PlayerContext):
        pass

    # Exit a parse tree produced by dgdlParser#player.
    def exitPlayer(self, ctx:dgdlParser.PlayerContext):
        pass


    # Enter a parse tree produced by dgdlParser#playerID.
    def enterPlayerID(self, ctx:dgdlParser.PlayerIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#playerID.
    def exitPlayerID(self, ctx:dgdlParser.PlayerIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#extURImap.
    def enterExtURImap(self, ctx:dgdlParser.ExtURImapContext):
        pass

    # Exit a parse tree produced by dgdlParser#extURImap.
    def exitExtURImap(self, ctx:dgdlParser.ExtURImapContext):
        pass


    # Enter a parse tree produced by dgdlParser#extURIID.
    def enterExtURIID(self, ctx:dgdlParser.ExtURIIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#extURIID.
    def exitExtURIID(self, ctx:dgdlParser.ExtURIIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#extURI.
    def enterExtURI(self, ctx:dgdlParser.ExtURIContext):
        pass

    # Exit a parse tree produced by dgdlParser#extURI.
    def exitExtURI(self, ctx:dgdlParser.ExtURIContext):
        pass


    # Enter a parse tree produced by dgdlParser#store.
    def enterStore(self, ctx:dgdlParser.StoreContext):
        pass

    # Exit a parse tree produced by dgdlParser#store.
    def exitStore(self, ctx:dgdlParser.StoreContext):
        pass


    # Enter a parse tree produced by dgdlParser#storeName.
    def enterStoreName(self, ctx:dgdlParser.StoreNameContext):
        pass

    # Exit a parse tree produced by dgdlParser#storeName.
    def exitStoreName(self, ctx:dgdlParser.StoreNameContext):
        pass


    # Enter a parse tree produced by dgdlParser#storeOwner.
    def enterStoreOwner(self, ctx:dgdlParser.StoreOwnerContext):
        pass

    # Exit a parse tree produced by dgdlParser#storeOwner.
    def exitStoreOwner(self, ctx:dgdlParser.StoreOwnerContext):
        pass


    # Enter a parse tree produced by dgdlParser#storeStructure.
    def enterStoreStructure(self, ctx:dgdlParser.StoreStructureContext):
        pass

    # Exit a parse tree produced by dgdlParser#storeStructure.
    def exitStoreStructure(self, ctx:dgdlParser.StoreStructureContext):
        pass


    # Enter a parse tree produced by dgdlParser#visibility.
    def enterVisibility(self, ctx:dgdlParser.VisibilityContext):
        pass

    # Exit a parse tree produced by dgdlParser#visibility.
    def exitVisibility(self, ctx:dgdlParser.VisibilityContext):
        pass


    # Enter a parse tree produced by dgdlParser#backtrack.
    def enterBacktrack(self, ctx:dgdlParser.BacktrackContext):
        pass

    # Exit a parse tree produced by dgdlParser#backtrack.
    def exitBacktrack(self, ctx:dgdlParser.BacktrackContext):
        pass


    # Enter a parse tree produced by dgdlParser#rule.
    def enterRule(self, ctx:dgdlParser.RuleContext):
        pass

    # Exit a parse tree produced by dgdlParser#rule.
    def exitRule(self, ctx:dgdlParser.RuleContext):
        pass


    # Enter a parse tree produced by dgdlParser#ruleID.
    def enterRuleID(self, ctx:dgdlParser.RuleIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#ruleID.
    def exitRuleID(self, ctx:dgdlParser.RuleIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#scopeType.
    def enterScopeType(self, ctx:dgdlParser.ScopeTypeContext):
        pass

    # Exit a parse tree produced by dgdlParser#scopeType.
    def exitScopeType(self, ctx:dgdlParser.ScopeTypeContext):
        pass


    # Enter a parse tree produced by dgdlParser#ruleBody.
    def enterRuleBody(self, ctx:dgdlParser.RuleBodyContext):
        pass

    # Exit a parse tree produced by dgdlParser#ruleBody.
    def exitRuleBody(self, ctx:dgdlParser.RuleBodyContext):
        pass


    # Enter a parse tree produced by dgdlParser#effects.
    def enterEffects(self, ctx:dgdlParser.EffectsContext):
        pass

    # Exit a parse tree produced by dgdlParser#effects.
    def exitEffects(self, ctx:dgdlParser.EffectsContext):
        pass


    # Enter a parse tree produced by dgdlParser#effect.
    def enterEffect(self, ctx:dgdlParser.EffectContext):
        pass

    # Exit a parse tree produced by dgdlParser#effect.
    def exitEffect(self, ctx:dgdlParser.EffectContext):
        pass


    # Enter a parse tree produced by dgdlParser#parameter.
    def enterParameter(self, ctx:dgdlParser.ParameterContext):
        pass

    # Exit a parse tree produced by dgdlParser#parameter.
    def exitParameter(self, ctx:dgdlParser.ParameterContext):
        pass


    # Enter a parse tree produced by dgdlParser#content.
    def enterContent(self, ctx:dgdlParser.ContentContext):
        pass

    # Exit a parse tree produced by dgdlParser#content.
    def exitContent(self, ctx:dgdlParser.ContentContext):
        pass


    # Enter a parse tree produced by dgdlParser#contentItem.
    def enterContentItem(self, ctx:dgdlParser.ContentItemContext):
        pass

    # Exit a parse tree produced by dgdlParser#contentItem.
    def exitContentItem(self, ctx:dgdlParser.ContentItemContext):
        pass


    # Enter a parse tree produced by dgdlParser#contentSet.
    def enterContentSet(self, ctx:dgdlParser.ContentSetContext):
        pass

    # Exit a parse tree produced by dgdlParser#contentSet.
    def exitContentSet(self, ctx:dgdlParser.ContentSetContext):
        pass


    # Enter a parse tree produced by dgdlParser#contentVar.
    def enterContentVar(self, ctx:dgdlParser.ContentVarContext):
        pass

    # Exit a parse tree produced by dgdlParser#contentVar.
    def exitContentVar(self, ctx:dgdlParser.ContentVarContext):
        pass


    # Enter a parse tree produced by dgdlParser#contentStr.
    def enterContentStr(self, ctx:dgdlParser.ContentStrContext):
        pass

    # Exit a parse tree produced by dgdlParser#contentStr.
    def exitContentStr(self, ctx:dgdlParser.ContentStrContext):
        pass


    # Enter a parse tree produced by dgdlParser#conditional.
    def enterConditional(self, ctx:dgdlParser.ConditionalContext):
        pass

    # Exit a parse tree produced by dgdlParser#conditional.
    def exitConditional(self, ctx:dgdlParser.ConditionalContext):
        pass


    # Enter a parse tree produced by dgdlParser#condelseif.
    def enterCondelseif(self, ctx:dgdlParser.CondelseifContext):
        pass

    # Exit a parse tree produced by dgdlParser#condelseif.
    def exitCondelseif(self, ctx:dgdlParser.CondelseifContext):
        pass


    # Enter a parse tree produced by dgdlParser#condelse.
    def enterCondelse(self, ctx:dgdlParser.CondelseContext):
        pass

    # Exit a parse tree produced by dgdlParser#condelse.
    def exitCondelse(self, ctx:dgdlParser.CondelseContext):
        pass


    # Enter a parse tree produced by dgdlParser#requirements.
    def enterRequirements(self, ctx:dgdlParser.RequirementsContext):
        pass

    # Exit a parse tree produced by dgdlParser#requirements.
    def exitRequirements(self, ctx:dgdlParser.RequirementsContext):
        pass


    # Enter a parse tree produced by dgdlParser#condition.
    def enterCondition(self, ctx:dgdlParser.ConditionContext):
        pass

    # Exit a parse tree produced by dgdlParser#condition.
    def exitCondition(self, ctx:dgdlParser.ConditionContext):
        pass


    # Enter a parse tree produced by dgdlParser#interaction.
    def enterInteraction(self, ctx:dgdlParser.InteractionContext):
        pass

    # Exit a parse tree produced by dgdlParser#interaction.
    def exitInteraction(self, ctx:dgdlParser.InteractionContext):
        pass


    # Enter a parse tree produced by dgdlParser#addressee.
    def enterAddressee(self, ctx:dgdlParser.AddresseeContext):
        pass

    # Exit a parse tree produced by dgdlParser#addressee.
    def exitAddressee(self, ctx:dgdlParser.AddresseeContext):
        pass


    # Enter a parse tree produced by dgdlParser#target.
    def enterTarget(self, ctx:dgdlParser.TargetContext):
        pass

    # Exit a parse tree produced by dgdlParser#target.
    def exitTarget(self, ctx:dgdlParser.TargetContext):
        pass


    # Enter a parse tree produced by dgdlParser#schemeApp.
    def enterSchemeApp(self, ctx:dgdlParser.SchemeAppContext):
        pass

    # Exit a parse tree produced by dgdlParser#schemeApp.
    def exitSchemeApp(self, ctx:dgdlParser.SchemeAppContext):
        pass


    # Enter a parse tree produced by dgdlParser#forcetarget.
    def enterForcetarget(self, ctx:dgdlParser.ForcetargetContext):
        pass

    # Exit a parse tree produced by dgdlParser#forcetarget.
    def exitForcetarget(self, ctx:dgdlParser.ForcetargetContext):
        pass


    # Enter a parse tree produced by dgdlParser#forceID.
    def enterForceID(self, ctx:dgdlParser.ForceIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#forceID.
    def exitForceID(self, ctx:dgdlParser.ForceIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#opener.
    def enterOpener(self, ctx:dgdlParser.OpenerContext):
        pass

    # Exit a parse tree produced by dgdlParser#opener.
    def exitOpener(self, ctx:dgdlParser.OpenerContext):
        pass


    # Enter a parse tree produced by dgdlParser#event.
    def enterEvent(self, ctx:dgdlParser.EventContext):
        pass

    # Exit a parse tree produced by dgdlParser#event.
    def exitEvent(self, ctx:dgdlParser.EventContext):
        pass


    # Enter a parse tree produced by dgdlParser#eventpos.
    def enterEventpos(self, ctx:dgdlParser.EventposContext):
        pass

    # Exit a parse tree produced by dgdlParser#eventpos.
    def exitEventpos(self, ctx:dgdlParser.EventposContext):
        pass


    # Enter a parse tree produced by dgdlParser#storeInspection.
    def enterStoreInspection(self, ctx:dgdlParser.StoreInspectionContext):
        pass

    # Exit a parse tree produced by dgdlParser#storeInspection.
    def exitStoreInspection(self, ctx:dgdlParser.StoreInspectionContext):
        pass


    # Enter a parse tree produced by dgdlParser#storepos.
    def enterStorepos(self, ctx:dgdlParser.StoreposContext):
        pass

    # Exit a parse tree produced by dgdlParser#storepos.
    def exitStorepos(self, ctx:dgdlParser.StoreposContext):
        pass


    # Enter a parse tree produced by dgdlParser#roleInspection.
    def enterRoleInspection(self, ctx:dgdlParser.RoleInspectionContext):
        pass

    # Exit a parse tree produced by dgdlParser#roleInspection.
    def exitRoleInspection(self, ctx:dgdlParser.RoleInspectionContext):
        pass


    # Enter a parse tree produced by dgdlParser#magnitude.
    def enterMagnitude(self, ctx:dgdlParser.MagnitudeContext):
        pass

    # Exit a parse tree produced by dgdlParser#magnitude.
    def exitMagnitude(self, ctx:dgdlParser.MagnitudeContext):
        pass


    # Enter a parse tree produced by dgdlParser#container.
    def enterContainer(self, ctx:dgdlParser.ContainerContext):
        pass

    # Exit a parse tree produced by dgdlParser#container.
    def exitContainer(self, ctx:dgdlParser.ContainerContext):
        pass


    # Enter a parse tree produced by dgdlParser#containersize.
    def enterContainersize(self, ctx:dgdlParser.ContainersizeContext):
        pass

    # Exit a parse tree produced by dgdlParser#containersize.
    def exitContainersize(self, ctx:dgdlParser.ContainersizeContext):
        pass


    # Enter a parse tree produced by dgdlParser#storeComparison.
    def enterStoreComparison(self, ctx:dgdlParser.StoreComparisonContext):
        pass

    # Exit a parse tree produced by dgdlParser#storeComparison.
    def exitStoreComparison(self, ctx:dgdlParser.StoreComparisonContext):
        pass


    # Enter a parse tree produced by dgdlParser#comparison.
    def enterComparison(self, ctx:dgdlParser.ComparisonContext):
        pass

    # Exit a parse tree produced by dgdlParser#comparison.
    def exitComparison(self, ctx:dgdlParser.ComparisonContext):
        pass


    # Enter a parse tree produced by dgdlParser#store1.
    def enterStore1(self, ctx:dgdlParser.Store1Context):
        pass

    # Exit a parse tree produced by dgdlParser#store1.
    def exitStore1(self, ctx:dgdlParser.Store1Context):
        pass


    # Enter a parse tree produced by dgdlParser#user1.
    def enterUser1(self, ctx:dgdlParser.User1Context):
        pass

    # Exit a parse tree produced by dgdlParser#user1.
    def exitUser1(self, ctx:dgdlParser.User1Context):
        pass


    # Enter a parse tree produced by dgdlParser#store2.
    def enterStore2(self, ctx:dgdlParser.Store2Context):
        pass

    # Exit a parse tree produced by dgdlParser#store2.
    def exitStore2(self, ctx:dgdlParser.Store2Context):
        pass


    # Enter a parse tree produced by dgdlParser#user2.
    def enterUser2(self, ctx:dgdlParser.User2Context):
        pass

    # Exit a parse tree produced by dgdlParser#user2.
    def exitUser2(self, ctx:dgdlParser.User2Context):
        pass


    # Enter a parse tree produced by dgdlParser#dialogueSize.
    def enterDialogueSize(self, ctx:dgdlParser.DialogueSizeContext):
        pass

    # Exit a parse tree produced by dgdlParser#dialogueSize.
    def exitDialogueSize(self, ctx:dgdlParser.DialogueSizeContext):
        pass


    # Enter a parse tree produced by dgdlParser#correspondence.
    def enterCorrespondence(self, ctx:dgdlParser.CorrespondenceContext):
        pass

    # Exit a parse tree produced by dgdlParser#correspondence.
    def exitCorrespondence(self, ctx:dgdlParser.CorrespondenceContext):
        pass


    # Enter a parse tree produced by dgdlParser#relation.
    def enterRelation(self, ctx:dgdlParser.RelationContext):
        pass

    # Exit a parse tree produced by dgdlParser#relation.
    def exitRelation(self, ctx:dgdlParser.RelationContext):
        pass


    # Enter a parse tree produced by dgdlParser#currentPlayer.
    def enterCurrentPlayer(self, ctx:dgdlParser.CurrentPlayerContext):
        pass

    # Exit a parse tree produced by dgdlParser#currentPlayer.
    def exitCurrentPlayer(self, ctx:dgdlParser.CurrentPlayerContext):
        pass


    # Enter a parse tree produced by dgdlParser#externalCondition.
    def enterExternalCondition(self, ctx:dgdlParser.ExternalConditionContext):
        pass

    # Exit a parse tree produced by dgdlParser#externalCondition.
    def exitExternalCondition(self, ctx:dgdlParser.ExternalConditionContext):
        pass


    # Enter a parse tree produced by dgdlParser#user.
    def enterUser(self, ctx:dgdlParser.UserContext):
        pass

    # Exit a parse tree produced by dgdlParser#user.
    def exitUser(self, ctx:dgdlParser.UserContext):
        pass


    # Enter a parse tree produced by dgdlParser#schemeID.
    def enterSchemeID(self, ctx:dgdlParser.SchemeIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#schemeID.
    def exitSchemeID(self, ctx:dgdlParser.SchemeIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#commitment.
    def enterCommitment(self, ctx:dgdlParser.CommitmentContext):
        pass

    # Exit a parse tree produced by dgdlParser#commitment.
    def exitCommitment(self, ctx:dgdlParser.CommitmentContext):
        pass


    # Enter a parse tree produced by dgdlParser#locution.
    def enterLocution(self, ctx:dgdlParser.LocutionContext):
        pass

    # Exit a parse tree produced by dgdlParser#locution.
    def exitLocution(self, ctx:dgdlParser.LocutionContext):
        pass


    # Enter a parse tree produced by dgdlParser#argument.
    def enterArgument(self, ctx:dgdlParser.ArgumentContext):
        pass

    # Exit a parse tree produced by dgdlParser#argument.
    def exitArgument(self, ctx:dgdlParser.ArgumentContext):
        pass


    # Enter a parse tree produced by dgdlParser#premises.
    def enterPremises(self, ctx:dgdlParser.PremisesContext):
        pass

    # Exit a parse tree produced by dgdlParser#premises.
    def exitPremises(self, ctx:dgdlParser.PremisesContext):
        pass


    # Enter a parse tree produced by dgdlParser#conclusion.
    def enterConclusion(self, ctx:dgdlParser.ConclusionContext):
        pass

    # Exit a parse tree produced by dgdlParser#conclusion.
    def exitConclusion(self, ctx:dgdlParser.ConclusionContext):
        pass


    # Enter a parse tree produced by dgdlParser#move.
    def enterMove(self, ctx:dgdlParser.MoveContext):
        pass

    # Exit a parse tree produced by dgdlParser#move.
    def exitMove(self, ctx:dgdlParser.MoveContext):
        pass


    # Enter a parse tree produced by dgdlParser#moveaction.
    def enterMoveaction(self, ctx:dgdlParser.MoveactionContext):
        pass

    # Exit a parse tree produced by dgdlParser#moveaction.
    def exitMoveaction(self, ctx:dgdlParser.MoveactionContext):
        pass


    # Enter a parse tree produced by dgdlParser#movetime.
    def enterMovetime(self, ctx:dgdlParser.MovetimeContext):
        pass

    # Exit a parse tree produced by dgdlParser#movetime.
    def exitMovetime(self, ctx:dgdlParser.MovetimeContext):
        pass


    # Enter a parse tree produced by dgdlParser#storeOp.
    def enterStoreOp(self, ctx:dgdlParser.StoreOpContext):
        pass

    # Exit a parse tree produced by dgdlParser#storeOp.
    def exitStoreOp(self, ctx:dgdlParser.StoreOpContext):
        pass


    # Enter a parse tree produced by dgdlParser#storeaction.
    def enterStoreaction(self, ctx:dgdlParser.StoreactionContext):
        pass

    # Exit a parse tree produced by dgdlParser#storeaction.
    def exitStoreaction(self, ctx:dgdlParser.StoreactionContext):
        pass


    # Enter a parse tree produced by dgdlParser#statusUpdate.
    def enterStatusUpdate(self, ctx:dgdlParser.StatusUpdateContext):
        pass

    # Exit a parse tree produced by dgdlParser#statusUpdate.
    def exitStatusUpdate(self, ctx:dgdlParser.StatusUpdateContext):
        pass


    # Enter a parse tree produced by dgdlParser#status.
    def enterStatus(self, ctx:dgdlParser.StatusContext):
        pass

    # Exit a parse tree produced by dgdlParser#status.
    def exitStatus(self, ctx:dgdlParser.StatusContext):
        pass


    # Enter a parse tree produced by dgdlParser#roleAssignment.
    def enterRoleAssignment(self, ctx:dgdlParser.RoleAssignmentContext):
        pass

    # Exit a parse tree produced by dgdlParser#roleAssignment.
    def exitRoleAssignment(self, ctx:dgdlParser.RoleAssignmentContext):
        pass


    # Enter a parse tree produced by dgdlParser#externalEffect.
    def enterExternalEffect(self, ctx:dgdlParser.ExternalEffectContext):
        pass

    # Exit a parse tree produced by dgdlParser#externalEffect.
    def exitExternalEffect(self, ctx:dgdlParser.ExternalEffectContext):
        pass


    # Enter a parse tree produced by dgdlParser#moveID.
    def enterMoveID(self, ctx:dgdlParser.MoveIDContext):
        pass

    # Exit a parse tree produced by dgdlParser#moveID.
    def exitMoveID(self, ctx:dgdlParser.MoveIDContext):
        pass


    # Enter a parse tree produced by dgdlParser#sysgame.
    def enterSysgame(self, ctx:dgdlParser.SysgameContext):
        pass

    # Exit a parse tree produced by dgdlParser#sysgame.
    def exitSysgame(self, ctx:dgdlParser.SysgameContext):
        pass


    # Enter a parse tree produced by dgdlParser#upperChar.
    def enterUpperChar(self, ctx:dgdlParser.UpperCharContext):
        pass

    # Exit a parse tree produced by dgdlParser#upperChar.
    def exitUpperChar(self, ctx:dgdlParser.UpperCharContext):
        pass


    # Enter a parse tree produced by dgdlParser#lowerChar.
    def enterLowerChar(self, ctx:dgdlParser.LowerCharContext):
        pass

    # Exit a parse tree produced by dgdlParser#lowerChar.
    def exitLowerChar(self, ctx:dgdlParser.LowerCharContext):
        pass


    # Enter a parse tree produced by dgdlParser#identifier.
    def enterIdentifier(self, ctx:dgdlParser.IdentifierContext):
        pass

    # Exit a parse tree produced by dgdlParser#identifier.
    def exitIdentifier(self, ctx:dgdlParser.IdentifierContext):
        pass


    # Enter a parse tree produced by dgdlParser#number.
    def enterNumber(self, ctx:dgdlParser.NumberContext):
        pass

    # Exit a parse tree produced by dgdlParser#number.
    def exitNumber(self, ctx:dgdlParser.NumberContext):
        pass



del dgdlParser