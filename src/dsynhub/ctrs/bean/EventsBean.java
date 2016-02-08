package dsynhub.ctrs.bean;

public class EventsBean {

	
	 String eventid;        
	 String eventname;      
	 String eventinfo;      
	 String eventprice;          
	 public String getEventprice() {
		return eventprice;
	}
	public void setEventprice(String eventprice) {
		this.eventprice = eventprice;
	}
	String adminid;
	 String firstname;
		String middlename;
		String lastname;
	public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getMiddlename() {
			return middlename;
		}
		public void setMiddlename(String middlename) {
			this.middlename = middlename;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventinfo() {
		return eventinfo;
	}
	public void setEventinfo(String eventinfo) {
		this.eventinfo = eventinfo;
	}
	
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}        
}
