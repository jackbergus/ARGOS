package jackbergus.protocol;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class EvaluatorOrSubscriber extends haxe.lang.HxObject
{
	public EvaluatorOrSubscriber(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public EvaluatorOrSubscriber(jackbergus.dgep.connections.DialogueLogic c, int serviceId, java.lang.String registerFor, java.lang.Object sleep, java.lang.Object inFuture, java.lang.Object inNext, java.lang.Object busyWait, java.lang.String servicePrefix)
	{
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		jackbergus.protocol.EvaluatorOrSubscriber.__hx_ctor_jackbergus_protocol_EvaluatorOrSubscriber(this, c, serviceId, registerFor, sleep, inFuture, inNext, busyWait, servicePrefix);
	}
	
	
	protected static void __hx_ctor_jackbergus_protocol_EvaluatorOrSubscriber(jackbergus.protocol.EvaluatorOrSubscriber __hx_this, jackbergus.dgep.connections.DialogueLogic c, int serviceId, java.lang.String registerFor, java.lang.Object sleep, java.lang.Object inFuture, java.lang.Object inNext, java.lang.Object busyWait, java.lang.String servicePrefix)
	{
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if (( servicePrefix == null )) 
		{
			//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			servicePrefix = "service";
		}
		
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		boolean busyWait1 = ( (haxe.lang.Runtime.eq(busyWait, null)) ? (true) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (busyWait) ))) );
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		boolean inNext1 = ( (haxe.lang.Runtime.eq(inNext, null)) ? (true) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (inNext) ))) );
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		boolean inFuture1 = ( (haxe.lang.Runtime.eq(inFuture, null)) ? (false) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (inFuture) ))) );
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		double sleep1 = ( (haxe.lang.Runtime.eq(sleep, null)) ? (0.5) : (((double) (haxe.lang.Runtime.toDouble(sleep)) )) );
		//line 37 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.protocol = new jackbergus.protocol.ProtocolService(((jackbergus.dgep.connections.DialogueLogic) (c) ), haxe.lang.Runtime.toString(( servicePrefix  )), ((java.lang.Object) (sleep1) ));
		//line 38 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.fut = inFuture1;
		//line 39 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.next = inNext1;
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.cs = "Consume";
		//line 41 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.s = "Subscribe";
		//line 42 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.p = "Publish";
		//line 43 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.po = "PushOutcome";
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.tl = "TestLast";
		//line 45 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.noargs = new haxe.ds.StringMap<java.lang.String>();
		//line 46 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.busy = busyWait1;
		//line 47 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.fixedAction = registerFor;
		//line 48 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.wasforeverServerGetDataCalled = false;
		//line 49 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.selfMap = new haxe.ds.StringMap<java.lang.String>();
		//line 50 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (__hx_this.selfMap) )) ).set("s", __hx_this.protocol.getSelfServiceName());
	}
	
	
	public jackbergus.protocol.ProtocolService protocol;
	
	public boolean fut;
	
	public boolean next;
	
	public java.lang.String cs;
	
	public java.lang.String p;
	
	public java.lang.String po;
	
	public java.lang.String s;
	
	public java.lang.String tl;
	
	public java.lang.String pd;
	
	public haxe.ds.StringMap<java.lang.String> noargs;
	
	public boolean busy;
	
	public java.lang.String fixedAction;
	
	public boolean wasforeverServerGetDataCalled;
	
	public haxe.ds.StringMap<java.lang.String> selfMap;
	
	public jackbergus.utils.ErrorMonad foreverServerGetData()
	{
		//line 59 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if (this.wasforeverServerGetDataCalled) 
		{
			//line 60 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			return jackbergus.utils.ErrorMonad.Error("Cannot call foreverServerGetData twice!", jackbergus.protocol.EvaluatrOrSubscriberCases.CannotCallGetDataTwice);
		}
		
		//line 63 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		haxe.ds.StringMap<java.lang.String> result = null;
		//line 64 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		{
			//line 65 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			result = this.protocol.testAction(( this.s + this.fixedAction ), this.selfMap, "bogus", this.busy);
			//line 66 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (( result == null )) 
			{
				//line 67 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				return jackbergus.utils.ErrorMonad.Error(( ( "Action " + this.fixedAction ) + " not available for subscription" ), jackbergus.protocol.EvaluatrOrSubscriberCases.CannotSubscribeToAction);
			}
			
		}
		
		//line 73 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		result = this.protocol.testAction(( this.cs + this.fixedAction ), this.selfMap, "bogus", true);
		//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if (( result == null )) 
		{
			//line 75 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			return jackbergus.utils.ErrorMonad.Error(( ( "Action " + this.fixedAction ) + " cannot retrieve data from the publisher" ), jackbergus.protocol.EvaluatrOrSubscriberCases.CannotRetrievePublisherData);
		}
		
		//line 78 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if ( ! (result.exists("p")) ) 
		{
			//line 79 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			return jackbergus.utils.ErrorMonad.Error(( ( "Cannot read for " + this.fixedAction ) + " the data provided by the publisher in parameter \'p\'" ), jackbergus.protocol.EvaluatrOrSubscriberCases.PublisherMapIsEmpty);
		}
		else
		{
			//line 81 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			this.wasforeverServerGetDataCalled = true;
			//line 82 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			return jackbergus.utils.ErrorMonad.Good(haxe.lang.Runtime.toString(result.get("p")));
		}
		
	}
	
	
	public jackbergus.utils.ErrorMonad foreverServerSendResponse(java.lang.String response)
	{
		//line 94 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if ( ! (this.wasforeverServerGetDataCalled) ) 
		{
			//line 95 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			return jackbergus.utils.ErrorMonad.Error("Error: invoking foreverServerSendResponse before satisfactory calling foreverServerGetData", jackbergus.protocol.EvaluatrOrSubscriberCases.NotAdequateProtocolAdoption);
		}
		
		//line 98 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		this.wasforeverServerGetDataCalled = false;
		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.selfMap) )) ).set("o", response);
		//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		haxe.ds.StringMap<java.lang.String> result = this.protocol.testAction(( this.po + this.fixedAction ), this.selfMap, "bogus", false);
		//line 101 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if (( result == null )) 
		{
			//line 102 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			return jackbergus.utils.ErrorMonad.Error(( ( "Action " + this.fixedAction ) + " not available for response with subscription" ), jackbergus.protocol.EvaluatrOrSubscriberCases.CannotReplyToSubscription);
		}
		
		//line 104 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.selfMap) )) ).remove("o");
		//line 107 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		result = this.protocol.testAction(( this.tl + this.fixedAction ), this.noargs, "bogus", false);
		//line 108 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if (( result == null )) 
		{
			//line 109 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			return jackbergus.utils.ErrorMonad.Error(( ( "Action " + this.fixedAction ) + " not available for testing the response!" ), jackbergus.protocol.EvaluatrOrSubscriberCases.CannotTestForResponse);
		}
		
		//line 112 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		return jackbergus.utils.ErrorMonad.Good(true);
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		{
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (( field != null )) 
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				switch (field.hashCode())
				{
					case 1978108528:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("selfMap")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.selfMap = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case -989163880:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("protocol")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.protocol = ((jackbergus.protocol.ProtocolService) (value) );
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 1430157820:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("wasforeverServerGetDataCalled")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.wasforeverServerGetDataCalled = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 101765:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("fut")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.fut = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 531425994:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("fixedAction")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.fixedAction = haxe.lang.Runtime.toString(value);
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3377907:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("next")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.next = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3035641:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("busy")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.busy = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3184:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("cs")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.cs = haxe.lang.Runtime.toString(value);
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case -1040247266:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("noargs")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.noargs = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 112:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("p")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.p = haxe.lang.Runtime.toString(value);
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3572:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("pd")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.pd = haxe.lang.Runtime.toString(value);
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3583:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("po")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.po = haxe.lang.Runtime.toString(value);
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3704:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("tl")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.tl = haxe.lang.Runtime.toString(value);
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 115:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("s")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.s = haxe.lang.Runtime.toString(value);
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		{
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (( field != null )) 
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				switch (field.hashCode())
				{
					case -1578141549:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("foreverServerSendResponse")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "foreverServerSendResponse")) );
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case -989163880:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("protocol")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.protocol;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 975691062:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("foreverServerGetData")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "foreverServerGetData")) );
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 101765:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("fut")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.fut;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 1978108528:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("selfMap")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.selfMap;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3377907:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("next")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.next;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 1430157820:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("wasforeverServerGetDataCalled")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.wasforeverServerGetDataCalled;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3184:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("cs")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.cs;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 531425994:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("fixedAction")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.fixedAction;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 112:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("p")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.p;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3035641:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("busy")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.busy;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3583:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("po")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.po;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case -1040247266:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("noargs")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.noargs;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 115:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("s")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.s;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3572:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("pd")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.pd;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 3704:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("tl")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.tl;
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		{
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			boolean __temp_executeDef1 = true;
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (( field != null )) 
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				switch (field.hashCode())
				{
					case -1578141549:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("foreverServerSendResponse")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.foreverServerSendResponse(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 975691062:
					{
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("foreverServerGetData")) 
						{
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.foreverServerGetData();
						}
						
						//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (__temp_executeDef1) 
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("selfMap");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("wasforeverServerGetDataCalled");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("fixedAction");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("busy");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("noargs");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("pd");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("tl");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("s");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("po");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("p");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("cs");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("next");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("fut");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("protocol");
		//line 19 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


