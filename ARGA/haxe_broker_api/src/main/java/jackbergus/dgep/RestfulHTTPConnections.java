package jackbergus.dgep;


import jackbergus.ARGA.utils.HTTPRequests;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class RestfulHTTPConnections extends haxe.lang.HxObject
{
	public RestfulHTTPConnections(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public RestfulHTTPConnections(java.lang.String addr, int port)
	{
		//line 53 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		jackbergus.dgep.RestfulHTTPConnections.__hx_ctor_jackbergus_dgep_RestfulHTTPConnections(this, addr, port);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_RestfulHTTPConnections(jackbergus.dgep.RestfulHTTPConnections __hx_this, java.lang.String addr, int port)
	{
		//line 54 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		__hx_this.url = ( ( ( "http://" + addr ) + ":" ) + port );
	}
	
	
	public java.lang.String url;
	
	public java.lang.String fileRequest(java.lang.String path, java.lang.String content, java.lang.Object isPut)
	{
		//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		boolean isPut1 = ( (haxe.lang.Runtime.eq(isPut, null)) ? (true) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (isPut) ))) );
		//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		if (( content == null )) 
		{
			//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			content = "";
		}
		
		//line 59 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		sys.Http req = new sys.Http(haxe.lang.Runtime.toString(( this.url + path )));
		//line 60 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		haxe.io.BytesOutput responseBytes = new haxe.io.BytesOutput();
		//line 61 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		if (( content.length() > 0 )) 
		{
			//line 62 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			req.setPostData(content);
		}
		
		//line 63 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		req.onError = ( (( jackbergus.dgep.RestfulHTTPConnections_fileRequest_63__Fun.__hx_current != null )) ? (jackbergus.dgep.RestfulHTTPConnections_fileRequest_63__Fun.__hx_current) : (jackbergus.dgep.RestfulHTTPConnections_fileRequest_63__Fun.__hx_current = ((jackbergus.dgep.RestfulHTTPConnections_fileRequest_63__Fun) (new jackbergus.dgep.RestfulHTTPConnections_fileRequest_63__Fun()) )) );
		//line 64 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		if (isPut1) 
		{
			//line 65 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			req.customRequest(true, responseBytes, null, "PUT");
		}
		else
		{
			//line 67 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			req.customRequest(true, responseBytes, null, null);
		}
		
		//line 68 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		haxe.io.Bytes response = responseBytes.getBytes();
		//line 69 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		return response.toString();
	}
	
	
	public java.lang.String postFile(java.lang.String path, java.lang.String content)
	{
		return HTTPRequests.postRequest( this.url +path, content, null);
//		//line 79 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
//		if (( content == null ))
//		{
//			//line 79 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
//			content = "";
//		}
//
//		//line 79 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
//		return this.fileRequest(path, content, false);
	}
	
	
	public java.lang.String get(java.lang.String path)
	{
		return HTTPRequests.getRequest(this.url+path);
		//line 89 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
//		return restclient.RestClient.get(( this.url + path ), null, null);
	}
	
	
	public java.lang.String putFile(java.lang.String path, java.lang.String content)
	{
		return HTTPRequests.putRequest(url+path, content, null);
//		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
//		if (( content == null ))
//		{
//			//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
//			content = "";
//		}
//
//		//line 99 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
//		return this.fileRequest(path, content, true);
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		{
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			boolean __temp_executeDef1 = true;
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			if (( field != null )) 
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				switch (field.hashCode())
				{
					case 116079:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("url")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							this.url = haxe.lang.Runtime.toString(value);
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return value;
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			if (__temp_executeDef1) 
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		{
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			boolean __temp_executeDef1 = true;
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			if (( field != null )) 
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				switch (field.hashCode())
				{
					case -219874005:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("putFile")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "putFile")) );
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
					case 116079:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("url")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return this.url;
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
					case 102230:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("get")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "get")) );
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
					case -1300516493:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("fileRequest")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "fileRequest")) );
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
					case 756593212:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("postFile")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "postFile")) );
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			if (__temp_executeDef1) 
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		{
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			boolean __temp_executeDef1 = true;
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			if (( field != null )) 
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				switch (field.hashCode())
				{
					case -219874005:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("putFile")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return this.putFile(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )));
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
					case -1300516493:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("fileRequest")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return this.fileRequest(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )), ( (( dynargs.length > 2 )) ? (dynargs[2]) : (null) ));
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
					case 102230:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("get")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return this.get(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
					case 756593212:
					{
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						if (field.equals("postFile")) 
						{
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							__temp_executeDef1 = false;
							//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
							return this.postFile(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )));
						}
						
						//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
			if (__temp_executeDef1) 
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		baseArr.push("url");
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/RestfulHTTPConnections.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


