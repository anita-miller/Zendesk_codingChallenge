/**
 * 
 */
package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;

/**
 * @author anitanaseri
 *
 */
public class APICall {

	private String subdomain;
	private String username;
	private String password;
	
	/**
	 * @return the subdomain
	 */
	public String getSubdomain() {
		return subdomain;
	}
	/**
	 * @param subdomain the subdomain to set
	 */
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * Loging to Zendesk account with username and password and subdomain name created
	 * and get tickets in JSON Array using GET API and pass it to TicketReader class
	 * 
	 * @param
	 * @author anitanaseri
	 * @throws IOException 
	 * @date 2019-06-04
	 */
	public boolean login() throws IOException{
		

		URL url = new URL("https://" + subdomain + ".zendesk.com/api/v2/tickets.json");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		//To send a GET request, we’ll have to set the request method property to GET
		connection.setRequestMethod("GET");
		
		//setting up the header that we only accept JSON
		connection.setRequestProperty("Accept", "application/json");
		
		return false;
	
	}
}
