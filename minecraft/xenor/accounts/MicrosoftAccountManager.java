package xenor.accounts;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class MicrosoftAccountManager {
	
	public void MicrosoftAccountManage() throws UnsupportedEncodingException, IOException {
		URL microsoftapiwebsite = new URL("https://login.live.com/oauth20_token.srf");
		
		Map<String, Object> parameters = new HashMap<>();
		
		StringBuilder postData = new StringBuilder();
		for(Map.Entry<String, Object> param : parameters.entrySet()) {
			if(postData.length() != 0) postData.append('&');
			//postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
			postData.append('=');
		}
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		
		HttpURLConnection con = (HttpURLConnection)microsoftapiwebsite.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type: application/x-www-form-urlencoded", "client_id=7ab08011-025f-4d5b-9242-b584930c088a&client_secret=bfa4281e-476c-419d-a883-4fc23dc561f5&code=CODE_FROM_PREVIOUS_STEP&grant_type=authorization_code&redirect_uri=https://login.microsoftonline.com/common/oauth2/nativeclient");
		con.setDoOutput(true);
		con.getOutputStream().write(postDataBytes);
		
		Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		
		StringBuilder sb = new StringBuilder();
		for(int c; (c = in.read()) >= 0;)
			sb.append((char)c);
		String response = sb.toString();
		
		System.out.println(response);
		
		JSONObject myResponse = new JSONObject(response.toString());
	}
		
	
}
