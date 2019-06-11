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
	
	private final int NUM_TICKETS_IN_LIST = 25;
	private PrintClass printer = new PrintClass();
	private int counter = 0;
	private int pageLimitTicketIndex = NUM_TICKETS_IN_LIST;
	private boolean headerFlag = true;
	private int input = 1;
	
	// Display all the tickets from the HashMap, 25 tickets at a time.
	public void showAllAvailableTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) {

		ArrayList<Ticket> ticketsList = new ArrayList<>(ticketMap.values());
		
		while (counter < ticketsList.size() && input != 3) {
			if (headerFlag) {
				printer.ticketHeader();
				headerFlag = false;
			}
			
			//display tickets from the hash map one by one, counter is index of tickets 0 to ticketsList.size()
			showIndividualTicket(ticketsList.get(counter));
			
			counter++;
			
			//if all tickets are shown thank and exit the application
			if (ticketsList.size() - counter == 0) {
				displayPrevPageOfTickets(ticketMap, scanner); 
			}
			
			//pagelimit variable is based on counter, when counter shows 0-25 pagelimit is 25, 
			// then increases by 25 to let counter to show tickets at index 25-50 and so on
			if (counter >= pageLimitTicketIndex) {
				//when counter is 25 and we at first page, there wont be prev option
				if(counter ==NUM_TICKETS_IN_LIST) {
					displayNextPageOfTickets(ticketMap, scanner);
				}
				else {
					displayPrevAndNextPageOfTickets(ticketMap, scanner);
				}
				headerFlag = true;
			}
		}
	}
	
	//seprating the feature of going to next and prev into 3 functions since first page only has next page
	//and last page only has prev page.
	public void displayPrevAndNextPageOfTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) 
	{
		printer.wantToViewNextOrPrevPageOfTicket();
		input = scanner.nextInt();
		
		switch (input) {
		case 1:
			//increase pageLimitTicketIndex so next page of ticket can be read
			pageLimitTicketIndex += NUM_TICKETS_IN_LIST;
			break;
			
		case 2:
			pageLimitTicketIndex = pageLimitTicketIndex - NUM_TICKETS_IN_LIST;
			//decrease counter by twice as much so it shows prev page tickets up to pageLimitTicketIndex
			counter = counter - 2*NUM_TICKETS_IN_LIST;
			break;
			
		case 3:
			wantTicketByIDAndBackToList(ticketMap, scanner);
			displayPrevAndNextPageOfTickets(ticketMap, scanner);
			break;
			
		case 4:
			goBackToMenu(ticketMap, scanner);
			break;
			
		case 5:
			printer.thanksAndExitApp();
			System.exit(0); 
			break;
		default:
			// message for wrong input.
			printer.invalidInput();
			displayPrevAndNextPageOfTickets(ticketMap, scanner);
			break;
		}
		
	}
	
	
	
	public void displayPrevPageOfTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) {
		printer.wantToViewPrevPageOfTicket();
		input = scanner.nextInt();
		
		switch (input) {
		case 1:
			pageLimitTicketIndex = pageLimitTicketIndex - NUM_TICKETS_IN_LIST;
			//decrease counter by twice as much so it shows prev page tickets up to pageLimitTicketIndex
			counter = counter - 2*NUM_TICKETS_IN_LIST;
			break;
			
		case 2:
			wantTicketByIDAndBackToList(ticketMap, scanner);
			displayPrevPageOfTickets(ticketMap, scanner);
			break;
			
		case 3:
			goBackToMenu(ticketMap, scanner);
			break;
			
		case 4:
			printer.thanksAndExitApp();
			System.exit(0); 
			break;
			
		default:
			// message for wrong input.
			printer.invalidInput();
			displayPrevPageOfTickets(ticketMap, scanner);
			break;
		}
	}
	
	
	public void displayNextPageOfTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) {
		printer.wantToViewNextPageOfTicket();
		input = scanner.nextInt();
		
		switch (input) {
		case 1:
			//increase the pageLimitTicketIndex to view next set of tickets
			pageLimitTicketIndex += NUM_TICKETS_IN_LIST;
			break;
			
		case 2:
			//view a ticket by id while staying in the same point at list
			wantTicketByIDAndBackToList(ticketMap, scanner);
			displayNextPageOfTickets(ticketMap, scanner);
			break;
			
		case 3:
			goBackToMenu(ticketMap, scanner);
			break;
			
		case 4:
			printer.thanksAndExitApp();
			System.exit(0); 
			break;
			
		default:
			// message for wrong input.
			printer.invalidInput();
			displayNextPageOfTickets(ticketMap, scanner);
			break;
		}
	}
	
	//view ticket by Id without leaving specific point in the list therefore no need to comeback and more convenient
	public void wantTicketByIDAndBackToList(HashMap<Long, Ticket> ticketMap, Scanner scanner) {
		printer.enterTicketID();
		Long id = scanner.nextLong();
		// Search the Ticket for the ID in HashMap and a summary of ticket is shown
		displaySummaryTicketById(ticketMap, id);
		showDescription(ticketMap, id);
		
	}
	
	//takes the user back to main menu at started and resets all the changes
	public void goBackToMenu(HashMap<Long, Ticket> ticketMap, Scanner scanner) {
		printer.showOptions();
		input = scanner.nextInt();

		if(input == 1) {
			counter =0;
			pageLimitTicketIndex = NUM_TICKETS_IN_LIST;
			headerFlag = true;
			showAllAvailableTickets(ticketMap, scanner);
		}
		else if(input == 2) { 
			displayTicketById(ticketMap, scanner);
		}
		else {
			// Exit the app.
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
		input = scanner.nextInt();
		if(input == 1) {
			
			showDescription(ticketMap, id);
			displayMoreTicketsByID(ticketMap, scanner);
		}
		else if(input == 2) {
			goBackToMenu(ticketMap, scanner);
		}
		else if(input == 3) {
			//if user doesn't want to view more tickets exit
			printer.thanksAndExitApp();
			System.exit(0); 
		}
		
	}
	
	//displays the some fields of a chosen ticket, doesn't show the description
	public Ticket displaySummaryTicketById(HashMap<Long, Ticket> ticketMap, Long key) {

		//hashmap stores tickets by id as key, so we look for key input in keys of hashmap
		if (ticketMap.containsKey(key)) {
			printer.ticketHeader();
			showIndividualTicket(ticketMap.get(key));
			
		}
		else {
			//if the ticket ID doesn't exist
			System.out.println("Sorry , We couldn't find your requested ticket ID");
		}
		
		return ticketMap.get(key);
	}
	
	//asks user if it wants to see more tickets, if yes calls the displayTicketById() functions
	public void displayMoreTicketsByID(HashMap<Long, Ticket> ticketMap, Scanner scanner) {
		printer.displayAnotherTicketById();
		int displayMoreTicketInput = scanner.nextInt();
		
		if(displayMoreTicketInput ==1) {
			displayTicketById(ticketMap, scanner);
		}
		else {
			//if user doesn't want to view more tickets exit
			printer.thanksAndExitApp();
			System.exit(0); 
		}
		
	}
	//show details of a given ticket
	public void showIndividualTicket(Ticket ticket) {

		long id = ticket.getId();
		long requester_id = ticket.getRequester_id();
		long assignee_id = ticket.getAssignee_id();
		String subject = ticket.getSubject();
		String status = ticket.getStatus();
		String priority = ticket.getPriority();
		String created_at = ticket.getCreated_at();
		ArrayList<String> tags = ticket.getTags();
		
		//description = description.replaceAll("(.{1,50})\\s+", "$1\n");
		System.out.format("%-4d | %-45s | %-10s | %-10s | %-20s| %-6d | %-6d | %-50s\n\n", id, subject, status, priority, created_at,requester_id, assignee_id,tags);
		printer.seperatingLine();
		
	}
	
	//shows the description of a specific ticket
	public void showDescription(HashMap<Long, Ticket> ticketMap, Long key) 
	{
		Ticket ticket = null;
		//find the ticket based on its Id
		if (ticketMap.containsKey(key)) 
		{
			ticket = ticketMap.get(key);	
		} 
		else 
		{
			//if the ticket ID doesn't exist
			printer.idNotFound();
			return;
			
		}
	
		//find description of the ticket
		String description = ticket.getDescription();
		System.out.format("\n%-4s " +":"+ "%4s \n", "Description", description);
	}
	
	
}
