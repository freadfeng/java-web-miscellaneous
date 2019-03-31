package org.ffeng.miscellaneous.projects.badminton.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.ffeng.miscellaneous.projects.badminton.servlet.BadmintonDispatcherServlet;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(this.getClass().getName());
		Cookie cookie = new Cookie("myCookie", "TestONly");
		cookie.setSecure(true);
		response.addCookie(cookie);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			throw new Exception("Invalid username/password");
		}
		WebApplicationContext context = (WebApplicationContext) request.getAttribute(BadmintonDispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		BasicDataSource dataSource = context.getBean("badmintonDataSource", BasicDataSource.class);
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("show tables;");
		ResultSet resultset = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultset.getMetaData();

		for (int i = 0; i < metaData.getColumnCount(); i++) {
			String columnLabel = metaData.getColumnLabel(i+1);
			System.out.print(columnLabel + "\t");
		}
		while (resultset.next()) {
			System.out.println();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				String columnLabel = metaData.getColumnLabel(i+1);
				System.out.print(resultset.getString(columnLabel) + "\t");
			}
		}
		connection.close();
		// query users
		ModelAndView mv = new ModelAndView();
		mv.setViewName("badminton/index.jsp");
		return mv;
	}
}
