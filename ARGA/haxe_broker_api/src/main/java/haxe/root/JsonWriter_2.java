package haxe.root;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class JsonWriter_2 extends haxe.lang.HxObject
{
	public JsonWriter_2(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public JsonWriter_2(java.lang.Object ignoreNullOptionals)
	{
		//line 384 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		haxe.root.JsonWriter_2.__hx_ctor__JsonWriter_2(this, ignoreNullOptionals);
	}
	
	
	protected static void __hx_ctor__JsonWriter_2(haxe.root.JsonWriter_2 __hx_this, java.lang.Object ignoreNullOptionals)
	{
		//line 383 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		__hx_this.shouldQuote = true;
		//line 385 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		{
			//line 385 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			java.lang.Object ignoreNullOptionals1 = ( (haxe.lang.Runtime.eq(ignoreNullOptionals, null)) ? (((java.lang.Object) (false) )) : (ignoreNullOptionals) );
			//line 385 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			__hx_this.ignoreNullOptionals = haxe.lang.Runtime.toBool(((java.lang.Boolean) (ignoreNullOptionals1) ));
		}
		
	}
	
	
	public boolean ignoreNullOptionals;
	
	public boolean shouldQuote;
	
	public final java.lang.String quote(java.lang.String str)
	{
		//line 390 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		if (this.shouldQuote) 
		{
			//line 390 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			return json2object.writer.StringUtils.quote(str);
		}
		else
		{
			//line 390 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			return str;
		}
		
	}
	
	
	public final haxe.root.JsonWriter_2 dontQuote()
	{
		//line 393 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		this.shouldQuote = false;
		//line 394 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		return this;
	}
	
	
	public java.lang.String buildIndent(java.lang.String space, int level)
	{
		//line 398 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		if (( level == 0 )) 
		{
			//line 398 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			return "";
		}
		
		//line 399 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		haxe.root.StringBuf buff = new haxe.root.StringBuf();
		//line 400 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		{
			//line 400 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			int _g = 0;
			//line 400 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			int _g1 = level;
			//line 400 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			while (( _g < _g1 ))
			{
				//line 400 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				int i = _g++;
				//line 401 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				buff.add(haxe.lang.Runtime.toString(space));
				//line 401 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
			}
			
		}
		
		//line 403 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		return buff.toString();
	}
	
	
	public java.lang.String _write(haxe.ds.List<jackbergus.dgep.requests.RawParticipantToJSON> o, java.lang.String space, java.lang.Object level, java.lang.Object indentFirst, haxe.lang.Function onAllOptionalNull)
	{
		//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		boolean indentFirst1 = ( (haxe.lang.Runtime.eq(indentFirst, null)) ? (false) : (haxe.lang.Runtime.toBool(((java.lang.Boolean) (indentFirst) ))) );
		//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		int level1 = ( (haxe.lang.Runtime.eq(level, null)) ? (0) : (((int) (haxe.lang.Runtime.toInt(level)) )) );
		//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		if (( space == null )) 
		{
			//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			space = "";
		}
		
		//line 77 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		java.lang.String indent = this.buildIndent(space, level1);
		//line 78 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		java.lang.String firstIndent = ( (indentFirst1) ? (indent) : ("") );
		//line 79 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		if (( o == null )) 
		{
			//line 79 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			return ( firstIndent + "null" );
		}
		
		//line 80 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		haxe.root.JsonWriter_3 valueWriter = new haxe.root.JsonWriter_3(((java.lang.Object) (this.ignoreNullOptionals) ));
		//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		haxe.root.Array<java.lang.String> _g = new haxe.root.Array<java.lang.String>(new java.lang.String[]{});
		//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		{
			//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			haxe.ds._List.ListNode<jackbergus.dgep.requests.RawParticipantToJSON> _g1_head = o.h;
			//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			while (( _g1_head != null ))
			{
				//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				jackbergus.dgep.requests.RawParticipantToJSON val = _g1_head.item;
				//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				_g1_head = _g1_head.next;
				//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				jackbergus.dgep.requests.RawParticipantToJSON element = val;
				//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				_g.push(valueWriter._write(element, space, ( level1 + 1 ), true, onAllOptionalNull));
			}
			
		}
		
		//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		haxe.root.Array<java.lang.String> values = _g;
		//line 84 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		java.lang.String newLine = ( ((  ! (haxe.lang.Runtime.valEq(space, ""))  && ( o.length > 0 ) )) ? ("\n") : ("") );
		//line 86 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		java.lang.String json = ( ( firstIndent + "[" ) + newLine );
		//line 87 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		json += ( values.join(( "," + newLine )) + newLine );
		//line 88 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		json += ( indent + "]" );
		//line 89 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		return json;
	}
	
	
	public java.lang.String write(haxe.ds.List<jackbergus.dgep.requests.RawParticipantToJSON> o, java.lang.String space)
	{
		//line 496 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		if (( space == null )) 
		{
			//line 496 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			space = "";
		}
		
		//line 496 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		return this._write(o, space, 0, false, null);
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		{
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			boolean __temp_executeDef1 = true;
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			if (( field != null )) 
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				switch (field.hashCode())
				{
					case -459681655:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("shouldQuote")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							this.shouldQuote = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return value;
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case -32802150:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("ignoreNullOptionals")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							this.ignoreNullOptionals = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return value;
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			if (__temp_executeDef1) 
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		{
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			boolean __temp_executeDef1 = true;
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			if (( field != null )) 
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				switch (field.hashCode())
				{
					case 113399775:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("write")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "write")) );
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case -32802150:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("ignoreNullOptionals")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return this.ignoreNullOptionals;
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case -1461798176:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("_write")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "_write")) );
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case -459681655:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("shouldQuote")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return this.shouldQuote;
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case 1961597114:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("buildIndent")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "buildIndent")) );
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case 107953788:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("quote")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "quote")) );
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case 2062138731:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("dontQuote")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "dontQuote")) );
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			if (__temp_executeDef1) 
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		{
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			boolean __temp_executeDef1 = true;
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			if (( field != null )) 
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				switch (field.hashCode())
				{
					case 113399775:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("write")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return this.write(((haxe.ds.List<jackbergus.dgep.requests.RawParticipantToJSON>) (dynargs[0]) ), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )));
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case 107953788:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("quote")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return this.quote(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case -1461798176:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("_write")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return this._write(((haxe.ds.List<jackbergus.dgep.requests.RawParticipantToJSON>) (dynargs[0]) ), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )), ( (( dynargs.length > 2 )) ? (dynargs[2]) : (null) ), ( (( dynargs.length > 3 )) ? (dynargs[3]) : (null) ), ((haxe.lang.Function) (( (( dynargs.length > 4 )) ? (dynargs[4]) : (null) )) ));
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case 2062138731:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("dontQuote")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return this.dontQuote();
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
					case 1961597114:
					{
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						if (field.equals("buildIndent")) 
						{
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
							return this.buildIndent(haxe.lang.Runtime.toString(dynargs[0]), ((int) (haxe.lang.Runtime.toInt(dynargs[1])) ));
						}
						
						//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
			if (__temp_executeDef1) 
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		baseArr.push("shouldQuote");
		//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		baseArr.push("ignoreNullOptionals");
		//line 381 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/DataBuilder.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


