/**
 * 
 */
package main;

import java.util.Scanner;

/**
 * @author anitanaseri
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Authentication class to make REST API call with basic authorization.
		APICall APIAuthorisation = new APICall();

		Scanner scanner = new Scanner(System.in);
		

		System.out.println("\t Welcome to Zendesk Ticket Viewer Application");
		System.out.print("\n Please Enter your Subdomain : ");
				
				
		APIAuthorisation.setSubdomain(scanner.nextLine());

		System.out.print("\n Please Enter your email address : ");
				
		APIAuthorisation.setUsername(scanner.nextLine());

		System.out.print("\n Please Enter your password : ");
		
		APIAuthorisation.setPassword(scanner.nextLine());

				

	}

}
