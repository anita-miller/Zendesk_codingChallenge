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
			System.out.format("\n%-4s | %-50s | %-4s | %-5s | %-5s| %-50s\n", "ID", "SUBJECT", "Org ID", "Created at", "Status", "Tags");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------");
			for (Ticket ticket : ticketsList) {
				ShowIndividualTicket(ticket);
			}
		//if there are more than 25 tickets
		} else {
			int counter = 0;
			int pageLimit = TICKETS_IN_LIST;
			boolean headerFlag = true;
			String input = "yes";
			
			while (counter < ticketsList.size() && input.toLowerCase().equals("yes")) {
				if (headerFlag) {

				System.out.format("\n%-4s | %-50s | %-4s | %-5s | %-5s| %-50s\n", "ID", "SUBJECT", "Org ID", "Created at", "Status", "Tags");
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------");
							
				headerFlag = false;
				}
				
				//display tickets from the hashmap one by one
				ShowIndividualTicket(ticketsList.get(counter));
				
				//counter counts number of tickets which are from 0-100
				counter++;

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

			System.out.format("\n%-4s | %-50s | %-4s | %-5s | %-5s| %-50s\n", "ID", "SUBJECT", "Org ID", "Created at", "Status", "Tags");
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------");
			ShowIndividualTicket(ticketMap.get(key));
		} else {
			//if the ticket ID doesn't exist
			System.out.println("Ticket ID not found in the account");
		}
	}

	public void ShowIndividualTicket(Ticket ticket) {

		long id = ticket.getId();
		long organization_id = ticket.getOrganization_id();
		String created_at = ticket.getCreated_at();
		String status = ticket.getStatus();
		String subject = ticket.getSubject();
		String description = ticket.getDescription();
		ArrayList<String> tags = ticket.getTags();


		long problem_id = ticket.getProblem_id();
		//description = description.replaceAll("(.{1,50})\\s+", "$1\n");
		System.out.format("%-4d | %-50s | %-6d | %-10s | %-7s| %-50s\n", id, subject,organization_id, created_at, status, tags);
		/*
		System.out.format("%-4s " +":"+ "%4d \n", "ID", id);
		System.out.format("%-4s " +":"+ "%4d \n", "Problem ID", problem_id);
		System.out.format("%-5s " +":"+ "%s\n","created at", created_at);
		System.out.format("%-5s " +":"+ "%s\n","Type", type);
		System.out.format("%-5s " +":"+ "%s\n","SUBJECT", subject);
		System.out.format("%-5s " +":"+ "%s\n","Description", description);
		System.out.format("%-5s " +":"+ "%s\n", "TAGS", tags);
		System.out.println(
				"\n------------------------------------------------------------------------------------------------------------------------------------------------\n");
		*/
	}
	
	public void showSpecificField(HashMap<Long, Ticket> ticketMap, Long key, String field) {
		
		//all the fields in ticket
		String url = ticket.getUrl();
		String external_id = ticket.getExternal_id();
		String updated_at = ticket.getUpdated_at();
		String type = ticket.getType();
		String priority = ticket.getPriority();
		String recipient = ticket.getRecipient();
		long requester_id = ticket.getRequester_id();
		long assignee_id = ticket.getAssignee_id();
		long group_id = ticket.getGroup_id();
		ArrayList<Integer> collaborator_id;
		long problem_id = ticket.getProblem_id();
		boolean has_incidents= ticket.isHas_incidents();
		boolean is_public = ticket.isIs_public();
		String due_at = ticket.getDue_at();
		String satisfaction_rating = ticket.getSatisfaction_rating();
	}
}
