package haxe.root;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class JsonParser_8 extends json2object.reader.BaseParser<haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>>
{
	public JsonParser_8(haxe.lang.EmptyObject empty)
	{
		//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
	}
	
	
	public JsonParser_8(haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		haxe.root.JsonParser_8.__hx_ctor__JsonParser_8(this, errors, putils, errorType);
	}
	
	
	protected static void __hx_ctor__JsonParser_8(haxe.root.JsonParser_8 __hx_this, haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 962 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object errorType1 = ( (haxe.lang.Runtime.eq(errorType, null)) ? (((java.lang.Object) (0) )) : (errorType) );
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		json2object.reader.BaseParser.__hx_ctor_json2object_reader_BaseParser(((json2object.reader.BaseParser<haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>>) (__hx_this) ), ((haxe.root.Array<json2object.Error>) (errors) ), ((json2object.PositionUtils) (putils) ), ((int) (haxe.lang.Runtime.toInt(errorType1)) ));
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
	}
	
	
	@Override public void onIncorrectType(java.lang.Object pos, java.lang.String variable)
	{
		//line 968 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.errors.push(json2object.Error.IncorrectType(variable, "haxe.ds.Map<String, List<jackbergus.dgep.internals.Move>>", pos));
		//line 969 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super.onIncorrectType(pos, variable);
	}
	
	
	@Override public void loadJsonNull(java.lang.Object pos, java.lang.String variable)
	{
		//line 548 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.value = null;
	}
	
	
	@Override public void loadJsonObject(haxe.root.Array<hxjsonast.JObjectField> o, java.lang.Object pos, java.lang.String variable)
	{
		//line 540 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		try 
		{
			//line 541 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			this.value = ((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (new haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>()) );
			//line 542 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			{
				//line 542 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				int _g = 0;
				//line 542 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				while (( _g < o.length ))
				{
					//line 542 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					hxjsonast.JObjectField field = o.__get(_g);
					//line 542 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					 ++ _g;
					//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					{
						//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						haxe.IMap<java.lang.String, haxe.ds.List<jackbergus.dgep.internals.Move>> this1 = this.value;
						//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						java.lang.String key = null;
						//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						try 
						{
							//line 494 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							haxe.root.JsonParser_5 key1 = new haxe.root.JsonParser_5(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (2) ));
							//line 494 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							json2object.PositionUtils _this = this.putils;
							//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							key = key1.loadJson(new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JString(field.name)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(pos, "file", true)), ((int) (( ((int) (haxe.lang.Runtime.getField_f(pos, "min", true)) ) - ((int) (1) ) )) ), ((int) (( ((int) (haxe.lang.Runtime.getField_f(pos, "max", true)) ) - ((int) (1) ) )) ))) )), variable);
						}
						catch (java.lang.Throwable _g1)
						{
							//line 1 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/?"
							java.lang.Object _g2 = haxe.Exception.caught(_g1).unwrap();
							//line 493 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							if (( _g2 instanceof json2object.InternalError )) 
							{
								//line 1 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/?"
								json2object.InternalError e = ((json2object.InternalError) (_g2) );
								//line 496 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (( e != json2object.InternalError.ParsingThrow )) 
								{
									//line 497 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e)) );
								}
								
								//line 500 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								continue;
							}
							else
							{
								//line 493 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								throw _g1;
							}
							
						}
						
						
						//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						haxe.ds.List<jackbergus.dgep.internals.Move> value = null;
						//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						try 
						{
							//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							value = new haxe.root.JsonParser_1(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (2) )).loadJson(field.value, field.name);
						}
						catch (java.lang.Throwable _g3)
						{
							//line 1 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/?"
							java.lang.Object _g4 = haxe.Exception.caught(_g3).unwrap();
							//line 526 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							if (( _g4 instanceof json2object.InternalError )) 
							{
								//line 1 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/?"
								json2object.InternalError e1 = ((json2object.InternalError) (_g4) );
								//line 530 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (( e1 != json2object.InternalError.ParsingThrow )) 
								{
									//line 531 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									throw ((java.lang.RuntimeException) (haxe.Exception.thrown(e1)) );
								}
								
								//line 534 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								continue;
							}
							else
							{
								//line 526 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								throw _g3;
							}
							
						}
						
						
						//line 543 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (this1) ).set(key, value);
					}
					
				}
				
			}
			
		}
		catch (java.lang.Throwable typedException)
		{
			//line 540 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(typedException)) );
		}
		
		
	}
	
	
	public haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>> getAuto()
	{
		//line 996 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		return new haxe.root.JsonParser_8(((haxe.root.Array<json2object.Error>) (new haxe.root.Array<json2object.Error>(new json2object.Error[]{})) ), ((json2object.PositionUtils) (this.putils) ), ((int) (0) )).loadJson(new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JNull) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(""), ((int) (0) ), ((int) (1) ))) )), null);
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
					
					
					case 1374971853:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (field.equals("loadJsonObject")) 
						{
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							__temp_executeDef1 = false;
							//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "loadJsonObject")) );
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
					case 1374971853:
					case -691317355:
					case -1401289504:
					{
						//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						if (( (( ( __temp_hash2 == 1374971853 ) && field.equals("loadJsonObject") )) || ( (( ( __temp_hash2 == -691317355 ) && field.equals("loadJsonNull") )) || field.equals("onIncorrectType") ) )) 
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


