package haxe.io;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Bytes extends haxe.lang.HxObject
{
	public Bytes(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Bytes(int length, byte[] b)
	{
		//line 34 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		haxe.io.Bytes.__hx_ctor_haxe_io_Bytes(this, length, b);
	}
	
	
	protected static void __hx_ctor_haxe_io_Bytes(haxe.io.Bytes __hx_this, int length, byte[] b)
	{
		//line 35 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		__hx_this.length = length;
		//line 36 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		__hx_this.b = b;
	}
	
	
	public static haxe.io.Bytes alloc(int length)
	{
		//line 564 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		return new haxe.io.Bytes(((int) (length) ), ((byte[]) (new byte[length]) ));
	}
	
	
	public static haxe.io.Bytes ofString(java.lang.String s, haxe.io.Encoding encoding)
	{
		//line 603 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		try 
		{
			//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			byte[] b = null;
			//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (( encoding == null )) 
			{
				//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				b = s.getBytes(haxe.lang.Runtime.toString("UTF-8"));
			}
			else
			{
				//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				switch (encoding)
				{
					case UTF8:
					{
						//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						b = s.getBytes(haxe.lang.Runtime.toString("UTF-8"));
						//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case RawNative:
					{
						//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						b = s.getBytes(haxe.lang.Runtime.toString("UTF-16LE"));
						//line 604 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 610 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			return new haxe.io.Bytes(((int) (b.length) ), ((byte[]) (b) ));
		}
		catch (java.lang.Throwable _g)
		{
			//line 611 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 612 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
	public int length;
	
	public byte[] b;
	
	public haxe.io.Bytes sub(int pos, int len)
	{
		//line 157 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		if (( ( ( pos < 0 ) || ( len < 0 ) ) || ( ( pos + len ) > this.length ) )) 
		{
			//line 158 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(haxe.io.Error.OutsideBounds)) );
		}
		
		//line 168 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		byte[] newarr = new byte[len];
		//line 169 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		java.lang.System.arraycopy(((java.lang.Object) (this.b) ), ((int) (pos) ), ((java.lang.Object) (newarr) ), ((int) (0) ), ((int) (len) ));
		//line 170 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		return new haxe.io.Bytes(((int) (len) ), ((byte[]) (newarr) ));
	}
	
	
	public java.lang.String getString(int pos, int len, haxe.io.Encoding encoding)
	{
		//line 416 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		boolean tmp = ( encoding == null );
		//line 419 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		if (( ( ( pos < 0 ) || ( len < 0 ) ) || ( ( pos + len ) > this.length ) )) 
		{
			//line 420 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(haxe.io.Error.OutsideBounds)) );
		}
		
		//line 440 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		try 
		{
			//line 440 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (( encoding == null )) 
			{
				//line 442 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				return new java.lang.String(((byte[]) (this.b) ), ((int) (pos) ), ((int) (len) ), haxe.lang.Runtime.toString("UTF-8"));
			}
			else
			{
				//line 440 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				switch (encoding)
				{
					case UTF8:
					{
						//line 442 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						return new java.lang.String(((byte[]) (this.b) ), ((int) (pos) ), ((int) (len) ), haxe.lang.Runtime.toString("UTF-8"));
					}
					
					
					case RawNative:
					{
						//line 444 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						return new java.lang.String(((byte[]) (this.b) ), ((int) (pos) ), ((int) (len) ), haxe.lang.Runtime.toString("UTF-16LE"));
					}
					
					
				}
				
			}
			
		}
		catch (java.lang.Throwable _g)
		{
			//line 446 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 447 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
		//line 415 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		return null;
	}
	
	
	@Override public java.lang.String toString()
	{
		//line 512 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		try 
		{
			//line 512 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			return new java.lang.String(((byte[]) (this.b) ), ((int) (0) ), ((int) (this.length) ), haxe.lang.Runtime.toString("UTF-8"));
		}
		catch (java.lang.Throwable _g)
		{
			//line 513 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 514 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		{
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (( field != null )) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				switch (field.hashCode())
				{
					case -1106363674:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("length")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							this.length = ((int) (value) );
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return value;
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		{
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (( field != null )) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				switch (field.hashCode())
				{
					case 98:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("b")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							this.b = ((byte[]) (value) );
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return value;
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case -1106363674:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("length")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							this.length = ((int) (haxe.lang.Runtime.toInt(value)) );
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return value;
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		{
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (( field != null )) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				switch (field.hashCode())
				{
					case -1776922004:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("toString")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "toString")) );
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case -1106363674:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("length")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return this.length;
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case 804029191:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("getString")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "getString")) );
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case 98:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("b")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return this.b;
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case 114240:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("sub")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "sub")) );
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		{
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (( field != null )) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				switch (field.hashCode())
				{
					case -1106363674:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("length")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return ((double) (this.length) );
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		{
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			boolean __temp_executeDef1 = true;
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (( field != null )) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				switch (field.hashCode())
				{
					case -1776922004:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("toString")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return this.toString();
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case 114240:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("sub")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return this.sub(((int) (haxe.lang.Runtime.toInt(dynargs[0])) ), ((int) (haxe.lang.Runtime.toInt(dynargs[1])) ));
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
					case 804029191:
					{
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						if (field.equals("getString")) 
						{
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							__temp_executeDef1 = false;
							//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
							return this.getString(((int) (haxe.lang.Runtime.toInt(dynargs[0])) ), ((int) (haxe.lang.Runtime.toInt(dynargs[1])) ), ((haxe.io.Encoding) (( (( dynargs.length > 2 )) ? (dynargs[2]) : (null) )) ));
						}
						
						//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
			if (__temp_executeDef1) 
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		baseArr.push("b");
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		baseArr.push("length");
		//line 29 "/usr/share/haxe/std/haxe/io/Bytes.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


