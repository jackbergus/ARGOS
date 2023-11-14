package hxjsonast;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class JsonValue extends haxe.lang.ParamEnum
{
	public JsonValue(int index, java.lang.Object[] params)
	{
		//line 240 "/usr/share/haxe/std/java/internal/HxObject.hx"
		super(index, params);
	}
	
	
	public static final java.lang.String[] __hx_constructs = new java.lang.String[]{"JString", "JNumber", "JObject", "JArray", "JBool", "JNull"};
	
	public static hxjsonast.JsonValue JString(java.lang.String s)
	{
		//line 31 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		return new hxjsonast.JsonValue(0, new java.lang.Object[]{s});
	}
	
	
	public static hxjsonast.JsonValue JNumber(java.lang.String s)
	{
		//line 39 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		return new hxjsonast.JsonValue(1, new java.lang.Object[]{s});
	}
	
	
	public static hxjsonast.JsonValue JObject(haxe.root.Array<hxjsonast.JObjectField> fields)
	{
		//line 46 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		return new hxjsonast.JsonValue(2, new java.lang.Object[]{fields});
	}
	
	
	public static hxjsonast.JsonValue JArray(haxe.root.Array<hxjsonast.Json> values)
	{
		//line 51 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		return new hxjsonast.JsonValue(3, new java.lang.Object[]{values});
	}
	
	
	public static hxjsonast.JsonValue JBool(boolean b)
	{
		//line 56 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		return new hxjsonast.JsonValue(4, new java.lang.Object[]{b});
	}
	
	
	public static final hxjsonast.JsonValue JNull = new hxjsonast.JsonValue(5, null);
	
	@Override public java.lang.String getTag()
	{
		//line 27 "/home/giacomo/haxelib/hxjsonast/1,1,0/src/hxjsonast/Json.hx"
		return hxjsonast.JsonValue.__hx_constructs[this.index];
	}
	
	
}


