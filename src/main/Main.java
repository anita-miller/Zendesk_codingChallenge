/**
 * 
 */
package main;

import java.io.IOException;
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

		Scanner scanner = new Scanner(System.in);
		
		TicketPresentation ticketPresentation = new TicketPresentation();
		
		//get users details to make API call
		System.out.println("\t Welcome to Zendesk Ticket Viewer Application");
		System.out.print("\n Please Enter your Subdomain : ");
				
				
		APIAuthorisation.setSubdomain(scanner.nextLine());

		System.out.print("\n Please Enter your email address : ");
				
		APIAuthorisation.setUsername(scanner.nextLine());

		System.out.print("\n Please Enter your password : ");
		
		APIAuthorisation.setPassword(scanner.nextLine());

		
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

				// Search the Ticket for the ID in HashMap
				ticketPresentation.displayTicketById(APIAuthorisation.getTicketReader().getHashmapOfTickets(), id);
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
		System.out.println("\n\t Please choose on of the options and Enter its number:");
		System.out.println("\t 1. View All available Tickets");
		System.out.println("\t 2. Find a ticket by ID");
		System.out.println("\t 3. exit");
	}

}
