/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4.model;

import java.sql.SQLException;
import java.util.List;

public interface IUserManagementDAO {
	public boolean addUser(UserBean usr) throws SQLException;
	 public List<UserBean> getAllUsers();
	   public UserBean getUserByID(int id);
	   public UserBean getUserByEmail(String email);
	   public void updateUser(UserBean usr);
	   public void delUser(UserBean usr);
	   public boolean checkUser(String username, String password);
	   public boolean changePass(String userid,String oldpass, String newpass);
}
