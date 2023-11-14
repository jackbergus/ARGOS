package jackbergus.protocol;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ProtocolService_doableActions_148__Fun extends haxe.lang.Function
{
	public ProtocolService_doableActions_148__Fun(java.lang.String actionKind)
	{
		//line 148 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		super(1, 0);
		//line 148 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		this.actionKind = actionKind;
	}
	
	
	@Override public java.lang.Object __hx_invoke1_o(double __fn_float1, java.lang.Object __fn_dyn1)
	{
		//line 148 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		java.lang.String x = ( (( __fn_dyn1 == haxe.lang.Runtime.undefined )) ? (haxe.lang.Runtime.toString(__fn_float1)) : (haxe.lang.Runtime.toString(__fn_dyn1)) );
		//line 148 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		return ((java.lang.String) (((java.lang.Object) (x) )) ).startsWith(haxe.lang.Runtime.toString(this.actionKind));
	}
	
	
	public java.lang.String actionKind;
	
}


