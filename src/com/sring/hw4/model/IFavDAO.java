/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4.model;

import java.sql.SQLException;
import java.util.List;

public interface IFavDAO {
	public boolean addfav(FavBean favb) throws SQLException;
	public List<FavBean> getAllFavByUserID(int userid);
	public boolean delFav(int favid,int userid);

	public boolean updateClick(int favid);
}
