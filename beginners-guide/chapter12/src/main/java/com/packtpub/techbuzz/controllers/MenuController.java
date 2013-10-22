package com.packtpub.techbuzz.controllers;

import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.MethodExpressionActionListener;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 * @author K. Siva Prasad Reddy
 * Date : 09-Aug-2013
 */
@ManagedBean
@RequestScoped
public class MenuController
{
	private MenuModel simpleMenuModel;
	private MenuModel menuModel;
	private MenuModel tieredMenuModel;
	private MenuModel breadcrumbMenuModel;
	private int activeIndex = 0;
	private boolean autoDisplay = true;
	
	public MenuController()
	{
		initSimpleMenuModel();
		initMenuModel();
		initTieredMenuModel();	
		initBreadcrumbMenuModel();
	}
	
	void initSimpleMenuModel()
	{
		simpleMenuModel = new DefaultMenuModel();
		
		DefaultMenuItem rootItem1 = new DefaultMenuItem();
		rootItem1.setValue("System Config");
		rootItem1.setIcon("ui-icon-gear");
		simpleMenuModel.addElement(rootItem1 );
		
		DefaultSubMenu sm1 = new DefaultSubMenu();
		sm1.setLabel("User Management");
		sm1.setIcon("ui-icon-person");
		
			DefaultMenuItem sm1Menu1Item1 = new DefaultMenuItem();
			sm1Menu1Item1.setValue("View Users");
			sm1Menu1Item1.setCommand("#{menuController.showUserManagement()}");
		
			DefaultMenuItem sm1Menu1Item2 = new DefaultMenuItem();
			sm1Menu1Item2.setValue("View User Activity");
			sm1Menu1Item2.setCommand("#{menuController.showUserActivity()}");
			sm1Menu1Item2.setAjax(false);
			
			sm1.addElement(sm1Menu1Item1);
			sm1.addElement(sm1Menu1Item2);
			
		simpleMenuModel.addElement(sm1);
		
		DefaultSubMenu sm2 = new DefaultSubMenu();
		sm2.setLabel("Tag Management");
		sm2.setIcon("ui-icon-tag");
		
			DefaultMenuItem sm2Item1 = new DefaultMenuItem();
			sm2Item1.setValue("View Tags");
			sm2Item1.setOutcome("menu");
			
			DefaultMenuItem sm2Item2 = new DefaultMenuItem();
			sm2Item2.setValue("Tag Stistics");
			sm2Item2.setUrl("menu.jsf");
			
		sm2.addElement(sm2Item1);
		sm2.addElement(sm2Item2);
		
		simpleMenuModel.addElement(sm2);
		
		
	}
	void initMenuModel()
	{
		menuModel = new DefaultMenuModel();
		
		DefaultSubMenu sm1 = new DefaultSubMenu();
		sm1.setLabel("User Management");
		sm1.setIcon("ui-icon-person");
		
			DefaultSubMenu sm1Menu1 = new DefaultSubMenu();
			sm1Menu1.setLabel("View Users");
			
				
				DefaultMenuItem sm1Menu1Ite1 = new DefaultMenuItem();
				sm1Menu1Ite1.setValue("Moderators");
				sm1Menu1Ite1.setUrl("tieredMenu.jsf");
			
				DefaultMenuItem sm1Menu1Ite2 = new DefaultMenuItem();
				sm1Menu1Ite2.setValue("Normal Users");
				sm1Menu1Ite2.setCommand("#{menuController.showUserManagement()}");
				sm1Menu1Ite2.setAjax(false);
			
			sm1Menu1.addElement(sm1Menu1Ite1);
			sm1Menu1.addElement(sm1Menu1Ite2);
				
			DefaultMenuItem sm1Item2 = new DefaultMenuItem();
			sm1Item2.setValue("Monitor User Activity");
			sm1Item2.setCommand("#{menuController.showUserActivity()}");
			sm1Item2.setAjax(false);
			
		sm1.addElement(sm1Menu1);
		sm1.addElement(sm1Item2);
		
		menuModel.addElement(sm1);
		
		DefaultSubMenu sm2 = new DefaultSubMenu();
		sm2.setLabel("Tag Management");
		sm2.setIcon("ui-icon-tag");
		
			DefaultMenuItem sm2Item1 = new DefaultMenuItem();
			sm2Item1.setValue("View Tags");
			sm2Item1.setOutcome("menu");
			
			DefaultMenuItem sm2Item2 = new DefaultMenuItem();
			sm2Item2.setValue("Tag Stistics");
			sm2Item2.setUrl("menu.jsf");
			
		sm2.addElement(sm2Item1);
		sm2.addElement(sm2Item2);
		
		menuModel.addElement(sm2);
		
		DefaultMenuItem rootItem1 = new DefaultMenuItem();
		rootItem1.setValue("System Config");
		rootItem1.setIcon("ui-icon-gear");
		menuModel.addElement(rootItem1 );
		
	}
	
