/**
 * 
 */
package presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import logic.Ticket;

/**
 * @author anitanaseri
 *
 */
public class TicketPresentation {
	private final int TICKETS_IN_LIST = 25;
	private PrintClass printer = new PrintClass();
	
	// Display all the tickets from the HashMap, 25 tickets at a time.
	public void showAllAvailableTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) {

		ArrayList<Ticket> ticketsList = new ArrayList<>(ticketMap.values());
		int counter = 0;
		int pageLimit = TICKETS_IN_LIST;
		boolean headerFlag = true;
		String input = "yes";
		
		while (counter < ticketsList.size() && input.toLowerCase().equals("yes")) {
			if (headerFlag) {
				printer.ticketHeader();
				headerFlag = false;
			}
			//
			//display tickets from the hashmap one by one
			showIndividualTicket(ticketsList.get(counter));
			
			counter++;
			
			// everytime counter passes multiply of 25, ask user if more pages should be loaded
			//if yes to print new page header header set flag to true
			//pageLimit keeps track of what tickets per page, 0-25 first page, 25-50 second page,...
			if (counter + 1> pageLimit) {
				
				printer.wantToReadMoreTickets();
				input = scanner.next();
				pageLimit += TICKETS_IN_LIST;
				headerFlag = true;
			}
			//if all tickets are shown thank and exit the application
			if (ticketsList.size() - counter == 0) {
				printer.endOfListThankAndExitApp();
				System.exit(0); 
			}

		}
		//if user wishes to leave
		if(input.toLowerCase().equals("no")) {
			printer.thanksAndExitApp();
			System.exit(0); 
		}
	}
			
	// Display ticket with the user input field ID as a key.
	public void displayTicketById(HashMap<Long, Ticket> ticketMap, Scanner scanner) {

		printer.enterTicketID();
		Long id = scanner.nextLong();
		// Search the Ticket for the ID in HashMap and a summary of ticket is shown
		displaySummaryTicketById(ticketMap, id);
		
		//user can request to see more fields of the ticket
		printer.wantToReadDesciption();
		
		//if user wants to read more ticketes
		String input = scanner.next().toLowerCase();
		if(input.equals("yes")) {
			showDescription(ticketMap, id);
			
		}else if(input.equals("no")) {
			//if user doesn't want to view more tickets exit
			printer.thanksAndExitApp();
			System.exit(0); 
		}
		
	}
	public Ticket displaySummaryTicketById(HashMap<Long, Ticket> ticketMap, Long key) {

		//hashmap stores tickets by id as key, so we look for key input in keys of hashmap
		if (ticketMap.containsKey(key)) {
			printer.ticketHeader();
			showIndividualTicket(ticketMap.get(key));
			
		} else {
			//if the ticket ID doesn't exist
			System.out.println("Sorry , We couldn't find your requested ticket ID");
		}
		
		return ticketMap.get(key);
	}

	//show deatils of a given ticken
	public void showIndividualTicket(Ticket ticket) {

		long id = ticket.getId();
		long requester_id = ticket.getRequester_id();
		long assignee_id = ticket.getAssignee_id();
		long organisation_id = ticket.getOrganisation_id();
		String subject = ticket.getSubject();
		String status = ticket.getStatus();
		String priority = ticket.getPriority();
		String created_at = ticket.getCreated_at();
		ArrayList<String> tags = ticket.getTags();

		//description = description.replaceAll("(.{1,50})\\s+", "$1\n");
		System.out.format("%-4d | %-50s | %-20s | %-20s | %-20s| %-6d | %-6d | %-14d | %-50s\n", id, subject, status, priority, created_at,requester_id, assignee_id, organisation_id,tags);
		printer.seperatingLine();
		
	}
	
	public void showDescription(HashMap<Long, Ticket> ticketMap, Long key) {
		Ticket ticket = null;
		//find the ticket based on its Id
		if (ticketMap.containsKey(key)) {

			ticket = ticketMap.get(key);
			
		} else {
			//if the ticket ID doesn't exist
			printer.idNotFound();
			return;
			
		}
	
		//find description of the ticket
		String description = ticket.getDescription();
		System.out.format("\n%-4s " +":"+ "%4s \n", "Description", description);
	}
	
	
}
