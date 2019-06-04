/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Source;
import model.Ticket;
import model.Via;

/**
 * @author anitanaseri
 *
 */
public class TicketReader {

	StringBuilder StringResultOfJsonInput;
	private HashMap<Long, Ticket> hashmapOfTickets = new HashMap<>();

	/**
	 * Takes the argument as InputStream from the GET API call to parse the String
	 * into Ticket Object
	 *
	 * @param
	 * @author anitanaseri
	 * @throws JSONException 
	 * @date 2019-06-04
	 */
	public void ticketDataParser(InputStream responseStream) throws JSONException{
		
		//An InputStreamReader is a bridge from byte streams to character streams,
		//It reads bytes and decodes them into characters
		BufferedReader TicketStream = new BufferedReader(new InputStreamReader((responseStream)));
		
		String tempStringToAppend;
		StringResultOfJsonInput = new StringBuilder();

		try {
			while ((tempStringToAppend = TicketStream.readLine()) != null) {
				StringResultOfJsonInput.append(tempStringToAppend);
			}

			TicketStream.close();
			this.createTicketsAndStore();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * create Tickets from Json and save them
	 * 
	 * @author anitanaseri
	 * @throws JSONException 
	 * @date 2019-06-04
	 */
	public void createTicketsAndStore() throws JSONException {

		JSONObject objectOfAllTickets = new JSONObject(StringResultOfJsonInput.toString());
		//getting all the tickets into an array
		JSONArray arrayOfTickets = objectOfAllTickets.getJSONArray("tickets");

		for (int i = 0; i < arrayOfTickets.length(); i++) {
			
			//get tickets one by one
			JSONObject ticketJson = arrayOfTickets.getJSONObject(i);
			
			long id = ticketJson.optLong("id");
			
			//create new Ticket and set its variable from what is in Json 
			Ticket ticket = createTicket(ticketJson);
			
			//store tickets in hashmap
			hashmapOfTickets.put(id, ticket);
		}
	}
	
	/**
	 * create new Ticket and set its variable from what is in Json. 
	 * 
	 * @author anitanaseri
	 * @throws JSONException 
	 * @date 2019-06-04
	 */
	private Ticket createTicket(JSONObject ticketJson) throws JSONException {
		
		//create new Ticket and set its variable from what is in Json 
		Ticket ticket = new Ticket();
		
		ticket.setId(ticketJson.optLong("id"));
		ticket.setRequester_id(ticketJson.getLong("requester_id"));
		ticket.setAssignee_id(ticketJson.optLong("assignee_id"));
		ticket.setSubject(ticketJson.optString("subject"));
		ticket.setDescription(ticketJson.optString("description"));
		
		//since tags are a list we need to extract it 
		JSONArray jsonArrayTags = ticketJson.getJSONArray("tags");
		ArrayList<String> arrayofTags = new ArrayList<>();

		for (int i = 0; i < jsonArrayTags.length(); i++) {
			arrayofTags.add(jsonArrayTags.get(i).toString());
		}

		ticket.setTags(arrayofTags);
		
		return ticket;
		
	}
}
