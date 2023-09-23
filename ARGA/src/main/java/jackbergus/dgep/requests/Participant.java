package jackbergus.dgep.requests;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Participant extends haxe.lang.HxObject
{
	public Participant(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Participant()
	{
		//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		jackbergus.dgep.requests.Participant.__hx_ctor_jackbergus_dgep_requests_Participant(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_requests_Participant(jackbergus.dgep.requests.Participant __hx_this)
	{
		//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		__hx_this.participants = new haxe.ds.StringMap<java.lang.String>();
		//line 59 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		__hx_this.parser = new haxe.root.JsonWriter_0(((java.lang.Object) (null) ));
	}
	
	
	public haxe.ds.StringMap<java.lang.String> participants;
	
	public haxe.root.JsonWriter_0 parser;
	
	public void add(java.lang.String name, java.lang.String role)
	{
		//line 69 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.participants) )) ).set(name, role);
	}
	
	
	public java.lang.String get(java.lang.String x)
	{
		//line 78 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		java.lang.String n = null;
		//line 79 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		if (((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.participants) )) ).exists(x)) 
		{
			//line 80 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			n = haxe.lang.Runtime.toString(((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.participants) )) ).get(x));
		}
		
		//line 82 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		return n;
	}
	
	
	public java.lang.String toJSONString()
	{
		//line 90 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		jackbergus.dgep.requests.RawParticipantObjectToJSON obj = new jackbergus.dgep.requests.RawParticipantObjectToJSON();
		//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			haxe.IMap<java.lang.String, java.lang.String> map = ((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.participants) )) );
			//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			haxe.IMap<java.lang.String, java.lang.String> _g_map = map;
			//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			java.lang.Object _g_keys = map.keys();
			//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			while (haxe.lang.Runtime.toBool(((java.lang.Boolean) (haxe.lang.Runtime.callField(_g_keys, "hasNext", null)) )))
			{
				//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				java.lang.String key = haxe.lang.Runtime.toString(haxe.lang.Runtime.callField(_g_keys, "next", null));
				//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				java.lang.String _g1_value = haxe.lang.Runtime.toString(_g_map.get(key));
				//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				java.lang.String _g1_key = key;
				//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				java.lang.String user = _g1_key;
				//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				java.lang.String age = _g1_value;
				//line 92 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				obj.participants.add(new jackbergus.dgep.requests.RawParticipantToJSON(haxe.lang.Runtime.toString(user), haxe.lang.Runtime.toString(age)));
			}
			
		}
		
		//line 95 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		return this.parser.write(obj, null);
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			boolean __temp_executeDef1 = true;
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (( field != null )) 
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				switch (field.hashCode())
				{
					case -995410913:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("parser")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							this.parser = ((haxe.root.JsonWriter_0) (value) );
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return value;
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case -1979713632:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("participants")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							this.participants = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return value;
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (__temp_executeDef1) 
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			boolean __temp_executeDef1 = true;
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (( field != null )) 
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				switch (field.hashCode())
				{
					case 2079347668:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("toJSONString")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "toJSONString")) );
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case -1979713632:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("participants")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return this.participants;
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case 102230:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("get")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "get")) );
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case -995410913:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("parser")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return this.parser;
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case 96417:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("add")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "add")) );
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (__temp_executeDef1) 
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		{
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			boolean __temp_executeDef1 = true;
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (( field != null )) 
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				switch (field.hashCode())
				{
					case 2079347668:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("toJSONString")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return this.toJSONString();
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case 96417:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("add")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							this.add(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
					case 102230:
					{
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						if (field.equals("get")) 
						{
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							__temp_executeDef1 = false;
							//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
							return this.get(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
			if (__temp_executeDef1) 
			{
				//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		baseArr.push("parser");
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		baseArr.push("participants");
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Participant.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


