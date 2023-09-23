package json2object;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class InternalError extends haxe.lang.ParamEnum
{
	public InternalError(int index, java.lang.Object[] params)
	{
		//line 240 "/usr/share/haxe/std/java/internal/HxObject.hx"
		super(index, params);
	}
	
	
	public static final java.lang.String[] __hx_constructs = new java.lang.String[]{"AbstractNoJsonRepresentation", "CannotGenerateSchema", "HandleExpr", "ParsingThrow", "UnsupportedAbstractEnumType", "UnsupportedEnumAbstractValue", "UnsupportedMapKeyType", "UnsupportedSchemaObjectType", "UnsupportedSchemaType"};
	
	public static json2object.InternalError AbstractNoJsonRepresentation(java.lang.String name)
	{
		//line 96 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.InternalError(0, new java.lang.Object[]{name});
	}
	
	
	public static json2object.InternalError CannotGenerateSchema(java.lang.String name)
	{
		//line 97 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.InternalError(1, new java.lang.Object[]{name});
	}
	
	
	public static final json2object.InternalError HandleExpr = new json2object.InternalError(2, null);
	
	public static final json2object.InternalError ParsingThrow = new json2object.InternalError(3, null);
	
	public static json2object.InternalError UnsupportedAbstractEnumType(java.lang.String name)
	{
		//line 100 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.InternalError(4, new java.lang.Object[]{name});
	}
	
	
	public static json2object.InternalError UnsupportedEnumAbstractValue(java.lang.String name)
	{
		//line 101 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.InternalError(5, new java.lang.Object[]{name});
	}
	
	
	public static json2object.InternalError UnsupportedMapKeyType(java.lang.String name)
	{
		//line 102 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.InternalError(6, new java.lang.Object[]{name});
	}
	
	
	public static json2object.InternalError UnsupportedSchemaObjectType(java.lang.String name)
	{
		//line 103 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.InternalError(7, new java.lang.Object[]{name});
	}
	
	
	public static json2object.InternalError UnsupportedSchemaType(java.lang.String type)
	{
		//line 104 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return new json2object.InternalError(8, new java.lang.Object[]{type});
	}
	
	
	@Override public java.lang.String getTag()
	{
		//line 95 "/home/giacomo/haxelib/json2object/3,11,0/src/json2object/Error.hx"
		return json2object.InternalError.__hx_constructs[this.index];
	}
	
	
}


