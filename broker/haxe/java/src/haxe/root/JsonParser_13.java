package haxe.root;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class JsonParser_13 extends json2object.reader.BaseParser<java.lang.Object>
{
	public JsonParser_13(haxe.lang.EmptyObject empty)
	{
		//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
	}
	
	
	public JsonParser_13(haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		haxe.root.JsonParser_13.__hx_ctor__JsonParser_13(this, errors, putils, errorType);
	}
	
	
	protected static void __hx_ctor__JsonParser_13(haxe.root.JsonParser_13 __hx_this, haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 962 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object errorType1 = ( (haxe.lang.Runtime.eq(errorType, null)) ? (((java.lang.Object) (0) )) : (errorType) );
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		json2object.reader.BaseParser.__hx_ctor_json2object_reader_BaseParser(((json2object.reader.BaseParser<java.lang.Object>) (__hx_this) ), ((haxe.root.Array<json2object.Error>) (errors) ), ((json2object.PositionUtils) (putils) ), ((int) (haxe.lang.Runtime.toInt(errorType1)) ));
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
	}
	
	
	@Override public void onIncorrectType(java.lang.Object pos, java.lang.String variable)
	{
		//line 968 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.errors.push(json2object.Error.IncorrectType(variable, "{ players : List<String>, description : String }", pos));
		//line 969 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super.onIncorrectType(pos, variable);
	}
	
	
	@Override public void loadJsonNull(java.lang.Object pos, java.lang.String variable)
	{
		//line 484 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.value = null;
	}
	
	
	@Override public void loadJsonObject(haxe.root.Array<hxjsonast.JObjectField> o, java.lang.Object pos, java.lang.String variable)
	{
		//line 472 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		haxe.ds.StringMap<java.lang.Object> assigned = new haxe.ds.StringMap<java.lang.Object>();
		//line 473 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.objectSetupAssign(assigned, new haxe.root.Array<java.lang.String>(new java.lang.String[]{"description", "players"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{false, false}));
		//line 474 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.value = this.getAuto();
		//line 476 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		{
			//line 476 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			int _g = 0;
			//line 476 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			while (( _g < o.length ))
			{
				//line 476 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				hxjsonast.JObjectField field = o.__get(_g);
				//line 476 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				 ++ _g;
				//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
				{
					//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					java.lang.String __temp_svar3 = (field.name);
					//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					boolean __temp_executeDef4 = true;
					//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					if (( __temp_svar3 != null )) 
					{
						//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						switch (__temp_svar3.hashCode())
						{
							case -1724546052:
							{
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (__temp_svar3.equals("description")) 
								{
									//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									__temp_executeDef4 = false;
									//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									java.lang.String __temp_expr1 = haxe.lang.Runtime.toString(haxe.lang.Runtime.setField(this.value, "description", haxe.lang.Runtime.toString(this.loadObjectField(((haxe.lang.Function) (new haxe.lang.Closure(new haxe.root.JsonParser_5(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (1) )), "loadJson")) ), field, "description", assigned, ((java.lang.Object) (haxe.lang.Runtime.getField(this.value, "description", true)) ), pos))));
								}
								
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								break;
							}
							
							
							case -493567566:
							{
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (__temp_svar3.equals("players")) 
								{
									//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									__temp_executeDef4 = false;
									//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									haxe.ds.List<java.lang.String> __temp_expr2 = ((haxe.ds.List<java.lang.String>) (haxe.lang.Runtime.setField(this.value, "players", ((haxe.ds.List<java.lang.String>) (this.loadObjectField(((haxe.lang.Function) (new haxe.lang.Closure(new haxe.root.JsonParser_15(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (1) )), "loadJson")) ), field, "players", assigned, ((java.lang.Object) (haxe.lang.Runtime.getField(this.value, "players", true)) ), pos)) ))) );
								}
								
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								break;
							}
							
							
						}
						
					}
					
					//line 438 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					if (__temp_executeDef4) 
					{
						//line 438 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						this.errors.push(json2object.Error.UnknownVariable(field.name, this.putils.convertPosition(field.namePos)));
					}
					
				}
				
			}
			
		}
		
		//line 480 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.objectErrors(assigned, pos);
	}
	
	
	public java.lang.Object getAuto()
	{
		//line 527 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		{
			//line 21 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/messages/ProtocolList.hx"
			haxe.ds.List<java.lang.String> __temp_odecl1 = new haxe.ds.List<java.lang.String>();
			//line 527 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			return new haxe.lang.DynamicObject(new java.lang.String[]{"description", "players"}, new java.lang.Object[]{"", __temp_odecl1}, new java.lang.String[]{}, new double[]{});
		}
		
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


