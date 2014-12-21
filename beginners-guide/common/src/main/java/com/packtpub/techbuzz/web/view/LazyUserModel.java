package com.packtpub.techbuzz.web.view;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.packtpub.techbuzz.entities.User;
import org.primefaces.model.SortMeta;

/**
 * @author K. Siva Prasad Reddy
 * Date : 05-Jul-2013
 */
public class LazyUserModel extends LazyDataModel<User> 
{  
    
	private static final long serialVersionUID = 1L;
	private List<User> datasource;  
    
	  public LazyUserModel(List<User> datasource) {  
	      this.datasource = datasource;  
	  }  
    
  @Override  
  public User getRowData(String rowKey) {  
      for(User car : datasource) {  
          if(car.getEmailId().equals(rowKey))  
              return car;  
      }  

      return null;  
  }  

  @Override  
  public Object getRowKey(User car) {  
      return car.getEmailId();  
  }  

    @Override
    public List<User> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
        return super.load(first, pageSize, multiSortMeta, filters); //To change body of generated methods, choose Tools | Templates.
    }

    @Override  
    public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {  
        List<User> data = new ArrayList<User>();  
        //filter  
        for(User user : datasource) {  
            boolean match = true;  
  
            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {  
                try {  
                    String filterProperty = it.next();  
                    String filterValue = (String) filters.get(filterProperty);  
                    Field field = user.getClass().getDeclaredField(filterProperty);
            		field.setAccessible(true);
            		String fieldValue = String.valueOf(field.get(user));
            		 
                    if(filterValue == null || fieldValue.startsWith(filterValue)) {  
                        match = true;  
                    }  
                    else {  
                        match = false;  
                        break;  
                    }  
                } catch(Exception e) {  
                	e.printStackTrace();
                    match = false;  
                }   
            }  
  
            if(match) {  
                data.add(user);  
            }  
        }  
        //sort  
        if(sortField != null) {  
            Collections.sort(data, new LazySorter(sortField, sortOrder));  
        }  
  
        //rowCount  
        int dataSize = data.size();  
        this.setRowCount(dataSize);  
  
        //paginate  
        if(dataSize > pageSize) {  
            try {  
                return data.subList(first, first + pageSize);  
            }  
            catch(IndexOutOfBoundsException e) {  
                return data.subList(first, first + (dataSize % pageSize));  
            }  
        }  
        else {  
            return data;  
        }  
    }
	
}

class LazySorter implements Comparator<User> {

    private String sortField;
    
    private SortOrder sortOrder;
    
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
	public int compare(User user1, User user2) {
        try {
        	Field field = user1.getClass().getDeclaredField(this.sortField);
    		field.setAccessible(true);
            Object value1 = field.get(user1);
            Object value2 = field.get(user2);

            
			int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
        	e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    
}

