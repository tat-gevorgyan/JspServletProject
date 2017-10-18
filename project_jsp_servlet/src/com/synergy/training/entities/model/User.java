package com.synergy.training.entities.model;

import com.synergy.training.entities.Holder;

/**
 * Created by Hilda on 10/15/2017.
 */
public class User extends Entity{

	private final String username;
 	private final String password;

 	public User(int id, String username, String password) {
		super(id);
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public static boolean findUser(String username, String password) {
 		for(User user: Holder.getUsers()) {
 			if(user.getPassword().equals(password) && user.getUsername().equals(username)) {
 				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "username='" + username + "\n" + " password='" + password + "\n";
	}
}
