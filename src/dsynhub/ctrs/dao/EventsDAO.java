package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Severity;

import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.bean.StateBean;
import dsynhub.ctrs.util.DBConnection;

public class EventsDAO {

	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<EventsBean> selectAdmin()
	{
		List<EventsBean> list=new ArrayList<EventsBean>();
		conn=DBConnection.getConnection();
		String query="select * from admin";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				EventsBean bean=new EventsBean();
				bean.setAdminid(rs.getString("adminid"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setMiddlename(rs.getString("middlename"));
				bean.setLastname(rs.getString("lastname"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insertData(EventsBean bean)
	{
		boolean flag=false;
		conn=DBConnection.getConnection();
		String query="insert into events values(seq_events.nextval,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,bean.getEventname());
			pstmt.setString(2,bean.getEventinfo());
			pstmt.setString(3, bean.getEventprice());
			pstmt.setString(4,bean.getAdminid());
			int a=pstmt.executeUpdate();
			if(a!=0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public List<EventsBean> selectEvents()
	{
		List<EventsBean> list=new ArrayList<EventsBean>();
		conn=DBConnection.getConnection();
		String query="select ev.eventid,ev.eventname,ev.eventinfo,ev.eventprice,ev.adminid,ad.firstname,ad.lastname from events ev,admin ad where ev.adminid=ad.adminid";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				
				EventsBean bean=new EventsBean();
				bean.setEventid(rs.getString("eventid"));
				bean.setEventname(rs.getString("eventname"));
				bean.setEventprice(rs.getString("eventprice"));
				bean.setEventinfo(rs.getString("eventinfo"));
				bean.setAdminid(rs.getString("adminid"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setLastname(rs.getString("lastname"));
				
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean deleteEvent(String id)
	{
		boolean flag=false;
		 
	      Connection conn=DBConnection.getConnection();
	      String query="delete from events where eventid="+id;
		try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			int a=pstmt.executeUpdate();
			if(a!=0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public EventsBean editEvents(String eventid)
	{
		EventsBean bean=new EventsBean();
		conn=DBConnection.getConnection();
		String query="select ev.eventid,ev.eventname,ev.eventinfo,ev.eventprice,ev.adminid,ad.firstname,ad.lastname from events ev,admin ad where ev.adminid=ad.adminid and ev.eventid=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,eventid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean.setAdminid(rs.getString("adminid"));
				bean.setEventid(eventid);
				bean.setEventname(rs.getString("eventname"));
				bean.setEventinfo(rs.getString("eventinfo"));
				bean.setEventprice(rs.getString("eventprice"));
			    bean.setFirstname(rs.getString("firstname"));
			    bean.setLastname(rs.getString("lastname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	public boolean updateData(EventsBean bean)
	{
		boolean flag=false;
		conn=DBConnection.getConnection();
		String query="update events set eventname=?,eventinfo=?,eventprice=?,adminid=? where eventid=?";
		try {
			pstmt=conn.prepareCall(query);
			pstmt.setString(1,bean.getEventname());
			pstmt.setString(2,bean.getEventinfo());
			pstmt.setString(3, bean.getEventprice());
			pstmt.setString(4,bean.getAdminid());
			pstmt.setString(5, bean.getEventid());
			int a=pstmt.executeUpdate();
			if(a!=0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	
}
