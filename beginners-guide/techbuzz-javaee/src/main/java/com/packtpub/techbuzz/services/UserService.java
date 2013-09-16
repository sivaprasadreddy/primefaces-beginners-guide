package com.packtpub.techbuzz.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.packtpub.techbuzz.entities.User;

/**
 * @author Siva
 *
 */
@Stateless
public class UserService
{
	
	@PersistenceContext
	private EntityManager em;
	
	
	public User createUser(User t)
	{
		em.persist(t);
		return t;
	}

	
	public User findById(Integer key)
	{
		return em.find(User.class, key);
	}

	
	public List<User> findAll()
	{
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	
	public void update(User t)
	{
		em.merge(t);
	}

	
	public void delete(Integer key)
	{
		User user = findById(key);
		if(user != null)
		{
			em.remove(user);
		}
	}

	
	public User login(String loginId, String password)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.emailId=?1  and u.password=?2", User.class);
		query.setParameter(1, loginId);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if(!users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

	
	public User findByEmailId(String email)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.email_id=?1", User.class);
		query.setParameter(1, email);
		List<User> users = query.getResultList();
		if(!users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

	
	public User findByUserName(String userName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	
	public int changePassword(String loginId, String oldPwd, String newPwd)
	{
		return 0;
	}

}
