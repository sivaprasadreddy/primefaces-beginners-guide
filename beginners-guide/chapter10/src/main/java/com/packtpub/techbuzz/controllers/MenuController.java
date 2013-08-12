package com.packtpub.techbuzz.controllers;

import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.MethodExpressionActionListener;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 * @author K. Siva Prasad Reddy
 * Date : 09-Aug-2013
 */
@ManagedBean
@RequestScoped
//@ViewScoped
public class MenuController
{
	private MenuModel menuModel;
	private MenuModel tieredMenuModel;
	private int activeIndex = 0;
	private boolean autoDisplay = true;
	
	public MenuController()
	{
		initSimpleMenuModel();
		initTieredMenuModel();	
	}
	
	void initSimpleMenuModel()
	{
		menuModel = new DefaultMenuModel();
		
		Submenu sm1 = new Submenu();
		sm1.setLabel("User Management");
		sm1.setIcon("ui-icon-person");
		
			Submenu sm1Menu1 = new Submenu();
			sm1Menu1.setLabel("View Users");
			
				
				MenuItem sm1Menu1Ite1 = new MenuItem();
				sm1Menu1Ite1.setValue("Moderators");
				sm1Menu1Ite1.setUrl("tieredMenu.jsf");
			
				MenuItem sm1Menu1Ite2 = new MenuItem();
				sm1Menu1Ite2.setValue("Normal Users");
				sm1Menu1Ite2.setActionExpression(buildMethodExpression("#{menuController.showUserManagement()}"));
				sm1Menu1Ite2.setAjax(false);
			
			sm1Menu1.getChildren().add(sm1Menu1Ite1);
			sm1Menu1.getChildren().add(sm1Menu1Ite2);
				
			MenuItem sm1Item2 = new MenuItem();
			sm1Item2.setValue("Monitor User Activity");
			sm1Item2.addActionListener(buildMethodExpressionActionListener("#{menuController.showUserActivity()}"));
			sm1Item2.setAjax(false);
			
		sm1.getChildren().add(sm1Menu1);
		sm1.getChildren().add(sm1Item2);
		
		menuModel.addSubmenu(sm1);
		
		Submenu sm2 = new Submenu();
		sm2.setLabel("Tag Management");
		sm2.setIcon("ui-icon-tag");
		
			MenuItem sm2Item1 = new MenuItem();
			sm2Item1.setValue("View Tags");
			sm2Item1.setOutcome("menu");
			
			MenuItem sm2Item2 = new MenuItem();
			sm2Item2.setValue("Tag Stistics");
			sm2Item2.setUrl("menu.jsf");
			
		sm2.getChildren().add(sm2Item1);
		sm2.getChildren().add(sm2Item2);
		
		menuModel.addSubmenu(sm2);
		
		MenuItem rootItem1 = new MenuItem();
		rootItem1.setValue("System Config");
		rootItem1.setIcon("ui-icon-gear");
		menuModel.addMenuItem(rootItem1 );
		
	}
	
