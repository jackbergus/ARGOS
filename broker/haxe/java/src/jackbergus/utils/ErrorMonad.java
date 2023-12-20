package jackbergus.utils;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ErrorMonad extends haxe.lang.ParamEnum
{
	public ErrorMonad(int index, java.lang.Object[] params)
	{
		//line 240 "/usr/share/haxe/std/java/internal/HxObject.hx"
		super(index, params);
	}
	
	
	public static final java.lang.String[] __hx_constructs = new java.lang.String[]{"Error", "Good"};
	
	public static jackbergus.utils.ErrorMonad Error(java.lang.String x, java.lang.Object error)
	{
		//line 5 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/utils/Monad.hx"
		return new jackbergus.utils.ErrorMonad(0, new java.lang.Object[]{x, error});
	}
	
	
	public static jackbergus.utils.ErrorMonad Good(java.lang.Object value)
	{
		//line 6 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/utils/Monad.hx"
		return new jackbergus.utils.ErrorMonad(1, new java.lang.Object[]{value});
	}
	
	
	@Override public java.lang.String getTag()
	{
		//line 4 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/utils/Monad.hx"
		return jackbergus.utils.ErrorMonad.__hx_constructs[this.index];
	}
	
	
}


