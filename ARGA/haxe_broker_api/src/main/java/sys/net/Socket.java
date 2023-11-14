package sys.net;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Socket extends haxe.lang.HxObject
{
	public Socket(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Socket()
	{
		//line 38 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		sys.net.Socket.__hx_ctor_sys_net_Socket(this);
	}
	
	
	protected static void __hx_ctor_sys_net_Socket(sys.net.Socket __hx_this)
	{
		//line 39 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		__hx_this.create();
	}
	
	
	public haxe.io.Input input;
	
	public haxe.io.Output output;
	
	public java.net.Socket sock;
	
	public java.net.ServerSocket server;
	
	public void create()
	{
		//line 43 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		this.sock = new java.net.Socket();
		//line 45 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		try 
		{
			//line 45 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			this.server = new java.net.ServerSocket();
		}
		catch (java.lang.Throwable _g)
		{
			//line 46 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 47 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
	public void close()
	{
		//line 51 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		try 
		{
			//line 52 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (( this.sock != null )) 
			{
				//line 53 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				this.sock.close();
			}
			
			//line 54 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (( this.server != null )) 
			{
				//line 55 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				this.server.close();
			}
			
		}
		catch (java.lang.Throwable _g)
		{
			//line 56 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 57 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
	public void connect(sys.net.Host host, int port)
	{
		//line 69 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		try 
		{
			//line 70 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			this.sock.connect(((java.net.SocketAddress) (new java.net.InetSocketAddress(((java.net.InetAddress) (host.wrapped) ), ((int) (port) ))) ));
			//line 71 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			this.output = new haxe.java.io.NativeOutput(((java.io.OutputStream) (this.sock.getOutputStream()) ));
			//line 72 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			this.input = new haxe.java.io.NativeInput(((java.io.InputStream) (this.sock.getInputStream()) ));
		}
		catch (java.lang.Throwable _g)
		{
			//line 73 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 74 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
	public void shutdown(boolean read, boolean write)
	{
		//line 87 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		try 
		{
			//line 88 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (read) 
			{
				//line 89 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				this.sock.shutdownInput();
			}
			
			//line 90 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (write) 
			{
				//line 91 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				this.sock.shutdownOutput();
			}
			
		}
		catch (java.lang.Throwable _g)
		{
			//line 92 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 93 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
	public void setTimeout(double timeout)
	{
		//line 139 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		try 
		{
			//line 139 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			this.sock.setSoTimeout(((int) (((int) (( timeout * 1000 )) )) ));
		}
		catch (java.lang.Throwable _g)
		{
			//line 140 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) );
			//line 141 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
		}
		
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		{
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			boolean __temp_executeDef1 = true;
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (( field != null )) 
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				switch (field.hashCode())
				{
					case -905826493:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("server")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.server = ((java.net.ServerSocket) (value) );
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return value;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 100358090:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("input")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.input = ((haxe.io.Input) (value) );
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return value;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 3535812:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("sock")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.sock = ((java.net.Socket) (value) );
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return value;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case -1005512447:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("output")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.output = ((haxe.io.Output) (value) );
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return value;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (__temp_executeDef1) 
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		{
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			boolean __temp_executeDef1 = true;
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (( field != null )) 
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				switch (field.hashCode())
				{
					case 1659754143:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("setTimeout")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "setTimeout")) );
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 100358090:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("input")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return this.input;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case -169343402:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("shutdown")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "shutdown")) );
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case -1005512447:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("output")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return this.output;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 951351530:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("connect")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "connect")) );
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 3535812:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("sock")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return this.sock;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 94756344:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("close")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "close")) );
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case -905826493:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("server")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return this.server;
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case -1352294148:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("create")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "create")) );
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (__temp_executeDef1) 
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		{
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			boolean __temp_executeDef1 = true;
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (( field != null )) 
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				switch (field.hashCode())
				{
					case 1659754143:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("setTimeout")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.setTimeout(((double) (haxe.lang.Runtime.toDouble(dynargs[0])) ));
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case -1352294148:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("create")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.create();
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case -169343402:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("shutdown")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.shutdown(haxe.lang.Runtime.toBool(((java.lang.Boolean) (dynargs[0]) )), haxe.lang.Runtime.toBool(((java.lang.Boolean) (dynargs[1]) )));
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 94756344:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("close")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.close();
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
					case 951351530:
					{
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						if (field.equals("connect")) 
						{
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							__temp_executeDef1 = false;
							//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
							this.connect(((sys.net.Host) (dynargs[0]) ), ((int) (haxe.lang.Runtime.toInt(dynargs[1])) ));
						}
						
						//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
			if (__temp_executeDef1) 
			{
				//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		baseArr.push("server");
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		baseArr.push("sock");
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		baseArr.push("output");
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		baseArr.push("input");
		//line 28 "/usr/share/haxe/std/java/_std/sys/net/Socket.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


