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
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
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
