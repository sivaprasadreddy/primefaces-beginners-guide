/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class CatalogController 
{
    private List<SelectItem> categories;    
    private String selectedCategory;

    public CatalogController() 
    {        
		categories = new ArrayList<SelectItem>();
		
		SelectItemGroup homeAppliancesGrp = new SelectItemGroup("Home Appliances");
		SelectItemGroup homeDecorGrp = new SelectItemGroup("Home & Decor");
		SelectItem clocks = new SelectItem("Wall Clocks");
		SelectItem candleHolders = new SelectItem("Candle Holders");
		SelectItem artPrints = new SelectItem("Art Prints");
		homeDecorGrp.setSelectItems(new SelectItem[] { clocks, candleHolders,artPrints });
		SelectItem indoorLighting = new SelectItem("Indoor Lighting");
		homeAppliancesGrp.setSelectItems(new SelectItem[] { homeDecorGrp,indoorLighting });

		SelectItemGroup electronicsGrp = new SelectItemGroup("Electronics");
		SelectItemGroup mobilesGrp = new SelectItemGroup("Mobiles");
		SelectItem android = new SelectItem("Android Phones");
		SelectItem windows = new SelectItem("Windows Phones");
		SelectItem dualSim = new SelectItem("Dual SIM Phones");
		mobilesGrp.setSelectItems(new SelectItem[] { android, windows, dualSim });
		SelectItemGroup laptopsGrp = new SelectItemGroup("Laptops");
		SelectItem apple = new SelectItem("Apple");
		SelectItem dell = new SelectItem("Dell");
		laptopsGrp.setSelectItems(new SelectItem[] { apple, dell });
		SelectItemGroup camerasGrp = new SelectItemGroup("Cameras");
		SelectItem canon = new SelectItem("Canon");
		SelectItem nikon = new SelectItem("Nikon");
		camerasGrp.setSelectItems(new SelectItem[] { canon, nikon });
		electronicsGrp.setSelectItems(new SelectItem[] { mobilesGrp, laptopsGrp, camerasGrp });

		SelectItemGroup booksGrp = new SelectItemGroup("Books");
		SelectItem literature = new SelectItem("Literature");
		SelectItem fiction = new SelectItem("Fiction");
		booksGrp.setSelectItems(new SelectItem[] { literature, fiction });
		categories.add(homeAppliancesGrp);
		categories.add(electronicsGrp);
		categories.add(booksGrp);
    }

	public List<SelectItem> getCategories()
	{
		return categories;
	}

	public void setCategories(List<SelectItem> categories)
	{
		this.categories = categories;
	}

	public String getSelectedCategory()
	{
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory)
	{
		this.selectedCategory = selectedCategory;
	}    

}
