/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.apache.commons.lang3.StringUtils;

import com.packtpub.techbuzz.entities.Tag;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class SelectionController 
{
	private boolean subscribeToEmailNotif;
	private boolean showOnlineStatus;
	private boolean recievePrivateMsgs;
	
	private List<String>  tags;
	private Map<String, String> popularTags = null;
	private List<String>  selectedTags;
	private List<String>  favoriteTags;
	private List<String>  selectedPopularTags;
	
	private List<Tag> tagPojos;
	private List<Tag> selectedTagsFromPojos = new ArrayList<Tag>();
	
	private String gender;
	private List<String> servers;
	private String selectedServer;
	private Tag selectedTag;
	private Tag selectedTag1;
	
    private String text1;
    private String number;
    private List<String> numbers;
    private List<String> searchInOptions;
    private List<String> selectedSearchInOptions;
  
    private List<SelectItem> tagItems;
    private String selectedTagItem;
    
    public SelectionController() 
    {
    	tags = new ArrayList<String>();
    	tags.add("JSF");
    	tags.add("PrimeFaces");
    	tags.add("JPA");
    	tags.add("jQuery");
    	
    	popularTags = new HashMap<String, String>();
    	popularTags.put("Java","java");
    	popularTags.put("JavaScript","javascript");
    	popularTags.put("PrimeFaces","primefaces");
    	
    	tagPojos = new ArrayList<Tag>();
    	tagPojos.add(new Tag(1, "JavaSE", "java-se", "Java Programming Language"));
    	tagPojos.add(new Tag(2, "JavaEE", "java-ee", "Java Enterproze Edition"));
    	tagPojos.add(new Tag(3, "Spring", "spring", "Spring Framework"));
    	
    	servers = new ArrayList<String>();
    	servers.add("Tomcat");
    	servers.add("Glassfish");
    	servers.add("JBoss");
    	
    	searchInOptions= new ArrayList<String>();
    	searchInOptions.add("Posts");
    	searchInOptions.add("Comments");
    	searchInOptions.add("Tags");
    	searchInOptions.add("Users");
    	
    	SelectItemGroup g1 = new SelectItemGroup("JavaSE");
        g1.setSelectItems(new SelectItem[] {new SelectItem("Threads", "Threads"), 
        					new SelectItem("JDBC", "JDBC")});
        
        SelectItemGroup g2 = new SelectItemGroup("JavaEE");
        g2.setSelectItems(new SelectItem[] {new SelectItem("JPA", "JPA"), 
        					new SelectItem("JMS", "JMS"), 
        					new SelectItem("EJB", "EJB")});
        
        tagItems = new ArrayList<SelectItem>();
        tagItems.add(g1);
        tagItems.add(g2);
        
        
	}

    public String getText1()
	{
		return text1;
	}

	public void setText1(String text1)
	{
		this.text1 = text1;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}
	
	public List<String> getNumbers()
	{
		return numbers;
	}

	public List<SelectItem> getTagItems()
	{
		return tagItems;
	}

	public void setTagItems(List<SelectItem> tagItems)
	{
		this.tagItems = tagItems;
	}

	public Tag getSelectedTag1()
	{
		return selectedTag1;
	}

	public void setSelectedTag1(Tag selectedTag1)
	{
		this.selectedTag1 = selectedTag1;
	}

	public String getSelectedTagItem()
	{
		return selectedTagItem;
	}

	public void setSelectedTagItem(String selectedTagItem)
	{
		this.selectedTagItem = selectedTagItem;
	}

	public void setNumbers(List<String> numbers)
	{
		this.numbers = numbers;
	}

	public List<String> getSearchInOptions()
	{
		return searchInOptions;
	}

	public void setSearchInOptions(List<String> searchInOptions)
	{
		this.searchInOptions = searchInOptions;
	}

	public List<String> getSelectedSearchInOptions()
	{
		return selectedSearchInOptions;
	}

	public void setSelectedSearchInOptions(List<String> selectedSearchInOptions)
	{
		this.selectedSearchInOptions = selectedSearchInOptions;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	public String getSelectedServer() {
		return selectedServer;
	}

	public void setSelectedServer(String selectedServer) {
		this.selectedServer = selectedServer;
	}

	public Tag getSelectedTag() {
		return selectedTag;
	}

	public void setSelectedTag(Tag selectedTag) {
		this.selectedTag = selectedTag;
	}

	public boolean isSubscribeToEmailNotif() {
		return subscribeToEmailNotif;
	}

	public void setSubscribeToEmailNotif(boolean subscribeToEmailNotif) {
		this.subscribeToEmailNotif = subscribeToEmailNotif;
	}
	
	public boolean isShowOnlineStatus() {
		return showOnlineStatus;
	}

	public void setShowOnlineStatus(boolean showOnlineStatus) {
		this.showOnlineStatus = showOnlineStatus;
	}

	public boolean isRecievePrivateMsgs() {
		return recievePrivateMsgs;
	}

	public void setRecievePrivateMsgs(boolean recievePrivateMsgs) {
		this.recievePrivateMsgs = recievePrivateMsgs;
	}

	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getSelectedTags() {
		return selectedTags;
	}

	public void setSelectedTags(List<String> selectedTags) {
		this.selectedTags = selectedTags;
	}

	public List<String> getFavoriteTags() {
		return favoriteTags;
	}

	public void setFavoriteTags(List<String> favoriteTags) {
		this.favoriteTags = favoriteTags;
	}
	public Map<String, String> getPopularTags() {
		return popularTags;
	}
	
	public List<String> getSelectedPopularTags() {
		return selectedPopularTags;
	}

	public void setSelectedPopularTags(List<String> selectedPopularTags) {
		this.selectedPopularTags = selectedPopularTags;
	}

	public void setPopularTags(Map<String, String> popularTags) {
		this.popularTags = popularTags;
	}
	public List<Tag> getTagPojos() {
		return tagPojos;
	}
	
	public List<Tag> getSelectedTagsFromPojos() {
		return selectedTagsFromPojos;
	}

	public void setSelectedTagsFromPojos(List<Tag> selectedTagsFromPojos) {
		this.selectedTagsFromPojos = selectedTagsFromPojos;
	}

	public void setTagPojos(List<Tag> tagPojos) {
		this.tagPojos = tagPojos;
	}

	public void handleEmailSubscription()
	{
		if(subscribeToEmailNotif){
			addMessage("You have subscribed to Email notifications");
		} else {
			addMessage("You have unsubscribed from Email notifications");
		}
	}
	
	public void updateUserpreferences() {
		String msg = "Show Online Status : "+showOnlineStatus+", "+"Accept Private Msgs : "+recievePrivateMsgs;
		addMessage(msg);
	}
	
	public void handleSelectMany() {
		String msg = "Selected Values";
		msg += "<br/>FavoriteTags : "+ StringUtils.join(favoriteTags, ", ");
		msg += "<br/>Popular Tags : "+ StringUtils.join(selectedPopularTags, ", ");
		msg += "<br/>Selected Tags : "+ StringUtils.join(selectedTags, ",");
		List<String> tagList = new ArrayList<String>();
		if(selectedTagsFromPojos != null){
			for (Tag tag : selectedTagsFromPojos) {
				tagList.add(tag.getLabel());
			}
		}
		msg += "<br/>Selected Tags(POJO) : "+ StringUtils.join(tagList, ", ");
		addMessage(msg);
	}

	public void  logout()
	{
		addMessage("You have been logged out.");
	}
	
	public void  showAccount()
	{
		addMessage("showAccount.");
	}

	public void addMessage(String summary) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));  
    }
	
}
