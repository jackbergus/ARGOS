package haxe.ds;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class List<T> extends haxe.lang.HxObject
{
	public List(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public List()
	{
		//line 44 "/usr/share/haxe/std/haxe/ds/List.hx"
		haxe.ds.List.__hx_ctor_haxe_ds_List(((haxe.ds.List<T>) (this) ));
		//line 44 "/usr/share/haxe/std/haxe/ds/List.hx"
		java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
	}
	
	
	protected static <T_c> void __hx_ctor_haxe_ds_List(haxe.ds.List<T_c> __hx_this)
	{
		//line 45 "/usr/share/haxe/std/haxe/ds/List.hx"
		__hx_this.length = 0;
	}
	
	
	public haxe.ds._List.ListNode<T> h;
	
	public haxe.ds._List.ListNode<T> q;
	
	public int length;
	
	public void add(T item)
	{
		//line 54 "/usr/share/haxe/std/haxe/ds/List.hx"
		haxe.ds._List.ListNode<T> next = null;
		//line 54 "/usr/share/haxe/std/haxe/ds/List.hx"
		haxe.ds._List.ListNode<T> x = new haxe.ds._List.ListNode<T>(((T) (item) ), ((haxe.ds._List.ListNode<T>) (next) ));
		//line 55 "/usr/share/haxe/std/haxe/ds/List.hx"
		if (( this.h == null )) 
		{
			//line 56 "/usr/share/haxe/std/haxe/ds/List.hx"
			this.h = x;
		}
		else
		{
			//line 58 "/usr/share/haxe/std/haxe/ds/List.hx"
			this.q.next = x;
		}
		
		//line 59 "/usr/share/haxe/std/haxe/ds/List.hx"
		this.q = x;
		//line 60 "/usr/share/haxe/std/haxe/ds/List.hx"
		this.length++;
	}
	
	
	public haxe.ds.List<T> filter(haxe.lang.Function f)
	{
		//line 218 "/usr/share/haxe/std/haxe/ds/List.hx"
		haxe.ds.List<T> l2 = new haxe.ds.List<T>();
		//line 219 "/usr/share/haxe/std/haxe/ds/List.hx"
		haxe.ds._List.ListNode<T> l = this.h;
		//line 220 "/usr/share/haxe/std/haxe/ds/List.hx"
		while (( l != null ))
		{
			//line 221 "/usr/share/haxe/std/haxe/ds/List.hx"
			T v = l.item;
			//line 222 "/usr/share/haxe/std/haxe/ds/List.hx"
			l = l.next;
			//line 223 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (haxe.lang.Runtime.toBool(((java.lang.Boolean) (f.__hx_invoke1_o(0.0, v)) ))) 
			{
				//line 224 "/usr/share/haxe/std/haxe/ds/List.hx"
				l2.add(v);
			}
			
		}
		
		//line 226 "/usr/share/haxe/std/haxe/ds/List.hx"
		return l2;
	}
	
	
	public <X> haxe.ds.List<X> map(haxe.lang.Function f)
	{
		//line 234 "/usr/share/haxe/std/haxe/ds/List.hx"
		haxe.ds.List<X> b = new haxe.ds.List<X>();
		//line 235 "/usr/share/haxe/std/haxe/ds/List.hx"
		haxe.ds._List.ListNode<T> l = this.h;
		//line 236 "/usr/share/haxe/std/haxe/ds/List.hx"
		while (( l != null ))
		{
			//line 237 "/usr/share/haxe/std/haxe/ds/List.hx"
			T v = l.item;
			//line 238 "/usr/share/haxe/std/haxe/ds/List.hx"
			l = l.next;
			//line 239 "/usr/share/haxe/std/haxe/ds/List.hx"
			b.add(((X) (f.__hx_invoke1_o(0.0, v)) ));
		}
		
		//line 241 "/usr/share/haxe/std/haxe/ds/List.hx"
		return b;
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		{
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			boolean __temp_executeDef1 = true;
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (( field != null )) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				switch (field.hashCode())
				{
					case -1106363674:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("length")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							this.length = ((int) (value) );
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return value;
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (__temp_executeDef1) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		{
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			boolean __temp_executeDef1 = true;
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (( field != null )) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				switch (field.hashCode())
				{
					case -1106363674:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("length")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							this.length = ((int) (haxe.lang.Runtime.toInt(value)) );
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return value;
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case 104:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("h")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							this.h = ((haxe.ds._List.ListNode<T>) (value) );
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return value;
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case 113:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("q")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							this.q = ((haxe.ds._List.ListNode<T>) (value) );
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return value;
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (__temp_executeDef1) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		{
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			boolean __temp_executeDef1 = true;
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (( field != null )) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				switch (field.hashCode())
				{
					case 107868:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("map")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "map")) );
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case 104:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("h")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return this.h;
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case -1274492040:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("filter")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "filter")) );
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case 113:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("q")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return this.q;
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case 96417:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("add")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "add")) );
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case -1106363674:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("length")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return this.length;
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (__temp_executeDef1) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		{
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			boolean __temp_executeDef1 = true;
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (( field != null )) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				switch (field.hashCode())
				{
					case -1106363674:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("length")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return ((double) (this.length) );
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (__temp_executeDef1) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		{
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			boolean __temp_executeDef1 = true;
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (( field != null )) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				switch (field.hashCode())
				{
					case 107868:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("map")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return ((haxe.ds.List<java.lang.Object>) (this.map(((haxe.lang.Function) (dynargs[0]) ))) );
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case 96417:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("add")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							this.add(((T) (dynargs[0]) ));
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
					case -1274492040:
					{
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						if (field.equals("filter")) 
						{
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							__temp_executeDef1 = false;
							//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
							return this.filter(((haxe.lang.Function) (dynargs[0]) ));
						}
						
						//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
			if (__temp_executeDef1) 
			{
				//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		baseArr.push("length");
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		baseArr.push("q");
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		baseArr.push("h");
		//line 32 "/usr/share/haxe/std/haxe/ds/List.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


