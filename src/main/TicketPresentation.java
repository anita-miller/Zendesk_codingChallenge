/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author anitanaseri
 *
 */
public class TicketPresentation {
	private final int TICKETS_IN_LIST = 25;
	
	// Display all the tickets from the HashMap, 25 tickets at a time.
	public void showAllAvailableTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) {

		ArrayList<Ticket> ticketsList = new ArrayList<>(ticketMap.values());
	
		
		//if number of tickets less than 25 show all of them in one page
		if (ticketsList.size() < TICKETS_IN_LIST) {
			System.out.format("\n%-4s | %-50s | %-10s | %-13s| %-50s\n", "ID", "SUBJECT", "Created at", "Status", "Tags");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------");
			for (Ticket ticket : ticketsList) {
				showIndividualTicket(ticket);
			}
		//if there are more than 25 tickets
		} else {
			int counter = 0;
			int pageLimit = TICKETS_IN_LIST;
			boolean headerFlag = true;
			String input = "yes";
			
			while (counter < ticketsList.size() && input.toLowerCase().equals("yes")) {
				if (headerFlag) {

				System.out.format("\n%-4s | %-50s | %-10s | %-13s| %-50s\n", "ID", "SUBJECT", "Requester Id", "Assignee Id", "Tags");
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------");
							
				headerFlag = false;
				}
				
				//display tickets from the hashmap one by one
				showIndividualTicket(ticketsList.get(counter));
				
				//counter counts number of tickets which are from 0-100
				counter++;
				
				//if all tickets are shown thank and exit the application
				if (ticketsList.size() - counter == 0) {
					System.out.println("Reached the end of the Tickets' List, \nExiting the Application. \nThank You !");
					System.exit(0); 
				}

				// when counter reaches 25 ask user if it wants more tickets if yes set header flag
				//to true to print new header for new page
				//pageLimit keeps track of what tickets per page, 0-25 first page, 25-50 second page,...
				if (counter + 1> pageLimit) {
					System.out.print("\n\n Do you wish to see more tickets? : ");
					input = scanner.next();
					pageLimit += TICKETS_IN_LIST;
					headerFlag = true;
				}
			}
		}
	}

	// Display ticket with the user input field ID as a key.
	public void displayTicketById(HashMap<Long, Ticket> ticketMap, Long key) {
		
		//hashmap stores tickets by id as key, so we look for key input in keys of hashmap
		if (ticketMap.containsKey(key)) {

			System.out.format("\n%-4s | %-50s | %-10s | %-13s| %-50s\n", "ID", "SUBJECT", "Requester Id", "Assignee Id", "Tags");
			System.out.println(
					"\n------------------------------------------------------------------------------------------------------------------------------------------------");
			showIndividualTicket(ticketMap.get(key));
		} else {
			//if the ticket ID doesn't exist
			System.out.println("Ticket ID not found in the account");
		}
	}

	//show deatils of a given ticken
	public void showIndividualTicket(Ticket ticket) {

		long id = ticket.getId();
		long requester_id = ticket.getRequester_id();
		long assignee_id = ticket.getAssignee_id();
		String subject = ticket.getSubject();
		ArrayList<String> tags = ticket.getTags();

		//description = description.replaceAll("(.{1,50})\\s+", "$1\n");
		System.out.format("%-4d | %-50s | %-6d | %-6d | %-50s\n", id, subject, requester_id, assignee_id, tags);
		
		System.out.println(
				"\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
		
	}
	
	public void showDescription(HashMap<Long, Ticket> ticketMap, Long key, String field) {
		Ticket ticket = null;
		//find the ticket based on its Id
		if (ticketMap.containsKey(key)) {

			ticket = ticketMap.get(key);
			
		} else {
			//if the ticket ID doesn't exist
			System.out.println("Ticket ID not found in the account");
			return;
			
		}
		
		//find description of the ticket
		String description = ticket.getDescription();
		
		//if input is description print it or return error
		if(field.toLowerCase().equals("yes")) {
			System.out.format("\n%-4s " +":"+ "%4s \n", "Description", description);
		}
		else {
			System.out.format("\nInvalid Input\n");
		}
		
		
	}
}