	void initTieredMenuModel()
	{
		tieredMenuModel = new DefaultMenuModel();
		
		DefaultSubMenu sm1 = new DefaultSubMenu();
		sm1.setLabel("User Management");
		sm1.setIcon("ui-icon-person");
		
			DefaultMenuItem sm1Item1 = new DefaultMenuItem();
			sm1Item1.setValue("Disable/Enable User");
			
			sm1Item1.setCommand("#{menuController.showUserManagement()}");
			sm1Item1.setAjax(false);
			
			DefaultMenuItem sm1Item2 = new DefaultMenuItem();
			sm1Item2.setValue("View User Activity");
			sm1Item2.setCommand("#{menuController.showUserActivity()}");
			
		sm1.addElement(sm1Item1);
		sm1.addElement(sm1Item2);
		
		tieredMenuModel.addElement(sm1);
		
		
		DefaultSubMenu sm2 = new DefaultSubMenu();
		sm2.setLabel("Tag Management");
		sm2.setIcon("ui-icon-tag");
		
			DefaultMenuItem sm2Item1 = new DefaultMenuItem();
			sm2Item1.setValue("View Tags");
			sm2Item1.setOutcome("tieredMenu");
			
			DefaultMenuItem sm2Item2 = new DefaultMenuItem();
			sm2Item2.setValue("Create Tag");
			sm2Item2.setUrl("tieredMenu.jsf");
			
		sm2.addElement(sm2Item1);
		sm2.addElement(sm2Item2);
		
		
		tieredMenuModel.addElement(sm2);
		
		
		DefaultSubMenu sm3 = new DefaultSubMenu();
		sm3.setLabel("Reports");
		sm3.setIcon("ui-icon-folder-open");
		
			DefaultSubMenu sm3menu1 = new DefaultSubMenu();
			sm3menu1.setLabel("User Reports");
				
				DefaultMenuItem sm3menu1Item1 = new DefaultMenuItem();
				sm3menu1Item1.setValue("Post Statistics");
				sm3menu1Item1.setUrl("tieredMenu.jsf");
				
				DefaultMenuItem sm3menu1Item2 = new DefaultMenuItem();
				sm3menu1Item2.setValue("User Count Tracking");
				sm3menu1Item2.setUrl("tieredMenu.jsf");
				
			sm3menu1.addElement(sm3menu1Item1);
			sm3menu1.addElement(sm3menu1Item2);
			
			DefaultSubMenu sm3menu2 = new DefaultSubMenu();
			sm3menu2.setLabel("Tag Usage Reports");
			
				DefaultMenuItem sm3menu2Item1 = new DefaultMenuItem();
				sm3menu2Item1.setValue("Tag Usage Statistics");
				sm3menu2Item1.setUrl("tieredMenu.jsf");
				
				DefaultMenuItem sm3menu2Item2 = new DefaultMenuItem();
				sm3menu2Item2.setValue("Tags Usage by User");
				sm3menu2Item2.setUrl("tieredMenu.jsf");
				
			sm3menu2.addElement(sm3menu2Item1);
			sm3menu2.addElement(sm3menu2Item2);
			
		sm3.addElement(sm3menu1);
		sm3.addElement(sm3menu2);
		
		tieredMenuModel.addElement(sm3);
		
		DefaultSubMenu sm4 = new DefaultSubMenu();
		sm4.setLabel("System Configuration");
		sm4.setIcon("ui-icon-gear");
		
			DefaultSubMenu sm4menu1 = new DefaultSubMenu();
			sm4menu1.setLabel("Global Settings");
				
				DefaultMenuItem sm4menu1Item1 = new DefaultMenuItem();
				sm4menu1Item1.setValue("Cache Settings");
				sm4menu1Item1.setUrl("tieredMenu.jsf");
				
				DefaultMenuItem sm4menu1Item2 = new DefaultMenuItem();
				sm4menu1Item2.setValue("User Lock Policy");
				sm4menu1Item2.setIcon("ui-icon-locked");
				sm4menu1Item2.setUrl("tieredMenu.jsf");
				
				sm4menu1.addElement(sm4menu1Item1);
				sm4menu1.addElement(sm4menu1Item2);
			
			DefaultSubMenu sm4menu2 = new DefaultSubMenu();
			sm4menu2.setLabel("Email Server");
			sm4menu2.setIcon("ui-icon-mail-closed");
			
				DefaultMenuItem sm4menu2Item1 = new DefaultMenuItem();
				sm4menu2Item1.setValue("SMTP Settings");
				sm4menu2Item1.setUrl("tieredMenu.jsf");
				
			sm4menu2.addElement(sm4menu2Item1);
			
		sm4.addElement(sm4menu1);
		sm4.addElement(sm4menu2);
		
		tieredMenuModel.addElement(sm4);
		
	}
	
