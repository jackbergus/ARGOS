package haxe.root;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Sys extends haxe.lang.HxObject
{
	public Sys(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Sys()
	{
		//line 28 "/usr/share/haxe/std/java/_std/Sys.hx"
		haxe.root.Sys.__hx_ctor__Sys(this);
	}
	
	
	protected static void __hx_ctor__Sys(haxe.root.Sys __hx_this)
	{
	}
	
	
	public static void sleep(double seconds)
	{
		//line 69 "/usr/share/haxe/std/java/_std/Sys.hx"
		try 
		{
			//line 69 "/usr/share/haxe/std/java/_std/Sys.hx"
			java.lang.Thread.sleep(((long) (( seconds * 1000 )) ));
		}
		catch (java.lang.Throwable _g)
		{
			//line 70 "/usr/share/haxe/std/java/_std/Sys.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 71 "/usr/share/haxe/std/java/_std/Sys.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
}


