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
		PrintClass printer = new PrintClass();
		 		
		// Creating object of FileInputStream and give property file
		FileInputStream ip= new FileInputStream("src/config.properties");
		// load the property file
		prop.load(ip);
		
		//setting auth credentials to access API
		APIAuthorisation.setSubdomain(prop.getProperty("auth_credential_subdomain"));
		APIAuthorisation.setUsername(prop.getProperty("auth_credential_username"));
		APIAuthorisation.setPassword(prop.getProperty("auth_credential_password"));
		

		
		// Authentication class to make REST API call with basic authorization.
		APICall APIAuthorisation = new APICall();

		//scanner to read users input
		Scanner scanner = new Scanner(System.in);
		
		TicketPresentation ticketPresentation = new TicketPresentation();
		
		PrintClass printer = new PrintClass();
		
		printer.welcomeMessage();
		
		//if login in fails print an error
		if (!APIAuthorisation.login()) {
			printer.logingFailed();

		} else {
			printer.showOptions();
			
			//read users input
			switch (scanner.nextInt()) {
			case 1:
				// Display all the tickets in HashMap, and pass Scanner so we can ask user if it wants
				//more pages of tickets since each page only has 25 tickets in it 
				ticketPresentation.showAllAvailableTickets(APIAuthorisation.getTicketReader().getHashmapOfTickets(), scanner);
				break;
				
			case 2:
				printer.enterTicketID();
				Long id = scanner.nextLong();
				
				// Search the Ticket for the ID in HashMap and a summary of ticket is shown
				ticketPresentation.displayTicketById(APIAuthorisation.getTicketReader().getHashmapOfTickets(), id);
				
				//user can request to see more fields of the ticket
				printer.wantToReadDesciption();
				
				//if user wants to read more ticketes
				String input = scanner.next().toLowerCase();
				if(input.equals("yes")) {
					ticketPresentation.showDescription(APIAuthorisation.getTicketReader().getHashmapOfTickets(), id);
					
				}else if(input.equals("no")) {
					//if user doesn't want to view more tickets exit
					printer.thanksAndExitApp();
					System.exit(0); 
				}
				
				
				break;
				
			case 3:
				// Exit the app.
				printer.thanksAndExitApp();
				System.exit(0); 

			default:
				// message for wrong input.
				printer.invalidInput();
				break;
			}
			
		}
	}

}
