package org.ffeng.miscellaneous.projects.badminton.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ffeng.miscellaneous.projects.badminton.bean.User;
import org.ffeng.miscellaneous.projects.badminton.logic.RegisterService;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RegisterController implements Controller {

	private RegisterService badmintonRegisterService;

	public void setBadmintonRegisterService(RegisterService badmintonRegisterService) {
		this.badmintonRegisterService = badmintonRegisterService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(this.getClass().getName());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new Exception("Invalid username/password");
		}
		User userProfile = null;
		if (request.getParameter("name") != null) {
			userProfile = new User();
			userProfile.setName(request.getParameter("name"));
		}
		badmintonRegisterService.registerUser(username, password, userProfile);
		// query users
		ModelAndView mv = new ModelAndView();
		mv.addObject(userProfile);
		mv.setViewName("badminton/index.jsp");
		System.out.println(userProfile);
		return mv;
	}
}
