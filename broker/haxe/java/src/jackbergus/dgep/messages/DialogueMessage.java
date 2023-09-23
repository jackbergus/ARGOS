package jackbergus.dgep.messages;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class DialogueMessage extends haxe.lang.HxObject
{
	public DialogueMessage(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public DialogueMessage()
	{
		//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		jackbergus.dgep.messages.DialogueMessage.__hx_ctor_jackbergus_dgep_messages_DialogueMessage(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_messages_DialogueMessage(jackbergus.dgep.messages.DialogueMessage __hx_this)
	{
		//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		__hx_this.moves = new jackbergus.dgep.internals.ResponseAndData();
		//line 32 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		__hx_this.dialogueID = "";
	}
	
	
	public jackbergus.dgep.internals.ResponseAndData moves;
	
	public java.lang.String dialogueID;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		{
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
			boolean __temp_executeDef1 = true;
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
			if (( field != null )) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
				switch (field.hashCode())
				{
					case -1384067853:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						if (field.equals("dialogueID")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							this.dialogueID = haxe.lang.Runtime.toString(value);
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							return value;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						break;
					}
					
					
					case 104087234:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						if (field.equals("moves")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							this.moves = ((jackbergus.dgep.internals.ResponseAndData) (value) );
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							return value;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
			if (__temp_executeDef1) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		{
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
			boolean __temp_executeDef1 = true;
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
			if (( field != null )) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
				switch (field.hashCode())
				{
					case -1384067853:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						if (field.equals("dialogueID")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							return this.dialogueID;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						break;
					}
					
					
					case 104087234:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						if (field.equals("moves")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
							return this.moves;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
			if (__temp_executeDef1) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		baseArr.push("dialogueID");
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		baseArr.push("moves");
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/DialogueMessage.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


