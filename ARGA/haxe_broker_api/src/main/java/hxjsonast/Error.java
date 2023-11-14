package hxjsonast;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Error extends haxe.lang.HxObject
{
	public Error(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Error(java.lang.String message, hxjsonast.Position pos)
	{
		//line 12 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		hxjsonast.Error.__hx_ctor_hxjsonast_Error(this, message, pos);
	}
	
	
	protected static void __hx_ctor_hxjsonast_Error(hxjsonast.Error __hx_this, java.lang.String message, hxjsonast.Position pos)
	{
		//line 13 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		__hx_this.message = message;
		//line 14 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		__hx_this.pos = pos;
	}
	
	
	public java.lang.String message;
	
	public hxjsonast.Position pos;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		{
			//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
			if (( field != null )) 
			{
				//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						if (field.equals("pos")) 
						{
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							__temp_executeDef1 = false;
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							this.pos = ((hxjsonast.Position) (value) );
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							return value;
						}
						
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						break;
					}
					
					
					case 954925063:
					{
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						if (field.equals("message")) 
						{
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							__temp_executeDef1 = false;
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							this.message = haxe.lang.Runtime.toString(value);
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							return value;
						}
						
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		{
			//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
			boolean __temp_executeDef1 = true;
			//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
			if (( field != null )) 
			{
				//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						if (field.equals("pos")) 
						{
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							__temp_executeDef1 = false;
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							return this.pos;
						}
						
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						break;
					}
					
					
					case 954925063:
					{
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						if (field.equals("message")) 
						{
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							__temp_executeDef1 = false;
							//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
							return this.message;
						}
						
						//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
			if (__temp_executeDef1) 
			{
				//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		baseArr.push("pos");
		//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		baseArr.push("message");
		//line 8 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Error.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


