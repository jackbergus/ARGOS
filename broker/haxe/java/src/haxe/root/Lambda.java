package haxe.root;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Lambda extends haxe.lang.HxObject
{
	public Lambda(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Lambda()
	{
		//line 39 "/usr/share/haxe/std/Lambda.hx"
		haxe.root.Lambda.__hx_ctor__Lambda(this);
	}
	
	
	protected static void __hx_ctor__Lambda(haxe.root.Lambda __hx_this)
	{
	}
	
	
	public static <A> boolean exists(java.lang.Object it, haxe.lang.Function f)
	{
		//line 126 "/usr/share/haxe/std/Lambda.hx"
		{
			//line 126 "/usr/share/haxe/std/Lambda.hx"
			java.lang.Object x = ((java.lang.Object) (haxe.lang.Runtime.callField(it, "iterator", null)) );
			//line 126 "/usr/share/haxe/std/Lambda.hx"
			while (haxe.lang.Runtime.toBool(((java.lang.Boolean) (haxe.lang.Runtime.callField(x, "hasNext", null)) )))
			{
				//line 126 "/usr/share/haxe/std/Lambda.hx"
				A x1 = ((A) (haxe.lang.Runtime.callField(x, "next", null)) );
				//line 127 "/usr/share/haxe/std/Lambda.hx"
				if (haxe.lang.Runtime.toBool(((java.lang.Boolean) (f.__hx_invoke1_o(0.0, x1)) ))) 
				{
					//line 128 "/usr/share/haxe/std/Lambda.hx"
					return true;
				}
				
			}
			
		}
		
		//line 129 "/usr/share/haxe/std/Lambda.hx"
		return false;
	}
	
	
}


