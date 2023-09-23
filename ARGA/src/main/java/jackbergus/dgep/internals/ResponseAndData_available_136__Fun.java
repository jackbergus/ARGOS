package jackbergus.dgep.internals;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ResponseAndData_available_136__Fun extends haxe.lang.Function
{
	public ResponseAndData_available_136__Fun(haxe.lang.Function pred)
	{
		//line 136 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		super(1, 0);
		//line 136 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		this.pred = pred;
	}
	
	
	@Override public java.lang.Object __hx_invoke1_o(double __fn_float1, java.lang.Object __fn_dyn1)
	{
		//line 136 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		jackbergus.dgep.internals.Move x = ( (( __fn_dyn1 == haxe.lang.Runtime.undefined )) ? (((jackbergus.dgep.internals.Move) (((java.lang.Object) (__fn_float1) )) )) : (((jackbergus.dgep.internals.Move) (__fn_dyn1) )) );
		//line 136 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		return x.nameMatch(this.pred);
	}
	
	
	public haxe.lang.Function pred;
	
}


