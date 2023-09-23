package restclient;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class RestClient_request_97__Fun extends haxe.lang.Function
{
	public RestClient_request_97__Fun(java.lang.String[] result)
	{
		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		super(1, 0);
		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		this.result = result;
	}
	
	
	@Override public java.lang.Object __hx_invoke1_o(double __fn_float1, java.lang.Object __fn_dyn1)
	{
		//line 97 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		java.lang.String data = ( (( __fn_dyn1 == haxe.lang.Runtime.undefined )) ? (haxe.lang.Runtime.toString(__fn_float1)) : (haxe.lang.Runtime.toString(__fn_dyn1)) );
		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		this.result[0] = data;
		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		return null;
	}
	
	
	public java.lang.String[] result;
	
}


