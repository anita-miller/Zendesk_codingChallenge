/**
 * 
 */
package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import org.json.JSONException;
import sun.misc.BASE64Encoder;

/**
 * @author anitanaseri
 *
 */
public class APICall {

	private String subdomain;
	private String username;
	private String password;
	private TicketReader ticketReader = new TicketReader();
	
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
	 * @throws JSONException 
	 * @date 2019-06-04
	 */
	public boolean login() throws IOException, JSONException{
		

		URL url = new URL("https://" + subdomain + ".zendesk.com/api/v2/tickets.json");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		//To send a GET request, we’ll have to set the request method property to GET
		connection.setRequestMethod("GET");
		
		//setting up the header that we only accept JSON
		connection.setRequestProperty("Accept", "application/json");
		
		
		//Basic authentication relies on a Base64 encoded 'Authorization' header whose value consists of 
		//the word 'Basic' followed by a space followed by the Base64 encoded name:password.
		String logingDetails = "" + username + ":" + password + "";
		String logingDetailsEncoded = new BASE64Encoder().encode(logingDetails.getBytes());
		connection.setRequestProperty("Authorization", "Basic " + logingDetailsEncoded);
		
		
		//if HTTP response message was anything except OK
		if (connection.getResponseCode() != 200) {
			//print an error and show what was the repsonse code
			System.out.println("Cannot connect to the subdomain, Status code is : " + connection.getResponseCode());
			return false;
			
		} else {

			// Sending the received InputStream to Ticket reader to create Tickets
			ticketReader.ticketDataReader(connection.getInputStream());

		}

		return true;
	
	}
}
