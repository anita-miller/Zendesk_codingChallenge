/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

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

		APIAuthorisation.getTicketReader().getHashmapOfTickets();
		TicketPresentation ticketPresentation = new TicketPresentation();	
		
		//check if the ticket with ID 1 is fethced correctly
		Ticket actual = ticketPresentation.displaySummaryTicketById(APIAuthorisation.getTicketReader().getHashmapOfTickets(),(long) 1.0);
		assertEquals("Sample ticket: Meet the ticket", actual.getSubject());
	
	}
	
}
