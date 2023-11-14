package haxe;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public interface IMap<K, V> extends haxe.lang.IHxObject
{
	java.lang.Object get(K k);
	
	java.lang.Object keys();
	
}


