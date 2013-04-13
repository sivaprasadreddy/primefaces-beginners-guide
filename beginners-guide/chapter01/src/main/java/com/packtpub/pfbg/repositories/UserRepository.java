/**
 * 
 */
package com.packtpub.pfbg.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.packtpub.pfbg.model.User;

/**
 * @author Siva
 *
 */
public class UserRepository 
{
	private static AtomicInteger ID = new AtomicInteger(0);
	private static Map<Integer, User> TABLE = new HashMap<Integer, User>();
	
	private UserRepository() 
	{
	}
	static
	{
		User user1 = new User(1, "admin", "admin", "Administrator");
		User user2 = new User(2, "siva", "siva", "Siva Prasad");
		User user3 = new User(3, "test", "test", "Guest");
		TABLE.put(user1.getId(), user1);
		TABLE.put(user2.getId(), user2);
		TABLE.put(user3.getId(), user3);
	}
	
	public static User findUser(Integer id) {
		return TABLE.get(id);
	}
	
	public static List<User> findAllUsers() {
		return new ArrayList<User>(TABLE.values());
	}
	
	public static Integer insertUser(User user) {
		Integer id = ID.incrementAndGet();
		user.setId(id);
		TABLE.put(id, user);
		return id;
	}
	
	public static void updateUser(User user) {
		TABLE.put(user.getId(), user);
	}
	
	public static void deleteUser(Integer id) {
		TABLE.remove(id);
	}
}
