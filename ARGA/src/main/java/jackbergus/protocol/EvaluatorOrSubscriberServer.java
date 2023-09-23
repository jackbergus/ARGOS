package jackbergus.protocol;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public abstract class EvaluatorOrSubscriberServer extends haxe.lang.HxObject
{
	public EvaluatorOrSubscriberServer(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public EvaluatorOrSubscriberServer(jackbergus.dgep.connections.DialogueLogic c, int serviceId, java.lang.String registerFor, java.lang.Object sleep, java.lang.Object inFuture, java.lang.Object inNext, java.lang.Object busyWait, java.lang.String servicePrefix)
	{
		//line 126 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		jackbergus.protocol.EvaluatorOrSubscriberServer.__hx_ctor_jackbergus_protocol_EvaluatorOrSubscriberServer(this, c, serviceId, registerFor, sleep, inFuture, inNext, busyWait, servicePrefix);
	}
	
	
	protected static void __hx_ctor_jackbergus_protocol_EvaluatorOrSubscriberServer(jackbergus.protocol.EvaluatorOrSubscriberServer __hx_this, jackbergus.dgep.connections.DialogueLogic c, int serviceId, java.lang.String registerFor, java.lang.Object sleep, java.lang.Object inFuture, java.lang.Object inNext, java.lang.Object busyWait, java.lang.String servicePrefix)
	{
		//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		if (( servicePrefix == null )) 
		{
			//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			servicePrefix = "service";
		}
		
		//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		boolean busyWait1 = ( (haxe.lang.Runtime.eq(busyWait, null)) ? (true) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (busyWait) ))) );
		//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		boolean inNext1 = ( (haxe.lang.Runtime.eq(inNext, null)) ? (true) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (inNext) ))) );
		//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		boolean inFuture1 = ( (haxe.lang.Runtime.eq(inFuture, null)) ? (false) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (inFuture) ))) );
		//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		double sleep1 = ( (haxe.lang.Runtime.eq(sleep, null)) ? (0.5) : (((double) (haxe.lang.Runtime.toDouble(sleep)) )) );
		//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		__hx_this.eos = new jackbergus.protocol.EvaluatorOrSubscriber(((jackbergus.dgep.connections.DialogueLogic) (c) ), ((int) (serviceId) ), haxe.lang.Runtime.toString(registerFor), ((java.lang.Object) (sleep1) ), ((java.lang.Object) (inFuture1) ), ((java.lang.Object) (inNext1) ), ((java.lang.Object) (busyWait1) ), haxe.lang.Runtime.toString(servicePrefix));
	}
	
	
	public jackbergus.protocol.EvaluatorOrSubscriber eos;
	
	public abstract java.lang.String processInstruction(java.lang.String input);
	
	public jackbergus.utils.ErrorMonad server()
	{
		//line 145 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		boolean outcome = true;
		//line 146 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		while (outcome)
		{
			//line 148 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			jackbergus.utils.ErrorMonad data = this.eos.foreverServerGetData();
			//line 149 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			java.lang.String payload = "";
			//line 150 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			haxe.Log.trace.__hx_invoke2_o(0.0, ( "Payload: " + payload ), 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.EvaluatorOrSubscriberServer", "jackbergus/protocol/EvaluatorOrSubscriber.hx", "server"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (150) )) )}));
			//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			switch (data.index)
			{
				case 0:
				{
					//line 152 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					java.lang.String m = haxe.lang.Runtime.toString(data.params[0]);
					//line 152 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					jackbergus.protocol.EvaluatrOrSubscriberCases c = ((jackbergus.protocol.EvaluatrOrSubscriberCases) (data.params[1]) );
					//line 152 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					return jackbergus.utils.ErrorMonad.Error(m, c);
				}
				
				
				case 1:
				{
					//line 153 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					java.lang.String d = haxe.lang.Runtime.toString(data.params[0]);
					//line 153 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					payload = d;
					//line 153 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					break;
				}
				
				
			}
			
			//line 156 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			java.lang.String out = this.processInstruction(payload);
			//line 157 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			haxe.Log.trace.__hx_invoke2_o(0.0, ( "Payload response: " + out ), 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.EvaluatorOrSubscriberServer", "jackbergus/protocol/EvaluatorOrSubscriber.hx", "server"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (157) )) )}));
			//line 159 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			jackbergus.utils.ErrorMonad response = this.eos.foreverServerSendResponse(out);
			//line 160 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			switch (response.index)
			{
				case 0:
				{
					//line 161 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					java.lang.String _g = haxe.lang.Runtime.toString(response.params[0]);
					//line 161 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					jackbergus.protocol.EvaluatrOrSubscriberCases _g1 = ((jackbergus.protocol.EvaluatrOrSubscriberCases) (response.params[1]) );
					//line 161 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					return response;
				}
				
				
				case 1:
				{
					//line 162 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					boolean x = haxe.lang.Runtime.toBool(((java.lang.Boolean) (response.params[0]) ));
					//line 162 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					outcome = x;
					//line 162 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
					break;
				}
				
				
			}
			
		}
		
		//line 165 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		return jackbergus.utils.ErrorMonad.Good(outcome);
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		{
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			boolean __temp_executeDef1 = true;
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (( field != null )) 
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				switch (field.hashCode())
				{
					case 100617:
					{
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("eos")) 
						{
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							this.eos = ((jackbergus.protocol.EvaluatorOrSubscriber) (value) );
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return value;
						}
						
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (__temp_executeDef1) 
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		{
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			boolean __temp_executeDef1 = true;
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (( field != null )) 
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				switch (field.hashCode())
				{
					case -905826493:
					{
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("server")) 
						{
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "server")) );
						}
						
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case 100617:
					{
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("eos")) 
						{
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.eos;
						}
						
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case -1524798817:
					{
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("processInstruction")) 
						{
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "processInstruction")) );
						}
						
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (__temp_executeDef1) 
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		{
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			boolean __temp_executeDef1 = true;
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (( field != null )) 
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				switch (field.hashCode())
				{
					case -905826493:
					{
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("server")) 
						{
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.server();
						}
						
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
					case -1524798817:
					{
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						if (field.equals("processInstruction")) 
						{
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							__temp_executeDef1 = false;
							//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
							return this.processInstruction(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
			if (__temp_executeDef1) 
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		baseArr.push("eos");
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/EvaluatorOrSubscriber.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


