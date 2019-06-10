/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.APICall;
import logic.Ticket;
import presentation.TicketPresentation;

/**
 * @author anitanaseri
 *
 */
public class TicketPresentationTest {
	private APICall APIAuthorisation;
	private final ByteArrayOutputStream displaySummaryTicketByIdReturnsErrorforWrongIDOutContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream showIndividualTicketOutContent = new ByteArrayOutputStream();
	
	private Ticket ticket;

	@Before
	public void setUpDisplaySummaryTicketByIdFetchedCorrectly() {
		
		//setting up for tickets to be loaded
	    APIAuthorisation = new APICall();
		try {
			APIAuthorisation.login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void displaySummaryTicketByIdFetchedCorrectlyTest(){
		//If the tickets are deleted/modified this test will no longer pass since ticket at id 1 won't have this 
		//specific subject
		TicketPresentation ticketPresentation = new TicketPresentation();	
		
		//check if the ticket with ID 1 is fethced correctly
		Ticket actualTicketWithID_1 = ticketPresentation.displaySummaryTicketById(APIAuthorisation.getTicketReader().getHashmapOfTickets(),(long) 1.0);
		System.out.print(actualTicketWithID_1.getSubject());
		assertEquals("Sample ticket: Meet the ticket", actualTicketWithID_1.getSubject());
	
	}
	

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(displaySummaryTicketByIdReturnsErrorforWrongIDOutContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(null);
	}
	
	@Test
	public void displaySummaryTicketByIdReturnsErrorforWrongIDTest(){
		Long wrongID = (long) 200;
		TicketPresentation ticketPresentation = new TicketPresentation();	
		
		//check if the ticket with ID 1 is fethced correctly
		ticketPresentation.displaySummaryTicketById(APIAuthorisation.getTicketReader().getHashmapOfTickets(),wrongID);
		
		assertEquals("Sorry , We couldn't find your requested ticket ID".trim(),
				displaySummaryTicketByIdReturnsErrorforWrongIDOutContent.toString().trim());
	}
	
	@Before
	public void SetupshowIndividualTicket() {
		ticket = new Ticket();
		
		ticket.setId(1);
		ticket.setRequester_id((long) 381345057874.0);
		ticket.setAssignee_id((long) 381285073454.0);
		ticket.setOrganisation_id(0);
		ticket.setSubject("Sample ticket: Meet the ticket");
		ticket.setStatus("open");
		ticket.setPriority("normal");
		ticket.setCreated_at("2019-06-03T23:36:20Z");
		ticket.setDescription("");
		
		//since tags are a list we need to extract it 
		ArrayList<String> arrayofTags = new ArrayList<>();

		arrayofTags.add("sample");
		arrayofTags.add("support");
		arrayofTags.add("zendesk");
		ticket.setTags(arrayofTags);
	}
	
	@After
	public void restoreStreamsshowIndividualTickettest() {
		System.setOut(null);
	}
	@org.junit.Test
	public void showIndividualTickettest(){
		System.setOut(new PrintStream(showIndividualTicketOutContent));

		TicketPresentation ticketPresentation = new TicketPresentation();	
		
		String expectedPrintValue = "1    | Sample ticket: Meet the ticket                | open       | normal     "
				+ "| 2019-06-03T23:36:20Z| 381345057874 | 381285073454 | [sample, support, zendesk]                        \n" + 
				"\n-------------------------------------------------------------------------------------------------------------"
				+ "-------------------------------------------------------";
		
		//test that the ticket printed by showIndividualTicket() is same as expectedPrintValue
		ticketPresentation.showIndividualTicket(ticket);
		assertEquals(expectedPrintValue.trim(),
				showIndividualTicketOutContent.toString().trim());
	}
}
