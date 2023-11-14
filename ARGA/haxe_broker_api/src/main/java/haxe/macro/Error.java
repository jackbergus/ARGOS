package haxe.macro;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Error extends haxe.Exception
{
	public Error(haxe.lang.EmptyObject empty)
	{
		//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		super(haxe.lang.EmptyObject.EMPTY);
	}
	
	
	public Error(java.lang.String message, java.lang.Object pos, haxe.Exception previous)
	{
		//line 1001 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		super(haxe.lang.Runtime.toString(message), ((haxe.Exception) (( (( previous == null )) ? (null) : (previous) )) ), ((java.lang.Object) (null) ));
		//line 1002 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		this.pos = pos;
	}
	
	
	public java.lang.Object pos;
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		{
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			boolean __temp_executeDef1 = true;
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (( field != null )) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						if (field.equals("pos")) 
						{
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							__temp_executeDef1 = false;
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							this.pos = ((java.lang.Object) (value) );
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							return value;
						}
						
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (__temp_executeDef1) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		{
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			boolean __temp_executeDef1 = true;
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (( field != null )) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						if (field.equals("pos")) 
						{
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							__temp_executeDef1 = false;
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							this.pos = ((java.lang.Object) (value) );
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							return value;
						}
						
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (__temp_executeDef1) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		{
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			boolean __temp_executeDef1 = true;
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (( field != null )) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						if (field.equals("pos")) 
						{
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							__temp_executeDef1 = false;
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							return this.pos;
						}
						
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (__temp_executeDef1) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		{
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			boolean __temp_executeDef1 = true;
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (( field != null )) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						if (field.equals("pos")) 
						{
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							__temp_executeDef1 = false;
							//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
							return ((double) (haxe.lang.Runtime.toDouble(this.pos)) );
						}
						
						//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
			if (__temp_executeDef1) 
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		baseArr.push("pos");
		//line 991 "/usr/share/haxe/std/haxe/macro/Expr.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


