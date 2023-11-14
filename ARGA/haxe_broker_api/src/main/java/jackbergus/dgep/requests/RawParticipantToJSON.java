package jackbergus.dgep.requests;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class RawParticipantToJSON extends haxe.lang.HxObject
{
	public RawParticipantToJSON(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public RawParticipantToJSON(java.lang.String n, java.lang.String p)
	{
		//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		jackbergus.dgep.requests.RawParticipantToJSON.__hx_ctor_jackbergus_dgep_requests_RawParticipantToJSON(this, n, p);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_requests_RawParticipantToJSON(jackbergus.dgep.requests.RawParticipantToJSON __hx_this, java.lang.String n, java.lang.String p)
	{
		//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		if (( p == null )) 
		{
			//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			p = "";
		}
		
		//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		if (( n == null )) 
		{
			//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			n = "";
		}
		
		//line 32 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		__hx_this.name = n;
		//line 33 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		__hx_this.player = p;
	}
	
	
	public java.lang.String name;
	
	public java.lang.String player;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			boolean __temp_executeDef1 = true;
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (( field != null )) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				switch (field.hashCode())
				{
					case -985752863:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("player")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							this.player = haxe.lang.Runtime.toString(value);
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case 3373707:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("name")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							this.name = haxe.lang.Runtime.toString(value);
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (__temp_executeDef1) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			boolean __temp_executeDef1 = true;
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (( field != null )) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				switch (field.hashCode())
				{
					case -985752863:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("player")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return this.player;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case 3373707:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("name")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return this.name;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (__temp_executeDef1) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		baseArr.push("player");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		baseArr.push("name");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


