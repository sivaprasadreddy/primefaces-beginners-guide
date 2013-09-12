/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.io.Serializable;
import java.util.List;

/**
 * @author skatam
 *
 */
public interface GenericRepository<PK extends Serializable, T> 
{

	public T create(T t);
	
	public T findById(PK key);
	
	public List<T> findAll();
	
	public void update(T t);
	
	public void delete(PK key);
	
	//public void delete(T t);
	
}
