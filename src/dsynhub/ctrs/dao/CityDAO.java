package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.bean.StateBean;
import dsynhub.ctrs.util.DBConnection;


public class CityDAO {
	Connection conn=null;
	PreparedStatement pstmt=null;
	  public List<CityBean> selectAdmin()
	  {
		  List<CityBean> list=new ArrayList<CityBean>();
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
					CityBean bean=new CityBean();
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
	 
	  
	  public List<CityBean> selectState()
	  {
		  List<CityBean> list=new ArrayList<CityBean>();
			conn=DBConnection.getConnection();
			String query="select * from state";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					CityBean bean=new CityBean();
					bean.setStateid(rs.getString("stateid"));
					bean.setStatename(rs.getString("statename"));
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	  }
	  
	  public boolean insertData(CityBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into city values(seq_city.nextval,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getCityname());
				pstmt.setString(2,bean.getStateid());
				pstmt.setString(3, bean.getAdminid());
				
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
	 
	  public List<CityBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<CityBean> list=new ArrayList<CityBean>();
		  String query="select ct.cityid,ct.cityname,ct.stateid,ct.adminid,ad.firstname,ad.lastname,st.statename from city ct,admin ad,state st where ct.stateid=st.stateid and ct.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			CityBean bean=null;
			while(rs.next())
			{
				bean=new CityBean();
				bean.setCityid(rs.getString("cityid"));
				bean.setCityname(rs.getString("cityname"));
				bean.setStateid(rs.getString("stateid"));
				bean.setAdminid(rs.getString("adminid"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setLastname(rs.getString("lastname"));
				bean.setStatename(rs.getString("statename"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	  }
	  
	  
	  public boolean deleteData(String cityid)
		 {
			 boolean flag=false;
		      Connection conn=DBConnection.getConnection();
		      String query="delete from city where cityid=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(query);
				pstmt.setString(1,cityid);
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
	  
	  public CityBean selectData(String cityid)
		 {
		      CityBean bean=null;
			 Connection conn=DBConnection.getConnection();
		      String query="select ct.cityid,ct.cityname,ct.stateid,ct.adminid,ad.firstname,ad.lastname,st.statename from city ct,admin ad,state st where ct.stateid=st.stateid and ct.adminid=ad.adminid and ct.cityid=?";
		      try {
				PreparedStatement pstmt=conn.prepareStatement(query);
				pstmt.setString(1,cityid);
				//pstmt.setString(2,"adminid");
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new CityBean();
					bean.setCityid(rs.getString("cityid"));
					bean.setCityname(rs.getString("cityname"));
					bean.setStateid(rs.getString("stateid"));
					bean.setAdminid(rs.getString("adminid"));
					bean.setFirstname(rs.getString("firstname"));
					bean.setLastname(rs.getString("lastname"));
					bean.setStatename(rs.getString("statename"));
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return bean;
		 }
	  
	  public boolean updateData(CityBean bean)
		 {
			 boolean flag=false;
			 
	         Connection conn=DBConnection.getConnection();
	         String query="update city set cityname=?,stateid=?,adminid=? where cityid=?";
	         try {
				PreparedStatement pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getCityname());
				pstmt.setString(2,bean.getStateid());
				pstmt.setString(3,bean.getAdminid());
				pstmt.setString(4,bean.getCityid());
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

