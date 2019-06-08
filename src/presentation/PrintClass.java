package presentation;
/**
 * @author anitanaseri
 *
 */
public class PrintClass {
	public void welcomeMessage() {
		System.out.println("Welcome to Zendesk Ticket Viewer Application");
	}
	
	public void logingFailed() {
		System.out.println("Loging failed, Please re-run the application");
	}
	
	public void enterTicketID() {
		System.out.print("\n Please Enter The ID for the Ticket :  ");
	}
	
	public void wantToReadDesciption(){
		System.out.print("Do you wish to read the ticket's description. \n");
	}
	
	public void thanksAndExitApp() {
		System.out.println("\nThank You for viewing! \nExiting the Application. ");
	}
	public void endOfListThankAndExitApp() {
		System.out.println("Reached the end of the Tickets' List,\nThank You ! \nExiting the Application. ");
	}
	
	public void seperatingLine() {
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
	}
	public void ticketHeader(){
		System.out.format("\n%-4s | %-50s | %-20s | %-20s | %-20s| %-10s | %-13s| %-15s| %-50s\n", "ID", "SUBJECT","Status", "Priority", "Created At","Requester ID", "Assignee ID","Organisation ID", "Tags");
		seperatingLine();
	}
	public void wantToViewNextPageOfTicket() {

		System.out.println("\nPlease choose on of the options and enter number below:");
		System.out.print("\n\n Do you wish to view next page of tickets? : ");
		System.out.println("\n\t 1. View next page of tickets");
		System.out.println("\t 2. exit");
		System.out.println("\nEnter number:");
	}
	
	public void wantToViewNextOrPrevPageOfTicket() {

		System.out.println("\nPlease choose on of the options and enter number below:");
		System.out.print("\n\n Do you wish to view next page of tickets? : ");
		System.out.println("\n\t 1. View next page of tickets");
		System.out.println("\t 2. View the previous page of tickets");
		System.out.println("\t 3. exit");
		System.out.println("\nEnter number:");
	}
	
	public void showOptions() {
		System.out.println("\nPlease choose on of the options and enter number below:");
		System.out.println("\n\t 1. View summary of All available Tickets");
		System.out.println("\t 2. Find a ticket by ID and view any of the ticket's fields");
		System.out.println("\t 3. exit");
		System.out.println("\nEnter number:");
		
	}
	public void invalidInput() {
		System.out.println("Sorry that is an invalid Input");
	}
	public void idNotFound() {
		System.out.println("Ticket ID not found in the account");
	}
}
