package org.ffeng.miscellaneous.projects.badminton.logic.impl;

import org.ffeng.miscellaneous.projects.badminton.bean.User;
import org.ffeng.miscellaneous.projects.badminton.dao.RegisterDao;
import org.ffeng.miscellaneous.projects.badminton.logic.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	private RegisterDao badmintonRegisterDao;

	public RegisterDao getBadmintonRegisterDao() {
		return badmintonRegisterDao;
	}

	public void setBadmintonRegisterDao(RegisterDao badmintonRegisterDao) {
		this.badmintonRegisterDao = badmintonRegisterDao;
	}

	@Override
	public User registerUser(String username, String password, User userProfile) throws Exception {
		badmintonRegisterDao.saveUserWithCredential(username, password, userProfile);
		return userProfile;
	}

	@Override
	public User login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
