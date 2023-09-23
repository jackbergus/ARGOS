package hxjsonast;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Parser extends haxe.lang.HxObject
{
	public Parser(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Parser(java.lang.String source, java.lang.String filename)
	{
		//line 24 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		hxjsonast.Parser.__hx_ctor_hxjsonast_Parser(this, source, filename);
	}
	
	
	protected static void __hx_ctor_hxjsonast_Parser(hxjsonast.Parser __hx_this, java.lang.String source, java.lang.String filename)
	{
		//line 25 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		__hx_this.source = source;
		//line 26 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		__hx_this.filename = filename;
		//line 27 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		__hx_this.pos = 0;
	}
	
	
	public static hxjsonast.Json parse(java.lang.String source, java.lang.String filename)
	{
		//line 17 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		return new hxjsonast.Parser(haxe.lang.Runtime.toString(source), haxe.lang.Runtime.toString(filename)).doParse();
	}
	
	
	public java.lang.String source;
	
	public java.lang.String filename;
	
	public int pos;
	
	public hxjsonast.Json doParse()
	{
		//line 31 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		hxjsonast.Json result = this.parseRec();
		//line 32 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		int c = 0;
		//line 33 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		while (true)
		{
			//line 33 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			java.lang.String s = this.source;
			//line 33 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			int index = this.pos++;
			//line 33 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			c = ( (( index < s.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s) )) ).charAt(index)) )) : (-1) );
			//line 33 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if ( ! ((( c != -1 ))) ) 
			{
				//line 33 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				break;
			}
			
			//line 34 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			switch (c)
			{
				case 9:
				case 10:
				case 13:
				case 32:
				{
					//line 35 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					break;
				}
				
				
				default:
				{
					//line 38 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					this.invalidChar();
					//line 38 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					break;
				}
				
			}
			
		}
		
		//line 41 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		return result;
	}
	
	
	public hxjsonast.Json parseRec()
	{
		//line 45 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		while (true)
		{
			//line 46 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			java.lang.String s = this.source;
			//line 46 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			int index = this.pos++;
			//line 46 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			int c = ( (( index < s.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s) )) ).charAt(index)) )) : (-1) );
			//line 47 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			switch (c)
			{
				case 9:
				case 10:
				case 13:
				case 32:
				{
					//line 48 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					break;
				}
				
				
				case 34:
				{
					//line 138 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int save = this.pos;
					//line 139 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.String s1 = this.parseString();
					//line 140 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JString(s1)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (( save - 1 )) ), ((int) (this.pos) ))) ));
				}
				
				
				case 45:
				case 48:
				case 49:
				case 50:
				case 51:
				case 52:
				case 53:
				case 54:
				case 55:
				case 56:
				case 57:
				{
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int start = ( this.pos - 1 );
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean minus = ( c == 45 );
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean digit =  ! (minus) ;
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean zero = ( c == 48 );
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean point = false;
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean e = false;
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean pm = false;
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean end = false;
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					while (true)
					{
						//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						{
							//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							java.lang.String s2 = this.source;
							//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							int index1 = this.pos++;
							//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							switch (( (( index1 < s2.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s2) )) ).charAt(index1)) )) : (-1) ))
							{
								case 43:
								case 45:
								{
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if ((  ! (e)  || pm )) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										this.invalidNumber(start);
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									digit = false;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									pm = true;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									break;
								}
								
								
								case 46:
								{
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if (( ( minus || point ) || e )) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										this.invalidNumber(start);
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									digit = false;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									point = true;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									break;
								}
								
								
								case 48:
								{
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if (( zero &&  ! (point)  )) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										this.invalidNumber(start);
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if (minus) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										minus = false;
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										zero = true;
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									digit = true;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									break;
								}
								
								
								case 49:
								case 50:
								case 51:
								case 52:
								case 53:
								case 54:
								case 55:
								case 56:
								case 57:
								{
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if (( zero &&  ! (point)  )) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										this.invalidNumber(start);
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if (minus) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										minus = false;
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									digit = true;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									zero = false;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									break;
								}
								
								
								case 69:
								case 101:
								{
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if (( ( minus || zero ) || e )) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										this.invalidNumber(start);
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									digit = false;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									e = true;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									break;
								}
								
								
								default:
								{
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									if ( ! (digit) ) 
									{
										//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
										this.invalidNumber(start);
									}
									
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.pos--;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									end = true;
									//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									break;
								}
								
							}
							
						}
						
						//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (end) 
						{
							//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							break;
						}
						
					}
					
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.String s3 = haxe.lang.StringExt.substr(this.source, start, ( this.pos - start ));
					//line 142 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JNumber(s3)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (start) ), ((int) (this.pos) ))) ));
				}
				
				
				case 91:
				{
					//line 92 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					haxe.root.Array<hxjsonast.Json> values = new haxe.root.Array<hxjsonast.Json>(new hxjsonast.Json[]{});
					//line 93 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.Object comma = null;
					//line 94 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int startPos = ( this.pos - 1 );
					//line 95 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					while (true)
					{
						//line 96 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s4 = this.source;
						//line 96 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index2 = this.pos++;
						//line 96 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						switch (( (( index2 < s4.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s4) )) ).charAt(index2)) )) : (-1) ))
						{
							case 9:
							case 10:
							case 13:
							case 32:
							{
								//line 97 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
							
							case 44:
							{
								//line 104 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (haxe.lang.Runtime.toBool(((java.lang.Boolean) ((comma)) ))) 
								{
									//line 105 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									comma = false;
								}
								else
								{
									//line 107 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.invalidChar();
								}
								
								//line 104 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
							
							case 93:
							{
								//line 100 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (haxe.lang.Runtime.eq(comma, false)) 
								{
									//line 101 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.invalidChar();
								}
								
								//line 102 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JArray(values)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (startPos) ), ((int) (this.pos) ))) ));
							}
							
							
							default:
							{
								//line 109 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (haxe.lang.Runtime.toBool(((java.lang.Boolean) ((comma)) ))) 
								{
									//line 110 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.invalidChar();
								}
								
								//line 111 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								this.pos--;
								//line 112 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								values.push(this.parseRec());
								//line 113 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								comma = true;
								//line 108 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
						}
						
					}
					
				}
				
				
				case 102:
				{
					//line 124 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int save1 = this.pos;
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean tmp = false;
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean tmp1 = false;
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean tmp2 = false;
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.String s5 = this.source;
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int index3 = this.pos++;
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if (( (( (( index3 < s5.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s5) )) ).charAt(index3)) )) : (-1) )) == 97 )) 
					{
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s6 = this.source;
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index4 = this.pos++;
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp2 = ( (( (( index4 < s6.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s6) )) ).charAt(index4)) )) : (-1) )) != 108 );
					}
					else
					{
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp2 = true;
					}
					
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if ( ! (tmp2) ) 
					{
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s7 = this.source;
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index5 = this.pos++;
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp1 = ( (( (( index5 < s7.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s7) )) ).charAt(index5)) )) : (-1) )) != 115 );
					}
					else
					{
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp1 = true;
					}
					
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if ( ! (tmp1) ) 
					{
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s8 = this.source;
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index6 = this.pos++;
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp = ( (( (( index6 < s8.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s8) )) ).charAt(index6)) )) : (-1) )) != 101 );
					}
					else
					{
						//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp = true;
					}
					
					//line 125 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if (tmp) 
					{
						//line 126 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.pos = save1;
						//line 127 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.invalidChar();
					}
					
					//line 129 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JBool(false)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (( save1 - 1 )) ), ((int) (this.pos) ))) ));
				}
				
				
				case 110:
				{
					//line 131 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int save2 = this.pos;
					//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean tmp3 = false;
					//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean tmp4 = false;
					//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.String s9 = this.source;
					//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int index7 = this.pos++;
					//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if (( (( (( index7 < s9.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s9) )) ).charAt(index7)) )) : (-1) )) == 117 )) 
					{
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s10 = this.source;
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index8 = this.pos++;
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp4 = ( (( (( index8 < s10.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s10) )) ).charAt(index8)) )) : (-1) )) != 108 );
					}
					else
					{
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp4 = true;
					}
					
					//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if ( ! (tmp4) ) 
					{
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s11 = this.source;
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index9 = this.pos++;
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp3 = ( (( (( index9 < s11.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s11) )) ).charAt(index9)) )) : (-1) )) != 108 );
					}
					else
					{
						//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp3 = true;
					}
					
					//line 132 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if (tmp3) 
					{
						//line 133 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.pos = save2;
						//line 134 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.invalidChar();
					}
					
					//line 136 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JNull) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (( save2 - 1 )) ), ((int) (this.pos) ))) ));
				}
				
				
				case 116:
				{
					//line 117 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int save3 = this.pos;
					//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean tmp5 = false;
					//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					boolean tmp6 = false;
					//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.String s12 = this.source;
					//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int index10 = this.pos++;
					//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if (( (( (( index10 < s12.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s12) )) ).charAt(index10)) )) : (-1) )) == 114 )) 
					{
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s13 = this.source;
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index11 = this.pos++;
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp6 = ( (( (( index11 < s13.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s13) )) ).charAt(index11)) )) : (-1) )) != 117 );
					}
					else
					{
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp6 = true;
					}
					
					//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if ( ! (tmp6) ) 
					{
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s14 = this.source;
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index12 = this.pos++;
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp5 = ( (( (( index12 < s14.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s14) )) ).charAt(index12)) )) : (-1) )) != 101 );
					}
					else
					{
						//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						tmp5 = true;
					}
					
					//line 118 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					if (tmp5) 
					{
						//line 119 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.pos = save3;
						//line 120 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.invalidChar();
					}
					
					//line 122 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JBool(true)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (( save3 - 1 )) ), ((int) (this.pos) ))) ));
				}
				
				
				case 123:
				{
					//line 51 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					haxe.root.Array<hxjsonast.JObjectField> fields = new haxe.root.Array<hxjsonast.JObjectField>();
					//line 52 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					haxe.ds.StringMap<java.lang.Object> names = new haxe.ds.StringMap<java.lang.Object>();
					//line 53 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.String field = null;
					//line 54 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					hxjsonast.Position fieldPos = null;
					//line 55 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					java.lang.Object comma1 = null;
					//line 56 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					int startPos1 = ( this.pos - 1 );
					//line 57 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					while (true)
					{
						//line 58 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.String s15 = this.source;
						//line 58 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						int index13 = this.pos++;
						//line 58 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						switch (( (( index13 < s15.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s15) )) ).charAt(index13)) )) : (-1) ))
						{
							case 9:
							case 10:
							case 13:
							case 32:
							{
								//line 59 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
							
							case 34:
							{
								//line 78 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (( haxe.lang.Runtime.toBool(((java.lang.Boolean) (( field != null )) )) || haxe.lang.Runtime.toBool(((java.lang.Boolean) (comma1) )) )) 
								{
									//line 79 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.invalidChar();
								}
								
								//line 80 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								int fieldStartPos = ( this.pos - 1 );
								//line 81 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								field = this.parseString();
								//line 82 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								fieldPos = new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (fieldStartPos) ), ((int) (this.pos) ));
								//line 83 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (names.exists(field)) 
								{
									//line 84 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									throw ((java.lang.RuntimeException) (haxe.Exception.thrown(new hxjsonast.Error(haxe.lang.Runtime.toString(( ( "Duplicate field name \"" + field ) + "\"" )), ((hxjsonast.Position) (fieldPos) )))) );
								}
								else
								{
									//line 86 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									names.set(field, true);
								}
								
								//line 77 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
							
							case 44:
							{
								//line 73 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (haxe.lang.Runtime.toBool(((java.lang.Boolean) ((comma1)) ))) 
								{
									//line 74 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									comma1 = false;
								}
								else
								{
									//line 76 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.invalidChar();
								}
								
								//line 73 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
							
							case 58:
							{
								//line 66 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (( field == null )) 
								{
									//line 67 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.invalidChar();
								}
								
								//line 68 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								fields.push(new hxjsonast.JObjectField(haxe.lang.Runtime.toString(field), ((hxjsonast.Position) (fieldPos) ), ((hxjsonast.Json) (this.parseRec()) )));
								//line 69 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								field = null;
								//line 70 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								fieldPos = null;
								//line 71 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								comma1 = true;
								//line 65 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
							
							case 125:
							{
								//line 62 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								if (( ( field != null ) || haxe.lang.Runtime.eq(comma1, false) )) 
								{
									//line 63 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
									this.invalidChar();
								}
								
								//line 64 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JObject(fields)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (startPos1) ), ((int) (this.pos) ))) ));
							}
							
							
							default:
							{
								//line 88 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								this.invalidChar();
								//line 88 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
								break;
							}
							
						}
						
					}
					
				}
				
				
				default:
				{
					//line 144 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					this.invalidChar();
					//line 144 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					break;
				}
				
			}
			
		}
		
	}
	
	
	public java.lang.String parseString()
	{
		//line 150 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		int start = this.pos;
		//line 151 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		haxe.root.StringBuf buf = null;
		//line 152 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		while (true)
		{
			//line 153 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			java.lang.String s = this.source;
			//line 153 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			int index = this.pos++;
			//line 153 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			int c = ( (( index < s.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s) )) ).charAt(index)) )) : (-1) );
			//line 154 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (( c == 34 )) 
			{
				//line 155 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				break;
			}
			
			//line 156 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (( c == 92 )) 
			{
				//line 157 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				if (( buf == null )) 
				{
					//line 158 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					buf = new haxe.root.StringBuf();
				}
				
				//line 159 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				buf.addSub(this.source, start, ( ( this.pos - start ) - 1 ));
				//line 160 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				java.lang.String s1 = this.source;
				//line 160 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				int index1 = this.pos++;
				//line 160 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				c = ( (( index1 < s1.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s1) )) ).charAt(index1)) )) : (-1) );
				//line 161 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				switch (c)
				{
					case 34:
					case 47:
					case 92:
					{
						//line 173 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						buf.addChar(c);
						//line 173 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 98:
					{
						//line 169 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						buf.addChar(8);
						//line 169 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 102:
					{
						//line 171 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						buf.addChar(12);
						//line 171 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 110:
					{
						//line 165 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						buf.addChar(10);
						//line 165 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 114:
					{
						//line 163 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						buf.addChar(13);
						//line 163 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 116:
					{
						//line 167 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						buf.addChar(9);
						//line 167 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 117:
					{
						//line 175 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						java.lang.Object uc = haxe.root.Std.parseInt(( "0x" + haxe.lang.StringExt.substr(this.source, this.pos, 4) ));
						//line 176 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.pos += 4;
						//line 194 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						buf.addChar(((int) (haxe.lang.Runtime.toInt(uc)) ));
						//line 174 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					default:
					{
						//line 197 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						throw ((java.lang.RuntimeException) (haxe.Exception.thrown(new hxjsonast.Error(haxe.lang.Runtime.toString(( "Invalid escape sequence \\" + new java.lang.String( java.lang.Character.toChars((int) c) ) )), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (( this.pos - 2 )) ), ((int) (this.pos) ))) )))) );
					}
					
				}
				
				//line 199 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				start = this.pos;
			}
			else
			{
				//line 211 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				if (( c == -1 )) 
				{
					//line 212 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					this.pos--;
					//line 213 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
					throw ((java.lang.RuntimeException) (haxe.Exception.thrown(new hxjsonast.Error(haxe.lang.Runtime.toString("Unclosed string"), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (( start - 1 )) ), ((int) (this.pos) ))) )))) );
				}
				
			}
			
		}
		
		//line 216 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		if (( buf == null )) 
		{
			//line 217 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			return haxe.lang.StringExt.substr(this.source, start, ( ( this.pos - start ) - 1 ));
		}
		else
		{
			//line 219 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			buf.addSub(this.source, start, ( ( this.pos - start ) - 1 ));
			//line 220 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			return buf.toString();
		}
		
	}
	
	
	public final hxjsonast.Json parseNumber(int c)
	{
		//line 225 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		int start = ( this.pos - 1 );
		//line 226 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		boolean minus = ( c == 45 );
		//line 227 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		boolean digit =  ! (minus) ;
		//line 228 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		boolean zero = ( c == 48 );
		//line 229 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		boolean point = false;
		//line 230 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		boolean e = false;
		//line 231 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		boolean pm = false;
		//line 232 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		boolean end = false;
		//line 233 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		while (true)
		{
			//line 234 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			{
				//line 234 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				java.lang.String s = this.source;
				//line 234 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				int index = this.pos++;
				//line 234 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				switch (( (( index < s.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s) )) ).charAt(index)) )) : (-1) ))
				{
					case 43:
					case 45:
					{
						//line 261 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if ((  ! (e)  || pm )) 
						{
							//line 262 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidNumber(start);
						}
						
						//line 263 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						digit = false;
						//line 263 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						pm = true;
						//line 260 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 46:
					{
						//line 251 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (( ( minus || point ) || e )) 
						{
							//line 252 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidNumber(start);
						}
						
						//line 253 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						digit = false;
						//line 254 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						point = true;
						//line 250 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 48:
					{
						//line 236 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (( zero &&  ! (point)  )) 
						{
							//line 237 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidNumber(start);
						}
						
						//line 238 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (minus) 
						{
							//line 239 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							minus = false;
							//line 240 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							zero = true;
						}
						
						//line 242 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						digit = true;
						//line 235 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 49:
					case 50:
					case 51:
					case 52:
					case 53:
					case 54:
					case 55:
					case 56:
					case 57:
					{
						//line 244 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (( zero &&  ! (point)  )) 
						{
							//line 245 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidNumber(start);
						}
						
						//line 246 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (minus) 
						{
							//line 247 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							minus = false;
						}
						
						//line 248 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						digit = true;
						//line 249 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						zero = false;
						//line 243 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 69:
					case 101:
					{
						//line 256 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (( ( minus || zero ) || e )) 
						{
							//line 257 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidNumber(start);
						}
						
						//line 258 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						digit = false;
						//line 259 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						e = true;
						//line 255 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					default:
					{
						//line 265 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if ( ! (digit) ) 
						{
							//line 266 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidNumber(start);
						}
						
						//line 267 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						this.pos--;
						//line 268 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						end = true;
						//line 264 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
				}
				
			}
			
			//line 270 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (end) 
			{
				//line 271 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				break;
			}
			
		}
		
		//line 273 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		java.lang.String s1 = haxe.lang.StringExt.substr(this.source, start, ( this.pos - start ));
		//line 274 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		return new hxjsonast.Json(((hxjsonast.JsonValue) (hxjsonast.JsonValue.JNumber(s1)) ), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (start) ), ((int) (this.pos) ))) ));
	}
	
	
	public final int nextChar()
	{
		//line 278 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		java.lang.String s = this.source;
		//line 278 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		int index = this.pos++;
		//line 278 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		if (( index < s.length() )) 
		{
			//line 278 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			return ((int) (((java.lang.String) (((java.lang.Object) (s) )) ).charAt(index)) );
		}
		else
		{
			//line 278 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			return -1;
		}
		
	}
	
	
	public final hxjsonast.Json mk(hxjsonast.Position pos, hxjsonast.JsonValue value)
	{
		//line 282 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		return new hxjsonast.Json(((hxjsonast.JsonValue) (value) ), ((hxjsonast.Position) (pos) ));
	}
	
	
	public final hxjsonast.Position mkPos(int min, int max)
	{
		//line 286 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		return new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (min) ), ((int) (max) ));
	}
	
	
	public void invalidChar()
	{
		//line 290 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		this.pos--;
		//line 291 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		throw ((java.lang.RuntimeException) (haxe.Exception.thrown(new hxjsonast.Error(haxe.lang.Runtime.toString(( "Invalid character: " + haxe.lang.StringExt.charAt(this.source, this.pos) )), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (this.pos) ), ((int) (( this.pos + 1 )) ))) )))) );
	}
	
	
	public void invalidNumber(int start)
	{
		//line 295 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		throw ((java.lang.RuntimeException) (haxe.Exception.thrown(new hxjsonast.Error(haxe.lang.Runtime.toString(( "Invalid number: " + haxe.lang.StringExt.substring(this.source, start, this.pos) )), ((hxjsonast.Position) (new hxjsonast.Position(haxe.lang.Runtime.toString(this.filename), ((int) (start) ), ((int) (this.pos) ))) )))) );
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		{
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (( field != null )) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("pos")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.pos = ((int) (value) );
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return value;
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		{
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (( field != null )) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("pos")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.pos = ((int) (haxe.lang.Runtime.toInt(value)) );
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return value;
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -896505829:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("source")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.source = haxe.lang.Runtime.toString(value);
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return value;
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -734768633:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("filename")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.filename = haxe.lang.Runtime.toString(value);
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return value;
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		{
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (( field != null )) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				switch (field.hashCode())
				{
					case -1321720800:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("invalidNumber")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "invalidNumber")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -896505829:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("source")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.source;
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -953670163:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("invalidChar")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "invalidChar")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -734768633:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("filename")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.filename;
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 103931862:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("mkPos")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "mkPos")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 111188:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("pos")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.pos;
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 3486:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("mk")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "mk")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 1810775272:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("doParse")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "doParse")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 1423892713:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("nextChar")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "nextChar")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 1187792093:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("parseRec")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "parseRec")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -820654116:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("parseNumber")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "parseNumber")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -678275932:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("parseString")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "parseString")) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		{
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (( field != null )) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				switch (field.hashCode())
				{
					case 111188:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("pos")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return ((double) (this.pos) );
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		{
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			boolean __temp_executeDef1 = true;
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (( field != null )) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				switch (field.hashCode())
				{
					case -1321720800:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("invalidNumber")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidNumber(((int) (haxe.lang.Runtime.toInt(dynargs[0])) ));
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 1810775272:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("doParse")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.doParse();
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -953670163:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("invalidChar")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							this.invalidChar();
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 1187792093:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("parseRec")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.parseRec();
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 103931862:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("mkPos")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.mkPos(((int) (haxe.lang.Runtime.toInt(dynargs[0])) ), ((int) (haxe.lang.Runtime.toInt(dynargs[1])) ));
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -678275932:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("parseString")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.parseString();
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 3486:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("mk")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.mk(((hxjsonast.Position) (dynargs[0]) ), ((hxjsonast.JsonValue) (dynargs[1]) ));
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case -820654116:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("parseNumber")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.parseNumber(((int) (haxe.lang.Runtime.toInt(dynargs[0])) ));
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
					case 1423892713:
					{
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						if (field.equals("nextChar")) 
						{
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							__temp_executeDef1 = false;
							//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
							return this.nextChar();
						}
						
						//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
			if (__temp_executeDef1) 
			{
				//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		baseArr.push("pos");
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		baseArr.push("filename");
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		baseArr.push("source");
		//line 9 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Parser.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


