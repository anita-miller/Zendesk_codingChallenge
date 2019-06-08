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
	public void setUpticketDataReader() {
		try {
			authentication.login();
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
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
	
}
