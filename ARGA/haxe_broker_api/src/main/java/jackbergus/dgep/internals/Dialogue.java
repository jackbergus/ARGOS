package jackbergus.dgep.internals;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Dialogue extends haxe.lang.HxObject
{
	public Dialogue(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public Dialogue()
	{
		//line 53 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		jackbergus.dgep.internals.Dialogue.__hx_ctor_jackbergus_dgep_internals_Dialogue(this);
	}
	
	
	protected static void __hx_ctor_jackbergus_dgep_internals_Dialogue(jackbergus.dgep.internals.Dialogue __hx_this)
	{
		//line 54 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		__hx_this.players = new haxe.ds.List<jackbergus.dgep.internals.Player>();
		//line 55 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		__hx_this.available_moves = new haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>();
		//line 56 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		__hx_this.dialogue_history = new haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.requests.Interaction>>();
	}
	
	
	public java.lang.String dgdl;
	
	public java.lang.String content_source;
	
	public haxe.ds.List<jackbergus.dgep.internals.Player> players;
	
	public java.lang.String turntaking;
	
	public boolean backtracking;
	
	public java.lang.String current_speaker;
	
	public java.lang.String status;
	
	public haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>> available_moves;
	
	public haxe.ds.List<java.lang.String> current_speakers;
	
	public haxe.ds.StringMap<haxe.ds.List<java.lang.String>> runtimevars;
	
	public haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.requests.Interaction>> dialogue_history;
	
	public haxe.ds.List<java.lang.String> extURI;
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		{
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
			boolean __temp_executeDef1 = true;
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
			if (( field != null )) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
				switch (field.hashCode())
				{
					case -1289060469:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("extURI")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.extURI = ((haxe.ds.List<java.lang.String>) (value) );
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 3081291:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("dgdl")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.dgdl = haxe.lang.Runtime.toString(value);
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 1387531565:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("dialogue_history")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.dialogue_history = ((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.requests.Interaction>>) (value) );
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 502589089:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("content_source")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.content_source = haxe.lang.Runtime.toString(value);
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 755843588:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("runtimevars")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.runtimevars = ((haxe.ds.StringMap<haxe.ds.List<java.lang.String>>) (value) );
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case -493567566:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("players")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.players = ((haxe.ds.List<jackbergus.dgep.internals.Player>) (value) );
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 1385704538:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("current_speakers")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.current_speakers = ((haxe.ds.List<java.lang.String>) (value) );
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 1027390017:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("turntaking")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.turntaking = haxe.lang.Runtime.toString(value);
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 747057612:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("available_moves")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.available_moves = ((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (value) );
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 426003614:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("backtracking")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.backtracking = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case -892481550:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("status")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.status = haxe.lang.Runtime.toString(value);
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case -1756415175:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("current_speaker")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							this.current_speaker = haxe.lang.Runtime.toString(value);
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return value;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
			if (__temp_executeDef1) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		{
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
			boolean __temp_executeDef1 = true;
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
			if (( field != null )) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
				switch (field.hashCode())
				{
					case -1289060469:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("extURI")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.extURI;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 3081291:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("dgdl")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.dgdl;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 1387531565:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("dialogue_history")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.dialogue_history;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 502589089:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("content_source")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.content_source;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 755843588:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("runtimevars")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.runtimevars;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case -493567566:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("players")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.players;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 1385704538:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("current_speakers")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.current_speakers;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 1027390017:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("turntaking")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.turntaking;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 747057612:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("available_moves")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.available_moves;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case 426003614:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("backtracking")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.backtracking;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case -892481550:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("status")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.status;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
					case -1756415175:
					{
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						if (field.equals("current_speaker")) 
						{
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							__temp_executeDef1 = false;
							//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
							return this.current_speaker;
						}
						
						//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
			if (__temp_executeDef1) 
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("extURI");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("dialogue_history");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("runtimevars");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("current_speakers");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("available_moves");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("status");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("current_speaker");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("backtracking");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("turntaking");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("players");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("content_source");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		baseArr.push("dgdl");
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/dgep/internals/Dialogue.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


