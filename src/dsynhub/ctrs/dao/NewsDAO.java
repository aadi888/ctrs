package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.bean.NewsBean;
import dsynhub.ctrs.util.DBConnection;

public class NewsDAO {

	
	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<NewsBean> selectAdmin()
	{
		List<NewsBean> list=new ArrayList<NewsBean>();
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
				NewsBean bean=new NewsBean();
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
	
	 public boolean insertData(NewsBean bean)
	 {
		 boolean flag=false;
         conn=DBConnection.getConnection();
        
		
         
         String query="insert into news values(seq_news.nextval,'"+bean.getNewstitle()+"',sysdate,'"+bean.getValidity()+"','"+bean.getAdminid()+"')";
         try {
		     Statement stmt=conn.createStatement();
		     int a=stmt.executeUpdate(query);
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
	 
	 public List<NewsBean> selectData()

	 {
		 List<NewsBean> list=new ArrayList<NewsBean>();
		 conn=DBConnection.getConnection();
		 String query="select ns.newsid,ns.newstitle,ns.datecreated,ns.validity,ns.adminid,ad.firstname,ad.lastname from news ns,admin ad where ns.adminid=ad.adminid";
		 try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
	       while(rs.next())
	       {
	    	   NewsBean bean=new NewsBean();
	    	   bean.setNewsid(rs.getString("newsid"));
	    	   bean.setNewstitle(rs.getString("newstitle"));
	    	   bean.setDatecreated(rs.getString("datecreated"));
	    	   bean.setValidity(rs.getString("validity"));
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
	 
	 public boolean deleteData(String hid)
	 {
		 boolean flag=false;
		 conn=DBConnection.getConnection();
		 
		 String query="delete from news where newsid=?";
		 try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,hid);
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
	 
	 public NewsBean selectData(String newsid)
	 {
		 NewsBean bean=null;
		 conn=DBConnection.getConnection();
		 String query="select ns.newsid,ns.newstitle,ns.datecreated,ns.validity,ns.adminid,ad.firstname,ad.lastname from news ns,admin ad where ns.adminid=ad.adminid and ns.newsid=?";
		 try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,newsid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new NewsBean();
				  bean.setNewsid(rs.getString("newsid"));
		    	   bean.setNewstitle(rs.getString("newstitle"));
		    	   bean.setDatecreated(rs.getString("datecreated"));
		    	   bean.setValidity(rs.getString("validity"));
		    	   bean.setAdminid(rs.getString("adminid"));
		    	   bean.setFirstname(rs.getString("firstname"));
		    	   bean.setLastname(rs.getString("lastname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return bean;
	 }
	 
	 public boolean updateData(NewsBean bean)
	 {
		 boolean flag=false;
		 conn=DBConnection.getConnection();
		 String query="update news set newstitle=?,validity=?,adminid=? where newsid=?";
		 try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,bean.getNewstitle());
			
			pstmt.setString(2,bean.getValidity());
			pstmt.setString(3,bean.getAdminid());
			pstmt.setString(4,bean.getNewsid());
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
