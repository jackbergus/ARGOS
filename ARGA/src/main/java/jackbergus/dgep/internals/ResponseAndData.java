package jackbergus.dgep.internals;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ResponseAndData extends haxe.lang.HxObject
{
	public ResponseAndData(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ResponseAndData()
	{
		//line 105 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		jackbergus.dgep.internals.ResponseAndData.__hx_ctor_jackbergus_dgep_internals_ResponseAndData(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_internals_ResponseAndData(jackbergus.dgep.internals.ResponseAndData __hx_this)
	{
		//line 125 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		__hx_this.response = new haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>();
		//line 126 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		__hx_this.data = new haxe.ds.StringMap<java.lang.String>();
	}
	
	
	public haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>> response;
	
	public haxe.ds.StringMap<java.lang.String> data;
	
	public haxe.ds.List<java.lang.String> available(java.lang.String user, haxe.lang.Function pred)
	{
		//line 130 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		haxe.ds.List<java.lang.String> l = new haxe.ds.List<java.lang.String>();
		//line 131 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		if ( ! (((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (((haxe.IMap<java.lang.String, haxe.ds.List<jackbergus.dgep.internals.Move>>) (this.response) )) ).exists(user)) ) 
		{
			//line 132 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			return l;
		}
		else
		{
			//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			return ((haxe.ds.List<java.lang.String>) (((haxe.ds.List) (((haxe.ds.List<jackbergus.dgep.internals.Move>) (((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (((haxe.IMap<java.lang.String, haxe.ds.List<jackbergus.dgep.internals.Move>>) (this.response) )) ).get(user)) ).filter(new jackbergus.dgep.internals.ResponseAndData_available_136__Fun(pred)).map(((haxe.lang.Function) (( (( jackbergus.dgep.internals.ResponseAndData_available_137__Fun.__hx_current != null )) ? (jackbergus.dgep.internals.ResponseAndData_available_137__Fun.__hx_current) : (jackbergus.dgep.internals.ResponseAndData_available_137__Fun.__hx_current = ((jackbergus.dgep.internals.ResponseAndData_available_137__Fun) (new jackbergus.dgep.internals.ResponseAndData_available_137__Fun()) )) )) ))) )) );
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		{
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			boolean __temp_executeDef1 = true;
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (( field != null )) 
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				switch (field.hashCode())
				{
					case 3076010:
					{
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("data")) 
						{
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							this.data = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return value;
						}
						
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case -340323263:
					{
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("response")) 
						{
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							this.response = ((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (value) );
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return value;
						}
						
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (__temp_executeDef1) 
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		{
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			boolean __temp_executeDef1 = true;
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (( field != null )) 
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				switch (field.hashCode())
				{
					case -733902135:
					{
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("available")) 
						{
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "available")) );
						}
						
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case -340323263:
					{
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("response")) 
						{
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.response;
						}
						
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
					case 3076010:
					{
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("data")) 
						{
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.data;
						}
						
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (__temp_executeDef1) 
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		{
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			boolean __temp_executeDef1 = true;
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (( field != null )) 
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				switch (field.hashCode())
				{
					case -733902135:
					{
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						if (field.equals("available")) 
						{
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							__temp_executeDef1 = false;
							//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
							return this.available(haxe.lang.Runtime.toString(dynargs[0]), ((haxe.lang.Function) (dynargs[1]) ));
						}
						
						//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			if (__temp_executeDef1) 
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		baseArr.push("data");
		//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		baseArr.push("response");
		//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


