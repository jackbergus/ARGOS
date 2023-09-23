package jackbergus.dgep.requests;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class RawParticipantObjectToJSON extends haxe.lang.HxObject
{
	public RawParticipantObjectToJSON(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public RawParticipantObjectToJSON()
	{
		//line 43 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		jackbergus.dgep.requests.RawParticipantObjectToJSON.__hx_ctor_jackbergus_dgep_requests_RawParticipantObjectToJSON(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_requests_RawParticipantObjectToJSON(jackbergus.dgep.requests.RawParticipantObjectToJSON __hx_this)
	{
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		__hx_this.participants = new haxe.ds.List<jackbergus.dgep.requests.RawParticipantToJSON>();
	}
	
	
	public haxe.ds.List<jackbergus.dgep.requests.RawParticipantToJSON> participants;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			boolean __temp_executeDef1 = true;
			//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (( field != null )) 
			{
				//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				switch (field.hashCode())
				{
					case -1979713632:
					{
						//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("participants")) 
						{
							//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							this.participants = ((haxe.ds.List<jackbergus.dgep.requests.RawParticipantToJSON>) (value) );
							//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return value;
						}
						
						//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (__temp_executeDef1) 
			{
				//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			boolean __temp_executeDef1 = true;
			//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (( field != null )) 
			{
				//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				switch (field.hashCode())
				{
					case -1979713632:
					{
						//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("participants")) 
						{
							//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return this.participants;
						}
						
						//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (__temp_executeDef1) 
			{
				//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		baseArr.push("participants");
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


