package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.bean.StateBean;
import dsynhub.ctrs.util.DBConnection;

public class StateDao {

	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public List<StateBean> selectAdmin()
	{
		List<StateBean> list=new ArrayList<StateBean>();
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
				StateBean bean=new StateBean();
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
	
	
	 public boolean insertState(String adminid,String statename)
	 {
		 boolean flag=false;
		 Connection conn=DBConnection.getConnection();
		 String query="insert into state values(seq_state.nextval,?,?)";
		 try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1,statename);
			pstmt.setString(2,adminid);
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
	 public List<StateBean> selectState()
		{
			List<StateBean> list=new ArrayList<StateBean>();
			conn=DBConnection.getConnection();
			String query="select st.adminid,st.stateid,st.statename,ad.firstname,ad.lastname from state st,admin ad where st.adminid=ad.adminid";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					StateBean bean=new StateBean();
					bean.setFirstname(rs.getString("firstname"));
					bean.setLastname(rs.getString("lastname"));
					bean.setAdminid(rs.getString("adminid"));
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
	 
	 public boolean deleteStateData(String stateid)
	 {
		 boolean flag=false;
	      Connection conn=DBConnection.getConnection();
	      String query="delete from state where stateid="+stateid;
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
	 public StateBean selectState(String stateid)
	 {
		 StateBean bean=new StateBean();
		 Connection conn=DBConnection.getConnection();
	      String query="select st.adminid,st.stateid,st.statename,ad.firstname,ad.lastname from state st,admin ad where st.adminid=ad.adminid and st.stateid=?";
	      try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"statename");
			//pstmt.setString(2,"adminid");
			pstmt.setString(1,stateid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				bean.setStateid(stateid);
				bean.setFirstname(rs.getString("firstname"));
				bean.setLastname(rs.getString("lastname"));
				bean.setAdminid(rs.getString("adminid"));
				bean.setStateid(rs.getString("stateid"));
				bean.setStatename(rs.getString("statename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return bean;
	 }
	 public boolean updateStateData(String stateid,String statename,String adminid)
	 {
		 boolean flag=false;
		 
         Connection conn=DBConnection.getConnection();
         String query="update state set statename=?,adminid=? where stateid="+stateid;
         try {
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1,statename);
			pstmt.setString(2,adminid);
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
	 
	 public List getAllStates() throws SQLException, Exception {

			Statement stmt = null;
			Connection con = null;
			ResultSet rs = null;
			List allStates = new ArrayList();
			StateBean stateBean = null;

			try {

				con = DBConnection.getConnection();

				if (con != null) {
					stmt = con.createStatement();
					String countryQuery = "SELECT * FROM state";
					System.out.println(countryQuery);
					rs = stmt.executeQuery(countryQuery);
					if (rs != null) {
						while (rs.next()) {
							stateBean = new StateBean();
							stateBean.setStateid(rs.getString("stateid"));
							stateBean.setStatename(rs.getString("statename"));
							allStates.add(stateBean);
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			}
			return allStates;
		}
}
