/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBManager {
	public static String dbname="test";
	public static String usrtable="sringarp_user";
	public static String favtable="sringarp_favorite";
	static boolean first_run=true;
	public static String hashid_salt="sringisalt";
	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/?useSSL=false";
		String username = "";
		String password = "";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");

			} catch (Exception e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(url, username, password);
			java.sql.Statement statement = con.createStatement(); 
			try {
				if(first_run){
					statement.executeUpdate("CREATE DATABASE IF NOT EXISTS `test`;");
					String usertablecreate="CREATE TABLE IF NOT EXISTS `"+dbname+"`.`"+usrtable+"` (`id` INT(11) NOT NULL AUTO_INCREMENT,`email` VARCHAR(200) NOT NULL,`fname` TINYTEXT NOT NULL,`lname` TINYTEXT NOT NULL,`password` VARCHAR(500) NOT NULL,`ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,`update_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,`active` TINYINT(1) UNSIGNED NULL DEFAULT '1',PRIMARY KEY (`id`),UNIQUE INDEX `email` (`email`)) COLLATE='utf8_general_ci' ENGINE=InnoDB AUTO_INCREMENT=9;";
					statement.executeUpdate(usertablecreate);

					String favtablecreate="CREATE TABLE IF NOT EXISTS `"+dbname+"`.`"+favtable+"` (`id` INT(11) NOT NULL AUTO_INCREMENT,`url` VARCHAR(500) NOT NULL DEFAULT '0',`click` INT(10) UNSIGNED NULL DEFAULT '0',`comment` VARCHAR(500) NULL DEFAULT NULL,`user` INT(11) NOT NULL DEFAULT '0',`active` TINYINT(1) NULL DEFAULT '1',`ts` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,`update_ts` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,PRIMARY KEY (`id`),INDEX `user` (`user`),CONSTRAINT `userid` FOREIGN KEY (`user`) REFERENCES `"+dbname+"`.`"+usrtable+"` (`id`) ON UPDATE CASCADE ON DELETE CASCADE) COLLATE='utf8_general_ci' ENGINE=InnoDB AUTO_INCREMENT=8;";
					statement.executeUpdate(favtablecreate);
					String query="INSERT INTO `"+dbname+"`.`"+usrtable+"` (`email`, `fname`, `lname`, `password`) VALUES ('sringarika@cmu.edu', 'sringarika', 'pandey', '$2a$10$l7rRB/hwnSVdF2TfGfeREuB40YahqeHzxfltB/G8zwDADjF0Czo0S' );";
					statement.executeUpdate(query);
					 query="INSERT INTO `"+dbname+"`.`"+usrtable+"` (`email`, `fname`, `lname`, `password`) VALUES ('john@cmu.edu', 'john', 'doe', '$2a$10$l7rRB/hwnSVdF2TfGfeREuB40YahqeHzxfltB/G8zwDADjF0Czo0S' );";
					statement.executeUpdate(query);
					 query="INSERT INTO `"+dbname+"`.`"+usrtable+"` (`email`, `fname`, `lname`, `password`) VALUES ('aakash@cmu.edu', 'aakash', 'tewari', '$2a$10$l7rRB/hwnSVdF2TfGfeREuB40YahqeHzxfltB/G8zwDADjF0Czo0S' );";
					statement.executeUpdate(query);
					query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://google.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'sringarika@cmu.edu'));";
					statement.executeUpdate(query);
					query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://yahoo.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'sringarika@cmu.edu'));";
					statement.executeUpdate(query);
					query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://msn.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'sringarika@cmu.edu'));";
					statement.executeUpdate(query);
					query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://aol.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'sringarika@cmu.edu'));";
					statement.executeUpdate(query);
					query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://facebook.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'john@cmu.edu'));";
					statement.executeUpdate(query);query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://instagram.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'john@cmu.edu'));";
					statement.executeUpdate(query);query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://snapchat.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'john@cmu.edu'));";
					statement.executeUpdate(query);query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://plus.google.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'john@cmu.edu'));";
					statement.executeUpdate(query);query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://hp.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'aakash@cmu.edu'));";
					statement.executeUpdate(query);query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://dell.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'aakash@cmu.edu'));";
					statement.executeUpdate(query);query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://amd.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'aakash@cmu.edu'));";
					statement.executeUpdate(query);query="INSERT INTO `"+dbname+"`.`"+favtable+"` (`url`, `user`) VALUES ('http://intel.com', (select `id`  from `"+dbname+"`.`"+usrtable+"` where `email` = 'aakash@cmu.edu'));";
					statement.executeUpdate(query);
					
					
					
					first_run=false;
				}
				
			} catch (Exception e) {
				first_run=false;
				e.printStackTrace();
				statement=null;
				//return null;
				
			}
			statement=null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}