package jackbergus.protocol;

import jackbergus.utils.Monad.ErrorMonad;
import jackbergus.dgep.connections.ConnectionLogic.DialogueLogic;
import jackbergus.protocol.ProtocolService.ProtocolService;

@:keep
enum ProposerOrPublisherCases {
    ActionNotReady;
    UnknownError;
    CannotPopValues;
    UnexpectedNullArgumentFromPop;
    DuplicateServiceName;
    MissingAuthorArgument;
    MissingResponseArgument;
}

/**
 * This implements a readaptation of the publisher side of the protocol. The publisher will mainly publish the request, while all 
 * the subscribers will take the data and provide a reply.
 */
 @:keep
class ProposerOrPublisher {
    var protocol:ProtocolService;
    var fut:Bool;
    var next:Bool;
    var sp:String;
    var p:String;
    var po:String;
    var noargs:Map<String,String>;
    var busy:Bool;

    @:keep
    public function new(c:DialogueLogic, agentName:String="ARGA", sleep:Float=0.5, inFuture:Bool=false, inNext:Bool=true, busyWait:Bool=true) {
        protocol = new ProtocolService(c, agentName, sleep);
        fut = inFuture;
        next = inNext;
        p = "Publish";
        sp = "StartPublish";
        po = "PopOutcome";
        noargs = new Map<String,String>();
        busy = busyWait;
    }


    /**
     * [Returning all the possible actions that can be used by the current publisher (becase at least one subscriber subscribed for it)]
     * @param action            Action to be looked for. If none is provided, it just lists all the actions currently available
     * @return List<String>     Actions matching the given criteria
     */
     @:keep
    public function publishableActions(action:String = ""):List<String> {
        return protocol.doableActions(sp, next, fut,  action);
    }

    /**
     * Implementing the protocol associated to the request of running the action over the serivces
     * @param action                                                         Action to be performed
     * @return ErrorMonad<Map<String,String>, ProposerOrPublisherCases>      Returns an error if something went wrong, and the expected value instead
     */
     @:keep
    public function returnResultsFromSubscribers(action:String, data:String):ErrorMonad<Map<String,String>, ProposerOrPublisherCases> {
        // The results associated to the query are the association service/response to the specific requested action
        var results = Error("Unknown error", UnknownError); 

        // If no current action can be published, then immediately returning as no result can be obtained from the subscribers
        if (publishableActions(action).length == 0)
            return Error("Action " + action+ " not available", ActionNotReady);



        // StartPublishing||x||
        var result:Null<Map<String,String>> = null;
        {
            result = protocol.testAction(sp + action, noargs, "bogus", busy, next, fut);
            if (result == null) {
                return Error("Action "+action+" not available at testAction", ActionNotReady);
            }
        }


        // Publish||x||
        var countServices = 0;
        var publishableData:Map<String,String> = new Map<String,String>();
        publishableData.set("d", data);
        do {
            // Performing a publish operation until there are no more agents to be notified, in a non-blocking way
            result = protocol.testAction(p + action, publishableData, "bogus", false, next, fut);
            countServices++;
        } while (result != null);

        
        // PopOutcome||x||
        if (!protocol.isActionAvailable(po+ action, busy,next, fut)) {
            return Error("Cannot pop the outcome of "+action+" given the busyness: "+(busy? "true":"false"), CannotPopValues);
        }
        var m:Map<String,String>= new Map<String,String>();
        do {
            result = protocol.testAction(po+ action, noargs, "bogus", false, next, fut);
            countServices--;
            if ((result == null) && (countServices> 0))
                return Error("Expecting that the PopOutcome would return a value, but null was returned instead", UnexpectedNullArgumentFromPop);
            if (!result.exists("o"))
                return Error("Expecting a missing response argument!", MissingResponseArgument);
            var o = result.get("o");
            if (!result.exists("s"))
                return Error("Expecting a missing service name argument!", MissingAuthorArgument);
            var s = result.get("s");
            if (m.exists(s))
                return Error("Obtained a duplicate service name for: "+s, DuplicateServiceName);
            m.set(s, o);
        } while (result != null);


        return Good(m);
    }


}