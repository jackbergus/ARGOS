package hxjsonast;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Json extends haxe.lang.HxObject
{
	public Json(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Json(hxjsonast.JsonValue value, hxjsonast.Position pos)
	{
		//line 18 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		hxjsonast.Json.__hx_ctor_hxjsonast_Json(this, value, pos);
	}
	
	
	protected static void __hx_ctor_hxjsonast_Json(hxjsonast.Json __hx_this, hxjsonast.JsonValue value, hxjsonast.Position pos)
	{
		//line 19 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		__hx_this.value = value;
		//line 20 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		__hx_this.pos = pos;
	}
	
	
	public hxjsonast.JsonValue value;
	
	public hxjsonast.Position pos;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		{
			//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (( field != null )) 
			{
				//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("pos")) 
						{
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							this.pos = ((hxjsonast.Position) (value) );
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return value;
						}
						
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
					case 111972721:
					{
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("value")) 
						{
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							this.value = ((hxjsonast.JsonValue) (value) );
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return value;
						}
						
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		{
			//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			boolean __temp_executeDef1 = true;
			//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (( field != null )) 
			{
				//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("pos")) 
						{
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return this.pos;
						}
						
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
					case 111972721:
					{
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("value")) 
						{
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return this.value;
						}
						
						//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (__temp_executeDef1) 
			{
				//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		baseArr.push("pos");
		//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		baseArr.push("value");
		//line 7 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


