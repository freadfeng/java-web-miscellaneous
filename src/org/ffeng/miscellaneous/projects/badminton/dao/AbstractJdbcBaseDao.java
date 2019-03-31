/**
 * 
 */
package org.ffeng.miscellaneous.projects.badminton.dao;

import javax.sql.DataSource;

/**
 * @author ffeng
 * 
 *         Abstract base DAO offers DataSource for all subclass. Subclass can
 *         use getDataSource() to get the DataSource object, weather or not
 *         pooled depends on which implementation was injected.
 */
public abstract class AbstractJdbcBaseDao {
	private DataSource badmintonDataSource;

	public DataSource getBadmintonDataSource() {
		return badmintonDataSource;
	}

	public void setBadmintonDataSource(DataSource badmintonDataSource) {
		this.badmintonDataSource = badmintonDataSource;
	}

}
