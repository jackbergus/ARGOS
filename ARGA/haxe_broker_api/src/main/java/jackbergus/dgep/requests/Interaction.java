package jackbergus.dgep.requests;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Interaction extends haxe.lang.HxObject
{
	public Interaction(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Interaction(java.lang.String move, java.lang.String s, java.lang.String t)
	{
		//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		jackbergus.dgep.requests.Interaction.__hx_ctor_jackbergus_dgep_requests_Interaction(this, move, s, t);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_requests_Interaction(jackbergus.dgep.requests.Interaction __hx_this, java.lang.String move, java.lang.String s, java.lang.String t)
	{
		//line 32 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		__hx_this.moveId = move;
		//line 33 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		__hx_this.speaker = s;
		//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		__hx_this.target = t;
		//line 35 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		__hx_this.reply = new haxe.ds.StringMap<java.lang.String>();
	}
	
	
	public java.lang.String moveId;
	
	public java.lang.String speaker;
	
	public java.lang.String target;
	
	public haxe.ds.StringMap<java.lang.String> reply;
	
	public void add(java.lang.String key, java.lang.String val)
	{
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.reply) )) ).set(key, val);
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		{
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			boolean __temp_executeDef1 = true;
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			if (( field != null )) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				switch (field.hashCode())
				{
					case 108401386:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("reply")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							this.reply = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return value;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
					case -1068264244:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("moveId")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							this.moveId = haxe.lang.Runtime.toString(value);
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return value;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
					case -880905839:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("target")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							this.target = haxe.lang.Runtime.toString(value);
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return value;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
					case -2008522753:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("speaker")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							this.speaker = haxe.lang.Runtime.toString(value);
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return value;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			if (__temp_executeDef1) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		{
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			boolean __temp_executeDef1 = true;
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			if (( field != null )) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				switch (field.hashCode())
				{
					case 96417:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("add")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "add")) );
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
					case -1068264244:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("moveId")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return this.moveId;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
					case 108401386:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("reply")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return this.reply;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
					case -2008522753:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("speaker")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return this.speaker;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
					case -880905839:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("target")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							return this.target;
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			if (__temp_executeDef1) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		{
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			boolean __temp_executeDef1 = true;
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			if (( field != null )) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				switch (field.hashCode())
				{
					case 96417:
					{
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						if (field.equals("add")) 
						{
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							__temp_executeDef1 = false;
							//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
							this.add(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
			if (__temp_executeDef1) 
			{
				//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		baseArr.push("reply");
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		baseArr.push("target");
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		baseArr.push("speaker");
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		baseArr.push("moveId");
		//line 24 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/requests/Interaction.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


