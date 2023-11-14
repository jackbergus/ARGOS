package jackbergus.dgep.internals;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Move extends haxe.lang.HxObject
{
	public Move(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Move()
	{
		//line 38 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		jackbergus.dgep.internals.Move.__hx_ctor_jackbergus_dgep_internals_Move(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_internals_Move(jackbergus.dgep.internals.Move __hx_this)
	{
		//line 39 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		__hx_this.reply = new haxe.ds.StringMap<java.lang.String>();
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		__hx_this.opener = "";
		//line 41 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		__hx_this.moveID = "";
		//line 42 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		__hx_this.target = "";
	}
	
	
	public haxe.ds.StringMap<java.lang.String> reply;
	
	public java.lang.String opener;
	
	public java.lang.String moveID;
	
	public java.lang.String target;
	
	public boolean nameMatch(haxe.lang.Function pred)
	{
		//line 46 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		return haxe.lang.Runtime.toBool(((java.lang.Boolean) (pred.__hx_invoke1_o(0.0, this.moveID)) ));
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		{
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			boolean __temp_executeDef1 = true;
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (( field != null )) 
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				switch (field.hashCode())
				{
					case -880905839:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("target")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							this.target = haxe.lang.Runtime.toString(value);
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return value;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case 108401386:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("reply")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							this.reply = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return value;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case -1068264276:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("moveID")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							this.moveID = haxe.lang.Runtime.toString(value);
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return value;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case -1010579337:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("opener")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							this.opener = haxe.lang.Runtime.toString(value);
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return value;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (__temp_executeDef1) 
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		{
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			boolean __temp_executeDef1 = true;
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (( field != null )) 
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				switch (field.hashCode())
				{
					case 1216695802:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("nameMatch")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "nameMatch")) );
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case 108401386:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("reply")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.reply;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case -880905839:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("target")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.target;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case -1010579337:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("opener")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.opener;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case -1068264276:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("moveID")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.moveID;
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (__temp_executeDef1) 
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		{
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			boolean __temp_executeDef1 = true;
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (( field != null )) 
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				switch (field.hashCode())
				{
					case 1216695802:
					{
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("nameMatch")) 
						{
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.nameMatch(((haxe.lang.Function) (dynargs[0]) ));
						}
						
						//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (__temp_executeDef1) 
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		baseArr.push("target");
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		baseArr.push("moveID");
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		baseArr.push("opener");
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		baseArr.push("reply");
		//line 25 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


