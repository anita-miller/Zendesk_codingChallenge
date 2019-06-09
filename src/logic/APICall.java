/**
 * 
 */
package logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;
import org.json.JSONException;

/**
 * @author anitanaseri
 *
 */
public class APICall {

	private String subdomain;
	private String username;
	private String password;
	private TicketReader ticketReader = new TicketReader();
	HttpURLConnection connection;
	private final int OK_RESPONSE_CODE = 200;
	private int responseCode;
	
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
		
		//loading credentials from properties file, and decrypt them 
		receiveAndDecryptCeredentials();
		
		URL url = new URL("https://" + subdomain + ".zendesk.com/api/v2/tickets.json");
		connection = settingUpConnection(url);
		responseCode = runningbasicAuth(connection);
				
		//if HTTP response message was anything except OK
		if (responseCode != OK_RESPONSE_CODE) {
			//print an error and show what was the repsonse code
			System.out.println("Sorry, Currently we cannot connect to the subdomain, Status code is : " + connection.getResponseCode());
			return false;
			
		} else {

			// Sending the received InputStream to Ticket reader to create Tickets
			ticketReader.ticketDataReader(connection.getInputStream());
			return true;
		}
	
	}
	
	/**
	 *  connect to API with basic auth and returns the response code 
	 * 
	 * @param
	 * @author anitanaseri
	 * @throws IOException 
	 * @date 2019-06-07
	 */
	public HttpURLConnection settingUpConnection(URL url) throws IOException {

		connection = (HttpURLConnection) url.openConnection();
		
		//To send a GET request, we’ll have to set the request method property to GET
		connection.setRequestMethod("GET");
		
		//setting up the header that we only accept JSON
		connection.setRequestProperty("Accept", "application/json");
		
		return connection;
	}
	/**
	 * run basic auth and returns the response code
	 * 
	 * @param
	 * @author anitanaseri
	 * @throws IOException 
	 * @date 2019-06-07
	 */
	public int runningbasicAuth(HttpURLConnection connection) throws IOException {

		//Basic authentication relies on a Base64 encoded 'Authorization' header whose value consists of 
		//the word 'Basic' followed by a space followed by the Base64 encoded name:password.
        String logingDetails = "" + username + ":" + password + "";
        

		String logingDetailsEncoded = new String(Base64.getEncoder().encodeToString(logingDetails.getBytes()));
		connection.setRequestProperty("Authorization", "Basic " + logingDetailsEncoded);
		
		return connection.getResponseCode();
	}
	
	/**
	 * loading credentials from properties file, and decrypt them 
	 * 
	 * @param
	 * @author anitanaseri
	 * @throws IOException 
	 * @date 2019-06-05
	 */
	public void receiveAndDecryptCeredentials() throws IOException {
		Properties prop=new Properties(); 
		
		// Creating object of FileInputStream and give property file
		FileInputStream ip= new FileInputStream("src/config.properties");
		// load the property file
		prop.load(ip);

		//passing encrypted auth credentials to APIAuthorisation to decrypt and use
		this.setSubdomain(prop.getProperty("auth_credential_subdomain"));
		this.setUsername(prop.getProperty("auth_credential_username"));
		this.setPassword(prop.getProperty("auth_credential_password"));
		

		//using Decryption class to decrypt, encrypted credentials
		DecryptionClass enc = new DecryptionClass();
		try {
			password = enc.decrypt(password.toString());
			subdomain = enc.decrypt(subdomain.toString());
			username = enc.decrypt(username.toString());

		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	

	/**
	 * @param subdomain the subdomain to set
	 */
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	
	/**
	 * @return the subdomain
	 */
	public String getSubdomain() {
		return subdomain;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * @return the ticketReader
	 */
	public TicketReader getTicketReader() {
		return ticketReader;
	}

	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

}
