package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import dsynhub.ctrs.bean.StateBean;
import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.util.DBConnection;

public class UserdetailsDAO {

	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public List<UserdetailsBean> selectCity()
	{
		List<UserdetailsBean> list=new ArrayList<UserdetailsBean>();
		conn=DBConnection.getConnection();
		String query="select * from city";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				UserdetailsBean bean=new UserdetailsBean();
				bean.setCityid(rs.getString("cityid"));
				bean.setCityname(rs.getString("cityname"));
				
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insertData(UserdetailsBean bean)
	{
		
		boolean flag=false;
		conn=DBConnection.getConnection();
		String query="insert into userdetails values(seq_userdetails.nextval,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1,bean.getName());
			pstmt.setString(2,bean.getEmail());
			pstmt.setString(3,bean.getPassword());
			pstmt.setString(4,bean.getGender());
			pstmt.setString(5,bean.getMobilenumber());
			pstmt.setString(6,bean.getCityid());
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
	
	public List<UserdetailsBean> selectData()
	{
		List<UserdetailsBean> list=new ArrayList<UserdetailsBean>();
		conn=DBConnection.getConnection();
		String query="select ud.userid,ud.name,ud.email,ud.password,ud.gender,ud.mobilenumber,ud.cityid,ct.cityname from userdetails ud,city ct where ud.cityid=ct.cityid";
		try {
			pstmt=conn.prepareStatement(query);
			
			UserdetailsBean bean=null;
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean=new UserdetailsBean();
				bean.setCityid(rs.getString("cityid"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setGender(rs.getString("gender"));
				bean.setMobilenumber(rs.getString("mobilenumber"));
				bean.setUserid(rs.getString("userid"));
				bean.setCityname(rs.getString("cityname"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean deleteData(String userid)
	{
		boolean flag=false;
		conn=DBConnection.getConnection();
		String query="delete from userdetails where userid=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,userid);
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
	public UserdetailsBean selectData(String userid)
	{
		UserdetailsBean bean=new UserdetailsBean();
		conn=DBConnection.getConnection();
		String query="select ud.userid,ud.name,ud.email,ud.password,ud.gender,ud.mobilenumber,ud.cityid,ct.cityname from userdetails ud,city ct where ud.cityid=ct.cityid and ud.userid=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,userid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean.setUserid(userid);
				bean.setCityid(rs.getString("cityid"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setGender(rs.getString("gender"));
				bean.setMobilenumber(rs.getString("mobilenumber"));
				bean.setUserid(rs.getString("userid"));
				bean.setCityname(rs.getString("cityname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	public boolean updateData(UserdetailsBean bean)
	{
		boolean flag=false;
		conn=DBConnection.getConnection();
		String query="update userdetails set name=?,email=?,gender=?,mobilenumber=?,cityid=? where userid=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,bean.getName());
			pstmt.setString(2,bean.getEmail());
			pstmt.setString(3,bean.getGender());
			pstmt.setString(4,bean.getMobilenumber());
			pstmt.setString(5,bean.getCityid());
			pstmt.setString(6,bean.getUserid());
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
	
	public UserdetailsBean selectInfo(String id)
	{
		UserdetailsBean bean=null;
		Connection conn=null;
		Statement stmt=null;
	
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			
			String query="select  ud.NAME,ud.EMAIL,ud.MOBILENUMBER,ct.CITYNAME from userdetails ud,city ct where ud.cityid=ct.cityid and userid="+id;
			ResultSet rs=stmt.executeQuery(query);
			 bean=new UserdetailsBean();
			while(rs.next())
			{
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setMobilenumber(rs.getString("mobilenumber"));
				bean.setCityname(rs.getString("cityname"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	public String selectId(String email)
	{
		String id=null;
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			String query="select userid from userdetails where email="+"'"+email+"'";
			
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				id=rs.getString("userid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
}
