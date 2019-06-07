/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Test;

import logic.APICall;

/**
 * @author anitanaseri
 *
 */
public class APICallTest {
	@Test
	public void loginWithWrongCredentialsTest() throws IOException, JSONException {
		APICall authentication = new APICall();
		
		authentication.setSubdomain("subdomain");
		authentication.setUsername("email@gmail.com");
		authentication.setPassword("password");
		
		assertEquals(false, authentication.login());
	}
	
	@Test
	public void APINotAvailableTest() throws IOException, JSONException {
		APICall authentication = new APICall();
		
		
		assertEquals(false, authentication.login());
	}
	
	

}
