package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.MoviebranchBean;
import dsynhub.ctrs.util.DBConnection;

public class MoviebranchDAO {

	
	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<MoviebranchBean> selectAdmin()
	{
		List<MoviebranchBean> list=new ArrayList<MoviebranchBean>();
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
				MoviebranchBean bean=new MoviebranchBean();
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
	
	public List<MoviebranchBean> selectMovie()
	{
		List<MoviebranchBean> list=new ArrayList<MoviebranchBean>();
		conn=DBConnection.getConnection();
		String query="select * from movie";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				MoviebranchBean bean=new MoviebranchBean();
				bean.setMovieid(rs.getString("movieid"));
				bean.setMoviename(rs.getString("moviename"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

}
	public List<MoviebranchBean> selectBranch()
	{
		List<MoviebranchBean> list=new ArrayList<MoviebranchBean>();
		conn=DBConnection.getConnection();
		String query="select * from branch";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				MoviebranchBean bean=new MoviebranchBean();
				bean.setBranchid(rs.getString("branchid"));
				bean.setBranchname(rs.getString("branchname"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

}
	

	  public boolean insertData(MoviebranchBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into moviebranch values(seq_moviebranch.nextval,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getMovieid());
				pstmt.setString(2, bean.getBranchid());
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
	  
	  public List<MoviebranchBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<MoviebranchBean> list=new ArrayList<MoviebranchBean>();
		  String query="select mb.moviebranchid,mv.moviename,br.branchname,ad.firstname,ad.lastname from moviebranch mb,movie mv,branch br,admin ad where mb.movieid=mv.movieid and mb.branchid=br.branchid and mb.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			MoviebranchBean bean=null;
			while(rs.next())
			{
				bean=new MoviebranchBean();
			bean.setMoviebranchid(rs.getString("moviebranchid"));
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
	 	  
	  public boolean deleteData(String moviebranchid)
		 {
			 boolean flag=false;
		      conn=DBConnection.getConnection();
		      String query="delete from moviebranch where moviebranchid=?";
			try {
				 pstmt=conn.prepareStatement(query);
				pstmt.setString(1,moviebranchid);
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
	  
	  public MoviebranchBean selectData(String moviebranchid)
		{
			MoviebranchBean bean=null;
			conn=DBConnection.getConnection();
			String query="select mb.moviebranchid,mv.moviename,br.branchname,ad.firstname,ad.lastname from moviebranch mb,movie mv,branch br,admin ad where mb.movieid=mv.movieid and mb.branchid=br.branchid and mb.adminid=ad.adminid and moviebranchid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,moviebranchid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new MoviebranchBean();
					bean.setMoviebranchid(rs.getString("moviebranchid"));
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
	  
	  public boolean updateData(MoviebranchBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update moviebranch set movieid=?,branchid=?,adminid=? where moviebranchid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getMovieid());
				pstmt.setString(2,bean.getBranchid());
				pstmt.setString(3,bean.getAdminid());
				pstmt.setString(4,bean.getMoviebranchid());
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
