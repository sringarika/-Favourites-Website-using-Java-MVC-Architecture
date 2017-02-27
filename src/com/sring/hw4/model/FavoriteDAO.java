/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sring.hw4.DBManager;

public class FavoriteDAO implements IFavDAO {
	Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 PreparedStatement preparedStatement = null;
	@Override
	public boolean addfav(FavBean favb) throws SQLException {
		
		// TODO Auto-generated method stub
		try{
			
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "INSERT INTO `"+DBManager.dbname+"`.`"+DBManager.favtable+"` "
					+ "(`url`, `comment`, `user`) "
					+ "VALUES (?, ?, ?);"; 
			preparedStatement = con.prepareStatement(query);
			
			 preparedStatement.setString(1, favb.getUrl());
			 
			 preparedStatement.setString(2, favb.getComment());
			 preparedStatement.setInt(3, favb.getUserid());
			 try {
				if( preparedStatement.executeUpdate()!=0){
					return true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	@Override
	public List<FavBean> getAllFavByUserID(int userid) {
		// TODO Auto-generated method stub
		try{
			
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "SELECT `id`, `url`, `click`, `comment`, `user`  FROM `"+DBManager.dbname+"`.`"+DBManager.favtable+"` WHERE  `user`=? and `active`=1;"; 
			preparedStatement = con.prepareStatement(query);
			 preparedStatement.setInt(1, userid);
			 try {
				// Hashids hashids = new Hashids(DBManager.hashid_salt,8);
				 resultSet=preparedStatement.executeQuery();
				 List<FavBean> temp= new ArrayList<FavBean>();
				 while (resultSet.next()) {
					FavBean fb= new FavBean();
					fb.setId(resultSet.getInt("id"));
					fb.setHashid(resultSet.getString("id"));
					fb.setUserid(resultSet.getInt("user"));
					fb.setUrl(resultSet.getString("url"));
					fb.setComment(resultSet.getString("comment"));
					fb.setClick(resultSet.getInt("click"));
					temp.add(fb);
					fb=null;
				}
				 
				return temp;
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		
		
		return null;
	}

	@Override
	public boolean delFav(int favid,int userid) {
		// TODO Auto-generated method stub
try {
			
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "UPDATE `"+DBManager.dbname+"`.`"+DBManager.favtable+"` SET `active`='0' WHERE  `id`=? and `user`=?;"; 
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, favid);
			preparedStatement.setInt(2, userid);
			 try {
					if( preparedStatement.executeUpdate()!=0){
						return true;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateClick(int favid) {
		// TODO Auto-generated method stub
		
		//UPDATE `"+DBManager.dbname+"`.`"+DBManager.favtable+"` SET `click`=`click`+1 WHERE  `id`=?;
		try {
			
			con=DBManager.createConnection();
			statement = con.createStatement();
			String query = "UPDATE `"+DBManager.dbname+"`.`"+DBManager.favtable+"` SET `click`=`click`+1 WHERE  `id`=? ;"; 
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, favid);
			
			 try {
					if( preparedStatement.executeUpdate()!=0){
						return true;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}



}
