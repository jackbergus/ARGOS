package jackbergus.protocol;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class ProtocolService extends haxe.lang.HxObject
{
	public ProtocolService(haxe.lang.EmptyObject empty)
	{
	}
	
	
	public ProtocolService(jackbergus.dgep.connections.DialogueLogic c, java.lang.String agentName, java.lang.Object sleep)
	{
		//line 26 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		jackbergus.protocol.ProtocolService.__hx_ctor_jackbergus_protocol_ProtocolService(this, c, agentName, sleep);
	}
	
	
	protected static void __hx_ctor_jackbergus_protocol_ProtocolService(jackbergus.protocol.ProtocolService __hx_this, jackbergus.dgep.connections.DialogueLogic c, java.lang.String agentName, java.lang.Object sleep)
	{
		//line 26 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		double sleep1 = ( (haxe.lang.Runtime.eq(sleep, null)) ? (0.5) : (((double) (haxe.lang.Runtime.toDouble(sleep)) )) );
		//line 27 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		__hx_this.connection = c;
		//line 28 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		__hx_this.self = agentName;
		//line 29 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		__hx_this.s = sleep1;
	}
	
	
	public jackbergus.dgep.connections.DialogueLogic connection;
	
	public java.lang.String self;
	
	public double s;
	
	public java.lang.String getSelfServiceName()
	{
		//line 37 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		return this.self;
	}
	
	
	public boolean canIDoActionQM(java.lang.String action)
	{
		//line 53 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		jackbergus.dgep.internals.ResponseAndData m = this.connection.moves(this.self);
		//line 54 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		if ( ! (((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (((haxe.IMap<java.lang.String, haxe.ds.List<jackbergus.dgep.internals.Move>>) (m.response) )) ).exists(this.self)) ) 
		{
			//line 55 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return false;
		}
		
		//line 56 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		haxe.ds.List<jackbergus.dgep.internals.Move> myActions = ((haxe.ds.List<jackbergus.dgep.internals.Move>) (((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (((haxe.IMap<java.lang.String, haxe.ds.List<jackbergus.dgep.internals.Move>>) (m.response) )) ).get(this.self)) );
		//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			haxe.ds._List.ListNode<jackbergus.dgep.internals.Move> _g_head = myActions.h;
			//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			while (( _g_head != null ))
			{
				//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				jackbergus.dgep.internals.Move val = _g_head.item;
				//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				_g_head = _g_head.next;
				//line 57 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				jackbergus.dgep.internals.Move x = val;
				//line 58 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				if (haxe.lang.Runtime.valEq(x.moveID, action)) 
				{
					//line 59 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
					return true;
				}
				
			}
			
		}
		
		//line 61 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		return false;
	}
	
	
	public haxe.ds.List<java.lang.String> availableActions(haxe.lang.Function pred)
	{
		//line 72 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		haxe.ds.List<java.lang.String> l = new haxe.ds.List<java.lang.String>();
		//line 73 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		jackbergus.dgep.internals.ResponseAndData m = this.connection.moves(this.self);
		//line 74 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		if ( ! (((haxe.ds.StringMap<haxe.ds.List<jackbergus.dgep.internals.Move>>) (((haxe.IMap<java.lang.String, haxe.ds.List<jackbergus.dgep.internals.Move>>) (m.response) )) ).exists(this.self)) ) 
		{
			//line 75 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return l;
		}
		
		//line 76 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 76 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			haxe.ds._List.ListNode<java.lang.String> _g_head = m.available(this.self, pred).h;
			//line 76 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			while (( _g_head != null ))
			{
				//line 76 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				java.lang.String val = _g_head.item;
				//line 76 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				_g_head = _g_head.next;
				//line 76 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				java.lang.String x = val;
				//line 77 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				l.add(x);
			}
			
		}
		
		//line 78 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		return l;
	}
	
	
	public boolean isActionAvailable(java.lang.String action, boolean busyWait)
	{
		//line 90 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		if (busyWait) 
		{
			//line 91 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			while ( ! (this.canIDoActionQM(action)) )
			{
				//line 92 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				haxe.root.Sys.sleep(this.s);
			}
			
			//line 93 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			haxe.Log.trace.__hx_invoke2_o(0.0, ( "Can perform action after busy waiting: " + action ), 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.ProtocolService", "jackbergus/protocol/ProtocolService.hx", "isActionAvailable"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (93) )) )}));
			//line 94 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return true;
		}
		else
		{
			//line 96 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			boolean outcome = this.canIDoActionQM(action);
			//line 97 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (outcome) 
			{
				//line 98 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				haxe.Log.trace.__hx_invoke2_o(0.0, ( "Can immediately perform action: " + action ), 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.ProtocolService", "jackbergus/protocol/ProtocolService.hx", "isActionAvailable"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (98) )) )}));
			}
			else
			{
				//line 100 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				haxe.Log.trace.__hx_invoke2_o(0.0, ( "Cannot immediately perform action: " + action ), 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.ProtocolService", "jackbergus/protocol/ProtocolService.hx", "isActionAvailable"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (100) )) )}));
			}
			
			//line 101 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return outcome;
		}
		
	}
	
	
	public haxe.ds.StringMap<java.lang.String> testAction(java.lang.String action, haxe.ds.StringMap<java.lang.String> args, java.lang.String target, boolean busyWait)
	{
		//line 122 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		haxe.ds.StringMap<java.lang.String> r = null;
		//line 131 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		if ( ! (this.isActionAvailable(action, busyWait)) ) 
		{
			//line 132 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return r;
		}
		
		//line 133 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		jackbergus.dgep.requests.Interaction i = new jackbergus.dgep.requests.Interaction(haxe.lang.Runtime.toString(action), haxe.lang.Runtime.toString(this.self), haxe.lang.Runtime.toString(target));
		//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			haxe.IMap<java.lang.String, java.lang.String> map = args;
			//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			haxe.IMap<java.lang.String, java.lang.String> _g_map = map;
			//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			java.lang.Object _g_keys = map.keys();
			//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			while (haxe.lang.Runtime.toBool(((java.lang.Boolean) (haxe.lang.Runtime.callField(_g_keys, "hasNext", null)) )))
			{
				//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				java.lang.String key = haxe.lang.Runtime.toString(haxe.lang.Runtime.callField(_g_keys, "next", null));
				//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				java.lang.String _g1_value = haxe.lang.Runtime.toString(_g_map.get(key));
				//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				java.lang.String _g1_key = key;
				//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				java.lang.String k = _g1_key;
				//line 134 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				java.lang.String v = _g1_value;
				//line 135 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				i.add(k, v);
			}
			
		}
		
		//line 136 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		try 
		{
			//line 137 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			r = this.connection.interaction(i).data;
			//line 138 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return r;
		}
		catch (java.lang.Throwable _g)
		{
			//line 139 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			haxe.Exception e = haxe.Exception.caught(_g);
			//line 140 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			haxe.Log.trace.__hx_invoke2_o(0.0, e.get_message(), 0.0, new haxe.lang.DynamicObject(new java.lang.String[]{"className", "fileName", "methodName"}, new java.lang.Object[]{"jackbergus.protocol.ProtocolService", "jackbergus/protocol/ProtocolService.hx", "testAction"}, new java.lang.String[]{"lineNumber"}, new double[]{((double) (((double) (140) )) )}));
			//line 141 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return r;
		}
		
		
	}
	
	
	public haxe.ds.List<java.lang.String> doableActions(java.lang.String actionKind, java.lang.String action)
	{
		//line 147 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		if (( action == null )) 
		{
			//line 147 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			action = "";
		}
		
		//line 147 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		if (( action.length() == 0 )) 
		{
			//line 148 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return ((haxe.ds.List<java.lang.String>) (((haxe.ds.List) (this.availableActions(new jackbergus.protocol.ProtocolService_doableActions_148__Fun(actionKind)).map(((haxe.lang.Function) (new jackbergus.protocol.ProtocolService_doableActions_149__Fun(actionKind)) ))) )) );
		}
		else
		{
			//line 151 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			return ((haxe.ds.List<java.lang.String>) (((haxe.ds.List) (this.availableActions(new jackbergus.protocol.ProtocolService_doableActions_151__Fun(actionKind, action)).map(((haxe.lang.Function) (new jackbergus.protocol.ProtocolService_doableActions_152__Fun(actionKind)) ))) )) );
		}
		
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (( field != null )) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				switch (field.hashCode())
				{
					case 115:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("s")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							this.s = ((double) (value) );
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return value;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (( field != null )) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				switch (field.hashCode())
				{
					case 115:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("s")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							this.s = ((double) (haxe.lang.Runtime.toDouble(value)) );
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return value;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case -775651618:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("connection")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							this.connection = ((jackbergus.dgep.connections.DialogueLogic) (value) );
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return value;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 3526476:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("self")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							this.self = haxe.lang.Runtime.toString(value);
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return value;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (( field != null )) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				switch (field.hashCode())
				{
					case 380154072:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("doableActions")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "doableActions")) );
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case -775651618:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("connection")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.connection;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 1196783976:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("testAction")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "testAction")) );
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 3526476:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("self")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.self;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case -1588249943:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("isActionAvailable")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "isActionAvailable")) );
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 115:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("s")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.s;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 546591220:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("availableActions")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "availableActions")) );
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case -17320514:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("getSelfServiceName")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "getSelfServiceName")) );
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 1246223318:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("canIDoActionQM")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "canIDoActionQM")) );
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (( field != null )) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				switch (field.hashCode())
				{
					case 115:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("s")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.s;
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		{
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			boolean __temp_executeDef1 = true;
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (( field != null )) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				switch (field.hashCode())
				{
					case 380154072:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("doableActions")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.doableActions(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toString(( (( dynargs.length > 1 )) ? (dynargs[1]) : (null) )));
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case -17320514:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("getSelfServiceName")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.getSelfServiceName();
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 1196783976:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("testAction")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.testAction(haxe.lang.Runtime.toString(dynargs[0]), ((haxe.ds.StringMap<java.lang.String>) (dynargs[1]) ), haxe.lang.Runtime.toString(dynargs[2]), haxe.lang.Runtime.toBool(((java.lang.Boolean) (dynargs[3]) )));
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 1246223318:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("canIDoActionQM")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.canIDoActionQM(haxe.lang.Runtime.toString(dynargs[0]));
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case -1588249943:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("isActionAvailable")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.isActionAvailable(haxe.lang.Runtime.toString(dynargs[0]), haxe.lang.Runtime.toBool(((java.lang.Boolean) (dynargs[1]) )));
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
					case 546591220:
					{
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						if (field.equals("availableActions")) 
						{
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							__temp_executeDef1 = false;
							//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
							return this.availableActions(((haxe.lang.Function) (dynargs[0]) ));
						}
						
						//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
			if (__temp_executeDef1) 
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			else
			{
				//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		baseArr.push("s");
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		baseArr.push("self");
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		baseArr.push("connection");
		//line 13 "/home/giacomo/projects/tweetyPrEAF/broker/haxe/src/jackbergus/protocol/ProtocolService.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


