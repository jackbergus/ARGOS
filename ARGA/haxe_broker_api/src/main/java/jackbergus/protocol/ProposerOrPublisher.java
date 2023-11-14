package jackbergus.protocol;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ProposerOrPublisher extends haxe.lang.HxObject
{
	public ProposerOrPublisher(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ProposerOrPublisher(jackbergus.dgep.connections.DialogueLogic c, java.lang.String agentName, java.lang.Object sleep, java.lang.Object busyWait)
	{
		//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		jackbergus.protocol.ProposerOrPublisher.__hx_ctor_jackbergus_protocol_ProposerOrPublisher(this, c, agentName, sleep, busyWait);
	}
	
	
	protected static void __hx_ctor_jackbergus_protocol_ProposerOrPublisher(jackbergus.protocol.ProposerOrPublisher __hx_this, jackbergus.dgep.connections.DialogueLogic c, java.lang.String agentName, java.lang.Object sleep, java.lang.Object busyWait)
	{
		//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		boolean busyWait1 = ( (haxe.lang.Runtime.eq(busyWait, null)) ? (true) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (busyWait) ))) );
		//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		double sleep1 = ( (haxe.lang.Runtime.eq(sleep, null)) ? (0.5) : (((double) (haxe.lang.Runtime.toDouble(sleep)) )) );
		//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		if (( agentName == null )) 
		{
			//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			agentName = "ARGA";
		}
		
		//line 35 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		__hx_this.protocol = new jackbergus.protocol.ProtocolService(((jackbergus.dgep.connections.DialogueLogic) (c) ), haxe.lang.Runtime.toString(agentName), ((java.lang.Object) (sleep1) ));
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		__hx_this.p = "Publish";
		//line 37 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		__hx_this.sp = "StartPublish";
		//line 38 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		__hx_this.po = "PopOutcome";
		//line 39 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		__hx_this.noargs = new haxe.ds.StringMap<java.lang.String>();
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		__hx_this.busy = busyWait1;
	}
	
	
	public jackbergus.protocol.ProtocolService protocol;
	
	public boolean fut;
	
	public boolean next;
	
	public java.lang.String sp;
	
	public java.lang.String p;
	
	public java.lang.String po;
	
	public haxe.ds.StringMap<java.lang.String> noargs;
	
	public boolean busy;
	
	public haxe.ds.List<java.lang.String> publishableActions(java.lang.String action)
	{
		//line 51 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		if (( action == null )) 
		{
			//line 51 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			action = "";
		}
		
		//line 51 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		return this.protocol.doableActions(this.sp, action);
	}
	
	
	public jackbergus.utils.ErrorMonad returnResultsFromSubscribers(java.lang.String action, java.lang.String data)
	{
		//line 62 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		jackbergus.utils.ErrorMonad results = jackbergus.utils.ErrorMonad.Error("Unknown error", jackbergus.protocol.ProposerOrPublisherCases.UnknownError);
		//line 65 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		if (( this.publishableActions(action).length == 0 )) 
		{
			//line 66 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			return jackbergus.utils.ErrorMonad.Error(( ( "Action " + action ) + " not available" ), jackbergus.protocol.ProposerOrPublisherCases.ActionNotReady);
		}
		
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		haxe.ds.StringMap<java.lang.String> result = null;
		//line 72 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		{
			//line 73 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			result = this.protocol.testAction(( this.sp + action ), this.noargs, "bogus", this.busy);
			//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( result == null )) 
			{
				//line 75 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return jackbergus.utils.ErrorMonad.Error(( ( "Action " + action ) + " not available at testAction" ), jackbergus.protocol.ProposerOrPublisherCases.ActionNotReady);
			}
			
		}
		
		//line 81 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		int countServices = 0;
		//line 82 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		haxe.ds.StringMap<java.lang.String> publishableData = new haxe.ds.StringMap<java.lang.String>();
		//line 83 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		publishableData.set("d", data);
		//line 84 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		java.lang.String servicesToCount = "[]";
		//line 85 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		while (true)
		{
			//line 87 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			result = this.protocol.testAction(( this.p + action ), publishableData, "bogus", false);
			//line 88 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( result != null )) 
			{
				//line 89 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				if (result.exists("l")) 
				{
					//line 90 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
					servicesToCount = haxe.lang.Runtime.toString(result.get("l"));
				}
				
			}
			
			//line 85 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if ( ! ((( result != null ))) ) 
			{
				//line 85 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				break;
			}
			
		}
		
		//line 94 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		haxe.root.Array<java.lang.String> servicesToCountList = haxe.lang.StringExt.split(haxe.lang.StringExt.substring(servicesToCount, 1, ( servicesToCount.length() - 1 )), ",");
		//line 95 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		countServices = servicesToCountList.length;
		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		if ( ! (this.protocol.isActionAvailable(( this.po + action ), this.busy)) ) 
		{
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			return jackbergus.utils.ErrorMonad.Error(( ( ( "Cannot pop the outcome of " + action ) + " given the busyness: " ) + (( (this.busy) ? ("true") : ("false") )) ), jackbergus.protocol.ProposerOrPublisherCases.CannotPopValues);
		}
		
		//line 102 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		haxe.ds.StringMap<java.lang.String> m = new haxe.ds.StringMap<java.lang.String>();
		//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		while (true)
		{
			//line 104 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			result = this.protocol.testAction(( this.po + action ), this.noargs, "bogus", false);
			//line 105 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			 -- countServices;
			//line 106 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( ( result == null ) && ( countServices > 0 ) )) 
			{
				//line 107 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return jackbergus.utils.ErrorMonad.Error("Expecting that the PopOutcome would return a value, but null was returned instead", jackbergus.protocol.ProposerOrPublisherCases.UnexpectedNullArgumentFromPop);
			}
			
			//line 108 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( result == null )) 
			{
				//line 109 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				break;
			}
			
			//line 110 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if ( ! (result.exists("o")) ) 
			{
				//line 111 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return jackbergus.utils.ErrorMonad.Error("Expecting a missing response argument!", jackbergus.protocol.ProposerOrPublisherCases.MissingResponseArgument);
			}
			
			//line 112 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			java.lang.String o = haxe.lang.Runtime.toString(result.get("o"));
			//line 113 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if ( ! (result.exists("s")) ) 
			{
				//line 114 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return jackbergus.utils.ErrorMonad.Error("Expecting a missing service name argument!", jackbergus.protocol.ProposerOrPublisherCases.MissingAuthorArgument);
			}
			
			//line 115 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			java.lang.String s = haxe.lang.Runtime.toString(result.get("s"));
			//line 116 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (m.exists(s)) 
			{
				//line 117 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return jackbergus.utils.ErrorMonad.Error(( "Obtained a duplicate service name for: " + s ), jackbergus.protocol.ProposerOrPublisherCases.DuplicateServiceName);
			}
			
			//line 118 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			m.set(s, o);
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if ( ! ((( ( result != null ) && ( countServices > 0 ) ))) ) 
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				break;
			}
			
		}
		
		//line 121 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		if (( countServices == 0 )) 
		{
			//line 123 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			result = this.protocol.testAction(( this.po + action ), this.noargs, "bogus", false);
			//line 124 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( result == null )) 
			{
				//line 125 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				haxe.Log.trace.__hx_invoke2_o(0.0, "Null last result", 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.ProposerOrPublisher", "jackbergus/protocol/ProposerOrPublisher.hx", "returnResultsFromSubscribers"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (125) )) )}));
			}
			else
			{
				//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				haxe.Log.trace.__hx_invoke2_o(0.0, "last result not null", 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.ProposerOrPublisher", "jackbergus/protocol/ProposerOrPublisher.hx", "returnResultsFromSubscribers"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (127) )) )}));
			}
			
			//line 128 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			return jackbergus.utils.ErrorMonad.Good(m);
		}
		else
		{
			//line 130 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			return jackbergus.utils.ErrorMonad.Error("Something went wrong: not the expected number of agents was provided", jackbergus.protocol.ProposerOrPublisherCases.UnexpectedNullArgumentFromPop);
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		{
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			boolean __temp_executeDef1 = true;
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( field != null )) 
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				switch (field.hashCode())
				{
					case 3035641:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("busy")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.busy = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case -989163880:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("protocol")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.protocol = ((jackbergus.protocol.ProtocolService) (value) );
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case -1040247266:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("noargs")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.noargs = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 101765:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("fut")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.fut = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 3583:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("po")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.po = haxe.lang.Runtime.toString(value);
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 3377907:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("next")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.next = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 112:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("p")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.p = haxe.lang.Runtime.toString(value);
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 3677:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("sp")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							this.sp = haxe.lang.Runtime.toString(value);
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return value;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (__temp_executeDef1) 
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		{
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			boolean __temp_executeDef1 = true;
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( field != null )) 
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				switch (field.hashCode())
				{
					case -1925711493:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("returnResultsFromSubscribers")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "returnResultsFromSubscribers")) );
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case -989163880:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("protocol")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.protocol;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case -1638963756:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("publishableActions")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "publishableActions")) );
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 101765:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("fut")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.fut;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 3035641:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("busy")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.busy;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 3377907:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("next")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.next;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case -1040247266:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("noargs")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.noargs;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 3677:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("sp")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.sp;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 3583:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("po")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.po;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case 112:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("p")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.p;
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (__temp_executeDef1) 
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		{
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			boolean __temp_executeDef1 = true;
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (( field != null )) 
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				switch (field.hashCode())
				{
					case -1925711493:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("returnResultsFromSubscribers")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.returnResultsFromSubscribers(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
					case -1638963756:
					{
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						if (field.equals("publishableActions")) 
						{
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							__temp_executeDef1 = false;
							//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
							return this.publishableActions(haxe.lang.Runtime.toString(( (( dynargs.length > 0 )) ? (dynargs[0]) : (null) )));
						}
						
						//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
			if (__temp_executeDef1) 
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("busy");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("noargs");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("po");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("p");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("sp");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("next");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("fut");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		baseArr.push("protocol");
		//line 23 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProposerOrPublisher.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