	void initTieredMenuModel()
	{
		tieredMenuModel = new DefaultMenuModel();
		
		Submenu sm1 = new Submenu();
		sm1.setLabel("User Management");
		sm1.setIcon("ui-icon-person");
		
			MenuItem sm1Item1 = new MenuItem();
			sm1Item1.setValue("Disable/Enable User");
			
			sm1Item1.addActionListener(buildMethodExpressionActionListener("#{menuController.showUserManagement()}"));
			sm1Item1.setAjax(false);
			
			MenuItem sm1Item2 = new MenuItem();
			sm1Item2.setValue("View User Activity");
			sm1Item2.addActionListener(buildMethodExpressionActionListener("#{menuController.showUserActivity()}"));
			
		sm1.getChildren().add(sm1Item1);
		sm1.getChildren().add(sm1Item2);
		
		tieredMenuModel.addSubmenu(sm1);
		
		
		Submenu sm2 = new Submenu();
		sm2.setLabel("Tag Management");
		sm2.setIcon("ui-icon-tag");
		
			MenuItem sm2Item1 = new MenuItem();
			sm2Item1.setValue("View Tags");
			sm2Item1.setOutcome("tieredMenu");
			
			MenuItem sm2Item2 = new MenuItem();
			sm2Item2.setValue("Create Tag");
			sm2Item2.setUrl("tieredMenu.jsf");
			
		sm2.getChildren().add(sm2Item1);
		sm2.getChildren().add(sm2Item2);
		
		
		tieredMenuModel.addSubmenu(sm2);
		
		
		Submenu sm3 = new Submenu();
		sm3.setLabel("Reports");
		sm3.setIcon("ui-icon-folder-open");
		
			Submenu sm3menu1 = new Submenu();
			sm3menu1.setLabel("User Reports");
				
				MenuItem sm3menu1Item1 = new MenuItem();
				sm3menu1Item1.setValue("Post Statistics");
				sm3menu1Item1.setUrl("tieredMenu.jsf");
				
				MenuItem sm3menu1Item2 = new MenuItem();
				sm3menu1Item2.setValue("User Count Tracking");
				sm3menu1Item2.setUrl("tieredMenu.jsf");
				
			sm3menu1.getChildren().add(sm3menu1Item1);
			sm3menu1.getChildren().add(sm3menu1Item2);
			
			Submenu sm3menu2 = new Submenu();
			sm3menu2.setLabel("Tag Usage Reports");
			
				MenuItem sm3menu2Item1 = new MenuItem();
				sm3menu2Item1.setValue("Tag Usage Statistics");
				sm3menu2Item1.setUrl("tieredMenu.jsf");
				
				MenuItem sm3menu2Item2 = new MenuItem();
				sm3menu2Item2.setValue("Tags Usage by User");
				sm3menu2Item2.setUrl("tieredMenu.jsf");
				
			sm3menu2.getChildren().add(sm3menu2Item1);
			sm3menu2.getChildren().add(sm3menu2Item2);
			
		sm3.getChildren().add(sm3menu1);
		sm3.getChildren().add(sm3menu2);
		
		tieredMenuModel.addSubmenu(sm3);
		
		Submenu sm4 = new Submenu();
		sm4.setLabel("System Configuration");
		sm4.setIcon("ui-icon-gear");
		
			Submenu sm4menu1 = new Submenu();
			sm4menu1.setLabel("Global Settings");
				
				MenuItem sm4menu1Item1 = new MenuItem();
				sm4menu1Item1.setValue("Cache Settings");
				sm4menu1Item1.setUrl("tieredMenu.jsf");
				
				MenuItem sm4menu1Item2 = new MenuItem();
				sm4menu1Item2.setValue("User Lock Policy");
				sm4menu1Item2.setIcon("ui-icon-locked");
				sm4menu1Item2.setUrl("tieredMenu.jsf");
				
				sm4menu1.getChildren().add(sm4menu1Item1);
				sm4menu1.getChildren().add(sm4menu1Item2);
			
			Submenu sm4menu2 = new Submenu();
			sm4menu2.setLabel("Email Server");
			sm4menu2.setIcon("ui-icon-mail-closed");
			
				MenuItem sm4menu2Item1 = new MenuItem();
				sm4menu2Item1.setValue("SMTP Settings");
				sm4menu2Item1.setUrl("tieredMenu.jsf");
				
			sm4menu2.getChildren().add(sm4menu2Item1);
			
		sm4.getChildren().add(sm4menu1);
		sm4.getChildren().add(sm4menu2);
		
		tieredMenuModel.addSubmenu(sm4);
		
	}
	
	public MenuModel getMenuModel()
	{
		return menuModel;
	}
	public MenuModel getTieredMenuModel()
	{
		return tieredMenuModel;
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
		//System.out.println("activeIndex int->"+activeIndex);
		this.activeIndex = activeIndex;
	}
	public void setActiveIndex(Long activeIndex)
	{
		//System.out.println("activeIndex ->"+activeIndex);
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
