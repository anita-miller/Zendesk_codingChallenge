/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import logic.APICall;
import logic.Ticket;
import logic.TicketReader;

/**
 * @author anitanaseri
 *
 */
public class TicketReaderTest {
	private TicketReader ticketReader = new TicketReader();
	private APICall authentication = new APICall();
	private Ticket expectedTicket;
	
	@Before
	public void setUpticketDataReader() throws JSONException, IOException {
		authentication.login();
		
		ticketReader = authentication.getTicketReader();
	}
	
	@Test
	public void ticketDataReaderTest(){
		//checking that when ticketDataReader get an InputStream it parses the string correctly
		String testString = "{\"tickets\":[]}";
		InputStream stream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));
		try {
			ticketReader.ticketDataReader(stream);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("{\"tickets\":[]}", ticketReader.getStringResultOfJsonInput().toString());
		
	}
	
	
	@Before
	public void SetupcreateTicket() {
		expectedTicket = new Ticket();
		
		expectedTicket.setId(1);
		expectedTicket.setRequester_id((long) 381345057874.0);
		expectedTicket.setAssignee_id((long) 381285073454.0);
		expectedTicket.setOrganisation_id(0);
		expectedTicket.setSubject("Sample ticket: Meet the ticket");
		expectedTicket.setStatus("open");
		expectedTicket.setPriority("normal");
		expectedTicket.setCreated_at("2019-06-03T23:36:20Z");
		expectedTicket.setDescription("Hi Anita,\n\nThis is your first ticket. Ta-da! "
				+ "Any customer request sent to your supported channels (email, chat, voicemail, web form, and tweet) "
				+ "will become a Support ticket, just like this one. Respond to this ticket by typing a message above "
				+ "and clicking Submit. You can also see how an email becomes a ticket by emailing your new account, "
				+ "support@anitanaseri.zendesk.com. Your ticket will appear in ticket views.\n\nThat's the ticket on tickets."
				+ " If you want to learn more, check out: \nhttps://support.zendesk.com/hc/en-us/articles/203691476\n");
		
		//since tags are a list we need to extract it 
		ArrayList<String> arrayofTags = new ArrayList<>();

		arrayofTags.add("sample");
		arrayofTags.add("support");
		arrayofTags.add("zendesk");
		expectedTicket.setTags(arrayofTags);
	}
	
	@Test
	public void createTicketTest() throws JSONException{
		//check that createTicket function correctly creates ticket 
		JSONObject objectOfAllTickets = new JSONObject(ticketReader.getStringResultOfJsonInput().toString());
		//getting all the tickets into an array
		JSONArray arrayOfTickets = objectOfAllTickets.getJSONArray("tickets");
		JSONObject ticketJson = arrayOfTickets.getJSONObject(0);
		
		assertEquals(expectedTicket.getDescription(), ticketReader.createTicket(ticketJson).getDescription());
		
	}
}
