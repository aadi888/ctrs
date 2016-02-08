package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.BranchBean;
import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.util.DBConnection;

public class BranchDAO {

	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<BranchBean> selectAdmin()
	{
		List<BranchBean> list=new ArrayList<BranchBean>();
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
				BranchBean bean=new BranchBean();
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
	
	public List<BranchBean> selectCinema()
	{
		List<BranchBean> list=new ArrayList<BranchBean>();
		conn=DBConnection.getConnection();
		String query="select * from cinema";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				BranchBean bean=new BranchBean();
				bean.setCinemaid(rs.getString("cinemaid"));
				bean.setCinemaname(rs.getString("cinemaname"));
				list.add(bean);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	 public boolean insertData(BranchBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into branch values(seq_branch.nextval,?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getBranchname());
				pstmt.setString(2, bean.getBranchaddress());
				pstmt.setString(3, bean.getCinemaid());
				pstmt.setString(4, bean.getAdminid());
				
				
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
	  public List<BranchBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<BranchBean> list=new ArrayList<BranchBean>();
		  String query="select br.branchid,br.branchname,br.branchaddress,br.cinemaid,br.adminid,cn.cinemaname,ad.firstname,ad.lastname from branch br,cinema cn,admin ad where br.cinemaid=cn.cinemaid and br.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			BranchBean bean=null;
			while(rs.next())
			{
				bean=new BranchBean();
				bean.setBranchid(rs.getString("branchid"));
				bean.setBranchname(rs.getString("branchname"));
				bean.setBranchaddress(rs.getString("branchaddress"));
				bean.setAdminid(rs.getString("adminid"));
				bean.setCinemaid(rs.getString("cinemaid"));
				bean.setCinemaname(rs.getString("cinemaname"));
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
	  
	  public boolean deleteData(String branchid)
		 {
			 boolean flag=false;
		      conn=DBConnection.getConnection();
		      String query="delete from branch where branchid=?";
			try {
				 pstmt=conn.prepareStatement(query);
				pstmt.setString(1,branchid);
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
	
	  public BranchBean selectData(String branchid)
		{
			BranchBean bean=null;
			conn=DBConnection.getConnection();
			String query="select br.branchid,br.branchname,br.branchaddress,br.cinemaid,br.adminid,cn.cinemaname,ad.firstname,ad.lastname from branch br,cinema cn,admin ad where br.cinemaid=cn.cinemaid and br.adminid=ad.adminid and br.branchid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,branchid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new BranchBean();
				
					bean.setBranchid(rs.getString("branchid"));
					bean.setBranchname(rs.getString("branchname"));
					bean.setBranchaddress(rs.getString("branchaddress"));
					bean.setAdminid(rs.getString("adminid"));
					bean.setCinemaid(rs.getString("cinemaid"));
					bean.setCinemaname(rs.getString("cinemaname"));
					bean.setFirstname(rs.getString("firstname"));
					bean.setLastname(rs.getString("lastname"));
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
	  
	  public boolean updateData(BranchBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update branch set branchname=?,branchaddress=?,cinemaid=?,adminid=? where branchid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getBranchname());
				pstmt.setString(2,bean.getBranchaddress());
				pstmt.setString(3,bean.getCinemaid());
				pstmt.setString(4,bean.getAdminid());
				pstmt.setString(5,bean.getBranchid());
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
