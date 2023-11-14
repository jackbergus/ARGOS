package json2object.reader;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class BaseParser<T> extends haxe.lang.HxObject
{
	public BaseParser(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public BaseParser(haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, int errorType)
	{
		//line 44 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		json2object.reader.BaseParser.__hx_ctor_json2object_reader_BaseParser(((json2object.reader.BaseParser<T>) (this) ), ((haxe.root.Array<json2object.Error>) (errors) ), ((json2object.PositionUtils) (putils) ), ((int) (errorType) ));
		//line 44 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
	}
	
	
	protected static <T_c> void __hx_ctor_json2object_reader_BaseParser(json2object.reader.BaseParser<T_c> __hx_this, haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, int errorType)
	{
		//line 45 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		__hx_this.errors = errors;
		//line 46 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		__hx_this.putils = putils;
		//line 47 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		__hx_this.errorType = errorType;
	}
	
	
	public T value;
	
	public haxe.root.Array<json2object.Error> errors;
	
	public int errorType;
	
	public json2object.PositionUtils putils;
	
	public T fromJson(java.lang.String jsonString, java.lang.String filename)
	{
		//line 50 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		try 
		{
			//line 50 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( filename == null )) 
			{
				//line 50 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				filename = "";
			}
			
			//line 51 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			this.putils = new json2object.PositionUtils(haxe.lang.Runtime.toString(jsonString));
			//line 52 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			this.errors = new haxe.root.Array<json2object.Error>(new json2object.Error[]{});
			//line 53 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			try 
			{
				//line 54 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				hxjsonast.Json json = new hxjsonast.Parser(haxe.lang.Runtime.toString(jsonString), haxe.lang.Runtime.toString(filename)).doParse();
				//line 55 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				this.loadJson(json, null);
			}
			catch (java.lang.Throwable _g)
			{
				//line 57 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				java.lang.Object _g1 = haxe.Exception.caught(_g).unwrap();
				//line 53 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				if (( _g1 instanceof hxjsonast.Error )) 
				{
					//line 57 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					hxjsonast.Error e = ((hxjsonast.Error) (_g1) );
					//line 58 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.errors.push(json2object.Error.ParserError(e.message, this.putils.convertPosition(e.pos)));
				}
				else
				{
					//line 53 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					throw _g;
				}
				
			}
			
			
			//line 60 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			return this.value;
		}
		catch (java.lang.Throwable typedException)
		{
			//line 50 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(typedException)) );
		}
		
		
	}
	
	
	public T loadJson(hxjsonast.Json json, java.lang.String variable)
	{
		//line 63 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (( variable == null )) 
		{
			//line 63 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			variable = "";
		}
		
		//line 64 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		java.lang.Object pos = this.putils.convertPosition(json.pos);
		//line 65 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		{
			//line 65 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			hxjsonast.JsonValue _g = json.value;
			//line 65 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			switch (_g.index)
			{
				case 0:
				{
					//line 67 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					java.lang.String s = haxe.lang.Runtime.toString(_g.params[0]);
					//line 67 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.loadJsonString(s, pos, variable);
					//line 67 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					break;
				}
				
				
				case 1:
				{
					//line 68 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					java.lang.String n = haxe.lang.Runtime.toString(_g.params[0]);
					//line 68 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.loadJsonNumber(n, pos, variable);
					//line 68 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					break;
				}
				
				
				case 2:
				{
					//line 71 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					haxe.root.Array<hxjsonast.JObjectField> o = ((haxe.root.Array<hxjsonast.JObjectField>) (_g.params[0]) );
					//line 71 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.loadJsonObject(o, pos, variable);
					//line 71 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					break;
				}
				
				
				case 3:
				{
					//line 70 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					haxe.root.Array<hxjsonast.Json> a = ((haxe.root.Array<hxjsonast.Json>) (_g.params[0]) );
					//line 70 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.loadJsonArray(a, pos, variable);
					//line 70 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					break;
				}
				
				
				case 4:
				{
					//line 69 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					boolean b = haxe.lang.Runtime.toBool(((java.lang.Boolean) (_g.params[0]) ));
					//line 69 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.loadJsonBool(b, pos, variable);
					//line 69 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					break;
				}
				
				
				case 5:
				{
					//line 66 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.loadJsonNull(pos, variable);
					//line 66 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					break;
				}
				
				
			}
			
		}
		
		//line 73 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		return this.value;
	}
	
	
	public void loadJsonNull(java.lang.Object pos, java.lang.String variable)
	{
		//line 77 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
	}
	
	
	public void loadJsonString(java.lang.String s, java.lang.Object pos, java.lang.String variable)
	{
		//line 81 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
	}
	
	
	public java.lang.String loadString(java.lang.String s, java.lang.Object pos, java.lang.String variable, haxe.root.Array<java.lang.String> validValues, java.lang.String defaultValue)
	{
		//line 85 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (( validValues.indexOf(s, null) != -1 )) 
		{
			//line 86 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			return s;
		}
		
		//line 88 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
		//line 89 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		return defaultValue;
	}
	
	
	public void loadJsonNumber(java.lang.String f, java.lang.Object pos, java.lang.String variable)
	{
		//line 93 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
	}
	
	
	public int loadJsonUInt(java.lang.String f, java.lang.Object pos, java.lang.String variable, int value)
	{
		//line 97 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		int uint = 0;
		//line 98 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		f = ((java.lang.String) (((java.lang.Object) (f) )) ).trim();
		//line 99 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		boolean neg = haxe.lang.Runtime.valEq(haxe.lang.StringExt.charAt(f, 0), "-");
		//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (neg) 
		{
			//line 101 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			f = haxe.lang.StringExt.substr(f, 1, null);
		}
		
		//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		boolean hex = ((java.lang.String) (((java.lang.Object) (f) )) ).startsWith(haxe.lang.Runtime.toString("0x"));
		//line 104 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (hex) 
		{
			//line 105 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			f = haxe.lang.StringExt.substr(f, 2, null);
		}
		
		//line 108 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		int base = ( (hex) ? (16) : (10) );
		//line 109 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		int pow = 1;
		//line 110 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		int i = ( f.length() - 1 );
		//line 111 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		while (( i >= 0 ))
		{
			//line 112 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			java.lang.Object cur = ( (hex) ? (haxe.root.Std.parseInt(( "0x" + haxe.lang.StringExt.charAt(f, i) ))) : (haxe.root.Std.parseInt(haxe.lang.StringExt.charAt(f, i))) );
			//line 113 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (haxe.lang.Runtime.eq(cur, null)) 
			{
				//line 114 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				this.onIncorrectType(pos, variable);
				//line 115 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				return value;
			}
			
			//line 117 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			uint = ((int) (( ((int) (uint) ) + ( ((int) (pow) ) * ((int) (haxe.lang.Runtime.toInt(cur)) ) ) )) );
			//line 118 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			pow *= base;
			//line 119 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			 -- i;
		}
		
		//line 121 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		return uint;
	}
	
	
	public int loadJsonInt(java.lang.String f, java.lang.Object pos, java.lang.String variable, int value)
	{
		//line 125 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (( ( ! (haxe.lang.Runtime.eq(haxe.root.Std.parseInt(f), null)) ) && haxe.lang.Runtime.eq(haxe.root.Std.parseInt(f), haxe.root.Std.parseFloat(f)) )) 
		{
			//line 126 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			return ((int) (haxe.lang.Runtime.toInt(haxe.root.Std.parseInt(f))) );
		}
		
		//line 128 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
		//line 129 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		return value;
	}
	
	
	public double loadJsonFloat(java.lang.String f, java.lang.Object pos, java.lang.String variable, double value)
	{
		//line 133 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (( ! (haxe.lang.Runtime.eq(haxe.root.Std.parseInt(f), null)) )) 
		{
			//line 134 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			return haxe.root.Std.parseFloat(f);
		}
		
		//line 136 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
		//line 137 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		return value;
	}
	
	
	public void loadJsonBool(boolean b, java.lang.Object pos, java.lang.String variable)
	{
		//line 141 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
	}
	
	
	public void loadJsonArray(haxe.root.Array<hxjsonast.Json> a, java.lang.Object pos, java.lang.String variable)
	{
		//line 145 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
	}
	
	
	public haxe.root.Array loadJsonArrayValue(haxe.root.Array<hxjsonast.Json> a, java.lang.Object loadJsonFn, java.lang.String variable)
	{
		//line 149 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		try 
		{
			//line 149 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			haxe.root.Array _g = new haxe.root.Array(new java.lang.Object[]{});
			//line 150 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			{
				//line 150 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				int _g1 = 0;
				//line 150 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				while (( _g1 < a.length ))
				{
					//line 150 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					hxjsonast.Json j = a.__get(_g1);
					//line 150 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					 ++ _g1;
					//line 152 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					java.lang.Object tmp = null;
					//line 152 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					try 
					{
						//line 152 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						tmp = ((java.lang.Object) (((haxe.lang.Function) (loadJsonFn) ).__hx_invoke2_o(0.0, j, 0.0, variable)) );
					}
					catch (java.lang.Throwable _g2)
					{
						//line 154 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						java.lang.Object _g3 = haxe.Exception.caught(_g2).unwrap();
						//line 152 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (( _g3 instanceof json2object.InternalError )) 
						{
							//line 154 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							json2object.InternalError e = ((json2object.InternalError) (_g3) );
							//line 155 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							if (( e != json2object.InternalError.ParsingThrow )) 
							{
								//line 156 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
								throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
							}
							
							//line 159 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							continue;
						}
						else
						{
							//line 152 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							throw _g2;
						}
						
					}
					
					
					//line 152 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					_g.push(tmp);
				}
				
			}
			
			//line 149 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			return _g;
		}
		catch (java.lang.Throwable typedException)
		{
			//line 148 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(typedException)) );
		}
		
		
	}
	
	
	public void loadJsonObject(haxe.root.Array<hxjsonast.JObjectField> o, java.lang.Object pos, java.lang.String variable)
	{
		//line 166 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.onIncorrectType(pos, variable);
	}
	
	
	public java.lang.Object loadObjectField(java.lang.Object loadJsonFn, hxjsonast.JObjectField field, java.lang.String name, haxe.ds.StringMap<java.lang.Object> assigned, java.lang.Object defaultValue, java.lang.Object pos)
	{
		//line 170 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		try 
		{
			//line 171 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			java.lang.Object ret = ((java.lang.Object) (((haxe.lang.Function) (loadJsonFn) ).__hx_invoke2_o(0.0, field.value, 0.0, field.name)) );
			//line 172 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			assigned.set(name, true);
			//line 173 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			return ret;
		}
		catch (java.lang.Throwable _g)
		{
			//line 174 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			java.lang.Object _g1 = haxe.Exception.caught(_g).unwrap();
			//line 170 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( _g1 instanceof json2object.InternalError )) 
			{
				//line 174 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				json2object.InternalError e = ((json2object.InternalError) (_g1) );
				//line 175 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				if (( e != json2object.InternalError.ParsingThrow )) 
				{
					//line 176 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
				}
				
			}
			else
			{
				//line 199 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				java.lang.Object e1 = _g1;
				//line 200 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				this.errors.push(json2object.Error.CustomFunctionException(e1, pos));
			}
			
		}
		
		
		//line 202 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		return defaultValue;
	}
	
	
	public void loadObjectFieldReflect(java.lang.Object loadJsonFn, hxjsonast.JObjectField field, java.lang.String name, haxe.ds.StringMap<java.lang.Object> assigned, java.lang.Object pos)
	{
		//line 206 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		try 
		{
			//line 207 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			haxe.root.Reflect.setField(this.value, name, ((java.lang.Object) (((haxe.lang.Function) (loadJsonFn) ).__hx_invoke2_o(0.0, field.value, 0.0, field.name)) ));
			//line 208 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			assigned.set(name, true);
		}
		catch (java.lang.Throwable _g)
		{
			//line 209 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			java.lang.Object _g1 = haxe.Exception.caught(_g).unwrap();
			//line 206 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( _g1 instanceof json2object.InternalError )) 
			{
				//line 209 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				json2object.InternalError e = ((json2object.InternalError) (_g1) );
				//line 210 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				if (( e != json2object.InternalError.ParsingThrow )) 
				{
					//line 211 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
				}
				
			}
			else
			{
				//line 214 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				java.lang.Object e1 = _g1;
				//line 215 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				this.errors.push(json2object.Error.CustomFunctionException(e1, pos));
			}
			
		}
		
		
	}
	
	
	public void objectSetupAssign(haxe.ds.StringMap<java.lang.Object> assigned, haxe.root.Array<java.lang.String> keys, haxe.root.Array<java.lang.Object> values)
	{
		//line 220 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		int _g = 0;
		//line 220 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		int _g1 = keys.length;
		//line 220 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		while (( _g < _g1 ))
		{
			//line 220 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			int i = _g++;
			//line 221 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			assigned.set(keys.__get(i), haxe.lang.Runtime.toBool(((java.lang.Boolean) (values.__get(i)) )));
		}
		
	}
	
	
	public void objectErrors(haxe.ds.StringMap<java.lang.Object> assigned, java.lang.Object pos)
	{
		//line 226 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		java.lang.Object lastPos = this.putils.convertPosition(new hxjsonast.Position(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(pos, "file", true)), ((int) (( ((int) (haxe.lang.Runtime.getField_f(pos, "max", true)) ) - ((int) (1) ) )) ), ((int) (( ((int) (haxe.lang.Runtime.getField_f(pos, "max", true)) ) - ((int) (1) ) )) )));
		//line 227 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		{
			//line 227 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			java.lang.Object s = ((java.lang.Object) (new haxe.ds._StringMap.StringMapKeyIterator<java.lang.Object>(((haxe.ds.StringMap<java.lang.Object>) (((haxe.ds.StringMap) (assigned) )) ))) );
			//line 227 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			while (haxe.lang.Runtime.toBool(((java.lang.Boolean) (haxe.lang.Runtime.callField(s, "hasNext", null)) )))
			{
				//line 227 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				java.lang.String s1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.callField(s, "next", null));
				//line 228 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				if (( ! (haxe.lang.Runtime.toBool(((java.lang.Boolean) (assigned.get(s1)) ))) )) 
				{
					//line 229 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
					this.errors.push(json2object.Error.UninitializedVariable(s1, lastPos));
				}
				
			}
			
		}
		
	}
	
	
	public void onIncorrectType(java.lang.Object pos, java.lang.String variable)
	{
		//line 235 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		this.parsingThrow();
	}
	
	
	public void parsingThrow()
	{
		//line 239 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (( this.errorType != ((int) (0) ) )) 
		{
			//line 240 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(json2object.InternalError.ParsingThrow)) );
		}
		
	}
	
	
	public void objectThrow(java.lang.Object pos, java.lang.String variable)
	{
		//line 245 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (( this.errorType == ((int) (2) ) )) 
		{
			//line 246 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(json2object.InternalError.ParsingThrow)) );
		}
		
		//line 249 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		if (( this.errorType == ((int) (1) ) )) 
		{
			//line 250 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			this.errors.push(json2object.Error.UninitializedVariable(variable, pos));
		}
		
	}
	
	
	public final void mapSet(haxe.ds.StringMap<java.lang.Object> map, java.lang.String key, boolean value)
	{
		//line 255 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		map.set(key, value);
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		{
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			boolean __temp_executeDef1 = true;
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( field != null )) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				switch (field.hashCode())
				{
					case 329552226:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("errorType")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.errorType = ((int) (value) );
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return value;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 111972721:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("value")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.value = ((T) (((java.lang.Object) (value) )) );
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((double) (haxe.lang.Runtime.toDouble(((java.lang.Object) (value) ))) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (__temp_executeDef1) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		{
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			boolean __temp_executeDef1 = true;
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( field != null )) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				switch (field.hashCode())
				{
					case -976890303:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("putils")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.putils = ((json2object.PositionUtils) (value) );
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return value;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 111972721:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("value")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.value = ((T) (value) );
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return value;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 329552226:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("errorType")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.errorType = ((int) (haxe.lang.Runtime.toInt(value)) );
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return value;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1294635157:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("errors")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.errors = ((haxe.root.Array<json2object.Error>) (value) );
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return value;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (__temp_executeDef1) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		{
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			boolean __temp_executeDef1 = true;
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( field != null )) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				switch (field.hashCode())
				{
					case -1081388698:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("mapSet")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "mapSet")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 111972721:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("value")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.value;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1287699737:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("objectThrow")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "objectThrow")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1294635157:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("errors")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.errors;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 917442070:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("parsingThrow")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "parsingThrow")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 329552226:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("errorType")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.errorType;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1401289504:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("onIncorrectType")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "onIncorrectType")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -976890303:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("putils")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.putils;
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1684188278:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("objectErrors")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "objectErrors")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1244949582:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("fromJson")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "fromJson")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1212017933:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("objectSetupAssign")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "objectSetupAssign")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1845314286:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJson")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJson")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1943733448:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadObjectFieldReflect")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadObjectFieldReflect")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -691317355:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonNull")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonNull")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1319711797:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadObjectField")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadObjectField")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1506354335:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonString")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonString")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1374971853:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonObject")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonObject")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -215790441:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadString")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadString")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1719045158:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonArrayValue")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonArrayValue")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1363976151:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonNumber")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonNumber")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 31908875:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonArray")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonArray")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -691151032:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonUInt")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonUInt")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -691680520:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonBool")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonBool")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1823420895:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonInt")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonInt")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 36344846:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonFloat")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonFloat")) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (__temp_executeDef1) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		{
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			boolean __temp_executeDef1 = true;
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( field != null )) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				switch (field.hashCode())
				{
					case 329552226:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("errorType")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((double) (this.errorType) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 111972721:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("value")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return ((double) (haxe.lang.Runtime.toDouble(((java.lang.Object) (this.value) ))) );
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (__temp_executeDef1) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		{
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			boolean __temp_executeDef1 = true;
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (( field != null )) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				switch (field.hashCode())
				{
					case -1081388698:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("mapSet")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.mapSet(((haxe.ds.StringMap<java.lang.Object>) (dynargs[0]) ), haxe.lang.Runtime.toString(dynargs[1]), haxe.lang.Runtime.toBool(((java.lang.Boolean) (dynargs[2]) )));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1244949582:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("fromJson")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.fromJson(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1287699737:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("objectThrow")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.objectThrow(dynargs[0], haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1845314286:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJson")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.loadJson(((hxjsonast.Json) (dynargs[0]) ), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 917442070:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("parsingThrow")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.parsingThrow();
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -691317355:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonNull")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.loadJsonNull(dynargs[0], haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1401289504:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("onIncorrectType")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.onIncorrectType(dynargs[0], haxe.lang.Runtime.toString(dynargs[1]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1506354335:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonString")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.loadJsonString(haxe.lang.Runtime.toString(dynargs[0]), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1684188278:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("objectErrors")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.objectErrors(((haxe.ds.StringMap<java.lang.Object>) (dynargs[0]) ), dynargs[1]);
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -215790441:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadString")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.loadString(haxe.lang.Runtime.toString(dynargs[0]), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]), ((haxe.root.Array<java.lang.String>) (dynargs[3]) ), haxe.lang.Runtime.toString(dynargs[4]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1212017933:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("objectSetupAssign")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.objectSetupAssign(((haxe.ds.StringMap<java.lang.Object>) (dynargs[0]) ), ((haxe.root.Array<java.lang.String>) (dynargs[1]) ), ((haxe.root.Array<java.lang.Object>) (dynargs[2]) ));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1363976151:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonNumber")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.loadJsonNumber(haxe.lang.Runtime.toString(dynargs[0]), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1943733448:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadObjectFieldReflect")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.loadObjectFieldReflect(dynargs[0], ((hxjsonast.JObjectField) (dynargs[1]) ), haxe.lang.Runtime.toString(dynargs[2]), ((haxe.ds.StringMap<java.lang.Object>) (dynargs[3]) ), dynargs[4]);
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -691151032:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonUInt")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.loadJsonUInt(haxe.lang.Runtime.toString(dynargs[0]), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]), ((int) (haxe.lang.Runtime.toInt(dynargs[3])) ));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1319711797:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadObjectField")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.loadObjectField(dynargs[0], ((hxjsonast.JObjectField) (dynargs[1]) ), haxe.lang.Runtime.toString(dynargs[2]), ((haxe.ds.StringMap<java.lang.Object>) (dynargs[3]) ), dynargs[4], dynargs[5]);
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -1823420895:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonInt")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.loadJsonInt(haxe.lang.Runtime.toString(dynargs[0]), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]), ((int) (haxe.lang.Runtime.toInt(dynargs[3])) ));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1374971853:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonObject")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.loadJsonObject(((haxe.root.Array<hxjsonast.JObjectField>) (dynargs[0]) ), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 36344846:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonFloat")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.loadJsonFloat(haxe.lang.Runtime.toString(dynargs[0]), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]), ((double) (haxe.lang.Runtime.toDouble(dynargs[3])) ));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 1719045158:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonArrayValue")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							return this.loadJsonArrayValue(((haxe.root.Array<hxjsonast.Json>) (dynargs[0]) ), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case -691680520:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonBool")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.loadJsonBool(haxe.lang.Runtime.toBool(((java.lang.Boolean) (dynargs[0]) )), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
					case 31908875:
					{
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						if (field.equals("loadJsonArray")) 
						{
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							__temp_executeDef1 = false;
							//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
							this.loadJsonArray(((haxe.root.Array<hxjsonast.Json>) (dynargs[0]) ), dynargs[1], haxe.lang.Runtime.toString(dynargs[2]));
						}
						
						//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
			if (__temp_executeDef1) 
			{
				//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		baseArr.push("putils");
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		baseArr.push("errorType");
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		baseArr.push("errors");
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		baseArr.push("value");
		//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/BaseParser.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


