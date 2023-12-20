package jackbergus.dgep.messages;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ProtocolMessage extends haxe.lang.HxObject
{
	public ProtocolMessage(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ProtocolMessage(java.lang.String m, java.lang.String p)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		jackbergus.dgep.messages.ProtocolMessage.__hx_ctor_jackbergus_dgep_messages_ProtocolMessage(this, m, p);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_messages_ProtocolMessage(jackbergus.dgep.messages.ProtocolMessage __hx_this, java.lang.String m, java.lang.String p)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		if (( p == null )) 
		{
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			p = "";
		}
		
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		if (( m == null )) 
		{
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			m = "";
		}
		
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		__hx_this.message = m;
		//line 26 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		__hx_this.protocol = p;
	}
	
	
	public java.lang.String message;
	
	public java.lang.String protocol;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		{
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			boolean __temp_executeDef1 = true;
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			if (( field != null )) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
				switch (field.hashCode())
				{
					case -989163880:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						if (field.equals("protocol")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							this.protocol = haxe.lang.Runtime.toString(value);
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							return value;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						break;
					}
					
					
					case 954925063:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						if (field.equals("message")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							this.message = haxe.lang.Runtime.toString(value);
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							return value;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			if (__temp_executeDef1) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		{
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			boolean __temp_executeDef1 = true;
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			if (( field != null )) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
				switch (field.hashCode())
				{
					case -989163880:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						if (field.equals("protocol")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							return this.protocol;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						break;
					}
					
					
					case 954925063:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						if (field.equals("message")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
							return this.message;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
			if (__temp_executeDef1) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		baseArr.push("protocol");
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		baseArr.push("message");
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolMessage.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


