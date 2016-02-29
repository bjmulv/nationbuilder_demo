package ca.mphost.importer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.text.MessageFormat;
import java.util.Arrays;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;


/**
 * A sample application that demonstrates how the Google OAuth2 library can be used to authenticate
 * against Daily Motion.
 *
 * @author Ravi Mistry
 */
public class OAuthExample {

  public static void main(String[] args) throws IOException {
	//   https://server.example.com/token server url example
//	  try {
//	    TokenResponse response =
//	        new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
//	            new GenericUrl("https://bmulvihillsandbox.nationbuilder.com/oauth/authorize"), "here write your code")
//	            .setRedirectUri("https://bmulvihillsandbox.nationbuilder.com/oauth_tool/callback")
//	            .set("client_id","00a49e6b576d1cfcca31f6b8f4215355a6dce314f5f43b810acbbc6f0331f810")
//	            .set("client_secret","b14324f7d0c51aa9837784b44c5f17d71e9600fe2f0bacdbfb3d5637d4984bd8")
//	            .execute();
//	    System.out.println("Access token: " + response.getAccessToken());
//	  } catch (Exception e) {
//	    e.printStackTrace();
//	  }
	  
	  String URLMessage = "https://{0}.nationbuilder.com/oauth/authorize?response_type=code&client_id={1}&redirect_uri={2}";
	  String slug = "bmulvihillsandbox";
	  String redirectUrl = "https://bmulvihillsandbox.nationbuilder.com/oauth_tool/callback";
	  String clientId = "00a49e6b576d1cfcca31f6b8f4215355a6dce314f5f43b810acbbc6f0331f810";
	  String clientSecret = "b14324f7d0c51aa9837784b44c5f17d71e9600fe2f0bacdbfb3d5637d4984bd8";
	  
	  String urlStr = MessageFormat.format(URLMessage, slug, clientId, redirectUrl );
	  URL url = new URL( urlStr );
	  HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
	  conn.connect();
	  
	  int length = conn.getContentLength();
	  int total = 0;
	  InputStream in = conn.getInputStream();
	  byte[] data = new byte[length];
	  while( total < length ) {
		  int numRead = in.read(data, total, length - total);
		  total += numRead;
	  }
	  System.out.println( new String( data, 0, total ));
  }
}
