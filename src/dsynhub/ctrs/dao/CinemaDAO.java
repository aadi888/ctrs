package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.util.DBConnection;

public class CinemaDAO {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<CinemaBean> selectAdmin()
	{
		List<CinemaBean> list=new ArrayList<CinemaBean>();
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
				CinemaBean bean=new CinemaBean();
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
	
	public List<CinemaBean> selectCity()
	{
		List<CinemaBean> list=new ArrayList<CinemaBean>();
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
				CinemaBean bean=new CinemaBean();
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

	  public boolean insertData(CinemaBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into cinema values(seq_cinema.nextval,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getCinemaname());
				pstmt.setString(2, bean.getCityid());
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
	  
	  public List<CinemaBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<CinemaBean> list=new ArrayList<CinemaBean>();
		  String query="select cn.cinemaid,cn.cinemaname,cn.cityid,cn.adminid,ad.firstname,ad.lastname,ct.cityname,st.statename from cinema cn,admin ad,city ct,state st where cn.adminid=ad.adminid and cn.cityid=ct.cityid and ct.stateid=st.stateid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			CinemaBean bean=null;
			while(rs.next())
			{
				bean=new CinemaBean();
				bean.setCinemaid(rs.getString("cinemaid"));
				bean.setCinemaname(rs.getString("cinemaname"));
				bean.setAdminid(rs.getString("adminid"));
				bean.setCityid(rs.getString("cityid"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setLastname(rs.getString("lastname"));
				bean.setCityname(rs.getString("cityname"));
				bean.setStatename(rs.getString("statename"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	  }
	  public boolean deleteData(String cinemaid)
		 {
			 boolean flag=false;
		      conn=DBConnection.getConnection();
		      String query="delete from cinema where cinemaid=?";
			try {
				 pstmt=conn.prepareStatement(query);
				pstmt.setString(1,cinemaid);
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
	  
	  public CinemaBean selectData(String cinemaid)
		{
			CinemaBean bean=null;
			conn=DBConnection.getConnection();
			String query="select cn.cinemaid,cn.cinemaname,cn.cityid,cn.adminid,ad.firstname,ad.lastname,ct.cityname from cinema cn,admin ad,city ct,state st where cn.adminid=ad.adminid and cn.cityid=ct.cityid and cn.cinemaid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,cinemaid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new CinemaBean();
					bean.setCinemaid(rs.getString("cinemaid"));
					bean.setCinemaname(rs.getString("cinemaname"));
					bean.setAdminid(rs.getString("adminid"));
					bean.setCityid(rs.getString("cityid"));
					bean.setFirstname(rs.getString("firstname"));
					bean.setLastname(rs.getString("lastname"));
					bean.setCityname(rs.getString("cityname"));
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
		
	  public boolean updateData(CinemaBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update cinema set cinemaname=?,cityid=?,adminid=? where cinemaid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getCinemaname());
				pstmt.setString(2,bean.getCityid());
				pstmt.setString(3,bean.getAdminid());
				pstmt.setString(4,bean.getCinemaid());
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

	  public boolean selectCity(String id)
		{
		    boolean flag=false;
			conn=DBConnection.getConnection();
			String query="select * from city where cityname=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1, id);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					if(rs.getString("cityname").equals(id))
					{
						flag=true;
					}
				}
				
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
	  public String selectCityid(String id)
		{
		    boolean flag=false;
			conn=DBConnection.getConnection();
			String cityid=null;
			String query="select * from city where cityname=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1, id);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					CityBean bean=new CityBean();
				  cityid=rs.getString("cityid");
				}
				
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cityid;
		}

}
