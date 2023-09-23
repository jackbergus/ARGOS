package jackbergus.dgep.connections;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ProtocolLogic extends haxe.lang.HxObject
{
	public ProtocolLogic(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ProtocolLogic(jackbergus.dgep.connections.ConnectionRaw x, java.lang.String protocolName, jackbergus.dgep.messages.ProtocolMessage msg)
	{
		//line 78 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.connections.ProtocolLogic.__hx_ctor_jackbergus_dgep_connections_ProtocolLogic(this, x, protocolName, msg);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_connections_ProtocolLogic(jackbergus.dgep.connections.ProtocolLogic __hx_this, jackbergus.dgep.connections.ConnectionRaw x, java.lang.String protocolName, jackbergus.dgep.messages.ProtocolMessage msg)
	{
		//line 79 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.x = x;
		//line 80 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.msg = msg;
		//line 81 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.protocol = protocolName;
		//line 82 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.dialogues = new haxe.ds.StringMap<jackbergus.dgep.connections.DialogueLogic>();
	}
	
	
	public jackbergus.dgep.connections.ConnectionRaw x;
	
	public jackbergus.dgep.messages.ProtocolMessage msg;
	
	public java.lang.String protocol;
	
	public haxe.ds.StringMap<jackbergus.dgep.connections.DialogueLogic> dialogues;
	
	public jackbergus.dgep.connections.DialogueLogic newDialogue(java.lang.String name, jackbergus.dgep.requests.Participant p, java.lang.String initiator)
	{
		//line 88 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		if (( initiator == null )) 
		{
			//line 88 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			initiator = "";
		}
		
		//line 89 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.messages.DialogueMessage msg = this.x.newDialogueFromProtocol(this.protocol, name, p.toJSONString(), initiator);
		//line 90 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.connections.DialogueLogic dl = new jackbergus.dgep.connections.DialogueLogic(((jackbergus.dgep.connections.ConnectionRaw) (this.x) ), haxe.lang.Runtime.toString(this.protocol), haxe.lang.Runtime.toString(name), ((jackbergus.dgep.messages.DialogueMessage) (msg) ));
		//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		((haxe.ds.StringMap<jackbergus.dgep.connections.DialogueLogic>) (((haxe.IMap<java.lang.String, jackbergus.dgep.connections.DialogueLogic>) (this.dialogues) )) ).set(name, dl);
		//line 92 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return dl;
	}
	
	
	public jackbergus.dgep.messages.ProtocolMessage getMessage()
	{
		//line 97 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return this.msg;
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 1340826011:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("dialogues")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.dialogues = ((haxe.ds.StringMap<jackbergus.dgep.connections.DialogueLogic>) (value) );
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 120:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("x")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.x = ((jackbergus.dgep.connections.ConnectionRaw) (value) );
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -989163880:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("protocol")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.protocol = haxe.lang.Runtime.toString(value);
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 108417:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("msg")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.msg = ((jackbergus.dgep.messages.ProtocolMessage) (value) );
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 1991785425:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("getMessage")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "getMessage")) );
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 120:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("x")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.x;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1022904216:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("newDialogue")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "newDialogue")) );
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 108417:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("msg")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.msg;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1340826011:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("dialogues")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.dialogues;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -989163880:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("protocol")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.protocol;
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 1991785425:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("getMessage")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.getMessage();
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1022904216:
					{
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("newDialogue")) 
						{
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.newDialogue(haxe.lang.Runtime.toString(dynargs[0]), ((jackbergus.dgep.requests.Participant) (dynargs[1]) ), haxe.lang.Runtime.toString(( (( dynargs.length > 2 )) ? (dynargs[2]) : (null) )));
						}
						
						//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("dialogues");
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("protocol");
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("msg");
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("x");
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


