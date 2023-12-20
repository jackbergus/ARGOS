package json2object.writer;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class StringUtils extends haxe.lang.HxObject
{
	public StringUtils(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public StringUtils()
	{
		//line 29 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
		json2object.writer.StringUtils.__hx_ctor_json2object_writer_StringUtils(this);
	}
	
	
	protected static void __hx_ctor_json2object_writer_StringUtils(json2object.writer.StringUtils __hx_this)
	{
	}
	
	
	public static java.lang.String quote(java.lang.String s)
	{
		//line 38 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
		haxe.root.StringBuf buf = new haxe.root.StringBuf();
		//line 62 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
		buf.addChar(34);
		//line 63 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
		int i = 0;
		//line 67 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
		while (true)
		{
			//line 68 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
			int index = i++;
			//line 68 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
			int c = ( (( index < s.length() )) ? (((int) (((java.lang.String) (((java.lang.Object) (s) )) ).charAt(index)) )) : (-1) );
			//line 69 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
			if (( c == -1 )) 
			{
				//line 69 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
				break;
			}
			
			//line 70 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
			switch (c)
			{
				case 8:
				{
					//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.add(haxe.lang.Runtime.toString("\\b"));
					//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
					//line 76 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
				
				case 9:
				{
					//line 75 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.add(haxe.lang.Runtime.toString("\\t"));
					//line 75 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					java.lang.Object __temp_expr2 = ((java.lang.Object) (null) );
					//line 75 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
				
				case 10:
				{
					//line 73 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.add(haxe.lang.Runtime.toString("\\n"));
					//line 73 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					java.lang.Object __temp_expr3 = ((java.lang.Object) (null) );
					//line 73 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
				
				case 12:
				{
					//line 77 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.add(haxe.lang.Runtime.toString("\\f"));
					//line 77 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					java.lang.Object __temp_expr4 = ((java.lang.Object) (null) );
					//line 77 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
				
				case 13:
				{
					//line 74 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.add(haxe.lang.Runtime.toString("\\r"));
					//line 74 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					java.lang.Object __temp_expr5 = ((java.lang.Object) (null) );
					//line 74 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
				
				case 34:
				{
					//line 71 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.add(haxe.lang.Runtime.toString("\\\""));
					//line 71 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					java.lang.Object __temp_expr6 = ((java.lang.Object) (null) );
					//line 71 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
				
				case 92:
				{
					//line 72 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.add(haxe.lang.Runtime.toString("\\\\"));
					//line 72 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					java.lang.Object __temp_expr7 = ((java.lang.Object) (null) );
					//line 72 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
				
				default:
				{
					//line 97 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					buf.addChar(c);
					//line 97 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
					break;
				}
				
			}
			
		}
		
		//line 104 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
		buf.addChar(34);
		//line 105 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/writer/StringUtils.hx"
		return buf.toString();
	}
	
	
}


