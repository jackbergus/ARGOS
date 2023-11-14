package haxe.root;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class JsonParser_1 extends json2object.reader.BaseParser<haxe.ds.List<jackbergus.dgep.internals.Move>>
{
	public JsonParser_1(haxe.lang.EmptyObject empty)
	{
		//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
	}
	
	
	public JsonParser_1(haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		haxe.root.JsonParser_1.__hx_ctor__JsonParser_1(this, errors, putils, errorType);
	}
	
	
	protected static void __hx_ctor__JsonParser_1(haxe.root.JsonParser_1 __hx_this, haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 962 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object errorType1 = ( (haxe.lang.Runtime.eq(errorType, null)) ? (((java.lang.Object) (0) )) : (errorType) );
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		__hx_ctor_json2object_reader_BaseParser(((json2object.reader.BaseParser<haxe.ds.List<jackbergus.dgep.internals.Move>>) (__hx_this) ), ((haxe.root.Array<json2object.Error>) (errors) ), ((json2object.PositionUtils) (putils) ), ((int) (haxe.lang.Runtime.toInt(errorType1)) ));
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
	}
	
	
	@Override public void onIncorrectType(java.lang.Object pos, java.lang.String variable)
	{
		//line 968 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.errors.push(json2object.Error.IncorrectType(variable, "haxe.ds.List<jackbergus.dgep.internals.Move>", pos));
		//line 969 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super.onIncorrectType(pos, variable);
	}
	
	
	@Override public void loadJsonNull(java.lang.Object pos, java.lang.String variable)
	{
		//line 187 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.value = null;
	}
	
	
	@Override public void loadJsonArray(haxe.root.Array<hxjsonast.Json> a, java.lang.Object pos, java.lang.String variable)
	{
		//line 170 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		try 
		{
			//line 171 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			haxe.root.JsonParser_2 parser = new haxe.root.JsonParser_2(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (2) ));
			//line 172 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			haxe.ds.List<jackbergus.dgep.internals.Move> res = new haxe.ds.List<jackbergus.dgep.internals.Move>();
			//line 173 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			{
				//line 173 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				int _g = 0;
				//line 173 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				while (( _g < a.length ))
				{
					//line 173 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					hxjsonast.Json j = a.__get(_g);
					//line 173 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					 ++ _g;
					//line 175 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					try 
					{
						//line 175 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						res.add(parser.loadJson(j, variable));
					}
					catch (java.lang.Throwable _g1)
					{
						//line 1 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/?"
						java.lang.Object _g2 = haxe.Exception.caught(_g1).unwrap();
						//line 174 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (( _g2 instanceof json2object.InternalError )) 
						{
							//line 1 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/?"
							json2object.InternalError e = ((json2object.InternalError) (_g2) );
							//line 178 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							if (( e != json2object.InternalError.ParsingThrow )) 
							{
								//line 179 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
							}
							
						}
						else
						{
							//line 174 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							throw _g1;
						}
						
					}
					
					
				}
				
			}
			
			//line 170 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			this.value = res;
		}
		catch (java.lang.Throwable typedException)
		{
			//line 170 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(typedException)) );
		}
		
		
	}
	
	
	public haxe.ds.List<jackbergus.dgep.internals.Move> getAuto()
	{
		//line 996 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		return new haxe.root.JsonParser_1(((haxe.root.Array<json2object.Error>) (new haxe.root.Array<json2object.Error>(new json2object.Error[]{})) ), ((json2object.PositionUtils) (this.putils) ), ((int) (0) )).loadJson(new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JNull) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(""), ((int) (0) ), ((int) (1) ))) )), null);
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		{
			//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			boolean __temp_executeDef1 = true;
			//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			if (( field != null )) 
			{
				//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				switch (field.hashCode())
				{
					case -75676123:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (field.equals("getAuto")) 
						{
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "getAuto")) );
						}
						
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						break;
					}
					
					
					case -1401289504:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (field.equals("onIncorrectType")) 
						{
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "onIncorrectType")) );
						}
						
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						break;
					}
					
					
					case 31908875:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (field.equals("loadJsonArray")) 
						{
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonArray")) );
						}
						
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						break;
					}
					
					
					case -691317355:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (field.equals("loadJsonNull")) 
						{
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonNull")) );
						}
						
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			if (__temp_executeDef1) 
			{
				//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		{
			//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			int __temp_hash2 = field.hashCode();
			//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			boolean __temp_executeDef1 = true;
			//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			if (( field != null )) 
			{
				//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				switch (__temp_hash2)
				{
					case 31908875:
					case -691317355:
					case -1401289504:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (( (( ( __temp_hash2 == 31908875 ) && field.equals("loadJsonArray") )) || ( (( ( __temp_hash2 == -691317355 ) && field.equals("loadJsonNull") )) || field.equals("onIncorrectType") ) )) 
						{
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							return haxe.lang.Runtime.slowCallField(this, field, dynargs);
						}
						
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						break;
					}
					
					
					case -75676123:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (field.equals("getAuto")) 
						{
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							return this.getAuto();
						}
						
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			if (__temp_executeDef1) 
			{
				//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				throw null;
			}
			
		}
		
	}
	
	
}


