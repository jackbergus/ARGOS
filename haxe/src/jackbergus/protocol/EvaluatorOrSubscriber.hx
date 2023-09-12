package jackbergus.protocol;

import jackbergus.utils.Monad.ErrorMonad;
import jackbergus.dgep.connections.ConnectionLogic.DialogueLogic;
import jackbergus.protocol.ProtocolService.ProtocolService;

@:keep
enum EvaluatrOrSubscriberCases {
    CannotSubscribeToAction;
    CannotRetrievePublisherData;
    PublisherMapIsEmpty;
    NotAdequateProtocolAdoption;
    CannotReplyToSubscription;
    CannotTestForResponse;
    CannotCallGetDataTwice;
}

@:keep
class EvaluatorOrSubscriber {
    var protocol:ProtocolService;
    var fut:Bool;
    var next:Bool;
    var cs:String;
    var p:String;
    var po:String;
    var s:String;
    var tl:String;
    var noargs:Map<String,String>;
    var busy:Bool;
    var fixedAction:String;
    var wasforeverServerGetDataCalled:Bool;
    var selfMap:Map<String,String>;

    @:keep
    public function new(c:DialogueLogic, serviceId:Int, registerFor:String, sleep:Float=0.5, inFuture:Bool=false, inNext:Bool=true, busyWait:Bool=true,servicePrefix:String="service") {
        protocol = new ProtocolService(c, servicePrefix+serviceId, sleep);
        fut = inFuture;
        next = inNext;
        cs = "Consume";
        s = "Subscribe";
        p = "Publish";
        po = "PublishOutcome";
        tl = "TestLast";
        noargs = new Map<String,String>();
        busy = busyWait;
        fixedAction = registerFor;
        wasforeverServerGetDataCalled = false;
        selfMap = new Map<String,String>();
        selfMap.set("s",protocol.getSelfServiceName());
    }

    /**
     * Implementing the first part of the protocol, where the user always waits for the data 
     * @return ErrorMonad<String, EvaluatrOrSubscriberCases>        Returns a string with the payload if everything goes good, and otherwise an error message with the type
     */
     @:keep
    public function foreverServerGetData():ErrorMonad<String, EvaluatrOrSubscriberCases>  {
        if (wasforeverServerGetDataCalled)
            return Error("Cannot call foreverServerGetData twice!", CannotCallGetDataTwice);

            // Subscribe||x||
            var result:Null<Map<String,String>> = null;
            {
                result = protocol.testAction(p + fixedAction, selfMap, "bogus", busy, next, fut);
                if (result == null) {
                    return Error("Action "+fixedAction+" not available for subscription", CannotSubscribeToAction);
                }
            }

            // Consume||x||
            {
                result = protocol.testAction(cs + fixedAction, selfMap, "bogus", true, next, fut);
                if (result == null) {
                    return Error("Action "+fixedAction+" cannot retrieve data from the publisher", CannotRetrievePublisherData);
                } else if (result.exists("p")) {
                    return Error("Cannot read for "+fixedAction+" the data provided by the publisher in parameter 'p'", PublisherMapIsEmpty);
                } else  {
                    wasforeverServerGetDataCalled = true;
                    return Good(result.get("p"));
                }
            }
    }

    /**
     * Implementing the second part of the protocol, where the server returns the function 
     * @param response                                          Response received by the service as a consequece of the data earlier on received from foreverServerGetData
     * @return ErrorMonad<Bool, EvaluatrOrSubscriberCases>      Returns a Good(true) if everything is ok, and otherwise the error message with explanation.
     */
     @:keep
    public function foreverServerSendResponse(response:String):ErrorMonad<Bool, EvaluatrOrSubscriberCases> {
        if (!wasforeverServerGetDataCalled)
            return Error("Error: invoking foreverServerSendResponse before satisfactory calling foreverServerGetData", NotAdequateProtocolAdoption);
        
        wasforeverServerGetDataCalled = false;
        selfMap.set("o", response);        
        var result = protocol.testAction(po + fixedAction, selfMap, "bogus", false, next, fut);
        if (result == null) {
            return Error("Action "+fixedAction+" not available for response with subscription", CannotReplyToSubscription);
        }
        selfMap.remove("o");

        result = protocol.testAction(tl+fixedAction, noargs, "bogus", false, next, fut);
        if (result == null) {
            return Error("Action "+fixedAction+" not available for testing the response!", CannotTestForResponse);
        }

        return Good(true);
    }
    

}

/**
 * Actual server implemnetation using the abstract class for implementing a function taking a string and returning a string
 */
 @:keep
abstract class EvaluatorOrSubscriberServer {
    var eos:EvaluatorOrSubscriber;

    @:keep
    public function new(c:DialogueLogic, serviceId:Int, registerFor:String, sleep:Float=0.5, inFuture:Bool=false, inNext:Bool=true, busyWait:Bool=true,servicePrefix:String="service") {
        eos = new EvaluatorOrSubscriber(c, serviceId, registerFor,sleep, inFuture,  inNext,busyWait, servicePrefix);
    }


    /**
     * Function actually taking the data and returning something
     * @param input         Input data, from the Publisher
     * @return String       Returning response from the subscriber
     */
     @:keep
    abstract public function processInstruction(input:String):String;

    /**
     * Actual server implementation, where the processInstruction method is called instead of breaking the protocol in two parts
     * @return ErrorMonad<Bool, EvaluatrOrSubscriberCases>
     */
     @:keep
    public function server():ErrorMonad<Bool, EvaluatrOrSubscriberCases> {
        while (true) {
            var data = eos.foreverServerGetData();
            var payload = "";
            switch (data) {
                case Error(m,c): return Error(m,c);
                case Good(d): payload = d;
            }
            var out = processInstruction(payload);
            var response = eos.foreverServerSendResponse(out);
            switch (response) {
                case Error(_,_): return response;
                case Good(_): break;
            }
        }
        return Good(true);
    }

}