package json2object;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Error extends haxe.lang.ParamEnum
{
	public Error(int index, java.lang.Object[] params)
	{
		//line 240 "/usr/share/haxe/std/java/internal/HxObject.hx"
		super(index, params);
	}
	
	
	public static final java.lang.String[] __hx_constructs = new java.lang.String[]{"IncorrectType", "IncorrectEnumValue", "InvalidEnumConstructor", "UninitializedVariable", "UnknownVariable", "ParserError", "CustomFunctionException"};
	
	public static json2object.Error IncorrectType(java.lang.String variable, java.lang.String expected, java.lang.Object pos)
	{
		//line 36 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.Error(0, new java.lang.Object[]{variable, expected, pos});
	}
	
	
	public static json2object.Error IncorrectEnumValue(java.lang.String value, java.lang.String expected, java.lang.Object pos)
	{
		//line 45 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.Error(1, new java.lang.Object[]{value, expected, pos});
	}
	
	
	public static json2object.Error InvalidEnumConstructor(java.lang.String value, java.lang.String expected, java.lang.Object pos)
	{
		//line 54 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.Error(2, new java.lang.Object[]{value, expected, pos});
	}
	
	
	public static json2object.Error UninitializedVariable(java.lang.String variable, java.lang.Object pos)
	{
		//line 62 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.Error(3, new java.lang.Object[]{variable, pos});
	}
	
	
	public static json2object.Error UnknownVariable(java.lang.String variable, java.lang.Object pos)
	{
		//line 70 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.Error(4, new java.lang.Object[]{variable, pos});
	}
	
	
	public static json2object.Error ParserError(java.lang.String message, java.lang.Object pos)
	{
		//line 78 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.Error(5, new java.lang.Object[]{message, pos});
	}
	
	
	public static json2object.Error CustomFunctionException(java.lang.Object e, java.lang.Object pos)
	{
		//line 86 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.Error(6, new java.lang.Object[]{e, pos});
	}
	
	
	@Override public java.lang.String getTag()
	{
		//line 28 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return json2object.Error.__hx_constructs[this.index];
	}
	
	
}


