package presentation;
/**
 * @author anitanaseri
 *
 */
public class PrintClass {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	
	public void welcomeMessage() {
		System.out.println(ANSI_BLUE + "\nWelcome to Zendesk Ticket Viewer Application" + ANSI_RESET);
	}
	
	public void showOptions() {
		System.out.println("\nPlease choose one of the options below and click enter:");
		System.out.println(ANSI_RED + "\n\t 1. " + ANSI_RESET +" View summary of all available tickets");
		System.out.println(ANSI_RED + "\n\t 2. " + ANSI_RESET +" Find a ticket by ID and view its description");
		System.out.println(ANSI_RED + "\n\t 3. " + ANSI_RESET +" Exit");
		System.out.println("\nEnter number:");
		
	}
	
	public void logingFailed() {
		System.out.println("It failed to log in, Please re-run the application");
	}
	
	public void enterTicketID() {
		System.out.print("\n Please Enter The ID for the Ticket :  ");
	}
	
	public void wantToReadDesciption(){
		System.out.println("\n\nPlease choose on of the options and enter number below:");
		System.out.println(ANSI_RED + "\n\t 1. " + ANSI_RESET +" Read the ticket's description");
		System.out.println(ANSI_RED + "\n\t 2. " + ANSI_RESET +" Go back to the menu");
		System.out.println(ANSI_RED + "\n\t 3. " + ANSI_RESET +" exit");
		System.out.println("\nEnter number:");
		
	}
	
	public void displayAnotherTicketById() {
		System.out.println("\nDo you want to find another ticket by ID and view its descriptio:");
		System.out.println(ANSI_RED + "\n\t 1. " + ANSI_RESET +" Yes");
		System.out.println(ANSI_RED + "\n\t 2. " + ANSI_RESET +" No, I wish to exit");
		System.out.println("\nEnter number:");
	}
	
	public void thanksAndExitApp() {
		System.out.println("\nThank you for viewing! \nExiting the application. ");
	}
	public void endOfListThankAndExitApp() {
		System.out.println("\n\nReached the end of the Tickets' List,\nThank You for Viewing! \nExiting the Application. ");
	}
	
	public void seperatingLine() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
	}
	public void ticketHeader(){
		System.out.format(ANSI_PURPLE + "\n\n\n%-4s | %-45s | %-10s | %-10s | %-20s| %-10s | %-12s | %-30s\n", "ID", "SUBJECT","Status", "Priority", "Created At","Requester ID", "Assignee ID","Tags" + ANSI_RESET);
		seperatingLine();
	}
	public void wantToViewNextPageOfTicket() {

		System.out.println("\n\nPlease choose on of the options and enter number below:");
		System.out.println(ANSI_RED + "\n\t 1. " + ANSI_RESET +"View next page of tickets");
		System.out.println(ANSI_RED + "\n\t 2. " + ANSI_RESET +"Find a ticket by ID and view its description");
		System.out.println(ANSI_RED + "\n\t 3. " + ANSI_RESET +"Go back to the menu");
		System.out.println(ANSI_RED + "\n\t 4. " + ANSI_RESET +"Exit");
		System.out.println("\nEnter number:");
	}
	
	public void wantToViewNextOrPrevPageOfTicket() {
		System.out.println("\n\nPlease choose on of the options and enter number below:");
		System.out.println(ANSI_RED + "\n\t 1. " + ANSI_RESET +"View next page of tickets");
		System.out.println(ANSI_RED + "\n\t 2. " + ANSI_RESET +"View the previous page of tickets");
		System.out.println(ANSI_RED + "\n\t 3. " + ANSI_RESET +"Find a ticket by ID and view its description");
		System.out.println(ANSI_RED + "\n\t 4. " + ANSI_RESET +"Go back to the menu");
		System.out.println(ANSI_RED + "\n\t 5. " + ANSI_RESET +"Exit");
		System.out.println("\nEnter number:");
	}
	public void wantToViewPrevPageOfTicket() {

		System.out.println("\n\nPlease choose on of the options and enter number below:");
		System.out.println(ANSI_RED + "\n\t 1. " + ANSI_RESET +"View previous page of tickets");
		System.out.println(ANSI_RED + "\n\t 2. " + ANSI_RESET +"Find a ticket by ID and view its description");
		System.out.println(ANSI_RED + "\n\t 3. " + ANSI_RESET +"Go back to the menu");
		System.out.println(ANSI_RED + "\n\t 4. " + ANSI_RESET +"Exit");
		System.out.println("\nEnter number:");
	}
	
	public void invalidInput() {
		System.out.println("Sorry that is an invalid Input");
	}
	public void idNotFound() {
		System.out.println("Ticket ID not found in the account");
	}
}
