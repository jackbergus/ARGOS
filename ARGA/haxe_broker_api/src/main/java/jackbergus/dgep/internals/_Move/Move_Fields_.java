package jackbergus.dgep.internals._Move;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public final class Move_Fields_
{
	public static haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>> parseJSONMoves(java.lang.Object parse)
	{
		//line 73 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>> map = new haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>();
		//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		{
			//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			int _g = 0;
			//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			haxe.root.Array<java.lang.String> _g1 = haxe.root.Reflect.fields(parse);
			//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
			while (( _g < _g1.length ))
			{
				//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				java.lang.String username = _g1.__get(_g);
				//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				 ++ _g;
				//line 75 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				java.lang.String obj = haxe.lang.Runtime.toString(haxe.root.Reflect.field(parse, username));
				//line 76 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				haxe.ds.List<jackbergus.dgep.internals.Move> um = new haxe.ds.List<jackbergus.dgep.internals.Move>();
				//line 77 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				haxe.root.JsonParser_1 parser = new haxe.root.JsonParser_1(((haxe.root.Array<json2object.Error>) (null) ), ((json2object.PositionUtils) (null) ), ((java.lang.Object) (null) ));
				//line 78 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				um = parser.fromJson(obj, null);
				//line 95 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
				map.set(username, um);
			}
			
		}
		
		//line 97 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Move.hx"
		return map;
	}
	
	
}


