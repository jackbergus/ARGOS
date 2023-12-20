package sys;

import haxe.root.*;

@SuppressWarnings(value={"rawtypes", "unchecked"})
public class Http extends haxe.http.HttpBase
{
	static
	{
		//line 46 "/usr/share/haxe/std/sys/Http.hx"
		sys.Http.PROXY = null;
	}
	
	public Http(haxe.lang.EmptyObject empty)
	{
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		super(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
	}
	
	
	public Http(java.lang.String url)
	{
		//line 53 "/usr/share/haxe/std/sys/Http.hx"
		super(((haxe.lang.EmptyObject) (haxe.lang.EmptyObject.EMPTY) ));
		//line 53 "/usr/share/haxe/std/sys/Http.hx"
		sys.Http.__hx_ctor_sys_Http(this, url);
	}
	
	
	protected static void __hx_ctor_sys_Http(sys.Http __hx_this, java.lang.String url)
	{
		//line 49 "/usr/share/haxe/std/sys/Http.hx"
		__hx_this.cnxTimeout = ((double) (10) );
		//line 53 "/usr/share/haxe/std/sys/Http.hx"
		haxe.http.HttpBase.__hx_ctor_haxe_http_HttpBase(__hx_this, url);
	}
	
	
	public static java.lang.Object PROXY;
	
	public boolean noShutdown;
	
	public double cnxTimeout;
	
	public haxe.ds.StringMap<java.lang.String> responseHeaders;
	
	public java.lang.Object chunk_size;
	
	public haxe.io.Bytes chunk_buf;
	
	public java.lang.Object file;
	
	public void request(java.lang.Object post)
	{
		//line 57 "/usr/share/haxe/std/sys/Http.hx"
		haxe.io.BytesOutput output = new haxe.io.BytesOutput();
		//line 58 "/usr/share/haxe/std/sys/Http.hx"
		haxe.lang.Function old = this.onError;
		//line 59 "/usr/share/haxe/std/sys/Http.hx"
		boolean[] err = new boolean[]{false};
		//line 56 "/usr/share/haxe/std/sys/Http.hx"
		sys.Http _gthis = this;
		//line 60 "/usr/share/haxe/std/sys/Http.hx"
		this.onError = new sys.Http_request_60__Fun(output, old, err, _gthis);
		//line 67 "/usr/share/haxe/std/sys/Http.hx"
		post = ( ( haxe.lang.Runtime.toBool(((java.lang.Boolean) (post) )) || haxe.lang.Runtime.toBool(((java.lang.Boolean) (( this.postBytes != null )) )) ) || ( this.postData != null ) );
		//line 68 "/usr/share/haxe/std/sys/Http.hx"
		this.customRequest(haxe.lang.Runtime.toBool(((java.lang.Boolean) (post) )), output, null, null);
		//line 69 "/usr/share/haxe/std/sys/Http.hx"
		if ( ! (err[0]) ) 
		{
			//line 70 "/usr/share/haxe/std/sys/Http.hx"
			this.success(output.getBytes());
		}
		
	}
	
	
	public void customRequest(boolean post, haxe.io.Output api, sys.net.Socket sock, java.lang.String method)
	{
		//line 91 "/usr/share/haxe/std/sys/Http.hx"
		this.responseAsString = null;
		//line 92 "/usr/share/haxe/std/sys/Http.hx"
		this.responseBytes = null;
		//line 93 "/usr/share/haxe/std/sys/Http.hx"
		haxe.root.EReg url_regexp = new haxe.root.EReg(haxe.lang.Runtime.toString("^(https?://)?([a-zA-Z\\.0-9_-]+)(:[0-9]+)?(.*)$"), haxe.lang.Runtime.toString(""));
		//line 94 "/usr/share/haxe/std/sys/Http.hx"
		if ( ! (url_regexp.match(this.url)) ) 
		{
			//line 95 "/usr/share/haxe/std/sys/Http.hx"
			this.onError.__hx_invoke1_o(0.0, "Invalid URL");
			//line 96 "/usr/share/haxe/std/sys/Http.hx"
			return ;
		}
		
		//line 98 "/usr/share/haxe/std/sys/Http.hx"
		boolean secure = haxe.lang.Runtime.valEq(url_regexp.matched(1), "https://");
		//line 99 "/usr/share/haxe/std/sys/Http.hx"
		if (( sock == null )) 
		{
			//line 100 "/usr/share/haxe/std/sys/Http.hx"
			if (secure) 
			{
				//line 104 "/usr/share/haxe/std/sys/Http.hx"
				sock = new haxe.java.net.SslSocket();
			}
			else
			{
				//line 115 "/usr/share/haxe/std/sys/Http.hx"
				sock = new sys.net.Socket();
			}
			
			//line 117 "/usr/share/haxe/std/sys/Http.hx"
			sock.setTimeout(this.cnxTimeout);
		}
		
		//line 119 "/usr/share/haxe/std/sys/Http.hx"
		java.lang.String host = url_regexp.matched(2);
		//line 120 "/usr/share/haxe/std/sys/Http.hx"
		java.lang.String portString = url_regexp.matched(3);
		//line 121 "/usr/share/haxe/std/sys/Http.hx"
		java.lang.String request = url_regexp.matched(4);
		//line 125 "/usr/share/haxe/std/sys/Http.hx"
		if ( ! (haxe.lang.Runtime.valEq(haxe.lang.StringExt.charAt(request, 0), "/")) ) 
		{
			//line 126 "/usr/share/haxe/std/sys/Http.hx"
			request = ( "/" + request );
		}
		
		//line 128 "/usr/share/haxe/std/sys/Http.hx"
		java.lang.Object port = ( (( ( portString == null ) || haxe.lang.Runtime.valEq(portString, "") )) ? (( (secure) ? (443) : (80) )) : (haxe.root.Std.parseInt(haxe.lang.StringExt.substr(portString, 1, ( portString.length() - 1 )))) );
		//line 130 "/usr/share/haxe/std/sys/Http.hx"
		boolean multipart = ( ! (( this.file == null )) );
		//line 131 "/usr/share/haxe/std/sys/Http.hx"
		java.lang.String boundary = null;
		//line 132 "/usr/share/haxe/std/sys/Http.hx"
		java.lang.String uri = null;
		//line 133 "/usr/share/haxe/std/sys/Http.hx"
		if (multipart) 
		{
			//line 134 "/usr/share/haxe/std/sys/Http.hx"
			post = true;
			//line 135 "/usr/share/haxe/std/sys/Http.hx"
			boundary = ( ( ( haxe.root.Std.string(haxe.root.Std.random(1000)) + haxe.root.Std.string(haxe.root.Std.random(1000)) ) + haxe.root.Std.string(haxe.root.Std.random(1000)) ) + haxe.root.Std.string(haxe.root.Std.random(1000)) );
			//line 139 "/usr/share/haxe/std/sys/Http.hx"
			while (( boundary.length() < 38 ))
			{
				//line 140 "/usr/share/haxe/std/sys/Http.hx"
				boundary = ( "-" + boundary );
			}
			
			//line 141 "/usr/share/haxe/std/sys/Http.hx"
			haxe.root.StringBuf b = new haxe.root.StringBuf();
			//line 142 "/usr/share/haxe/std/sys/Http.hx"
			{
				//line 142 "/usr/share/haxe/std/sys/Http.hx"
				int _g = 0;
				//line 142 "/usr/share/haxe/std/sys/Http.hx"
				haxe.root.Array<java.lang.Object> _g1 = this.params;
				//line 142 "/usr/share/haxe/std/sys/Http.hx"
				while (( _g < _g1.length ))
				{
					//line 142 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object p = _g1.__get(_g);
					//line 142 "/usr/share/haxe/std/sys/Http.hx"
					 ++ _g;
					//line 143 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString("--"));
					//line 143 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr1 = ((java.lang.Object) (null) );
					//line 144 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString(boundary));
					//line 144 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr2 = ((java.lang.Object) (null) );
					//line 145 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString("\r\n"));
					//line 145 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr3 = ((java.lang.Object) (null) );
					//line 146 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString("Content-Disposition: form-data; name=\""));
					//line 146 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr4 = ((java.lang.Object) (null) );
					//line 147 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(p, "name", true)));
					//line 147 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr5 = ((java.lang.Object) (null) );
					//line 148 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString("\""));
					//line 148 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr6 = ((java.lang.Object) (null) );
					//line 149 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString("\r\n"));
					//line 149 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr7 = ((java.lang.Object) (null) );
					//line 150 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString("\r\n"));
					//line 150 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr8 = ((java.lang.Object) (null) );
					//line 151 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(p, "value", true)));
					//line 151 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr9 = ((java.lang.Object) (null) );
					//line 152 "/usr/share/haxe/std/sys/Http.hx"
					b.add(haxe.lang.Runtime.toString("\r\n"));
					//line 152 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object __temp_expr10 = ((java.lang.Object) (null) );
				}
				
			}
			
			//line 154 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString("--"));
			//line 154 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr11 = ((java.lang.Object) (null) );
			//line 155 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString(boundary));
			//line 155 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr12 = ((java.lang.Object) (null) );
			//line 156 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString("\r\n"));
			//line 156 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr13 = ((java.lang.Object) (null) );
			//line 157 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString("Content-Disposition: form-data; name=\""));
			//line 157 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr14 = ((java.lang.Object) (null) );
			//line 158 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(this.file, "param", true)));
			//line 158 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr15 = ((java.lang.Object) (null) );
			//line 159 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString("\"; filename=\""));
			//line 159 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr16 = ((java.lang.Object) (null) );
			//line 160 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(this.file, "filename", true)));
			//line 160 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr17 = ((java.lang.Object) (null) );
			//line 161 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString("\""));
			//line 161 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr18 = ((java.lang.Object) (null) );
			//line 162 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString("\r\n"));
			//line 162 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr19 = ((java.lang.Object) (null) );
			//line 163 "/usr/share/haxe/std/sys/Http.hx"
			b.add(haxe.lang.Runtime.toString(( ( ( "Content-Type: " + haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(this.file, "mimeType", true)) ) + "\r\n" ) + "\r\n" )));
			//line 163 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object __temp_expr20 = ((java.lang.Object) (null) );
			//line 164 "/usr/share/haxe/std/sys/Http.hx"
			uri = b.toString();
		}
		else
		{
			//line 166 "/usr/share/haxe/std/sys/Http.hx"
			int _g2 = 0;
			//line 166 "/usr/share/haxe/std/sys/Http.hx"
			haxe.root.Array<java.lang.Object> _g3 = this.params;
			//line 166 "/usr/share/haxe/std/sys/Http.hx"
			while (( _g2 < _g3.length ))
			{
				//line 166 "/usr/share/haxe/std/sys/Http.hx"
				java.lang.Object p1 = _g3.__get(_g2);
				//line 166 "/usr/share/haxe/std/sys/Http.hx"
				 ++ _g2;
				//line 167 "/usr/share/haxe/std/sys/Http.hx"
				if (( uri == null )) 
				{
					//line 168 "/usr/share/haxe/std/sys/Http.hx"
					uri = "";
				}
				else
				{
					//line 170 "/usr/share/haxe/std/sys/Http.hx"
					uri += "&";
				}
				
				//line 171 "/usr/share/haxe/std/sys/Http.hx"
				uri += ( ( haxe.root.StringTools.urlEncode(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(p1, "name", true))) + "=" ) + haxe.root.StringTools.urlEncode(( "" + haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(p1, "value", true)) )) );
			}
			
		}
		
		//line 175 "/usr/share/haxe/std/sys/Http.hx"
		haxe.io.BytesOutput b1 = new haxe.io.BytesOutput();
		//line 176 "/usr/share/haxe/std/sys/Http.hx"
		if (( method != null )) 
		{
			//line 177 "/usr/share/haxe/std/sys/Http.hx"
			b1.writeString(method, null);
			//line 178 "/usr/share/haxe/std/sys/Http.hx"
			b1.writeString(" ", null);
		}
		else
		{
			//line 179 "/usr/share/haxe/std/sys/Http.hx"
			if (post) 
			{
				//line 180 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString("POST ", null);
			}
			else
			{
				//line 182 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString("GET ", null);
			}
			
		}
		
		//line 184 "/usr/share/haxe/std/sys/Http.hx"
		if (( ! (( sys.Http.PROXY == null )) )) 
		{
			//line 185 "/usr/share/haxe/std/sys/Http.hx"
			b1.writeString("http://", null);
			//line 186 "/usr/share/haxe/std/sys/Http.hx"
			b1.writeString(host, null);
			//line 187 "/usr/share/haxe/std/sys/Http.hx"
			if (( ! (haxe.lang.Runtime.eq(port, 80)) )) 
			{
				//line 188 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString(":", null);
				//line 189 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString(( haxe.lang.Runtime.toString("") + haxe.lang.Runtime.toString(port) ), null);
			}
			
		}
		
		//line 192 "/usr/share/haxe/std/sys/Http.hx"
		b1.writeString(request, null);
		//line 194 "/usr/share/haxe/std/sys/Http.hx"
		if ((  ! (post)  && ( uri != null ) )) 
		{
			//line 195 "/usr/share/haxe/std/sys/Http.hx"
			if (( haxe.lang.StringExt.indexOf(request, "?", 0) >= 0 )) 
			{
				//line 196 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString("&", null);
			}
			else
			{
				//line 198 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString("?", null);
			}
			
			//line 199 "/usr/share/haxe/std/sys/Http.hx"
			b1.writeString(uri, null);
		}
		
		//line 201 "/usr/share/haxe/std/sys/Http.hx"
		b1.writeString(( ( " HTTP/1.1\r\nHost: " + host ) + "\r\n" ), null);
		//line 202 "/usr/share/haxe/std/sys/Http.hx"
		if (( this.postData != null )) 
		{
			//line 203 "/usr/share/haxe/std/sys/Http.hx"
			this.postBytes = haxe.io.Bytes.ofString(this.postData, null);
			//line 204 "/usr/share/haxe/std/sys/Http.hx"
			this.postData = null;
		}
		
		//line 206 "/usr/share/haxe/std/sys/Http.hx"
		if (( this.postBytes != null )) 
		{
			//line 207 "/usr/share/haxe/std/sys/Http.hx"
			b1.writeString(( ( "Content-Length: " + this.postBytes.length ) + "\r\n" ), null);
		}
		else
		{
			//line 208 "/usr/share/haxe/std/sys/Http.hx"
			if (( post && ( uri != null ) )) 
			{
				//line 209 "/usr/share/haxe/std/sys/Http.hx"
				if (( multipart ||  ! (haxe.lang.Runtime.toBool(((java.lang.Boolean) (haxe.root.Lambda.exists(((java.lang.Object) (this.headers) ), ((haxe.lang.Function) (( (( sys.Http_customRequest_209__Fun.__hx_current != null )) ? (sys.Http_customRequest_209__Fun.__hx_current) : (sys.Http_customRequest_209__Fun.__hx_current = ((sys.Http_customRequest_209__Fun) (new sys.Http_customRequest_209__Fun()) )) )) ))) )))  )) 
				{
					//line 210 "/usr/share/haxe/std/sys/Http.hx"
					b1.writeString("Content-Type: ", null);
					//line 211 "/usr/share/haxe/std/sys/Http.hx"
					if (multipart) 
					{
						//line 212 "/usr/share/haxe/std/sys/Http.hx"
						b1.writeString("multipart/form-data", null);
						//line 213 "/usr/share/haxe/std/sys/Http.hx"
						b1.writeString("; boundary=", null);
						//line 214 "/usr/share/haxe/std/sys/Http.hx"
						b1.writeString(boundary, null);
					}
					else
					{
						//line 216 "/usr/share/haxe/std/sys/Http.hx"
						b1.writeString("application/x-www-form-urlencoded", null);
					}
					
					//line 217 "/usr/share/haxe/std/sys/Http.hx"
					b1.writeString("\r\n", null);
				}
				
				//line 219 "/usr/share/haxe/std/sys/Http.hx"
				if (multipart) 
				{
					//line 220 "/usr/share/haxe/std/sys/Http.hx"
					b1.writeString(( ( "Content-Length: " + (( ( ( uri.length() + ((int) (haxe.lang.Runtime.getField_f(this.file, "size", true)) ) ) + boundary.length() ) + 6 )) ) + "\r\n" ), null);
				}
				else
				{
					//line 222 "/usr/share/haxe/std/sys/Http.hx"
					b1.writeString(( ( "Content-Length: " + uri.length() ) + "\r\n" ), null);
				}
				
			}
			
		}
		
		//line 224 "/usr/share/haxe/std/sys/Http.hx"
		b1.writeString("Connection: close\r\n", null);
		//line 225 "/usr/share/haxe/std/sys/Http.hx"
		{
			//line 225 "/usr/share/haxe/std/sys/Http.hx"
			int _g4 = 0;
			//line 225 "/usr/share/haxe/std/sys/Http.hx"
			haxe.root.Array<java.lang.Object> _g5 = this.headers;
			//line 225 "/usr/share/haxe/std/sys/Http.hx"
			while (( _g4 < _g5.length ))
			{
				//line 225 "/usr/share/haxe/std/sys/Http.hx"
				java.lang.Object h = _g5.__get(_g4);
				//line 225 "/usr/share/haxe/std/sys/Http.hx"
				 ++ _g4;
				//line 226 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(h, "name", true)), null);
				//line 227 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString(": ", null);
				//line 228 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(h, "value", true)), null);
				//line 229 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString("\r\n", null);
			}
			
		}
		
		//line 231 "/usr/share/haxe/std/sys/Http.hx"
		b1.writeString("\r\n", null);
		//line 232 "/usr/share/haxe/std/sys/Http.hx"
		if (( this.postBytes != null )) 
		{
			//line 233 "/usr/share/haxe/std/sys/Http.hx"
			b1.writeFullBytes(this.postBytes, 0, this.postBytes.length);
		}
		else
		{
			//line 234 "/usr/share/haxe/std/sys/Http.hx"
			if (( post && ( uri != null ) )) 
			{
				//line 235 "/usr/share/haxe/std/sys/Http.hx"
				b1.writeString(uri, null);
			}
			
		}
		
		//line 236 "/usr/share/haxe/std/sys/Http.hx"
		try 
		{
			//line 237 "/usr/share/haxe/std/sys/Http.hx"
			if (( ! (( sys.Http.PROXY == null )) )) 
			{
				//line 238 "/usr/share/haxe/std/sys/Http.hx"
				sock.connect(new sys.net.Host(haxe.lang.Runtime.toString(haxe.lang.Runtime.getField(sys.Http.PROXY, "host", true))), ((int) (haxe.lang.Runtime.getField_f(sys.Http.PROXY, "port", true)) ));
			}
			else
			{
				//line 240 "/usr/share/haxe/std/sys/Http.hx"
				sock.connect(new sys.net.Host(haxe.lang.Runtime.toString(host)), ((int) (haxe.lang.Runtime.toInt(port)) ));
			}
			
			//line 241 "/usr/share/haxe/std/sys/Http.hx"
			if (multipart) 
			{
				//line 242 "/usr/share/haxe/std/sys/Http.hx"
				this.writeBody(b1, ((haxe.io.Input) (haxe.lang.Runtime.getField(this.file, "io", true)) ), ((int) (haxe.lang.Runtime.getField_f(this.file, "size", true)) ), boundary, sock);
			}
			else
			{
				//line 244 "/usr/share/haxe/std/sys/Http.hx"
				this.writeBody(b1, null, 0, null, sock);
			}
			
			//line 245 "/usr/share/haxe/std/sys/Http.hx"
			this.readHttpResponse(api, sock);
			//line 246 "/usr/share/haxe/std/sys/Http.hx"
			sock.close();
		}
		catch (java.lang.Throwable _g6)
		{
			//line 247 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object e = ((java.lang.Object) (haxe.Exception.caught(_g6).unwrap()) );
			//line 247 "/usr/share/haxe/std/sys/Http.hx"
			{
				//line 249 "/usr/share/haxe/std/sys/Http.hx"
				try 
				{
					//line 249 "/usr/share/haxe/std/sys/Http.hx"
					sock.close();
				}
				catch (java.lang.Throwable _g7)
				{
				}
				
				
				//line 251 "/usr/share/haxe/std/sys/Http.hx"
				this.onError.__hx_invoke1_o(0.0, haxe.root.Std.string(e));
			}
			
		}
		
		
	}
	
	
	public void writeBody(haxe.io.BytesOutput body, haxe.io.Input fileInput, int fileSize, java.lang.String boundary, sys.net.Socket sock)
	{
		//line 255 "/usr/share/haxe/std/sys/Http.hx"
		try 
		{
			//line 256 "/usr/share/haxe/std/sys/Http.hx"
			if (( body != null )) 
			{
				//line 257 "/usr/share/haxe/std/sys/Http.hx"
				haxe.io.Bytes bytes = body.getBytes();
				//line 258 "/usr/share/haxe/std/sys/Http.hx"
				sock.output.writeFullBytes(bytes, 0, bytes.length);
			}
			
			//line 260 "/usr/share/haxe/std/sys/Http.hx"
			if (( boundary != null )) 
			{
				//line 261 "/usr/share/haxe/std/sys/Http.hx"
				int bufsize = 4096;
				//line 262 "/usr/share/haxe/std/sys/Http.hx"
				haxe.io.Bytes buf = haxe.io.Bytes.alloc(bufsize);
				//line 263 "/usr/share/haxe/std/sys/Http.hx"
				while (( fileSize > 0 ))
				{
					//line 264 "/usr/share/haxe/std/sys/Http.hx"
					int size = ( (( fileSize > bufsize )) ? (bufsize) : (fileSize) );
					//line 265 "/usr/share/haxe/std/sys/Http.hx"
					int len = 0;
					//line 267 "/usr/share/haxe/std/sys/Http.hx"
					try 
					{
						//line 267 "/usr/share/haxe/std/sys/Http.hx"
						len = fileInput.readBytes(buf, 0, size);
					}
					catch (java.lang.Throwable _g)
					{
						//line 266 "/usr/share/haxe/std/sys/Http.hx"
						if (( ((java.lang.Object) (haxe.Exception.caught(_g).unwrap()) ) instanceof haxe.io.Eof )) 
						{
							//line 269 "/usr/share/haxe/std/sys/Http.hx"
							break;
						}
						else
						{
							//line 266 "/usr/share/haxe/std/sys/Http.hx"
							throw _g;
						}
						
					}
					
					
					//line 270 "/usr/share/haxe/std/sys/Http.hx"
					sock.output.writeFullBytes(buf, 0, len);
					//line 271 "/usr/share/haxe/std/sys/Http.hx"
					fileSize -= len;
				}
				
				//line 273 "/usr/share/haxe/std/sys/Http.hx"
				sock.output.writeString("\r\n", null);
				//line 274 "/usr/share/haxe/std/sys/Http.hx"
				sock.output.writeString("--", null);
				//line 275 "/usr/share/haxe/std/sys/Http.hx"
				sock.output.writeString(boundary, null);
				//line 276 "/usr/share/haxe/std/sys/Http.hx"
				sock.output.writeString("--", null);
			}
			
		}
		catch (java.lang.Throwable typedException)
		{
			//line 255 "/usr/share/haxe/std/sys/Http.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(typedException)) );
		}
		
		
	}
	
	
	public void readHttpResponse(haxe.io.Output api, sys.net.Socket sock)
	{
		//line 280 "/usr/share/haxe/std/sys/Http.hx"
		try 
		{
			//line 282 "/usr/share/haxe/std/sys/Http.hx"
			haxe.io.BytesBuffer b = new haxe.io.BytesBuffer();
			//line 283 "/usr/share/haxe/std/sys/Http.hx"
			int k = 4;
			//line 284 "/usr/share/haxe/std/sys/Http.hx"
			haxe.io.Bytes s = haxe.io.Bytes.alloc(4);
			//line 285 "/usr/share/haxe/std/sys/Http.hx"
			sock.setTimeout(this.cnxTimeout);
			//line 286 "/usr/share/haxe/std/sys/Http.hx"
			label1:
			while (true)
			{
				//line 287 "/usr/share/haxe/std/sys/Http.hx"
				int p = sock.input.readBytes(s, 0, k);
				//line 288 "/usr/share/haxe/std/sys/Http.hx"
				while (( p != k ))
				{
					//line 289 "/usr/share/haxe/std/sys/Http.hx"
					p += sock.input.readBytes(s, p, ( k - p ));
				}
				
				//line 290 "/usr/share/haxe/std/sys/Http.hx"
				{
					//line 290 "/usr/share/haxe/std/sys/Http.hx"
					if (( ( k < 0 ) || ( k > s.length ) )) 
					{
						//line 290 "/usr/share/haxe/std/sys/Http.hx"
						throw ((java.lang.RuntimeException) (haxe.Exception.thrown(haxe.io.Error.OutsideBounds)) );
					}
					
					//line 290 "/usr/share/haxe/std/sys/Http.hx"
					b.b.write(((byte[]) (s.b) ), ((int) (0) ), ((int) (k) ));
				}
				
				//line 291 "/usr/share/haxe/std/sys/Http.hx"
				switch (k)
				{
					case 1:
					{
						//line 293 "/usr/share/haxe/std/sys/Http.hx"
						int c = ( s.b[0] & 255 );
						//line 294 "/usr/share/haxe/std/sys/Http.hx"
						if (( c == 10 )) 
						{
							//line 295 "/usr/share/haxe/std/sys/Http.hx"
							break label1;
						}
						
						//line 296 "/usr/share/haxe/std/sys/Http.hx"
						if (( c == 13 )) 
						{
							//line 297 "/usr/share/haxe/std/sys/Http.hx"
							k = 3;
						}
						else
						{
							//line 299 "/usr/share/haxe/std/sys/Http.hx"
							k = 4;
						}
						
						//line 292 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 2:
					{
						//line 301 "/usr/share/haxe/std/sys/Http.hx"
						int c1 = ( s.b[1] & 255 );
						//line 302 "/usr/share/haxe/std/sys/Http.hx"
						if (( c1 == 10 )) 
						{
							//line 303 "/usr/share/haxe/std/sys/Http.hx"
							if (( (( s.b[0] & 255 )) == 13 )) 
							{
								//line 304 "/usr/share/haxe/std/sys/Http.hx"
								break label1;
							}
							
							//line 305 "/usr/share/haxe/std/sys/Http.hx"
							k = 4;
						}
						else
						{
							//line 306 "/usr/share/haxe/std/sys/Http.hx"
							if (( c1 == 13 )) 
							{
								//line 307 "/usr/share/haxe/std/sys/Http.hx"
								k = 3;
							}
							else
							{
								//line 309 "/usr/share/haxe/std/sys/Http.hx"
								k = 4;
							}
							
						}
						
						//line 300 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 3:
					{
						//line 311 "/usr/share/haxe/std/sys/Http.hx"
						int c2 = ( s.b[2] & 255 );
						//line 312 "/usr/share/haxe/std/sys/Http.hx"
						if (( c2 == 10 )) 
						{
							//line 313 "/usr/share/haxe/std/sys/Http.hx"
							if (( (( s.b[1] & 255 )) != 13 )) 
							{
								//line 314 "/usr/share/haxe/std/sys/Http.hx"
								k = 4;
							}
							else
							{
								//line 315 "/usr/share/haxe/std/sys/Http.hx"
								if (( (( s.b[0] & 255 )) != 10 )) 
								{
									//line 316 "/usr/share/haxe/std/sys/Http.hx"
									k = 2;
								}
								else
								{
									//line 318 "/usr/share/haxe/std/sys/Http.hx"
									break label1;
								}
								
							}
							
						}
						else
						{
							//line 319 "/usr/share/haxe/std/sys/Http.hx"
							if (( c2 == 13 )) 
							{
								//line 320 "/usr/share/haxe/std/sys/Http.hx"
								if (( ( (( s.b[1] & 255 )) != 10 ) || ( (( s.b[0] & 255 )) != 13 ) )) 
								{
									//line 321 "/usr/share/haxe/std/sys/Http.hx"
									k = 1;
								}
								else
								{
									//line 323 "/usr/share/haxe/std/sys/Http.hx"
									k = 3;
								}
								
							}
							else
							{
								//line 325 "/usr/share/haxe/std/sys/Http.hx"
								k = 4;
							}
							
						}
						
						//line 310 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 4:
					{
						//line 327 "/usr/share/haxe/std/sys/Http.hx"
						int c3 = ( s.b[3] & 255 );
						//line 328 "/usr/share/haxe/std/sys/Http.hx"
						if (( c3 == 10 )) 
						{
							//line 329 "/usr/share/haxe/std/sys/Http.hx"
							if (( (( s.b[2] & 255 )) != 13 )) 
							{
								//line 330 "/usr/share/haxe/std/sys/Http.hx"
								continue;
							}
							else
							{
								//line 331 "/usr/share/haxe/std/sys/Http.hx"
								if (( ( (( s.b[1] & 255 )) != 10 ) || ( (( s.b[0] & 255 )) != 13 ) )) 
								{
									//line 332 "/usr/share/haxe/std/sys/Http.hx"
									k = 2;
								}
								else
								{
									//line 334 "/usr/share/haxe/std/sys/Http.hx"
									break label1;
								}
								
							}
							
						}
						else
						{
							//line 335 "/usr/share/haxe/std/sys/Http.hx"
							if (( c3 == 13 )) 
							{
								//line 336 "/usr/share/haxe/std/sys/Http.hx"
								if (( ( (( s.b[2] & 255 )) != 10 ) || ( (( s.b[1] & 255 )) != 13 ) )) 
								{
									//line 337 "/usr/share/haxe/std/sys/Http.hx"
									k = 3;
								}
								else
								{
									//line 339 "/usr/share/haxe/std/sys/Http.hx"
									k = 1;
								}
								
							}
							
						}
						
						//line 326 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
				}
				
			}
			;
			//line 346 "/usr/share/haxe/std/sys/Http.hx"
			haxe.root.Array<java.lang.String> headers = haxe.lang.StringExt.split(b.getBytes().toString(), "\r\n");
			//line 348 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.String response = haxe.lang.Runtime.toString(headers.shift());
			//line 349 "/usr/share/haxe/std/sys/Http.hx"
			haxe.root.Array<java.lang.String> rp = haxe.lang.StringExt.split(response, " ");
			//line 350 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object status = haxe.root.Std.parseInt(rp.__get(1));
			//line 351 "/usr/share/haxe/std/sys/Http.hx"
			if (( haxe.lang.Runtime.eq(status, 0) || haxe.lang.Runtime.eq(status, null) )) 
			{
				//line 352 "/usr/share/haxe/std/sys/Http.hx"
				throw ((java.lang.RuntimeException) (haxe.Exception.thrown("Response status error")) );
			}
			
			//line 355 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.String __temp_expr1 = haxe.lang.Runtime.toString(headers.pop());
			//line 356 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.String __temp_expr2 = haxe.lang.Runtime.toString(headers.pop());
			//line 357 "/usr/share/haxe/std/sys/Http.hx"
			this.responseHeaders = ((haxe.ds.StringMap<java.lang.String>) (new haxe.ds.StringMap<java.lang.String>()) );
			//line 358 "/usr/share/haxe/std/sys/Http.hx"
			java.lang.Object size = null;
			//line 359 "/usr/share/haxe/std/sys/Http.hx"
			boolean chunked = false;
			//line 360 "/usr/share/haxe/std/sys/Http.hx"
			{
				//line 360 "/usr/share/haxe/std/sys/Http.hx"
				int _g = 0;
				//line 360 "/usr/share/haxe/std/sys/Http.hx"
				while (( _g < headers.length ))
				{
					//line 360 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.String hline = headers.__get(_g);
					//line 360 "/usr/share/haxe/std/sys/Http.hx"
					 ++ _g;
					//line 361 "/usr/share/haxe/std/sys/Http.hx"
					haxe.root.Array<java.lang.String> a = haxe.lang.StringExt.split(hline, ": ");
					//line 362 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.String hname = haxe.lang.Runtime.toString(a.shift());
					//line 363 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.String hval = ( (( a.length == 1 )) ? (a.__get(0)) : (a.join(": ")) );
					//line 364 "/usr/share/haxe/std/sys/Http.hx"
					hval = haxe.root.StringTools.ltrim(haxe.root.StringTools.rtrim(hval));
					//line 365 "/usr/share/haxe/std/sys/Http.hx"
					((haxe.ds.StringMap<java.lang.String>) (((haxe.IMap<java.lang.String, java.lang.String>) (this.responseHeaders) )) ).set(hname, hval);
					//line 366 "/usr/share/haxe/std/sys/Http.hx"
					{
						//line 366 "/usr/share/haxe/std/sys/Http.hx"
						java.lang.String __temp_svar3 = (hname.toLowerCase());
						//line 366 "/usr/share/haxe/std/sys/Http.hx"
						if (( __temp_svar3 != null )) 
						{
							//line 366 "/usr/share/haxe/std/sys/Http.hx"
							switch (__temp_svar3.hashCode())
							{
								case -1132779846:
								{
									//line 368 "/usr/share/haxe/std/sys/Http.hx"
									if (__temp_svar3.equals("content-length")) 
									{
										//line 368 "/usr/share/haxe/std/sys/Http.hx"
										size = haxe.root.Std.parseInt(hval);
									}
									
									//line 368 "/usr/share/haxe/std/sys/Http.hx"
									break;
								}
								
								
								case 1274458357:
								{
									//line 370 "/usr/share/haxe/std/sys/Http.hx"
									if (__temp_svar3.equals("transfer-encoding")) 
									{
										//line 370 "/usr/share/haxe/std/sys/Http.hx"
										chunked = haxe.lang.Runtime.valEq(hval.toLowerCase(), "chunked");
									}
									
									//line 370 "/usr/share/haxe/std/sys/Http.hx"
									break;
								}
								
								
							}
							
						}
						
					}
					
				}
				
			}
			
			//line 374 "/usr/share/haxe/std/sys/Http.hx"
			this.onStatus.__hx_invoke1_o(0.0, status);
			//line 376 "/usr/share/haxe/std/sys/Http.hx"
			haxe.root.EReg chunk_re = new haxe.root.EReg(haxe.lang.Runtime.toString("^([0-9A-Fa-f]+)[ ]*\r\n"), haxe.lang.Runtime.toString("m"));
			//line 377 "/usr/share/haxe/std/sys/Http.hx"
			this.chunk_size = null;
			//line 378 "/usr/share/haxe/std/sys/Http.hx"
			this.chunk_buf = null;
			//line 380 "/usr/share/haxe/std/sys/Http.hx"
			int bufsize = 1024;
			//line 381 "/usr/share/haxe/std/sys/Http.hx"
			haxe.io.Bytes buf = haxe.io.Bytes.alloc(bufsize);
			//line 382 "/usr/share/haxe/std/sys/Http.hx"
			if (chunked) 
			{
				//line 384 "/usr/share/haxe/std/sys/Http.hx"
				try 
				{
					//line 384 "/usr/share/haxe/std/sys/Http.hx"
					while (true)
					{
						//line 385 "/usr/share/haxe/std/sys/Http.hx"
						int len = sock.input.readBytes(buf, 0, bufsize);
						//line 386 "/usr/share/haxe/std/sys/Http.hx"
						if ( ! (this.readChunk(chunk_re, api, buf, len)) ) 
						{
							//line 387 "/usr/share/haxe/std/sys/Http.hx"
							break;
						}
						
					}
					
				}
				catch (java.lang.Throwable _g1)
				{
					//line 383 "/usr/share/haxe/std/sys/Http.hx"
					if (( ((java.lang.Object) (haxe.Exception.caught(_g1).unwrap()) ) instanceof haxe.io.Eof )) 
					{
						//line 390 "/usr/share/haxe/std/sys/Http.hx"
						throw ((java.lang.RuntimeException) (haxe.Exception.thrown("Transfer aborted")) );
					}
					else
					{
						//line 383 "/usr/share/haxe/std/sys/Http.hx"
						throw _g1;
					}
					
				}
				
				
			}
			else
			{
				//line 392 "/usr/share/haxe/std/sys/Http.hx"
				if (haxe.lang.Runtime.eq(size, null)) 
				{
					//line 393 "/usr/share/haxe/std/sys/Http.hx"
					if ( ! (this.noShutdown) ) 
					{
						//line 394 "/usr/share/haxe/std/sys/Http.hx"
						sock.shutdown(false, true);
					}
					
					//line 396 "/usr/share/haxe/std/sys/Http.hx"
					try 
					{
						//line 396 "/usr/share/haxe/std/sys/Http.hx"
						while (true)
						{
							//line 397 "/usr/share/haxe/std/sys/Http.hx"
							int len1 = sock.input.readBytes(buf, 0, bufsize);
							//line 398 "/usr/share/haxe/std/sys/Http.hx"
							if (( len1 == 0 )) 
							{
								//line 399 "/usr/share/haxe/std/sys/Http.hx"
								break;
							}
							
							//line 400 "/usr/share/haxe/std/sys/Http.hx"
							api.writeBytes(buf, 0, len1);
						}
						
					}
					catch (java.lang.Throwable _g2)
					{
						//line 395 "/usr/share/haxe/std/sys/Http.hx"
						if ( ! (( ((java.lang.Object) (haxe.Exception.caught(_g2).unwrap()) ) instanceof haxe.io.Eof )) ) 
						{
							//line 395 "/usr/share/haxe/std/sys/Http.hx"
							throw _g2;
						}
						
					}
					
					
				}
				else
				{
					//line 404 "/usr/share/haxe/std/sys/Http.hx"
					api.prepare(((int) (haxe.lang.Runtime.toInt(size)) ));
					//line 406 "/usr/share/haxe/std/sys/Http.hx"
					try 
					{
						//line 406 "/usr/share/haxe/std/sys/Http.hx"
						while (( ((int) (haxe.lang.Runtime.toInt(size)) ) > 0 ))
						{
							//line 407 "/usr/share/haxe/std/sys/Http.hx"
							int len2 = sock.input.readBytes(buf, 0, ( (( ((int) (haxe.lang.Runtime.toInt(size)) ) > bufsize )) ? (bufsize) : (((int) (haxe.lang.Runtime.toInt(size)) )) ));
							//line 408 "/usr/share/haxe/std/sys/Http.hx"
							api.writeBytes(buf, 0, len2);
							//line 409 "/usr/share/haxe/std/sys/Http.hx"
							size = ( ((int) (haxe.lang.Runtime.toInt(size)) ) - ((int) (len2) ) );
						}
						
					}
					catch (java.lang.Throwable _g3)
					{
						//line 405 "/usr/share/haxe/std/sys/Http.hx"
						if (( ((java.lang.Object) (haxe.Exception.caught(_g3).unwrap()) ) instanceof haxe.io.Eof )) 
						{
							//line 412 "/usr/share/haxe/std/sys/Http.hx"
							throw ((java.lang.RuntimeException) (haxe.Exception.thrown("Transfer aborted")) );
						}
						else
						{
							//line 405 "/usr/share/haxe/std/sys/Http.hx"
							throw _g3;
						}
						
					}
					
					
				}
				
			}
			
			//line 415 "/usr/share/haxe/std/sys/Http.hx"
			if (( chunked && (( ( ! (haxe.lang.Runtime.eq(this.chunk_size, null)) ) || ( this.chunk_buf != null ) )) )) 
			{
				//line 416 "/usr/share/haxe/std/sys/Http.hx"
				throw ((java.lang.RuntimeException) (haxe.Exception.thrown("Invalid chunk")) );
			}
			
			//line 417 "/usr/share/haxe/std/sys/Http.hx"
			if (( ( ((int) (haxe.lang.Runtime.toInt(status)) ) < 200 ) || ( ((int) (haxe.lang.Runtime.toInt(status)) ) >= 400 ) )) 
			{
				//line 418 "/usr/share/haxe/std/sys/Http.hx"
				throw ((java.lang.RuntimeException) (haxe.Exception.thrown(( haxe.lang.Runtime.toString("Http Error #") + haxe.lang.Runtime.toString(status) ))) );
			}
			
			//line 419 "/usr/share/haxe/std/sys/Http.hx"
			api.close();
		}
		catch (java.lang.Throwable typedException)
		{
			//line 280 "/usr/share/haxe/std/sys/Http.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(typedException)) );
		}
		
		
	}
	
	
	public boolean readChunk(haxe.root.EReg chunk_re, haxe.io.Output api, haxe.io.Bytes buf, int len)
	{
		//line 422 "/usr/share/haxe/std/sys/Http.hx"
		try 
		{
			//line 423 "/usr/share/haxe/std/sys/Http.hx"
			if (haxe.lang.Runtime.eq(this.chunk_size, null)) 
			{
				//line 424 "/usr/share/haxe/std/sys/Http.hx"
				if (( this.chunk_buf != null )) 
				{
					//line 425 "/usr/share/haxe/std/sys/Http.hx"
					haxe.io.BytesBuffer b = new haxe.io.BytesBuffer();
					//line 426 "/usr/share/haxe/std/sys/Http.hx"
					{
						//line 426 "/usr/share/haxe/std/sys/Http.hx"
						haxe.io.Bytes src = this.chunk_buf;
						//line 426 "/usr/share/haxe/std/sys/Http.hx"
						b.b.write(((byte[]) (src.b) ), ((int) (0) ), ((int) (src.length) ));
					}
					
					//line 427 "/usr/share/haxe/std/sys/Http.hx"
					{
						//line 427 "/usr/share/haxe/std/sys/Http.hx"
						if (( ( len < 0 ) || ( len > buf.length ) )) 
						{
							//line 427 "/usr/share/haxe/std/sys/Http.hx"
							throw ((java.lang.RuntimeException) (haxe.Exception.thrown(haxe.io.Error.OutsideBounds)) );
						}
						
						//line 427 "/usr/share/haxe/std/sys/Http.hx"
						b.b.write(((byte[]) (buf.b) ), ((int) (0) ), ((int) (len) ));
					}
					
					//line 428 "/usr/share/haxe/std/sys/Http.hx"
					buf = b.getBytes();
					//line 429 "/usr/share/haxe/std/sys/Http.hx"
					len += this.chunk_buf.length;
					//line 430 "/usr/share/haxe/std/sys/Http.hx"
					this.chunk_buf = null;
				}
				
				//line 435 "/usr/share/haxe/std/sys/Http.hx"
				if (chunk_re.match(buf.toString())) 
				{
					//line 437 "/usr/share/haxe/std/sys/Http.hx"
					java.lang.Object p = chunk_re.matchedPos();
					//line 438 "/usr/share/haxe/std/sys/Http.hx"
					if (( ((int) (haxe.lang.Runtime.getField_f(p, "len", true)) ) <= len )) 
					{
						//line 439 "/usr/share/haxe/std/sys/Http.hx"
						java.lang.String cstr = chunk_re.matched(1);
						//line 440 "/usr/share/haxe/std/sys/Http.hx"
						this.chunk_size = haxe.root.Std.parseInt(( "0x" + cstr ));
						//line 441 "/usr/share/haxe/std/sys/Http.hx"
						if (haxe.lang.Runtime.eq(this.chunk_size, 0)) 
						{
							//line 442 "/usr/share/haxe/std/sys/Http.hx"
							this.chunk_size = null;
							//line 443 "/usr/share/haxe/std/sys/Http.hx"
							this.chunk_buf = null;
							//line 444 "/usr/share/haxe/std/sys/Http.hx"
							return false;
						}
						
						//line 446 "/usr/share/haxe/std/sys/Http.hx"
						len = ( ((int) (len) ) - ((int) (haxe.lang.Runtime.getField_f(p, "len", true)) ) );
						//line 447 "/usr/share/haxe/std/sys/Http.hx"
						return this.readChunk(chunk_re, api, buf.sub(((int) (haxe.lang.Runtime.getField_f(p, "len", true)) ), len), len);
					}
					
				}
				
				//line 451 "/usr/share/haxe/std/sys/Http.hx"
				if (( len > 10 )) 
				{
					//line 452 "/usr/share/haxe/std/sys/Http.hx"
					this.onError.__hx_invoke1_o(0.0, "Invalid chunk");
					//line 453 "/usr/share/haxe/std/sys/Http.hx"
					return false;
				}
				
				//line 455 "/usr/share/haxe/std/sys/Http.hx"
				this.chunk_buf = buf.sub(0, len);
				//line 456 "/usr/share/haxe/std/sys/Http.hx"
				return true;
			}
			
			//line 459 "/usr/share/haxe/std/sys/Http.hx"
			if (( ((int) (haxe.lang.Runtime.toInt(this.chunk_size)) ) > len )) 
			{
				//line 460 "/usr/share/haxe/std/sys/Http.hx"
				{
					//line 460 "/usr/share/haxe/std/sys/Http.hx"
					sys.Http __temp_dynop1 = this;
					//line 460 "/usr/share/haxe/std/sys/Http.hx"
					__temp_dynop1.chunk_size = ( ((int) (haxe.lang.Runtime.toInt(__temp_dynop1.chunk_size)) ) - ((int) (len) ) );
				}
				
				//line 461 "/usr/share/haxe/std/sys/Http.hx"
				api.writeBytes(buf, 0, len);
				//line 462 "/usr/share/haxe/std/sys/Http.hx"
				return true;
			}
			
			//line 464 "/usr/share/haxe/std/sys/Http.hx"
			int end = ((int) (haxe.lang.Runtime.toInt(haxe.lang.Runtime.plus(this.chunk_size, 2))) );
			//line 465 "/usr/share/haxe/std/sys/Http.hx"
			if (( len >= end )) 
			{
				//line 466 "/usr/share/haxe/std/sys/Http.hx"
				if (( ((int) (haxe.lang.Runtime.toInt(this.chunk_size)) ) > 0 )) 
				{
					//line 467 "/usr/share/haxe/std/sys/Http.hx"
					api.writeBytes(buf, 0, ((int) (haxe.lang.Runtime.toInt(this.chunk_size)) ));
				}
				
				//line 468 "/usr/share/haxe/std/sys/Http.hx"
				len -= end;
				//line 469 "/usr/share/haxe/std/sys/Http.hx"
				this.chunk_size = null;
				//line 470 "/usr/share/haxe/std/sys/Http.hx"
				if (( len == 0 )) 
				{
					//line 471 "/usr/share/haxe/std/sys/Http.hx"
					return true;
				}
				
				//line 472 "/usr/share/haxe/std/sys/Http.hx"
				return this.readChunk(chunk_re, api, buf.sub(end, len), len);
			}
			
			//line 474 "/usr/share/haxe/std/sys/Http.hx"
			if (( ((int) (haxe.lang.Runtime.toInt(this.chunk_size)) ) > 0 )) 
			{
				//line 475 "/usr/share/haxe/std/sys/Http.hx"
				api.writeBytes(buf, 0, ((int) (haxe.lang.Runtime.toInt(this.chunk_size)) ));
			}
			
			//line 476 "/usr/share/haxe/std/sys/Http.hx"
			{
				//line 476 "/usr/share/haxe/std/sys/Http.hx"
				sys.Http __temp_dynop2 = this;
				//line 476 "/usr/share/haxe/std/sys/Http.hx"
				__temp_dynop2.chunk_size = ( ((int) (haxe.lang.Runtime.toInt(__temp_dynop2.chunk_size)) ) - ((int) (len) ) );
			}
			
			//line 477 "/usr/share/haxe/std/sys/Http.hx"
			return true;
		}
		catch (java.lang.Throwable typedException)
		{
			//line 422 "/usr/share/haxe/std/sys/Http.hx"
			throw ((java.lang.RuntimeException) (haxe.Exception.thrown(typedException)) );
		}
		
		
	}
	
	
	@Override public double __hx_setField_f(java.lang.String field, double value, boolean handleProperties)
	{
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		{
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			boolean __temp_executeDef1 = true;
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (( field != null )) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				switch (field.hashCode())
				{
					case 3143036:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("file")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.file = ((java.lang.Object) (value) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -196911308:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("cnxTimeout")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.cnxTimeout = ((double) (value) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -1525550445:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("chunk_size")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.chunk_size = ((java.lang.Object) (value) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (__temp_executeDef1) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				return super.__hx_setField_f(field, value, handleProperties);
			}
			else
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_setField(java.lang.String field, java.lang.Object value, boolean handleProperties)
	{
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		{
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			boolean __temp_executeDef1 = true;
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (( field != null )) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				switch (field.hashCode())
				{
					case 3143036:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("file")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.file = ((java.lang.Object) (value) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 989669175:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("noShutdown")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.noShutdown = haxe.lang.Runtime.toBool(((java.lang.Boolean) (value) ));
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 2028982689:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("chunk_buf")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.chunk_buf = ((haxe.io.Bytes) (value) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -196911308:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("cnxTimeout")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.cnxTimeout = ((double) (haxe.lang.Runtime.toDouble(value)) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -1525550445:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("chunk_size")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.chunk_size = ((java.lang.Object) (value) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 1387714565:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("responseHeaders")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.responseHeaders = ((haxe.ds.StringMap<java.lang.String>) (value) );
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return value;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (__temp_executeDef1) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				return super.__hx_setField(field, value, handleProperties);
			}
			else
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_getField(java.lang.String field, boolean throwErrors, boolean isCheck, boolean handleProperties)
	{
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		{
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			boolean __temp_executeDef1 = true;
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (( field != null )) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				switch (field.hashCode())
				{
					case -1139644809:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("readChunk")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "readChunk")) );
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 989669175:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("noShutdown")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.noShutdown;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -954305121:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("readHttpResponse")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "readHttpResponse")) );
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -196911308:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("cnxTimeout")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.cnxTimeout;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -1406861791:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("writeBody")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "writeBody")) );
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 1387714565:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("responseHeaders")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.responseHeaders;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 2113105374:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("customRequest")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "customRequest")) );
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -1525550445:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("chunk_size")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.chunk_size;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 1095692943:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("request")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return ((haxe.lang.Function) (new haxe.lang.Closure(this, "request")) );
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 2028982689:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("chunk_buf")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.chunk_buf;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 3143036:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("file")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.file;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (__temp_executeDef1) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				return super.__hx_getField(field, throwErrors, isCheck, handleProperties);
			}
			else
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public double __hx_getField_f(java.lang.String field, boolean throwErrors, boolean handleProperties)
	{
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		{
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			boolean __temp_executeDef1 = true;
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (( field != null )) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				switch (field.hashCode())
				{
					case 3143036:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("file")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return ((double) (haxe.lang.Runtime.toDouble(this.file)) );
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -196911308:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("cnxTimeout")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.cnxTimeout;
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -1525550445:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("chunk_size")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return ((double) (haxe.lang.Runtime.toDouble(this.chunk_size)) );
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (__temp_executeDef1) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				return super.__hx_getField_f(field, throwErrors, handleProperties);
			}
			else
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				throw null;
			}
			
		}
		
	}
	
	
	@Override public java.lang.Object __hx_invokeField(java.lang.String field, java.lang.Object[] dynargs)
	{
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		{
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			boolean __temp_executeDef1 = true;
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (( field != null )) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				switch (field.hashCode())
				{
					case -1139644809:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("readChunk")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							return this.readChunk(((haxe.root.EReg) (dynargs[0]) ), ((haxe.io.Output) (dynargs[1]) ), ((haxe.io.Bytes) (dynargs[2]) ), ((int) (haxe.lang.Runtime.toInt(dynargs[3])) ));
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 1095692943:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("request")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.request(( (( dynargs.length > 0 )) ? (dynargs[0]) : (null) ));
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -954305121:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("readHttpResponse")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.readHttpResponse(((haxe.io.Output) (dynargs[0]) ), ((sys.net.Socket) (dynargs[1]) ));
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case 2113105374:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("customRequest")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.customRequest(haxe.lang.Runtime.toBool(((java.lang.Boolean) (dynargs[0]) )), ((haxe.io.Output) (dynargs[1]) ), ((sys.net.Socket) (( (( dynargs.length > 2 )) ? (dynargs[2]) : (null) )) ), haxe.lang.Runtime.toString(( (( dynargs.length > 3 )) ? (dynargs[3]) : (null) )));
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
					case -1406861791:
					{
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						if (field.equals("writeBody")) 
						{
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							__temp_executeDef1 = false;
							//line 31 "/usr/share/haxe/std/sys/Http.hx"
							this.writeBody(((haxe.io.BytesOutput) (dynargs[0]) ), ((haxe.io.Input) (dynargs[1]) ), ((int) (haxe.lang.Runtime.toInt(dynargs[2])) ), haxe.lang.Runtime.toString(dynargs[3]), ((sys.net.Socket) (dynargs[4]) ));
						}
						
						//line 31 "/usr/share/haxe/std/sys/Http.hx"
						break;
					}
					
					
				}
				
			}
			
			//line 31 "/usr/share/haxe/std/sys/Http.hx"
			if (__temp_executeDef1) 
			{
				//line 31 "/usr/share/haxe/std/sys/Http.hx"
				return super.__hx_invokeField(field, dynargs);
			}
			
		}
		
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		return null;
	}
	
	
	@Override public void __hx_getFields(haxe.root.Array<java.lang.String> baseArr)
	{
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		baseArr.push("file");
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		baseArr.push("chunk_buf");
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		baseArr.push("chunk_size");
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		baseArr.push("responseHeaders");
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		baseArr.push("cnxTimeout");
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		baseArr.push("noShutdown");
		//line 31 "/usr/share/haxe/std/sys/Http.hx"
		super.__hx_getFields(baseArr);
	}
	
	
}


