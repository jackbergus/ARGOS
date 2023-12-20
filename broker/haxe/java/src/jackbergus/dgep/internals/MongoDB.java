package jackbergus.dgep.internals;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class MongoDB extends haxe.lang.HxObject
{
	public MongoDB(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public MongoDB()
	{
		//line 26 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		jackbergus.dgep.internals.MongoDB.__hx_ctor_jackbergus_dgep_internals_MongoDB(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_internals_MongoDB(jackbergus.dgep.internals.MongoDB __hx_this)
	{
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		__hx_this.dialogues = new haxe.ds.StringMap<jackbergus.dgep.internals.Dialogue>();
		//line 28 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		__hx_this.protocols = new haxe.ds.StringMap<java.lang.String>();
	}
	
	
	public haxe.ds.StringMap<java.lang.String> protocols;
	
	public haxe.ds.StringMap<jackbergus.dgep.internals.Dialogue> dialogues;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		{
			//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
			boolean __temp_executeDef1 = true;
			//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
			if (( field != null )) 
			{
				//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
				switch (field.hashCode())
				{
					case 1340826011:
					{
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						if (field.equals("dialogues")) 
						{
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							__temp_executeDef1 = false;
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							this.dialogues = ((haxe.ds.StringMap<jackbergus.dgep.internals.Dialogue>) (value) );
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							return value;
						}
						
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						break;
					}
					
					
					case -599309093:
					{
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						if (field.equals("protocols")) 
						{
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							__temp_executeDef1 = false;
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							this.protocols = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							return value;
						}
						
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
			if (__temp_executeDef1) 
			{
				//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		{
			//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
			boolean __temp_executeDef1 = true;
			//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
			if (( field != null )) 
			{
				//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
				switch (field.hashCode())
				{
					case 1340826011:
					{
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						if (field.equals("dialogues")) 
						{
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							__temp_executeDef1 = false;
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							return this.dialogues;
						}
						
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						break;
					}
					
					
					case -599309093:
					{
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						if (field.equals("protocols")) 
						{
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							__temp_executeDef1 = false;
							//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
							return this.protocols;
						}
						
						//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
			if (__temp_executeDef1) 
			{
				//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		baseArr.push("dialogues");
		//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		baseArr.push("protocols");
		//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/MongoDB.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


