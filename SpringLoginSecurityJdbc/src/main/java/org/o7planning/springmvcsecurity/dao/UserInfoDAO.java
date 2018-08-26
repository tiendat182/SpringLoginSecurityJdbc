/**
 * 
 */
package org.o7planning.springmvcsecurity.dao;

import java.util.List;

import org.o7planning.springmvcsecurity.model.UserInfo;

/**
 * @author DatLT
 *
 */
public interface UserInfoDAO {

	public UserInfo findUserInfo(String username);

	public List<String> getUserRoles(String username);
}
