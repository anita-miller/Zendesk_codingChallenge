package logic;

import java.util.ArrayList;

/**
 * @author anitanaseri
 *
 */
public class Ticket {


	private long id;
	private String subject;
	private String status;
	private String priority;
	private String created_at;
	private String description;
	private long requester_id;
	private long assignee_id;
	private long organisation_id;
	private ArrayList<String> tags;
	
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
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the organization_id
	 */
	public long getOrganisation_id() {
		return organisation_id;
	}
	/**
	 * @param organization_id the organization_id to set
	 */
	public void setOrganisation_id(long organisation_id) {
		this.organisation_id = organisation_id;
	}
	/**
	 * @return the group_id
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", subject=" + subject + ", description=" + description + ", requester_id="
				+ requester_id + ", assignee_id=" + assignee_id + ", tags=" + tags + ", organization_id="
				+ "]";
	}
	
	
	
}
