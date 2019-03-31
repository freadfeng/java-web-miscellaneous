package org.ffeng.miscellaneous.projects.badminton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.ffeng.miscellaneous.common.database.DatabaseUtil;
import org.ffeng.miscellaneous.common.random.UuidUtil;
import org.ffeng.miscellaneous.projects.badminton.bean.User;

public class RegisterDao extends AbstractJdbcBaseDao {

	public void saveUserWithCredential(String username, String password, User userProfile) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		String userSql = "insert into user(id, name) values(?, ?)";
		String credentialSql = "insert into user_credential(id, user_id, username, password) values(?, ?, ?, ?)";
		String userId = null;
		try {
			connection = getBadmintonDataSource().getConnection();
			if(userProfile != null) {
				userId = UuidUtil.generateUUID();
				statement = connection.prepareStatement(userSql);
				statement.setString(1, userId);
				statement.setString(2, userProfile.getName());
				statement.execute();
				userProfile.setId(userId);
			}
			
			statement = connection.prepareStatement(credentialSql);
			statement.setString(1, UuidUtil.generateUUID());
			statement.setString(2, userId);
			statement.setString(3, username);
			statement.setString(4, password);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.closeIgnoreException(connection);
		}
	}
}
