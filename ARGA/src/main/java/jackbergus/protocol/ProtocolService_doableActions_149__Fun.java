package jackbergus.protocol;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ProtocolService_doableActions_149__Fun extends haxe.lang.Function
{
	public ProtocolService_doableActions_149__Fun(java.lang.String actionKind)
	{
		//line 149 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		super(1, 0);
		//line 149 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		this.actionKind = actionKind;
	}
	
	
	@Override public java.lang.Object __hx_invoke1_o(double __fn_float1, java.lang.Object __fn_dyn1)
	{
		//line 149 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		java.lang.String x = ( (( __fn_dyn1 == haxe.lang.Runtime.undefined )) ? (haxe.lang.Runtime.toString(__fn_float1)) : (haxe.lang.Runtime.toString(__fn_dyn1)) );
		//line 149 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		return haxe.lang.StringExt.substr(x, this.actionKind.length(), null);
	}
	
	
	public java.lang.String actionKind;
	
}


