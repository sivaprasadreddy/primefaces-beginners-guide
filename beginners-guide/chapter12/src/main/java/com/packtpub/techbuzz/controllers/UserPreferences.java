package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.packtpub.techbuzz.web.view.Theme;

/**
 * @author K. Siva Prasad Reddy
 * Date : 24-Aug-2013
 */
@ManagedBean
@SessionScoped
public class UserPreferences implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String selectedTheme = "aristo";
	private Map<String, String> themes;
	private List<Theme> advancedThemes;
	
	public UserPreferences()
	{
		themes = new TreeMap<String, String>();  
        themes.put("Aristo", "aristo");  
        themes.put("Black-Tie", "black-tie");  
        themes.put("Blitzer", "blitzer");  
        themes.put("Bluesky", "bluesky");  
        themes.put("Casablanca", "casablanca");  
        themes.put("Cupertino", "cupertino");  
        themes.put("Dark-Hive", "dark-hive");  
        themes.put("Dot-Luv", "dot-luv");  
        themes.put("Eggplant", "eggplant");  
        themes.put("Excite-Bike", "excite-bike");  
        themes.put("Flick", "flick");  
        themes.put("Glass-X", "glass-x");  
        themes.put("Hot-Sneaks", "hot-sneaks");  
        themes.put("Humanity", "humanity");  
        themes.put("Le-Frog", "le-frog");  
        themes.put("Midnight", "midnight");  
        themes.put("Mint-Choc", "mint-choc");  
        themes.put("Overcast", "overcast");  
        themes.put("Pepper-Grinder", "pepper-grinder");  
        themes.put("Redmond", "redmond");  
        themes.put("Rocket", "rocket");  
        themes.put("Sam", "sam");  
        themes.put("Smoothness", "smoothness");  
        themes.put("South-Street", "south-street");  
        themes.put("Start", "start");  
        themes.put("Sunny", "sunny");  
        themes.put("Swanky-Purse", "swanky-purse");  
        themes.put("Trontastic", "trontastic");  
        themes.put("UI-Darkness", "ui-darkness");  
        themes.put("UI-Lightness", "ui-lightness");  
        themes.put("Vader", "vader");
        
        themes.put("SeaBlue", "seablue");
        
        
		
        advancedThemes = new ArrayList<Theme>();
        advancedThemes.add(new Theme("afterdark", "afterdark.png"));
        advancedThemes.add(new Theme("afternoon", "afternoon.png"));
        advancedThemes.add(new Theme("afterwork", "afterwork.png"));
        advancedThemes.add(new Theme("aristo", "aristo.png"));
        advancedThemes.add(new Theme("black-tie", "black-tie.png"));
        advancedThemes.add(new Theme("blitzer", "blitzer.png"));
        advancedThemes.add(new Theme("bluesky", "bluesky.png"));
        advancedThemes.add(new Theme("bootstrap", "bootstrap.png"));
        advancedThemes.add(new Theme("casablanca", "casablanca.png"));
        advancedThemes.add(new Theme("cruze", "cruze.png"));
        advancedThemes.add(new Theme("cupertino", "cupertino.png"));
        advancedThemes.add(new Theme("dark-hive", "dark-hive.png"));
        advancedThemes.add(new Theme("dot-luv", "dot-luv.png"));
        advancedThemes.add(new Theme("eggplant", "eggplant.png"));
        advancedThemes.add(new Theme("excite-bike", "excite-bike.png"));
        advancedThemes.add(new Theme("flick", "flick.png"));
        advancedThemes.add(new Theme("glass-x", "glass-x.png"));
        advancedThemes.add(new Theme("home", "home.png"));
        advancedThemes.add(new Theme("hot-sneaks", "hot-sneaks.png"));
        advancedThemes.add(new Theme("humanity", "humanity.png"));
        advancedThemes.add(new Theme("le-frog", "le-frog.png"));
        advancedThemes.add(new Theme("midnight", "midnight.png"));
        advancedThemes.add(new Theme("mint-choc", "mint-choc.png"));
        advancedThemes.add(new Theme("overcast", "overcast.png"));
        advancedThemes.add(new Theme("pepper-grinder", "pepper-grinder.png"));
        advancedThemes.add(new Theme("redmond", "redmond.png"));
        advancedThemes.add(new Theme("rocket", "rocket.png"));
        advancedThemes.add(new Theme("sam", "sam.png"));
        advancedThemes.add(new Theme("smoothness", "smoothness.png"));
        advancedThemes.add(new Theme("south-street", "south-street.png"));
        advancedThemes.add(new Theme("start", "start.png"));
        advancedThemes.add(new Theme("sunny", "sunny.png"));
        advancedThemes.add(new Theme("swanky-purse", "swanky-purse.png"));
        advancedThemes.add(new Theme("trontastic", "trontastic.png"));
        advancedThemes.add(new Theme("ui-darkness", "ui-darkness.png"));
        advancedThemes.add(new Theme("ui-lightness", "ui-lightness.png"));
        advancedThemes.add(new Theme("vader", "vader.png"));
        
        advancedThemes.add(new Theme("seablue", "seablue.png"));
        
	}
	public void setSelectedTheme(String selectedTheme)
	{
		System.out.println("set selectedTheme: "+selectedTheme);
		this.selectedTheme = selectedTheme;
	}
	public String getSelectedTheme()
	{
		if(selectedTheme == null || selectedTheme.trim().length()==0){
			selectedTheme = "aristo";
		}
		return selectedTheme;
	}
	public void saveUserTheme()
	{
		System.out.println("Save user Theme: "+getSelectedTheme());
	}
	public Map<String, String> getThemes()
	{
		return themes;
	}
	public List<Theme> getAdvancedThemes()
	{
		return advancedThemes;
	}
}
