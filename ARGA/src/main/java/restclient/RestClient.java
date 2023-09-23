package restclient;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class RestClient extends haxe.lang.HxObject
{
	static
	{
		//line 16 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		restclient.RestClient.preferHttpMethodOverride = false;
	}
	
	public RestClient(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public RestClient()
	{
		//line 11 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		restclient.RestClient.__hx_ctor_restclient_RestClient(this);
	}
	
	
	protected static void __hx_ctor_restclient_RestClient(restclient.RestClient __hx_this)
	{
	}
	
	
	public static boolean preferHttpMethodOverride;
	
	public static void postAsync(java.lang.String url, haxe.lang.Function onData, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		restclient.RestClient.requestAsync("POST", url, onData, parameters, onError);
	}
	
	
	public static void getAsync(java.lang.String url, haxe.lang.Function onData, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 26 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		restclient.RestClient.requestAsync("GET", url, onData, parameters, onError);
	}
	
	
	public static void putAsync(java.lang.String url, haxe.lang.Function onData, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 31 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		restclient.RestClient.requestAsync("PUT", url, onData, parameters, onError);
	}
	
	
	public static void deleteAsync(java.lang.String url, haxe.lang.Function onData, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		restclient.RestClient.requestAsync("DELETE", url, onData, parameters, onError);
	}
	
	
	public static java.lang.String post(java.lang.String url, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 43 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		return restclient.RestClient.request("POST", url, parameters, null, onError, null);
	}
	
	
	public static java.lang.String get(java.lang.String url, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 48 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		return restclient.RestClient.request("GET", url, parameters, null, onError, null);
	}
	
	
	public static java.lang.String put(java.lang.String url, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 53 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		return restclient.RestClient.request("PUT", url, parameters, null, onError, null);
	}
	
	
	public static java.lang.String delete(java.lang.String url, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		return restclient.RestClient.request("DELETE", url, parameters, null, onError, null);
	}
	
	
	public static void requestAsync(java.lang.String verb, java.lang.String url, haxe.lang.Function onData, haxe.ds.StringMap<java.lang.String> parameters, haxe.lang.Function onError)
	{
		//line 64 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		boolean post =  ! (haxe.lang.Runtime.valEq(verb, "GET")) ;
		//line 65 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		sys.Http httpRequest = restclient.RestClient.buildHttpRequest(verb, true, url, parameters, true, onData, onError);
		//line 73 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		httpRequest.request(post);
	}
	
	
	public static java.lang.String request(java.lang.String verb, java.lang.String url, haxe.ds.StringMap<java.lang.String> parameters, java.lang.Object async, haxe.lang.Function onData, haxe.lang.Function onError)
	{
		//line 82 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		boolean async1 = ( (haxe.lang.Runtime.eq(async, null)) ? (false) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (async) ))) );
		//line 83 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		java.lang.String[] result = new java.lang.String[1];
		//line 86 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		boolean useOverride = restclient.RestClient.preferHttpMethodOverride;
		//line 90 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		boolean post =  ! (haxe.lang.Runtime.valEq(verb, "GET")) ;
		//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		sys.Http httpRequest = restclient.RestClient.buildHttpRequest(verb, useOverride, url, parameters, false, new restclient.RestClient_request_97__Fun(result), onError);
		//line 106 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		haxe.io.BytesOutput output = new haxe.io.BytesOutput();
		//line 107 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		if (useOverride) 
		{
			//line 108 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
			verb = ( (post) ? ("POST") : ("GET") );
		}
		
		//line 109 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		httpRequest.customRequest(false, output, null, verb);
		//line 110 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		return output.getBytes().toString();
	}
	
	
	public static sys.Http buildHttpRequest(java.lang.String verb, boolean useOverride, java.lang.String url, haxe.ds.StringMap<java.lang.String> parameters, java.lang.Object async, haxe.lang.Function onData, haxe.lang.Function onError)
	{
		//line 118 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		boolean async1 = ( (haxe.lang.Runtime.eq(async, null)) ? (false) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (async) ))) );
		//line 119 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		sys.Http httpRequest = new sys.Http(haxe.lang.Runtime.toString(url));
		//line 125 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		if (( onError != null )) 
		{
			//line 127 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
			httpRequest.onError = onError;
		}
		
		//line 130 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		if (( onData != null )) 
		{
			//line 132 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
			httpRequest.onData = onData;
		}
		
		//line 135 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		if (( parameters != null )) 
		{
			//line 137 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
			java.lang.Object x = ((java.lang.Object) (new haxe.ds._StringMap.StringMapKeyIterator<java.lang.String>(((haxe.ds.StringMap<java.lang.String>) (parameters) ))) );
			//line 137 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
			while (haxe.lang.Runtime.toBool(((java.lang.Boolean) (haxe.lang.Runtime.callField(x, "hasNext", null)) )))
			{
				//line 137 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
				java.lang.String x1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.callField(x, "next", null));
				//line 139 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
				httpRequest.setParameter(x1, haxe.lang.Runtime.toString(parameters.get(x1)));
			}
			
		}
		
		//line 144 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		if (( ( useOverride &&  ! (haxe.lang.Runtime.valEq(verb, "GET"))  ) &&  ! (haxe.lang.Runtime.valEq(verb, "POST"))  )) 
		{
			//line 146 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
			httpRequest.setHeader("X-HTTP-Method-Override", verb);
		}
		
		//line 149 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/restclient/RestClient.hx"
		return httpRequest;
	}
	
	
}


