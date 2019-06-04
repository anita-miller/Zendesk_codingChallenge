/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.Ticket;

/**
 * @author anitanaseri
 *
 */
public class TicketPresentation {
	

	// Display ticket with the user input field ID as a key.
	public void displayTicketById(HashMap<Long, Ticket> ticketMap, Long key) {
		
		//hashmap stores tickets by id as key, so we look for key input in keys of hashmap
		if (ticketMap.containsKey(key)) {
			System.out.format("\n%-4s| %-4s | %-4s | %-50s | %-50s | %-30s", "ID", "Requester ID", "Assignee ID", "SUBJECT", "description","TAGS");
			System.out.println(
					"\n------------------------------------------------------------------------------------------------------------------------------------------------");
			ShowIndividualTicket(ticketMap.get(key));
		} else {
			//if the ticket ID doesn't exist
			System.out.println("Ticket ID not found in the account");
		}
	}

	public void ShowIndividualTicket(Ticket ticket) {

		long id = ticket.getId();
		long requester_id = ticket.getRequester_id();
		long assignee_id = ticket.getAssignee_id();
		String subject = ticket.getSubject();
		ArrayList<String> tags = ticket.getTags();
		String description = ticket.getDescription();
		
		
		System.out.format("%-4d| %-4d | %-4d | %-50s |  %-50s| %-50s\n", id, requester_id, assignee_id, subject, description, tags);
	}
}
