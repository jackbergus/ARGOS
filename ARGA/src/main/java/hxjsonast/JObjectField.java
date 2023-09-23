package hxjsonast;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class JObjectField extends haxe.lang.HxObject
{
	public JObjectField(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public JObjectField(java.lang.String name, hxjsonast.Position namePos, hxjsonast.Json value)
	{
		//line 86 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		hxjsonast.JObjectField.__hx_ctor_hxjsonast_JObjectField(this, name, namePos, value);
	}
	
	
	protected static void __hx_ctor_hxjsonast_JObjectField(hxjsonast.JObjectField __hx_this, java.lang.String name, hxjsonast.Position namePos, hxjsonast.Json value)
	{
		//line 87 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		__hx_this.name = name;
		//line 88 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		__hx_this.namePos = namePos;
		//line 89 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		__hx_this.value = value;
	}
	
	
	public java.lang.String name;
	
	public hxjsonast.Position namePos;
	
	public hxjsonast.Json value;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		{
			//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			boolean __temp_executeDef1 = true;
			//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (( field != null )) 
			{
				//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				switch (field.hashCode())
				{
					case 111972721:
					{
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("value")) 
						{
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							this.value = ((hxjsonast.Json) (value) );
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return value;
						}
						
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
					case 3373707:
					{
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("name")) 
						{
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							this.name = haxe.lang.Runtime.toString(value);
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return value;
						}
						
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
					case 1721937865:
					{
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("namePos")) 
						{
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							this.namePos = ((hxjsonast.Position) (value) );
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return value;
						}
						
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (__temp_executeDef1) 
			{
				//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		{
			//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			boolean __temp_executeDef1 = true;
			//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (( field != null )) 
			{
				//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				switch (field.hashCode())
				{
					case 111972721:
					{
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("value")) 
						{
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return this.value;
						}
						
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
					case 3373707:
					{
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("name")) 
						{
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return this.name;
						}
						
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
					case 1721937865:
					{
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						if (field.equals("namePos")) 
						{
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							__temp_executeDef1 = false;
							//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
							return this.namePos;
						}
						
						//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
			if (__temp_executeDef1) 
			{
				//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		baseArr.push("value");
		//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		baseArr.push("namePos");
		//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		baseArr.push("name");
		//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


