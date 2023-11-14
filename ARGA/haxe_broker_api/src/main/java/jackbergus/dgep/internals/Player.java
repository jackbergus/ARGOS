package jackbergus.dgep.internals;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Player extends haxe.lang.HxObject
{
	public Player(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Player()
	{
		//line 32 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		jackbergus.dgep.internals.Player.__hx_ctor_jackbergus_dgep_internals_Player(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_internals_Player(jackbergus.dgep.internals.Player __hx_this)
	{
		//line 33 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		__hx_this.playerID = "";
		//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		__hx_this.roles = new haxe.ds.List<java.lang.String>();
	}
	
	
	public java.lang.String playerID;
	
	public haxe.ds.List<java.lang.String> roles;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		{
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
			boolean __temp_executeDef1 = true;
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
			if (( field != null )) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
				switch (field.hashCode())
				{
					case 108695229:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						if (field.equals("roles")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							this.roles = ((haxe.ds.List<java.lang.String>) (value) );
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							return value;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						break;
					}
					
					
					case 1879273404:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						if (field.equals("playerID")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							this.playerID = haxe.lang.Runtime.toString(value);
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							return value;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
			if (__temp_executeDef1) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		{
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
			boolean __temp_executeDef1 = true;
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
			if (( field != null )) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
				switch (field.hashCode())
				{
					case 108695229:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						if (field.equals("roles")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							return this.roles;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						break;
					}
					
					
					case 1879273404:
					{
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						if (field.equals("playerID")) 
						{
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							__temp_executeDef1 = false;
							//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
							return this.playerID;
						}
						
						//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
			if (__temp_executeDef1) 
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		baseArr.push("roles");
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		baseArr.push("playerID");
		//line 20 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Player.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


