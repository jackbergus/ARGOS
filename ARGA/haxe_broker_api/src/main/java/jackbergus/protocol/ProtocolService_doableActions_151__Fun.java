package jackbergus.protocol;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ProtocolService_doableActions_151__Fun extends haxe.lang.Function
{
	public ProtocolService_doableActions_151__Fun(java.lang.String actionKind, java.lang.String action)
	{
		//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		super(1, 0);
		//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		this.actionKind = actionKind;
		//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		this.action = action;
	}
	
	
	@Override public java.lang.Object __hx_invoke1_o(double __fn_float1, java.lang.Object __fn_dyn1)
	{
		//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		java.lang.String x = ( (( __fn_dyn1 == haxe.lang.Runtime.undefined )) ? (haxe.lang.Runtime.toString(__fn_float1)) : (haxe.lang.Runtime.toString(__fn_dyn1)) );
		//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		return haxe.lang.Runtime.valEq(x, ( this.actionKind + this.action ));
	}
	
	
	public java.lang.String actionKind;
	
	public java.lang.String action;
	
}


