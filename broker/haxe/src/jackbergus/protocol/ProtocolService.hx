package jackbergus.protocol;

import jackbergus.dgep.connections.ConnectionLogic.DialogueLogic;
import jackbergus.dgep.requests.Interaction;

/**
 * This class provides a first overlay over the dgdl protocol: this creates a class for one single agent, provides
 * the capability for testing whether the agent is currently allowed to perform a specific action, and the method
 * that will allow the agent to perform the action only if allowed by the protocol itself.
 * 
 */
 @:keep
class ProtocolService {
    var connection:DialogueLogic;
    var self:String;
    var s:Float;

    /**
     * Constructor providing the first overlay over the DGDL protocol. This is mainly for associating to the 
     * same agent the same name and the same connection to the broker (gdep-wp)
     * @param c 
     * @param agentName 
     * @param sleep 
     */
     @:keep
    public function new(c:DialogueLogic, agentName:String, sleep:Float=0.5) {
        connection = c;
        self = agentName;
        s=sleep;
    }

    /**
     * Returning the service name associated to the current object
     * @return String
     */
    public function getSelfServiceName():String {
        return self;
    }

    /*function generateNewSubscriptionToClient(process:String, client:String) {
        return testAction("Subscribe"+process, e, client, true, true, false);
    }*/

    /**
     * This returns a boolean determining whether the current agent can perform a specific action
     * 
     * @param action        Action that the agent wants to perform
     * @param inNext        Whether the action shall appear among the next values
     * @param inFuture      Whether the action shall appear among the future values
     */
     @:keep
    public function canIDoActionQM(action:String) {
        var m = connection.moves(self);
        if (!m.response.exists(self))
            return false;
        var myActions = m.response.get(self);
        for (x in myActions) {
            if (x.moveID == action) 
                return true;
        }
        return false;
    }

    /**
     * Listing all the actions that can be run by the current user (either in Next or in Future)
     * 
     * @param inNext        To appear in Next
     * @param inFuture      To appear in Future
     * @param pred          Testing predicate over the name of the action
     */
    public function availableActions( pred:String->Bool) {
        var l = new List<String>();
        var m = connection.moves(self);
        if (!m.response.exists(self))
            return l;
        for (x in m.available(self, pred))
            l.add(x);
        return l;
    } 

    /**
     * [Testing whether the given action is available]
     * @param action        Action to be tested
     * @param busyWait      On busy waiting, this will always return true, and will diverge indefinitely if this is never available by the protocol
     * @param inNext        To be tested in the next actions
     * @param inFuture      To be tested in the future actions
     * @return Bool
     */
    public function isActionAvailable(action:String, busyWait:Bool):Bool {
        if (busyWait)  {
            while (!canIDoActionQM(action))
                Sys.sleep(this.s);
            trace("Can perform action after busy waiting: "+action);
            return true;
        } else {
            var outcome:Bool = (canIDoActionQM(action));
            if (outcome)
                trace("Can immediately perform action: "+action);
            else 
                trace("Cannot immediately perform action: "+action);
            return outcome;
        }
    }

    /**
     * A testing of the action returns a null map if the action cannot be performed, so to distinguish this
     * from the occasion where the action can be run by the player while obtaining an empty response (no parameter was given)
     * 
     * @param action            Action that the agent wants to perform
     * @param args              Parameters associated to the action provided as an input by the agent
     * @param target            Target that should nominally receive the action (the actual protocol does not enforce this)
     * @param busyWait          Whether I need to wait until I can actually perform the action (busy waiting) or not
     * @param inNext            Whether the action that I want to perform shall occur as an immediately next action
     * @param inFuture          Whether the action that I want to perform shall occur as a future action
     */
     @:keep
    public function testAction(action:String, 
                        args:Map<String,String>,
                        target:String, 
                        busyWait:Bool
                        ) {
        var r:Null<Map<String,String>> = null;                    
        /*if (busyWait)  {
            while (!canIDoActionQM(action, inNext, inFuture))
                Sys.sleep(this.s);
        } else {
            if (!canIDoActionQM(action, inNext, inFuture))
                return r;
        }*/

        if (!isActionAvailable(action, busyWait)) 
            return r;
        var i = new Interaction(action, self, target);
        for (k => v in args)
            i.add(k, v);
        try {
            r = connection.interaction(i).data;
            return r;
        } catch(e) {
            trace(e.message);
            return r;
        }
    }


    public function doableActions(actionKind:String, action:String = ""):List<String> {
        if (action.length == 0) {
            return availableActions(function(x) return StringTools.startsWith(x, actionKind))
                    .map(function(x) return x.substr(actionKind.length));
        } else {
            return availableActions(function(x) return x == actionKind+action)
                    .map(function(x) return x.substr(actionKind.length));
        }

    }

    /*public function lifecycle(proces:String,cli:String) {
        do {
            if (generateNewSubscriptionToClient(proces, cli) == null)
                return false;
        } while (true);
        return true;
    }*/
}
