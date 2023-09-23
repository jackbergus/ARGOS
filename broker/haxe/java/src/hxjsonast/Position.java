package hxjsonast;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Position extends haxe.lang.HxObject
{
	public Position(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Position(java.lang.String file, int min, int max)
	{
		//line 26 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		hxjsonast.Position.__hx_ctor_hxjsonast_Position(this, file, min, max);
	}
	
	
	protected static void __hx_ctor_hxjsonast_Position(hxjsonast.Position __hx_this, java.lang.String file, int min, int max)
	{
		//line 27 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		__hx_this.file = file;
		//line 28 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		__hx_this.min = min;
		//line 29 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		__hx_this.max = max;
	}
	
	
	public java.lang.String file;
	
	public int min;
	
	public int max;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		{
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			boolean __temp_executeDef1 = true;
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (( field != null )) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				switch (field.hashCode())
				{
					case 107876:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("max")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							this.max = ((int) (value) );
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return value;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
					case 108114:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("min")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							this.min = ((int) (value) );
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return value;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (__temp_executeDef1) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		{
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			boolean __temp_executeDef1 = true;
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (( field != null )) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				switch (field.hashCode())
				{
					case 107876:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("max")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							this.max = ((int) (haxe.lang.Runtime.toInt(value)) );
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return value;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
					case 3143036:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("file")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							this.file = haxe.lang.Runtime.toString(value);
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return value;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
					case 108114:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("min")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							this.min = ((int) (haxe.lang.Runtime.toInt(value)) );
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return value;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (__temp_executeDef1) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		{
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			boolean __temp_executeDef1 = true;
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (( field != null )) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				switch (field.hashCode())
				{
					case 107876:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("max")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return this.max;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
					case 3143036:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("file")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return this.file;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
					case 108114:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("min")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return this.min;
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (__temp_executeDef1) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		{
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			boolean __temp_executeDef1 = true;
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (( field != null )) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				switch (field.hashCode())
				{
					case 107876:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("max")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return ((double) (this.max) );
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
					case 108114:
					{
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						if (field.equals("min")) 
						{
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							__temp_executeDef1 = false;
							//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
							return ((double) (this.min) );
						}
						
						//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
			if (__temp_executeDef1) 
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		baseArr.push("max");
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		baseArr.push("min");
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		baseArr.push("file");
		//line 10 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Position.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


