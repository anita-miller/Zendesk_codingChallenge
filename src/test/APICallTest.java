/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.junit.Test;

import logic.APICall;

/**
 * @author anitanaseri
 *
 */
public class APICallTest {
	APICall authentication = new APICall();
	
	
	@Test
	public void runningbasicAuthWithWrongCredentialsTest() throws IOException, JSONException {
		APICall authentication = new APICall();

		//setting up test environment by creating connection 
		URL url = new URL("https://" + authentication.getSubdomain() + ".zendesk.com/api/v2/tickets.json");
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("GET");
		
		connection.setRequestProperty("Accept", "application/json");
		
		authentication.setSubdomain("subdomain");
		authentication.setUsername("email@gmail.com");
		authentication.setPassword("password");
		
		
		
		//getting 401 Unauthorized error when logging in with wrong credentials 
		assertEquals(401, authentication.runningbasicAuth(connection));
	}
	
	@Test
	public void settingUpConnectionAPINotAvailableTest() throws IOException, JSONException {

		//setting an url that we know isnt available
		APICall authentication = new APICall();
		
		URL url = new URL("https://api.github.com/users/wefbrwwgre");
		
		assertEquals(404, authentication.settingUpConnection(url).getResponseCode());
	}
	
	

}
