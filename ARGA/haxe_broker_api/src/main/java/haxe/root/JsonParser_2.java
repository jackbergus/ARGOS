package haxe.root;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class JsonParser_2 extends json2object.reader.BaseParser<jackbergus.dgep.internals.Move>
{
	public JsonParser_2(haxe.lang.EmptyObject empty)
	{
		//line 961 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
	}
	
	
	public JsonParser_2(haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		super(haxe.lang.EmptyObject.EMPTY);
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		haxe.root.JsonParser_2.__hx_ctor__JsonParser_2(this, errors, putils, errorType);
	}
	
	
	protected static void __hx_ctor__JsonParser_2(haxe.root.JsonParser_2 __hx_this, haxe.root.Array<json2object.Error> errors, json2object.PositionUtils putils, java.lang.Object errorType)
	{
		//line 962 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object errorType1 = ( (haxe.lang.Runtime.eq(errorType, null)) ? (((java.lang.Object) (0) )) : (errorType) );
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		__hx_ctor_json2object_reader_BaseParser(((json2object.reader.BaseParser<jackbergus.dgep.internals.Move>) (__hx_this) ), ((haxe.root.Array<json2object.Error>) (errors) ), ((json2object.PositionUtils) (putils) ), ((int) (haxe.lang.Runtime.toInt(errorType1)) ));
		//line 963 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
	}
	
	
	@Override public void onIncorrectType(java.lang.Object pos, java.lang.String variable)
	{
		//line 968 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		this.errors.push(json2object.Error.IncorrectType(variable, "jackbergus.dgep.internals.Move", pos));
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
		this.objectSetupAssign(assigned, new haxe.root.Array<java.lang.String>(new java.lang.String[]{"reply", "opener", "moveID", "target"}), new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{false, false, false, false}));
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
					java.lang.String __temp_svar1 = (field.name);
					//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					boolean __temp_executeDef2 = true;
					//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					if (( __temp_svar1 != null )) 
					{
						//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
						switch (__temp_svar1.hashCode())
						{
							case -1068264276:
							{
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (__temp_svar1.equals("moveID")) 
								{
									//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									__temp_executeDef2 = false;
									//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									this.value.moveID = haxe.lang.Runtime.toString(this.loadObjectField(((haxe.lang.Function) (new haxe.lang.Closure(new haxe.root.JsonParser_5(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (1) )), "loadJson")) ), field, "moveID", assigned, ((java.lang.Object) (this.value.moveID) ), pos));
								}
								
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								break;
							}
							
							
							case -880905839:
							{
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (__temp_svar1.equals("target")) 
								{
									//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									__temp_executeDef2 = false;
									//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									this.value.target = haxe.lang.Runtime.toString(this.loadObjectField(((haxe.lang.Function) (new haxe.lang.Closure(new haxe.root.JsonParser_5(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (1) )), "loadJson")) ), field, "target", assigned, ((java.lang.Object) (this.value.target) ), pos));
								}
								
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								break;
							}
							
							
							case -1010579337:
							{
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (__temp_svar1.equals("opener")) 
								{
									//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									__temp_executeDef2 = false;
									//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									this.value.opener = haxe.lang.Runtime.toString(this.loadObjectField(((haxe.lang.Function) (new haxe.lang.Closure(new haxe.root.JsonParser_5(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (1) )), "loadJson")) ), field, "opener", assigned, ((java.lang.Object) (this.value.opener) ), pos));
								}
								
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								break;
							}
							
							
							case 108401386:
							{
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								if (__temp_svar1.equals("reply")) 
								{
									//line 439 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									__temp_executeDef2 = false;
									//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
									this.value.reply = ((haxe.ds.StringMap<java.lang.String>) (this.loadObjectField(((haxe.lang.Function) (new haxe.lang.Closure(new haxe.root.JsonParser_4(((haxe.root.Array<json2object.Error>) (this.errors) ), ((json2object.PositionUtils) (this.putils) ), ((int) (1) )), "loadJson")) ), field, "reply", assigned, ((java.lang.Object) (this.value.reply) ), pos)) );
								}
								
								//line 376 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
								break;
							}
							
							
						}
						
					}
					
					//line 438 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
					if (__temp_executeDef2) 
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
	
	
	public jackbergus.dgep.internals.Move getAuto()
	{
		//line 459 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		jackbergus.dgep.internals.Move value = new jackbergus.dgep.internals.Move(haxe.lang.EmptyObject.EMPTY);
		//line 461 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		{
			//line 431 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			value.reply = ((haxe.ds.StringMap<java.lang.String>) (new haxe.ds.StringMap<java.lang.String>()) );
			//line 431 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			value.opener = "";
			//line 431 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			value.moveID = "";
			//line 431 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
			value.target = "";
		}
		
		//line 455 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/reader/DataBuilder.hx"
		return value;
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