	void initBreadcrumbMenuModel()
	{
		breadcrumbMenuModel = new DefaultMenuModel();
		DefaultMenuItem item1 = new DefaultMenuItem();
		item1.setValue("PrimeFaces");
		item1.setUrl("http://www.primefaces.org/");
		breadcrumbMenuModel.addElement(item1);
		
		DefaultMenuItem item2 = new DefaultMenuItem();
		item2.setValue("Board index");
		item2.setUrl("http://forum.primefaces.org/index.php");
		breadcrumbMenuModel.addElement(item2);
		
		DefaultMenuItem item3 = new DefaultMenuItem();
		item3.setValue("JavaServer Faces");
		item3.setUrl("http://forum.primefaces.org/viewforum.php?f=19");
		breadcrumbMenuModel.addElement(item3);
		
		DefaultMenuItem item4 = new DefaultMenuItem();
		item4.setValue("General");
		item4.setUrl("http://forum.primefaces.org/viewforum.php?f=3");
		breadcrumbMenuModel.addElement(item4);
		
	}
	
	public MenuModel getSimpleMenuModel()
	{
		return simpleMenuModel;
	}
	public MenuModel getMenuModel()
	{
		return menuModel;
	}
	public MenuModel getTieredMenuModel()
	{
		return tieredMenuModel;
	}
	public MenuModel getBreadcrumbMenuModel()
	{
		return breadcrumbMenuModel;
	}
	public void showUserManagement()
	{
		addMessage("Show User Management Screen");
	}
	
	public String showUserActivity()
	{
		addMessage("Show User Activity Details");
		return "menu";
	}
	
	public String showSearchPage() {
		//return "search";
		return "tabMenu";
	}
	public void showMyAccount() {
		addMessage("Show My Account Details");
	}
	public void showPage(String page) {
		addMessage("Show "+page+"");
	}
	public boolean isAutoDisplay()
	{
		return autoDisplay;
	}

	public void setAutoDisplay(boolean autoDisplay)
	{
		this.autoDisplay = autoDisplay;
	}

	public int getActiveIndex()
	{
		return activeIndex;
	}
	public void setActiveIndex(int activeIndex)
	{
		this.activeIndex = activeIndex;
	}
	//PrimeFaces invokes setActiveIndex() with Long type param
	public void setActiveIndex(Long activeIndex)
	{
		this.activeIndex = activeIndex.intValue();
	}
	public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
	
	public static MethodExpression buildMethodExpression(String methodExpr){
		FacesContext context = FacesContext.getCurrentInstance();
		MethodExpression methodExpression = context.getApplication().getExpressionFactory()
					.createMethodExpression(context.getELContext(), methodExpr, 
											null, new Class[] { ActionEvent.class }
											);
		return methodExpression;
	}
	
	public static ActionListener buildMethodExpressionActionListener(String methodExpr){		
		return new MethodExpressionActionListener(buildMethodExpression(methodExpr));
	}
}
