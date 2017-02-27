/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4.model;
import java.util.ArrayList;
import java.util.List;

import com.sring.hw4.BCrypt;
import com.sring.hw4.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class UserDAO implements IUserManagementDAO {
	Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 PreparedStatement preparedStatement = null;
	@Override
	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserBean> a= new ArrayList<UserBean>();
		con=DBManager.createConnection();
		try {
			
			statement = con.createStatement();
			String query = "SELECT * from  `"+DBManager.dbname+"`.`"+DBManager.usrtable+"` ;";
			preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) 
			 {
				String email1 = resultSet.getString("email"); 
				  String fname = resultSet.getString("fname");
				  String lname = resultSet.getString("lname");
				  UserBean usr= new UserBean();
				  usr.setId(resultSet.getInt("id"));
				  usr.setfName(fname);
				  usr.setlName(lname);
				  usr.setEmail(email1);
				a.add(usr);
				usr=null;
				
			 }
			if(a.size()>0)
			{
				return a;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserBean getUserByID(int id) {
		try {
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "SELECT `id`, `email`, `fname`, `lname` from  `"+DBManager.dbname+"`.`"+DBManager.usrtable+"` where `id`=? LIMIT 1;"; 
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) 
			 {
			 
				try {
				String email1 = resultSet.getString("email"); 
				  String fname = resultSet.getString("fname");
				  String lname = resultSet.getString("lname");
				  UserBean usr= new UserBean();
				  usr.setId(id);
				  usr.setfName(fname);
				  usr.setlName(lname);
				  usr.setEmail(email1);
				  return usr;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserBean getUserByEmail(String email) {
		try {
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "SELECT `id`, `email`, `fname`, `lname` from  `"+DBManager.dbname+"`.`"+DBManager.usrtable+"` where `email`=? LIMIT 1;"; 
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) 
			 {
			 
				try {
				String email1 = resultSet.getString("email"); 
				  String fname = resultSet.getString("fname");
				  String lname = resultSet.getString("lname");
				  int id = resultSet.getInt("id");
				  UserBean usr= new UserBean();
				  usr.setId(id);
				  usr.setfName(fname);
				  usr.setlName(lname);
				  usr.setEmail(email1);
				  return usr;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(UserBean usr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delUser(UserBean usr) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addUser(UserBean usr) throws SQLException {
		
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "INSERT INTO `"+DBManager.dbname+"`.`"+DBManager.usrtable+"` "
					+ "(`email`, `fname`, `lname`, `password`) "
					+ "VALUES (?, ?, ?, ?);"; 
			preparedStatement = con.prepareStatement(query);
			System.out.println(usr.getEmail());
			 preparedStatement.setString(1, usr.getEmail());
			 preparedStatement.setString(2, usr.getfName());
			 preparedStatement.setString(3, usr.getlName());
			 preparedStatement.setString(4, usr.getPass());
			 try {
				if( preparedStatement.executeUpdate()!=0){
					return true;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw e;
			}
		return false;
	}

	@Override
	public boolean checkUser(String username, String password) {
		try {
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "Select * from `"+DBManager.dbname+"`.`"+DBManager.usrtable+"` where `email`=?  and `active` = 1;"; 
			preparedStatement = con.prepareStatement(query);
			
			 preparedStatement.setString(1, username);
			 
			 
			 try {
				ResultSet rss=preparedStatement.executeQuery();
				rss.last();
				int temp=rss.getRow();
				System.out.println("LOGINNNNG::"+preparedStatement);
				if( temp>0 && BCrypt.checkpw(password, rss.getString("password"))){
					return true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changePass(String userid,String oldpass, String newpass) {
		// TODO Auto-generated method stub
		try {
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "UPDATE `"+DBManager.dbname+"`.`"+DBManager.usrtable+"` SET `password`=? WHERE  `id`=?;"; 
			preparedStatement = con.prepareStatement(query);
			
			 preparedStatement.setString(1,BCrypt.hashpw(newpass, BCrypt.gensalt()));
			 preparedStatement.setInt(2,  Integer.parseInt(userid));
			 int k=preparedStatement.executeUpdate();
			 if	(k>0)return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}

}
