package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.ScreenBean;
import dsynhub.ctrs.util.DBConnection;

public class ScreenDAO {
 
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<ScreenBean> selectAdmin()
	{
		List<ScreenBean> list=new ArrayList<ScreenBean>();
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
				ScreenBean bean=new ScreenBean();
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
	
	public List<ScreenBean> selectShow()
	{
		List<ScreenBean> list=new ArrayList<ScreenBean>();
		conn=DBConnection.getConnection();
		String query="select sh.showid,sh.showdate,mv.moviename,br.branchname from show sh,movie mv,branch br,moviebranch mb where sh.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				ScreenBean bean=new ScreenBean();
			    bean.setShowid(rs.getString("showid"));
			    bean.setShowdate(rs.getString("showdate"));
			    bean.setMoviename(rs.getString("moviename"));
			    bean.setBranchname(rs.getString("branchname"));
				
				
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	  public boolean insertData(ScreenBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into screen values(seq_screen.nextval,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getScreenno());
				pstmt.setString(2, bean.getShowid());
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
	  
	  public List<ScreenBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<ScreenBean> list=new ArrayList<ScreenBean>();
		  String query="select sc.screenid,sc.screenno,sc.adminid,sc.showid,sh.showdate,sh.moviebranchid,mv.moviename,br.branchname,ad.firstname,ad.lastname from screen sc,show sh,moviebranch mb,admin ad,movie mv,branch br where sc.showid=sh.showid and sh.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid and sc.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			ScreenBean bean=null;
			while(rs.next())
			{
				bean=new ScreenBean();
				bean.setScreenid(rs.getString("screenid"));
				bean.setScreenno(rs.getString("screenno"));
				bean.setAdminid(rs.getString("adminid"));
				bean.setShowid(rs.getString("showid"));
				bean.setShowdate(rs.getString("showdate"));
				bean.setMoviename(rs.getString("moviename"));
				bean.setBranchname(rs.getString("branchname"));
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
	  public boolean deleteData(String screenid)
		 {
			 boolean flag=false;
		      conn=DBConnection.getConnection();
		      String query="delete from screen where screenid=?";
			try {
				 pstmt=conn.prepareStatement(query);
				pstmt.setString(1,screenid);
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
	  
	  public ScreenBean selectData(String screenid)
		{
		  ScreenBean bean=null;
			conn=DBConnection.getConnection();
			String query="select sc.screenid,sc.screenno,sc.adminid,sc.showid,sh.moviebranchid,sh.showdate,mv.moviename,br.branchname,ad.firstname,ad.lastname from screen sc,show sh,moviebranch mb,admin ad,movie mv,branch br where sc.showid=sh.showid and sh.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid and sc.adminid=ad.adminid and screenid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,screenid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new ScreenBean();
					bean.setScreenid(rs.getString("screenid"));
					bean.setScreenno(rs.getString("screenno"));
					bean.setAdminid(rs.getString("adminid"));
					bean.setShowid(rs.getString("showid"));
					bean.setShowdate(rs.getString("showdate"));
					bean.setMoviename(rs.getString("moviename"));
					bean.setBranchname(rs.getString("branchname"));
					bean.setFirstname(rs.getString("firstname"));
					bean.setLastname(rs.getString("lastname"));
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
	  
	  public boolean updateData(ScreenBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update screen set screenno=?,showid=?,adminid=? where screenid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getScreenno());
				pstmt.setString(2,bean.getShowid());
				pstmt.setString(3,bean.getAdminid());
				pstmt.setString(4,bean.getScreenid());
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
