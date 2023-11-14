package jackbergus.dgep.connections;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ConnectionRaw extends haxe.lang.HxObject
{
	public ConnectionRaw(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ConnectionRaw(java.lang.String addr, int port)
	{
		//line 34 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		jackbergus.dgep.connections.ConnectionRaw.__hx_ctor_jackbergus_dgep_connections_ConnectionRaw(this, addr, port);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_connections_ConnectionRaw(jackbergus.dgep.connections.ConnectionRaw __hx_this, java.lang.String addr, int port)
	{
		//line 35 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		__hx_this.url = new jackbergus.dgep.RestfulHTTPConnections(haxe.lang.Runtime.toString(addr), ((int) (port) ));
		//line 36 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		__hx_this.protocolListParser = new haxe.root.JsonParser_11(((haxe.root.Array<json2object.Error>) (null) ), ((json2object.PositionUtils) (null) ), ((java.lang.Object) (null) ));
	}
	
	
	public jackbergus.dgep.RestfulHTTPConnections url;
	
	public haxe.root.JsonParser_11 protocolListParser;
	
	public java.lang.String loadDB(java.lang.String json)
	{
		//line 40 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return this.url.postFile("/load/", json);
	}
	
	
	public jackbergus.dgep.internals.MongoDB dump()
	{
		//line 44 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String x = this.url.get("/dump/");
		//line 45 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		jackbergus.dgep.internals.MongoDB obj = ((jackbergus.dgep.internals.MongoDB) (new haxe.format.JsonParser(haxe.lang.Runtime.toString(x)).doParse()) );
		//line 47 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return obj;
	}
	
	
	public jackbergus.dgep.messages.DialogueMessage newDialogueFromProtocol(java.lang.String protocol, java.lang.String dialogue, java.lang.String data, java.lang.String initiator)
	{
		//line 51 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		if (( initiator == null )) 
		{
			//line 51 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			initiator = "";
		}
		
		//line 52 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String str = ( ( ( "/new/" + protocol ) + "/" ) + dialogue );
		//line 53 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		if (( initiator.length() > 0 )) 
		{
			//line 54 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			str = ( ( str + "/" ) + initiator );
		}
		
		//line 55 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String x = this.url.postFile(str, data);
		//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		haxe.root.JsonParser_9 msgParser = new haxe.root.JsonParser_9(((haxe.root.Array<json2object.Error>) (null) ), ((json2object.PositionUtils) (null) ), ((java.lang.Object) (null) ));
		//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		jackbergus.dgep.messages.DialogueMessage msg = msgParser.fromJson(x, null);
		//line 59 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return msg;
	}
	
	
	public jackbergus.dgep.internals.ResponseAndData interaction(java.lang.String dialogue, java.lang.String interactionId, java.lang.String json)
	{
		//line 63 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String str = ( ( ( "/" + dialogue ) + "/interaction/" ) + interactionId );
		//line 64 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String x = this.url.postFile(str, json);
		//line 65 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		haxe.root.JsonParser_6 parser = new haxe.root.JsonParser_6(((haxe.root.Array<json2object.Error>) (null) ), ((json2object.PositionUtils) (null) ), ((java.lang.Object) (null) ));
		//line 67 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return parser.fromJson(x, null);
	}
	
	
	public jackbergus.dgep.internals.ResponseAndData dialogueMoves(java.lang.String dialogue, java.lang.String initiator)
	{
		//line 70 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		if (( initiator == null )) 
		{
			//line 70 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			initiator = "";
		}
		
		//line 71 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String str = ( ( "/" + dialogue ) + "/moves/" );
		//line 72 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		if (( initiator.length() > 0 )) 
		{
			//line 73 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			str += initiator;
		}
		
		//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String x = this.url.get(str);
		//line 75 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		haxe.root.JsonParser_6 parser = new haxe.root.JsonParser_6(((haxe.root.Array<json2object.Error>) (null) ), ((json2object.PositionUtils) (null) ), ((java.lang.Object) (null) ));
		//line 77 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return parser.fromJson(x, null);
	}
	
	
	public java.lang.String getProtocol2(java.lang.String id)
	{
		//line 82 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String x = this.url.get(( "/" + id ));
		//line 83 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return x;
	}
	
	
	public haxe.ds.StringMap<java.lang.Object> list()
	{
		//line 87 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String x = this.url.putFile("/list/", null);
		//line 88 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		haxe.ds.StringMap<java.lang.Object> obj = this.protocolListParser.fromJson(x, null);
		//line 89 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return obj;
	}
	
	
	public jackbergus.dgep.messages.ProtocolMessage newProtocol(java.lang.String name, java.lang.String data)
	{
		//line 94 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		java.lang.String x = this.url.putFile(( "/new/" + name ), data);
		//line 95 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		haxe.root.JsonParser_16 parser = new haxe.root.JsonParser_16(((haxe.root.Array<json2object.Error>) (null) ), ((json2object.PositionUtils) (null) ), ((java.lang.Object) (null) ));
		//line 96 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		jackbergus.dgep.messages.ProtocolMessage obj = parser.fromJson(x, null);
		//line 97 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		return obj;
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		{
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			boolean __temp_executeDef1 = true;
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			if (( field != null )) 
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				switch (field.hashCode())
				{
					case 1239709461:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("protocolListParser")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							this.protocolListParser = ((haxe.root.JsonParser_11) (value) );
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return value;
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 116079:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("url")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							this.url = ((jackbergus.dgep.RestfulHTTPConnections) (value) );
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return value;
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			if (__temp_executeDef1) 
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		{
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			boolean __temp_executeDef1 = true;
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			if (( field != null )) 
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				switch (field.hashCode())
				{
					case 267582552:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("newProtocol")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "newProtocol")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 116079:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("url")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.url;
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 3322014:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("list")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "list")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 1239709461:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("protocolListParser")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.protocolListParser;
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -608913948:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("getProtocol2")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "getProtocol2")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -1097520156:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("loadDB")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadDB")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -1074275382:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("dialogueMoves")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "dialogueMoves")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 3095028:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("dump")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "dump")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 1844104722:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("interaction")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "interaction")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -1143162854:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("newDialogueFromProtocol")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "newDialogueFromProtocol")) );
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			if (__temp_executeDef1) 
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		{
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			boolean __temp_executeDef1 = true;
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			if (( field != null )) 
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				switch (field.hashCode())
				{
					case 267582552:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("newProtocol")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.newProtocol(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -1097520156:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("loadDB")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.loadDB(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 3322014:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("list")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.list();
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 3095028:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("dump")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.dump();
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -608913948:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("getProtocol2")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.getProtocol2(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -1143162854:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("newDialogueFromProtocol")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.newDialogueFromProtocol(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(dynargs[1]), haxe.lang.Runtime.toString(dynargs[2]), haxe.lang.Runtime.toString(( (( dynargs.length > 3 )) ? (dynargs[3]) : (null) )));
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case -1074275382:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("dialogueMoves")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.dialogueMoves(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )));
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
					case 1844104722:
					{
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						if (field.equals("interaction")) 
						{
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							__temp_executeDef1 = false;
							//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
							return this.interaction(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(dynargs[1]), haxe.lang.Runtime.toString(dynargs[2]));
						}
						
						//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
			if (__temp_executeDef1) 
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		baseArr.push("protocolListParser");
		//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		baseArr.push("url");
		//line 30 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionRaw.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


