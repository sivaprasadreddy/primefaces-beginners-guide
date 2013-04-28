package com.packtpub.techbuzz.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository
{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User login(String userName, String pwd)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.userName=?1 and u.password=?2 and (u.disabled is null or u.disabled=0)", User.class);
		query.setParameter(1, userName);
		query.setParameter(2, pwd);
		List<User> list = query.getResultList();
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findByEmailId(String email)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.emailId=?1", User.class);
		query.setParameter(1, email);
		List<User> list = query.getResultList();
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findByUserName(String userName)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.userName=?1", User.class);
		query.setParameter(1, userName);
		List<User> list = query.getResultList();
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User createUser(User user)
	{
		em.persist(user);
		return user;
	}
	
	@Override
	public int changePwd(Integer userId, String oldPwd, String newPwd) {
		Query query = em.createQuery("update User u set u.password=?1 where u.userId=?2 and u.password=?3");
		query.setParameter(1, newPwd);
		query.setParameter(2, userId);
		query.setParameter(3, oldPwd);
		return query.executeUpdate();
	}
}
