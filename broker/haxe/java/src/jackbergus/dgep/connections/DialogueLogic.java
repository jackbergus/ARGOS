package jackbergus.dgep.connections;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class DialogueLogic extends haxe.lang.HxObject
{
	public DialogueLogic(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public DialogueLogic(jackbergus.dgep.connections.ConnectionRaw x, java.lang.String protocol, java.lang.String dialogue, jackbergus.dgep.messages.DialogueMessage msg)
	{
		//line 46 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.connections.DialogueLogic.__hx_ctor_jackbergus_dgep_connections_DialogueLogic(this, x, protocol, dialogue, msg);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_connections_DialogueLogic(jackbergus.dgep.connections.DialogueLogic __hx_this, jackbergus.dgep.connections.ConnectionRaw x, java.lang.String protocol, java.lang.String dialogue, jackbergus.dgep.messages.DialogueMessage msg)
	{
		//line 47 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.x = x;
		//line 48 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.protocolName = protocol;
		//line 49 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.dialogueName = dialogue;
		//line 50 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.msg = msg;
	}
	
	
	public jackbergus.dgep.connections.ConnectionRaw x;
	
	public java.lang.String protocolName;
	
	public java.lang.String dialogueName;
	
	public jackbergus.dgep.messages.DialogueMessage msg;
	
	public haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>> getMovesFromMessage()
	{
		//line 38 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>> r = null;
		//line 39 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		if (( this.msg != null )) 
		{
			//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			r = this.msg.moves.response;
		}
		
		//line 42 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return r;
	}
	
	
	public jackbergus.dgep.internals.ResponseAndData interaction(jackbergus.dgep.requests.Interaction i)
	{
		//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		haxe.lang.Function replacer = null;
		//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		java.lang.String space = null;
		//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		java.lang.String json = haxe.format.JsonPrinter.print(((java.lang.Object) (i) ), replacer, space);
		//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return this.x.interaction(this.dialogueName, i.moveId, json);
	}
	
	
	public jackbergus.dgep.internals.ResponseAndData moves(java.lang.String initiator)
	{
		//line 62 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		if (( initiator == null )) 
		{
			//line 62 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			initiator = "";
		}
		
		//line 63 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.internals.ResponseAndData z = this.x.dialogueMoves(this.dialogueName, initiator);
		//line 64 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		if (( z == null )) 
		{
			//line 65 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			haxe.Log.trace.__hx_invoke2_o(0.0, "Communication ERROR!", 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.dgep.connections.DialogueLogic", "jackbergus/dgep/connections/ConnectionLogic.hx", "moves"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (65) )) )}));
		}
		
		//line 66 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return z;
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 108417:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("msg")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.msg = ((jackbergus.dgep.messages.DialogueMessage) (value) );
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 120:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("x")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.x = ((jackbergus.dgep.connections.ConnectionRaw) (value) );
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1350835331:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("dialogueName")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.dialogueName = haxe.lang.Runtime.toString(value);
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 160854339:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("protocolName")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.protocolName = haxe.lang.Runtime.toString(value);
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 104087234:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("moves")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "moves")) );
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 120:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("x")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.x;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1844104722:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("interaction")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "interaction")) );
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 160854339:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("protocolName")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.protocolName;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -205664175:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("getMovesFromMessage")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "getMovesFromMessage")) );
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1350835331:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("dialogueName")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.dialogueName;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 108417:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("msg")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.msg;
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 104087234:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("moves")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.moves(haxe.lang.Runtime.toString(( (( dynargs.length > 0 )) ? (dynargs[0]) : (null) )));
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -205664175:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("getMovesFromMessage")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.getMovesFromMessage();
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1844104722:
					{
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("interaction")) 
						{
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.interaction(((jackbergus.dgep.requests.Interaction) (dynargs[0]) ));
						}
						
						//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("msg");
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("dialogueName");
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("protocolName");
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("x");
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


