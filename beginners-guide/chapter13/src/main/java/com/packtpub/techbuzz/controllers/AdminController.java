package com.packtpub.techbuzz.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.UserService;
import com.packtpub.techbuzz.web.view.LazyUserModel;
import com.packtpub.techbuzz.web.view.TagStatistics;

/**
 * @author K. Siva Prasad Reddy
 * Date : 27-Jun-2013
 */
@Component
@Scope(value="view")
public class AdminController
{
	@Autowired
	private UserService userService;
	
	private List<User> users = null;
	private List<User> filteredUsers = null;
	private User selectedUser = null;
	private List<User> selectedUsers = null;
	//Note: DataExporter with selectionONly attribute is not working with List<User> for any of the formats. 
	//But working fine with User[] for PDF and XLS exporting only. Seems like there is a bug.
	private User[] selectedUsersArray = null;
	private SelectItem[] userStatusOptions;
	
	private LazyUserModel lazyUserModel;
	private List<TagStatistics> tagStatisticsList = null;
	
	@PostConstruct
	void init()
	{
		users = userService.findAllUsers();
		this.userStatusOptions = new SelectItem[3];
		this.userStatusOptions[0] = new SelectItem("", "Select");  
		this.userStatusOptions[1] = new SelectItem("true", "True");
		this.userStatusOptions[2] = new SelectItem("false", "False");
		
		lazyUserModel = new LazyUserModel(users);
		
		tagStatisticsList = new ArrayList<TagStatistics>();
		tagStatisticsList.add(new TagStatistics("JSF", 1005,1500));
		tagStatisticsList.add(new TagStatistics("PrimeFaces", 2005,2200));
		tagStatisticsList.add(new TagStatistics("Spring", 2505,3000));
		tagStatisticsList.add(new TagStatistics("JPA", 1050,1750));
		tagStatisticsList.add(new TagStatistics("Hibernate", 500,750));
		tagStatisticsList.add(new TagStatistics("jQuery", 1205,1800));
		tagStatisticsList.add(new TagStatistics("JavaScript", 4005,5000));
		
	}
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public List<User> getFilteredUsers()
	{
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers)
	{
		this.filteredUsers = filteredUsers;
	}

	public User getSelectedUser()
	{
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser)
	{
		this.selectedUser = selectedUser;
	}

	public List<User> getSelectedUsers()
	{
		return selectedUsers;
	}

	public void setSelectedUsers(List<User> selectedUsers)
	{
		this.selectedUsers = selectedUsers;
	}

	public User[] getSelectedUsersArray()
	{
		return selectedUsersArray;
	}

	public void setSelectedUsersArray(User[] selectedUsersArray)
	{
		this.selectedUsersArray = selectedUsersArray;
	}

	public LazyUserModel getLazyUserModel()
	{
		return lazyUserModel;
	}

	public void setLazyUserModel(LazyUserModel lazyUserModel)
	{
		this.lazyUserModel = lazyUserModel;
	}

	public List<TagStatistics> getTagStatisticsList()
	{
		return tagStatisticsList;
	}

	public void setTagStatisticsList(List<TagStatistics> tagStatisticsList)
	{
		this.tagStatisticsList = tagStatisticsList;
	}
	
	public int getLastYearPostsCount()
	{
		int total = 0;
		for (TagStatistics tagStat : tagStatisticsList)
		{
			total += tagStat.getPostsCountLastYear();
		}
		return total;
	}
	public int getThisYearPostsCount()
	{
		int total = 0;
		for (TagStatistics tagStat : tagStatisticsList)
		{
			total += tagStat.getPostsCountThisYear();
		}
		return total;
	}
	

	public SelectItem[] getUserStatusOptions()
	{
		return userStatusOptions;
	}

	public void setUserStatusOptions(SelectItem[] userStatusOptions)
	{
		this.userStatusOptions = userStatusOptions;
	}

	public int sortByFirstName(Object firstName1, Object firstName2)
	{
		//return -1, 0 , 1 if firstName1 is less than, equal to or greater than firstName2 respectively
		return ((String)firstName1).compareToIgnoreCase(((String)firstName2));
	}
	
	public void onRowSelect(SelectEvent event) {  
        
		FacesMessage msg = new FacesMessage("User Selected: "+ ((User) event.getObject()).getEmailId());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
    public void onRowUnselect(UnselectEvent event) {  
        this.selectedUser = null;
    	FacesMessage msg = new FacesMessage("User Unselected: "+((User) event.getObject()).getEmailId());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
    
    public void disableSelectedUser()
	{
    	if(this.selectedUser == null){
    		return;
    	}
    	String msg = "Disabled User : [ "+this.selectedUser.getEmailId()+"]";
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));  		
	}
    
    public void disableSelectedUsers()
	{
    	String msg = "Disabled User Ids: [ ";
    	List<User> users = this.selectedUsers;
    	for (User user : users)
		{
    		msg += user.getId()+",";
		}
    	msg = msg.substring(0, msg.length()-1)+"]";
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));  		
	}
    
    public void postProcessXLS(Object document) {  
	    HSSFWorkbook wb = (HSSFWorkbook) document;  
	    HSSFSheet sheet = wb.getSheetAt(0);  
	    HSSFRow header = sheet.getRow(0);  
	      
	    HSSFCellStyle cellStyle = wb.createCellStyle();    
	    cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);  
	    cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	      
	    for(int i=0; i < header.getPhysicalNumberOfCells();i++) {  
	        HSSFCell cell = header.getCell(i);  
	        cell.setCellStyle(cellStyle);  
	    }  
	}  
	  
	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {  
	    Document pdf = (Document) document;  
	    pdf.open();  
	    pdf.setPageSize(PageSize.A4);  
	  
	    InputStream stream = AdminController.class.getResourceAsStream("/primefaces.jpg");
	    byte[] logoBytes =  IOUtils.toByteArray(stream);	   
	    pdf.add(Image.getInstance(logoBytes));  
	} 
	
	public void onEdit(RowEditEvent event) {  
		User user = (User) event.getObject();
        FacesMessage msg = new FacesMessage("Edited User : "+ user.getEmailId());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
    	User user = (User) event.getObject();
        FacesMessage msg = new FacesMessage("Editing Cancelled for User : "+ user.getEmailId());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void onCellEdit(CellEditEvent event) {  
        Object oldValue = event.getOldValue();  
        Object newValue = event.getNewValue();  
          
        if(newValue != null && !newValue.equals(oldValue)) {  
            FacesMessage msg = new FacesMessage("Cell Changed from : " + oldValue + ", to:" + newValue);  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }
    
    
}
