package main;

import java.util.ArrayList;

import model.Via;
/**
 * @author anitanaseri
 *
 */
public class Ticket {

	private String url;
	private long id;
	private String external_id;
	private Via via;
	private String created_at;
	private String updated_at;
	private String type;
	private String subject;
	private String raw_subject;
	private String description;
	private String priority;
	private String status;
	private String recipient;
	private long requester_id;
	private long submitter_id;
	private long assignee_id;
	private long organization_id;
	private long group_id;
	private ArrayList<Integer> collaborator_id;
	private ArrayList<Integer> follower_ids;
	private long forum_topic_id;
	private long problem_id;
	private boolean has_incidents;
	private boolean is_public;
	private String due_at;
	private ArrayList<String> tags;
	private ArrayList<String> custom_fields;
	private String satisfaction_rating;
	private ArrayList<Integer> sharing_agreement_ids;
	private ArrayList<String> fields;
	private ArrayList<Integer> followup_ids;
	private long brand_id;
	private boolean allow_channelback;
	
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the external_id
	 */
	public String getExternal_id() {
		return external_id;
	}
	/**
	 * @param external_id the external_id to set
	 */
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}
	/**
	 * @return the via
	 */
	public Via getVia() {
		return via;
	}
	/**
	 * @param via the via to set
	 */
	public void setVia(Via via) {
		this.via = via;
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
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the raw_subject
	 */
	public String getRaw_subject() {
		return raw_subject;
	}
	/**
	 * @param raw_subject the raw_subject to set
	 */
	public void setRaw_subject(String raw_subject) {
		this.raw_subject = raw_subject;
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
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}
	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	/**
	 * @return the submitter_id
	 */
	public long getSubmitter_id() {
		return submitter_id;
	}
	/**
	 * @param submitter_id the submitter_id to set
	 */
	public void setSubmitter_id(long submitter_id) {
		this.submitter_id = submitter_id;
	}
	/**
	 * @return the organization_id
	 */
	public long getOrganization_id() {
		return organization_id;
	}
	/**
	 * @param organization_id the organization_id to set
	 */
	public void setOrganization_id(long organization_id) {
		this.organization_id = organization_id;
	}
	/**
	 * @return the group_id
	 */
	public long getGroup_id() {
		return group_id;
	}
	/**
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	/**
	 * @return the collaborator_id
	 */
	public ArrayList<Integer> getCollaborator_id() {
		return collaborator_id;
	}
	/**
	 * @param collaborator_id the collaborator_id to set
	 */
	public void setCollaborator_id(ArrayList<Integer> collaborator_id) {
		this.collaborator_id = collaborator_id;
	}
	/**
	 * @return the follower_ids
	 */
	public ArrayList<Integer> getFollower_ids() {
		return follower_ids;
	}
	/**
	 * @param follower_ids the follower_ids to set
	 */
	public void setFollower_ids(ArrayList<Integer> follower_ids) {
		this.follower_ids = follower_ids;
	}
	/**
	 * @return the forum_topic_id
	 */
	public long getForum_topic_id() {
		return forum_topic_id;
	}
	/**
	 * @param forum_topic_id the forum_topic_id to set
	 */
	public void setForum_topic_id(long forum_topic_id) {
		this.forum_topic_id = forum_topic_id;
	}
	/**
	 * @return the problem_id
	 */
	public long getProblem_id() {
		return problem_id;
	}
	/**
	 * @param problem_id the problem_id to set
	 */
	public void setProblem_id(long problem_id) {
		this.problem_id = problem_id;
	}
	/**
	 * @return the has_incidents
	 */
	public boolean isHas_incidents() {
		return has_incidents;
	}
	/**
	 * @param has_incidents the has_incidents to set
	 */
	public void setHas_incidents(boolean has_incidents) {
		this.has_incidents = has_incidents;
	}
	/**
	 * @return the is_public
	 */
	public boolean isIs_public() {
		return is_public;
	}
	/**
	 * @param is_public the is_public to set
	 */
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}
	/**
	 * @return the due_at
	 */
	public String getDue_at() {
		return due_at;
	}
	/**
	 * @param due_at the due_at to set
	 */
	public void setDue_at(String due_at) {
		this.due_at = due_at;
	}
	/**
	 * @return the custom_fields
	 */
	public ArrayList<String> getCustom_fields() {
		return custom_fields;
	}
	/**
	 * @param custom_fields the custom_fields to set
	 */
	public void setCustom_fields(ArrayList<String> custom_fields) {
		this.custom_fields = custom_fields;
	}
	/**
	 * @return the satisfaction_rating
	 */
	public String getSatisfaction_rating() {
		return satisfaction_rating;
	}
	/**
	 * @param satisfaction_rating the satisfaction_rating to set
	 */
	public void setSatisfaction_rating(String satisfaction_rating) {
		this.satisfaction_rating = satisfaction_rating;
	}
	/**
	 * @return the sharing_agreement_ids
	 */
	public ArrayList<Integer> getSharing_agreement_ids() {
		return sharing_agreement_ids;
	}
	/**
	 * @param sharing_agreement_ids the sharing_agreement_ids to set
	 */
	public void setSharing_agreement_ids(ArrayList<Integer> sharing_agreement_ids) {
		this.sharing_agreement_ids = sharing_agreement_ids;
	}
	/**
	 * @return the fields
	 */
	public ArrayList<String> getFields() {
		return fields;
	}
	/**
	 * @param fields the fields to set
	 */
	public void setFields(ArrayList<String> fields) {
		this.fields = fields;
	}
	/**
	 * @return the followup_ids
	 */
	public ArrayList<Integer> getFollowup_ids() {
		return followup_ids;
	}
	/**
	 * @param followup_ids the followup_ids to set
	 */
	public void setFollowup_ids(ArrayList<Integer> followup_ids) {
		this.followup_ids = followup_ids;
	}
	/**
	 * @return the brand_id
	 */
	public long getBrand_id() {
		return brand_id;
	}
	/**
	 * @param brand_id the brand_id to set
	 */
	public void setBrand_id(long brand_id) {
		this.brand_id = brand_id;
	}
	/**
	 * @return the allow_channelback
	 */
	public boolean isAllow_channelback() {
		return allow_channelback;
	}
	/**
	 * @param allow_channelback the allow_channelback to set
	 */
	public void setAllow_channelback(boolean allow_channelback) {
		this.allow_channelback = allow_channelback;
	}
	@Override
	public String toString() {
		return "Ticket [url=" + url + ", id=" + id + ", external_id=" + external_id + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", type=" + type + ", subject=" + subject + ", raw_subject="
				+ raw_subject + ", description=" + description + ", priority=" + priority + ", status=" + status
				+ ", recipient=" + recipient + ", requester_id=" + requester_id + ", submitter_id=" + submitter_id
				+ ", assignee_id=" + assignee_id + ", organization_id=" + organization_id + ", group_id=" + group_id
				+ ", collaborator_id=" + collaborator_id + ", follower_ids=" + follower_ids + ", forum_topic_id="
				+ forum_topic_id + ", problem_id=" + problem_id + ", has_incidents=" + has_incidents + ", is_public="
				+ is_public + ", due_at=" + due_at + ", tags=" + tags + ", custom_fields=" + custom_fields
				+ ", satisfaction_rating=" + satisfaction_rating + ", sharing_agreement_ids=" + sharing_agreement_ids
				+ ", fields=" + fields + ", followup_ids=" + followup_ids + ", brand_id=" + brand_id
				+ ", allow_channelback=" + allow_channelback + "]";
	}
	
	
	
}
