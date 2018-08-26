/**
 * 
 */
package org.o7planning.springmvcsecurity.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.o7planning.springmvcsecurity.dao.UserInfoDAO;
import org.o7planning.springmvcsecurity.mapper.UserInfoMapper;
import org.o7planning.springmvcsecurity.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author DatLT
 *
 */
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO {

	@Autowired
	public UserInfoDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}


	@Override
	public UserInfo findUserInfo(String username) {
		String sql = "select u.username,"
				+ "u.password from Users u where u.username = ?";
		Object[] params = new Object[] { username };
		UserInfoMapper mapper = new UserInfoMapper();
		try {
			UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return userInfo;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}


	@Override
	public List<String> getUserRoles(String username) {
		String sql = "Select r.User_Role "//
				+ " from User_Roles r where r.Username = ? ";

		Object[] params = new Object[] { username };

		List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);

		return roles;
	}

}
