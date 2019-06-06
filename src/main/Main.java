/**
 * 
 */
package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONException;

/**
 * @author anitanaseri
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, JSONException {
		// Authentication class to make REST API call with basic authorization.
		APICall APIAuthorisation = new APICall();

		//scanner to read users input
		Scanner scanner = new Scanner(System.in);
		
		TicketPresentation ticketPresentation = new TicketPresentation();
		
		//loading credentials from properties file, first create object of Properties class
		Properties prop=new Properties(); 
		
		// Creating object of FileInputStream and give property file
		FileInputStream ip= new FileInputStream("src/config.properties");
		// load the property file
		prop.load(ip);

		//setting auth credentials to access API
		APIAuthorisation.setSubdomain(prop.getProperty("auth_credential_subdomain"));
		APIAuthorisation.setUsername(prop.getProperty("auth_credential_username"));
		APIAuthorisation.setPassword(prop.getProperty("auth_credential_password"));

		//get users details to make API call
		System.out.println("Welcome to Zendesk Ticket Viewer Application");
		
		//if login in fails print an error
		if (!APIAuthorisation.login()) {
			System.out.println("Loging failed, Please re-run the application");

		} else {
			showOptions();
			
			//read users input
			switch (scanner.nextInt()) {
			case 1:
				// Display all the tickets in HashMap, and pass Scanner so we can ask user if it wants
				//more pages of tickets since each page only has 25 tickets in it 
				ticketPresentation.showAllAvailableTickets(APIAuthorisation.getTicketReader().getHashmapOfTickets(), scanner);
				break;
				
			case 2:
				System.out.print("\n Please Enter The ID for the Ticket :  ");
				Long id = scanner.nextLong();
				
				// Search the Ticket for the ID in HashMap and a summary of ticket is shown
				ticketPresentation.displayTicketById(APIAuthorisation.getTicketReader().getHashmapOfTickets(), id);
				
				//user can request to see more fields of the ticket
				System.out.print("Do you wish to read the ticket's description. \n");
				
				String requestedField = scanner.next();
				
				ticketPresentation.showDescription(APIAuthorisation.getTicketReader().getHashmapOfTickets(), id, requestedField);
				
				break;
				
			case 3:
				// Exit the app.
				scanner.close();
				System.exit(0); 

			default:
				// message for wrong input.
				System.out.println("Invalid Input");
				break;
			}
			
		}
	}
	
	public static void showOptions() {
		System.out.println("\nPlease choose on of the options and Enter number below:");
		System.out.println("\n\t 1. View summary of All available Tickets");
		System.out.println("\t 2. Find a ticket by ID and view any of the ticket's fields");
		System.out.println("\t 3. exit");
		System.out.println("\nEnter number:");
		
	}

}
