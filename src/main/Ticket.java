package main;

import java.util.ArrayList;

public class Ticket {

	private long id;
	private long requester_id;
	private long assignee_id;
	private ArrayList<String> tags;
	private String subject;
	private String description;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the requester_id
	 */
	public long getRequester_id() {
		return requester_id;
	}
	/**
	 * @param requester_id the requester_id to set
	 */
	public void setRequester_id(long requester_id) {
		this.requester_id = requester_id;
	}
	
	/**
	 * @return the assignee_id
	 */
	public long getAssignee_id() {
		return assignee_id;
	}
	/**
	 * @param assignee_id the assignee_id to set
	 */
	public void setAssignee_id(long assignee_id) {
		this.assignee_id = assignee_id;
	}
	
	/**
	 * @return the tags
	 */
	public ArrayList<String> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Ticket [requester_id=" + requester_id + ", assignee_id=" + assignee_id + ", tags=" + tags + ", subject="
				+ subject + ", description=" + description + "]";
	}
	
}
