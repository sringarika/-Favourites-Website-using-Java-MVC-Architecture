/**
 * @author sringarikapandey
 * @date Dec 14
 * @course 08-672 A2 J2EE
 */
package com.sring.hw4.model;

public class FavBean {
		int id;
		String hashid;
		public String getHashid() {
			return hashid;
		}
		public void setHashid(String hashid) {
			this.hashid = hashid;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public int getClick() {
			return click;
		}
		public void setClick(int click) {
			this.click = click;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		int userid;
		String url;
		String comment;
		int click;
		int active;
}
