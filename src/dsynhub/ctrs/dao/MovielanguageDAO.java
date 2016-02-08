package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.MoviebranchBean;
import dsynhub.ctrs.bean.MovielanguageBean;
import dsynhub.ctrs.util.DBConnection;

public class MovielanguageDAO {

	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<MovielanguageBean> selectAdmin()
	{
		List<MovielanguageBean> list=new ArrayList<MovielanguageBean>();
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
				MovielanguageBean bean=new MovielanguageBean();
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
	
	public List<MovielanguageBean> selectMovie()
	{
		List<MovielanguageBean> list=new ArrayList<MovielanguageBean>();
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
				MovielanguageBean bean=new MovielanguageBean();
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
	public List<MovielanguageBean> selectLanguage()
	{
		List<MovielanguageBean> list=new ArrayList<MovielanguageBean>();
		conn=DBConnection.getConnection();
		String query="select * from language";
		try {
			
			pstmt=conn.prepareStatement(query);
			//pstmt.setString(1,"adminid");
			//pstmt.setString(2,"firstname");
			//pstmt.setString(3,"middlename");
			//pstmt.setString(4,"lastname");
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next())
			{
				MovielanguageBean bean=new MovielanguageBean();
				bean.setLanguageid(rs.getString("languageid"));
				bean.setLanguagename(rs.getString("languagename"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

}
	 public boolean insertData(MovielanguageBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into movielanguage values(seq_movielanguage.nextval,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getMovieid());
				pstmt.setString(2, bean.getLanguageid());
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
	 public List<MovielanguageBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<MovielanguageBean> list=new ArrayList<MovielanguageBean>();
		  String query="select ml.movielanguageid,mv.moviename,lg.languagename,ad.firstname,ad.lastname from movielanguage ml,movie mv,language lg,admin ad where ml.movieid=mv.movieid and ml.languageid=lg.languageid and ml.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			MovielanguageBean bean=null;
			while(rs.next())
			{
				bean=new MovielanguageBean();
            bean.setMovielanguageid(rs.getString("movielanguageid"));
			bean.setMoviename(rs.getString("moviename"));
			bean.setLanguagename(rs.getString("languagename"));
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
	 public boolean deleteData(String movielanguageid)
	 {
		 boolean flag=false;
	      conn=DBConnection.getConnection();
	      String query="delete from movielanguage where movielanguageid=?";
		try {
			 pstmt=conn.prepareStatement(query);
			pstmt.setString(1,movielanguageid);
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
  
	 public MovielanguageBean selectData(String movielanguageid)
		{
		    MovielanguageBean bean=null;
			conn=DBConnection.getConnection();
			String query="select ml.movielanguageid,mv.moviename,lg.languagename,ad.firstname,ad.lastname from movielanguage ml,movie mv,language lg,admin ad where ml.movieid=mv.movieid and ml.languageid=lg.languageid and ml.adminid=ad.adminid and movielanguageid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,movielanguageid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new MovielanguageBean();
					   bean.setMovielanguageid(rs.getString("movielanguageid"));
						bean.setMoviename(rs.getString("moviename"));
						bean.setLanguagename(rs.getString("languagename"));
						bean.setFirstname(rs.getString("firstname"));
						bean.setLastname(rs.getString("lastname"));
						
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
	 
	 public boolean updateData(MovielanguageBean bean)
	 {
		 boolean flag=false;
		 
         conn=DBConnection.getConnection();
         String query="update movielanguage set movieid=?,languageid=?,adminid=? where movielanguageid=?";
         try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,bean.getMovieid());
			pstmt.setString(2,bean.getLanguageid());
			pstmt.setString(3,bean.getAdminid());
			pstmt.setString(4,bean.getMovielanguageid());
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
