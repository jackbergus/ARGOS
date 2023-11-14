package json2object;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class PositionUtils extends haxe.lang.HxObject
{
	public PositionUtils(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public PositionUtils(java.lang.String content)
	{
		//line 32 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		json2object.PositionUtils.__hx_ctor_json2object_PositionUtils(this, content);
	}
	
	
	protected static void __hx_ctor_json2object_PositionUtils(json2object.PositionUtils __hx_this, java.lang.String content)
	{
		//line 30 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		__hx_this.linesInfo = new haxe.root.Array<java.lang.Object>();
		//line 32 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		{
			//line 33 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			int s = 0;
			//line 34 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			int e = 0;
			//line 36 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			int i = 0;
			//line 37 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			int lineCount = 0;
			//line 38 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			while (( i < content.length() ))
			{
				//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				{
					//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					java.lang.String __temp_svar1 = (haxe.lang.StringExt.charAt(content, i));
					//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					boolean __temp_executeDef2 = true;
					//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					if (( __temp_svar1 != null )) 
					{
						//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						switch (__temp_svar1.hashCode())
						{
							case 10:
							{
								//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
								if (__temp_svar1.equals("\n")) 
								{
									//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									__temp_executeDef2 = false;
									//line 50 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									e = i;
									//line 51 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									__hx_this.linesInfo.push(new haxe.lang.DynamicObject(new java.lang.String[]{}, new java.lang.Object[]{}, new java.lang.String[]{"end", "number", "start"}, new double[]{((double) (((double) (e) )) ), ((double) (((double) (lineCount) )) ), ((double) (((double) (s) )) )}));
									//line 52 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									 ++ lineCount;
									//line 53 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									 ++ i;
									//line 54 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									s = i;
								}
								
								//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
								break;
							}
							
							
							case 13:
							{
								//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
								if (__temp_svar1.equals("\r")) 
								{
									//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									__temp_executeDef2 = false;
									//line 41 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									e = i;
									//line 42 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									if (haxe.lang.Runtime.valEq(haxe.lang.StringExt.charAt(content, ( i + 1 )), "\n")) 
									{
										//line 43 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
										 ++ e;
									}
									
									//line 45 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									__hx_this.linesInfo.push(new haxe.lang.DynamicObject(new java.lang.String[]{}, new java.lang.Object[]{}, new java.lang.String[]{"end", "number", "start"}, new double[]{((double) (((double) (e) )) ), ((double) (((double) (lineCount) )) ), ((double) (((double) (s) )) )}));
									//line 46 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									 ++ lineCount;
									//line 47 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									i = ( e + 1 );
									//line 48 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
									s = i;
								}
								
								//line 39 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
								break;
							}
							
							
						}
						
					}
					
					//line 56 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					if (__temp_executeDef2) 
					{
						//line 56 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						 ++ i;
					}
					
				}
				
			}
			
			//line 59 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			__hx_this.linesInfo.push(new haxe.lang.DynamicObject(new java.lang.String[]{}, new java.lang.Object[]{}, new java.lang.String[]{"end", "number", "start"}, new double[]{((double) (((double) (i) )) ), ((double) (((double) (lineCount) )) ), ((double) (((double) (s) )) )}));
		}
		
	}
	
	
	public haxe.root.Array<java.lang.Object> linesInfo;
	
	public java.lang.Object convertPosition(hxjsonast.Position position)
	{
		//line 66 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		java.lang.String file = position.file;
		//line 67 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		int min = position.min;
		//line 68 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		int max = position.max;
		//line 70 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		java.lang.Object pos = new haxe.lang.DynamicObject(new java.lang.String[]{"file", "lines"}, new java.lang.Object[]{file, new haxe.root.Array<java.lang.Object>(new java.lang.Object[]{})}, new java.lang.String[]{"max", "min"}, new double[]{((double) (((double) (( max + 1 )) )) ), ((double) (((double) (( min + 1 )) )) )});
		//line 71 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		int lastLine = ( this.linesInfo.length - 1 );
		//line 73 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		int bounds_min = 0;
		//line 73 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		int bounds_max = lastLine;
		//line 74 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		if (( min > ((int) (haxe.lang.Runtime.getField_f(this.linesInfo.__get(0), "end", true)) ) )) 
		{
			//line 75 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			while (( bounds_max > bounds_min ))
			{
				//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				int i = ((int) (( ((double) ((( bounds_min + bounds_max ))) ) / 2 )) );
				//line 77 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				java.lang.Object line = this.linesInfo.__get(i);
				//line 78 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				if (( ((int) (haxe.lang.Runtime.getField_f(line, "start", true)) ) == min )) 
				{
					//line 79 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					bounds_min = i;
					//line 80 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					bounds_max = i;
				}
				
				//line 82 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				if (( ((int) (haxe.lang.Runtime.getField_f(line, "end", true)) ) < min )) 
				{
					//line 83 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					bounds_min = ( i + 1 );
				}
				
				//line 85 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				if (( ( ((int) (haxe.lang.Runtime.getField_f(line, "start", true)) ) > min ) || ( ( ((int) (haxe.lang.Runtime.getField_f(line, "end", true)) ) >= min ) && ( ((int) (haxe.lang.Runtime.getField_f(line, "start", true)) ) < min ) ) )) 
				{
					//line 86 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					bounds_max = i;
				}
				
			}
			
		}
		
		//line 93 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		{
			//line 93 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			int _g = bounds_min;
			//line 93 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			int _g1 = this.linesInfo.length;
			//line 93 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			while (( _g < _g1 ))
			{
				//line 93 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				int i1 = _g++;
				//line 94 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				java.lang.Object line1 = this.linesInfo.__get(i1);
				//line 95 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				if (( ( ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) <= min ) && ( ((int) (haxe.lang.Runtime.getField_f(line1, "end", true)) ) >= max ) )) 
				{
					//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					java.lang.Object __temp_stmt10 = null;
					//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					{
						//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl1 = ( ((int) (haxe.lang.Runtime.getField_f(line1, "number", true)) ) + 1 );
						//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl2 = ( ( ((int) (min) ) - ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) ) + 1 );
						//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl3 = ( ( ((int) (max) ) - ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) ) + 1 );
						//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						__temp_stmt10 = new haxe.lang.DynamicObject(new java.lang.String[]{}, new java.lang.Object[]{}, new java.lang.String[]{"end", "number", "start"}, new double[]{((double) (((double) (__temp_odecl3) )) ), ((double) (((double) (__temp_odecl1) )) ), ((double) (((double) (__temp_odecl2) )) )});
					}
					
					//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(pos, "lines", true)) ).push(__temp_stmt10);
					//line 97 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					break;
				}
				
				//line 99 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				if (( ( ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) <= min ) && ( min <= ((int) (haxe.lang.Runtime.getField_f(line1, "end", true)) ) ) )) 
				{
					//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					java.lang.Object __temp_stmt11 = null;
					//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					{
						//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl4 = ( ((int) (haxe.lang.Runtime.getField_f(line1, "number", true)) ) + 1 );
						//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl5 = ( ( ((int) (min) ) - ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) ) + 1 );
						//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl6 = ( ((int) (haxe.lang.Runtime.getField_f(line1, "end", true)) ) + 1 );
						//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						__temp_stmt11 = new haxe.lang.DynamicObject(new java.lang.String[]{}, new java.lang.Object[]{}, new java.lang.String[]{"end", "number", "start"}, new double[]{((double) (((double) (__temp_odecl6) )) ), ((double) (((double) (__temp_odecl4) )) ), ((double) (((double) (__temp_odecl5) )) )});
					}
					
					//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(pos, "lines", true)) ).push(__temp_stmt11);
				}
				
				//line 102 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				if (( ( ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) <= max ) && ( max <= ((int) (haxe.lang.Runtime.getField_f(line1, "end", true)) ) ) )) 
				{
					//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					java.lang.Object __temp_stmt12 = null;
					//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					{
						//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl7 = ( ((int) (haxe.lang.Runtime.getField_f(line1, "number", true)) ) + 1 );
						//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl8 = ( ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) + 1 );
						//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						int __temp_odecl9 = ( ( ((int) (max) ) - ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) ) + 1 );
						//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						__temp_stmt12 = new haxe.lang.DynamicObject(new java.lang.String[]{}, new java.lang.Object[]{}, new java.lang.String[]{"end", "number", "start"}, new double[]{((double) (((double) (__temp_odecl9) )) ), ((double) (((double) (__temp_odecl7) )) ), ((double) (((double) (__temp_odecl8) )) )});
					}
					
					//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					((haxe.root.Array<java.lang.Object>) (haxe.lang.Runtime.getField(pos, "lines", true)) ).push(__temp_stmt12);
				}
				
				//line 105 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				if (( ( ((int) (haxe.lang.Runtime.getField_f(line1, "start", true)) ) >= max ) || ( ((int) (haxe.lang.Runtime.getField_f(line1, "end", true)) ) >= max ) )) 
				{
					//line 106 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
					break;
				}
				
			}
			
		}
		
		//line 110 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		return pos;
	}
	
	
	public final hxjsonast.Position revert(java.lang.Object position)
	{
		//line 114 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		return new hxjsonast.Position(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(position, "file", true)), ((int) (( ((int) (haxe.lang.Runtime.getField_f(position, "min", true)) ) - ((int) (1) ) )) ), ((int) (( ((int) (haxe.lang.Runtime.getField_f(position, "max", true)) ) - ((int) (1) ) )) ));
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		{
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			boolean __temp_executeDef1 = true;
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			if (( field != null )) 
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				switch (field.hashCode())
				{
					case -1778872243:
					{
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						if (field.equals("linesInfo")) 
						{
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							__temp_executeDef1 = false;
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							this.linesInfo = ((haxe.root.Array<java.lang.Object>) (value) );
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							return value;
						}
						
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			if (__temp_executeDef1) 
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		{
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			boolean __temp_executeDef1 = true;
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			if (( field != null )) 
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				switch (field.hashCode())
				{
					case -934352412:
					{
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						if (field.equals("revert")) 
						{
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							__temp_executeDef1 = false;
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "revert")) );
						}
						
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						break;
					}
					
					
					case -1778872243:
					{
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						if (field.equals("linesInfo")) 
						{
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							__temp_executeDef1 = false;
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							return this.linesInfo;
						}
						
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						break;
					}
					
					
					case -1651394564:
					{
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						if (field.equals("convertPosition")) 
						{
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							__temp_executeDef1 = false;
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "convertPosition")) );
						}
						
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			if (__temp_executeDef1) 
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		{
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			boolean __temp_executeDef1 = true;
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			if (( field != null )) 
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				switch (field.hashCode())
				{
					case -934352412:
					{
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						if (field.equals("revert")) 
						{
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							__temp_executeDef1 = false;
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							return this.revert(dynargs[0]);
						}
						
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						break;
					}
					
					
					case -1651394564:
					{
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						if (field.equals("convertPosition")) 
						{
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							__temp_executeDef1 = false;
							//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
							return this.convertPosition(((hxjsonast.Position) (dynargs[0]) ));
						}
						
						//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
			if (__temp_executeDef1) 
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		baseArr.push("linesInfo");
		//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/PositionUtils.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


