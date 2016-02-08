package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.MovieBean;
import dsynhub.ctrs.util.DBConnection;

public class MovieDAO {

	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<MovieBean> selectAdmin()
	{
		List<MovieBean> list=new ArrayList<MovieBean>();
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
				MovieBean bean=new MovieBean();
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
	
	 public boolean insertData(MovieBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into movie values(seq_movie.nextval,?,?,?,?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getMoviename());
				pstmt.setString(2,bean.getDirector());
				pstmt.setString(3,bean.getWriter());
				pstmt.setString(4,bean.getMusic());
				pstmt.setString(5,bean.getReleasedate());
				pstmt.setString(6,bean.getEnddate());
				pstmt.setString(7,bean.getAdminid());
			
				
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
	 
	 public List<MovieBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<MovieBean> list=new ArrayList<MovieBean>();
		  String query="select mv.movieid,mv.moviename,mv.director,mv.writer,mv.music,mv.releasedate,mv.enddate,mv.adminid,ad.firstname,ad.lastname from movie mv,admin ad where mv.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			MovieBean bean=null;
			while(rs.next())
			{
				bean=new MovieBean();
				bean.setMovieid(rs.getString("movieid"));
				bean.setMoviename(rs.getString("moviename"));
				bean.setDirector(rs.getString("director"));
				bean.setWriter(rs.getString("writer"));
				bean.setMusic(rs.getString("music"));
				bean.setReleasedate(rs.getString("releasedate"));
				bean.setEnddate(rs.getString("enddate"));
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
	 public boolean deleteData(String movieid)
	 {
		 boolean flag=false;
	      conn=DBConnection.getConnection();
	      String query="delete from movie where movieid=?";
		try {
			 pstmt=conn.prepareStatement(query);
			pstmt.setString(1,movieid);
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
	 
	 public MovieBean selectData(String movieid)
		{
		   MovieBean bean=null;
			conn=DBConnection.getConnection();
			String query="select mv.movieid,mv.moviename,mv.director,mv.writer,mv.music,mv.releasedate,mv.enddate,mv.adminid,ad.firstname,ad.lastname from movie mv,admin ad where mv.adminid=ad.adminid and mv.movieid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,movieid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new MovieBean();
					bean.setMovieid(rs.getString("movieid"));
					bean.setMoviename(rs.getString("moviename"));
					bean.setDirector(rs.getString("director"));
					bean.setWriter(rs.getString("writer"));
					bean.setMusic(rs.getString("music"));
					bean.setReleasedate(rs.getString("releasedate"));
					bean.setEnddate(rs.getString("enddate"));
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
  
	 
		
	  public boolean updateData(MovieBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update movie set moviename=?,director=?,writer=?,music=?,releasedate=?,enddate=?,adminid=? where movieid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getMoviename());
				pstmt.setString(2,bean.getDirector());
				pstmt.setString(3,bean.getWriter());
				pstmt.setString(4,bean.getMusic());
				pstmt.setString(5,bean.getReleasedate());
				pstmt.setString(6,bean.getEnddate());
				pstmt.setString(7,bean.getAdminid());
				pstmt.setString(8,bean.getMovieid());
				
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
