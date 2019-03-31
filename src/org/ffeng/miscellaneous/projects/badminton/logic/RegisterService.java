package org.ffeng.miscellaneous.projects.badminton.logic;

import org.ffeng.miscellaneous.projects.badminton.bean.User;

public interface RegisterService {
	/**
	 * * Verify the the user identified by username and password
	 * 
	 * @param username    refer to user_credential.username
	 * @param password    refer to user_credential.password
	 * @param userProfile nullable
	 * @return The User identified by the username and password
	 * @throws Exception
	 */
	
	public User registerUser(String username, String password, User userProfile) throws Exception;

	/**
	 * Check user credential username/password, and return the User object as the
	 * profile.
	 * 
	 * @param username refer to user_credential.username
	 * @param password refer to user_credential.password
	 * @return User object as the user profile, or null if not authenticated.
	 * @throws Exception
	 */
	public User login(String username, String password) throws Exception;
}
