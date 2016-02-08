package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.MoviebranchBean;
import dsynhub.ctrs.bean.ShowBean;
import dsynhub.ctrs.util.DBConnection;

public class ShowDAO {

	
	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<ShowBean> selectAdmin()
	{
		List<ShowBean> list=new ArrayList<ShowBean>();
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
				ShowBean bean=new ShowBean();
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
	
	public List<ShowBean> selectMovieBranch()
	{
		List<ShowBean> list=new ArrayList<ShowBean>();
		conn=DBConnection.getConnection();
		String query="select mb.moviebranchid,mb.movieid,mb.branchid,mv.moviename,br.branchname from moviebranch mb,movie mv,branch br where mb.movieid=mv.movieid and mb.branchid=br.branchid";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				ShowBean bean=new ShowBean();
				bean.setMoviebranchid(rs.getString("moviebranchid"));
				bean.setMovieid(rs.getString("movieid"));
				bean.setBranchid(rs.getString("branchid"));
				bean.setBranchname(rs.getString("branchname"));
				bean.setMoviename(rs.getString("moviename"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

}
	 public boolean insertData(ShowBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			
			String query="insert into show values(seq_show.nextval,?,?,?)";
			try {
				 pstmt=conn.prepareStatement(query);	
				
				pstmt.setString(1,bean.getShowdate());
				pstmt.setString(2,bean.getMoviebranchid());
				pstmt.setString(3,bean.getAdminid());
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
	  public List<ShowBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<ShowBean> list=new ArrayList<ShowBean>();
		  String query="select sw.showid,sw.showdate,sw.moviebranchid,sw.adminid,ad.firstname,ad.lastname,mv.moviename,br.branchname from show sw,moviebranch mb,admin ad,movie mv,branch br where sw.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid and sw.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			ShowBean bean=null;
			while(rs.next())
			{
				bean=new ShowBean();
                bean.setBranchname(rs.getString("branchname"));
				bean.setMoviename(rs.getString("moviename"));
                bean.setShowdate(rs.getString("showdate"));
                bean.setShowid(rs.getString("showid"));
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
	  public boolean deleteData(String showid)
		 {
			 boolean flag=false;
		      conn=DBConnection.getConnection();
		      String query="delete from show where showid=?";
			try {
				 pstmt=conn.prepareStatement(query);
				pstmt.setString(1,showid);
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
	  
	  public ShowBean selectData(String showid)
		{
		     ShowBean bean=null;
			conn=DBConnection.getConnection();
			String query="select sw.showid,sw.showdate,sw.moviebranchid,sw.adminid,ad.firstname,ad.lastname,mv.moviename,br.branchname from show sw,moviebranch mb,admin ad,movie mv,branch br where sw.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid and sw.adminid=ad.adminid and sw.showid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,showid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new ShowBean();
					bean.setMoviebranchid(rs.getString("moviebranchid"));
					bean.setAdminid(rs.getString("adminid"));
	                bean.setBranchname(rs.getString("branchname"));
					bean.setMoviename(rs.getString("moviename"));
	                bean.setShowdate(rs.getString("showdate"));
	                bean.setShowid(rs.getString("showid"));
	                bean.setFirstname(rs.getString("firstname"));
	                bean.setLastname(rs.getString("lastname"));
					
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
	  
	  public boolean updateData(ShowBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update show set showdate=?,moviebranchid=?,adminid=? where showid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getShowdate());
				pstmt.setString(2,bean.getMoviebranchid());
				pstmt.setString(3,bean.getAdminid());
				pstmt.setString(4,bean.getShowid());
				
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
