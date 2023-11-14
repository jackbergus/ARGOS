package jackbergus.dgep.connections;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ConnectionLogic extends haxe.lang.HxObject
{
	public ConnectionLogic(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ConnectionLogic(java.lang.String addr, int port)
	{
		//line 109 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.connections.ConnectionLogic.__hx_ctor_jackbergus_dgep_connections_ConnectionLogic(this, addr, port);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_connections_ConnectionLogic(jackbergus.dgep.connections.ConnectionLogic __hx_this, java.lang.String addr, int port)
	{
		//line 110 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.x = new jackbergus.dgep.connections.ConnectionRaw(haxe.lang.Runtime.toString(addr), ((int) (port) ));
		//line 111 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		__hx_this.protocols = new haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic>();
	}
	
	
	public jackbergus.dgep.connections.ConnectionRaw x;
	
	public haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic> protocols;
	
	public jackbergus.dgep.internals.MongoDB dumpDB()
	{
		//line 117 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return this.x.dump();
	}
	
	
	public java.lang.String loadDB(jackbergus.dgep.internals.MongoDB db)
	{
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		haxe.lang.Function replacer = null;
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		java.lang.String space = null;
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		java.lang.String json = haxe.format.JsonPrinter.print(((java.lang.Object) (db) ), replacer, space);
		//line 123 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return this.x.loadDB(json);
	}
	
	
	public jackbergus.dgep.connections.ProtocolLogic getProtocol(java.lang.String name)
	{
		//line 128 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		java.lang.String obj = this.x.getProtocol2(name);
		//line 129 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.connections.ProtocolLogic protocol = null;
		//line 130 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		if ( ! (haxe.lang.Runtime.valEq(obj, "Protocol not found")) ) 
		{
			//line 131 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (((haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic>) (((haxe.IMap<java.lang.String, jackbergus.dgep.connections.ProtocolLogic>) (this.protocols) )) ).exists(name)) 
			{
				//line 132 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				protocol = ((jackbergus.dgep.connections.ProtocolLogic) (((haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic>) (((haxe.IMap<java.lang.String, jackbergus.dgep.connections.ProtocolLogic>) (this.protocols) )) ).get(name)) );
			}
			else
			{
				//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				jackbergus.dgep.messages.ProtocolMessage pm = new jackbergus.dgep.messages.ProtocolMessage(haxe.lang.Runtime.toString("saved"), haxe.lang.Runtime.toString(name));
				//line 135 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				((haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic>) (((haxe.IMap<java.lang.String, jackbergus.dgep.connections.ProtocolLogic>) (this.protocols) )) ).set(name, new jackbergus.dgep.connections.ProtocolLogic(((jackbergus.dgep.connections.ConnectionRaw) (this.x) ), haxe.lang.Runtime.toString(name), ((jackbergus.dgep.messages.ProtocolMessage) (pm) )));
				//line 136 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				protocol = ((jackbergus.dgep.connections.ProtocolLogic) (((haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic>) (((haxe.IMap<java.lang.String, jackbergus.dgep.connections.ProtocolLogic>) (this.protocols) )) ).get(name)) );
			}
			
		}
		
		//line 139 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return protocol;
	}
	
	
	public haxe.ds.StringMap<java.lang.Object> list()
	{
		//line 145 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return this.x.list();
	}
	
	
	public jackbergus.dgep.connections.ProtocolLogic newProtocol(java.lang.String name, java.lang.String data)
	{
		//line 150 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.messages.ProtocolMessage obj = this.x.newProtocol(name, data);
		//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		jackbergus.dgep.connections.ProtocolLogic pl = new jackbergus.dgep.connections.ProtocolLogic(((jackbergus.dgep.connections.ConnectionRaw) (this.x) ), haxe.lang.Runtime.toString(name), ((jackbergus.dgep.messages.ProtocolMessage) (obj) ));
		//line 152 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		((haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic>) (((haxe.IMap<java.lang.String, jackbergus.dgep.connections.ProtocolLogic>) (this.protocols) )) ).set(name, pl);
		//line 153 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		return pl;
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case -599309093:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("protocols")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.protocols = ((haxe.ds.StringMap<jackbergus.dgep.connections.ProtocolLogic>) (value) );
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 120:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("x")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							this.x = ((jackbergus.dgep.connections.ConnectionRaw) (value) );
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return value;
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 267582552:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("newProtocol")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "newProtocol")) );
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 120:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("x")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.x;
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 3322014:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("list")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "list")) );
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -599309093:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("protocols")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.protocols;
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1088736270:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("getProtocol")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "getProtocol")) );
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -1320643214:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("dumpDB")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "dumpDB")) );
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -1097520156:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("loadDB")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadDB")) );
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		{
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			boolean __temp_executeDef1 = true;
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (( field != null )) 
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				switch (field.hashCode())
				{
					case 267582552:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("newProtocol")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.newProtocol(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -1320643214:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("dumpDB")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.dumpDB();
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 3322014:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("list")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.list();
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case -1097520156:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("loadDB")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.loadDB(((jackbergus.dgep.internals.MongoDB) (dynargs[0]) ));
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
					case 1088736270:
					{
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						if (field.equals("getProtocol")) 
						{
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							__temp_executeDef1 = false;
							//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
							return this.getProtocol(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
			if (__temp_executeDef1) 
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("protocols");
		//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		baseArr.push("x");
		//line 103 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/connections/ConnectionLogic.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


