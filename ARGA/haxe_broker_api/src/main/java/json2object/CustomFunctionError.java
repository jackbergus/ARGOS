package json2object;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class CustomFunctionError extends haxe.lang.HxObject
{
	public CustomFunctionError(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public CustomFunctionError(java.lang.String message)
	{
		//line 112 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		json2object.CustomFunctionError.__hx_ctor_json2object_CustomFunctionError(this, message);
	}
	
	
	protected static void __hx_ctor_json2object_CustomFunctionError(json2object.CustomFunctionError __hx_this, java.lang.String message)
	{
		//line 113 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		__hx_this.message = message;
	}
	
	
	public java.lang.String message;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		{
			//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
			boolean __temp_executeDef1 = true;
			//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
			if (( field != null )) 
			{
				//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
				switch (field.hashCode())
				{
					case 954925063:
					{
						//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
						if (field.equals("message")) 
						{
							//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
							__temp_executeDef1 = false;
							//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
							this.message = haxe.lang.Runtime.toString(value);
							//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
							return value;
						}
						
						//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
			if (__temp_executeDef1) 
			{
				//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		{
			//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
			boolean __temp_executeDef1 = true;
			//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
			if (( field != null )) 
			{
				//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
				switch (field.hashCode())
				{
					case 954925063:
					{
						//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
						if (field.equals("message")) 
						{
							//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
							__temp_executeDef1 = false;
							//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
							return this.message;
						}
						
						//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
			if (__temp_executeDef1) 
			{
				//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		baseArr.push("message");
		//line 107 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


