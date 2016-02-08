package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.BranchBean;
import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.LanguageBean;
import dsynhub.ctrs.util.DBConnection;

public class LanguageDAO {

	
	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<LanguageBean> selectAdmin()
	{
		List<LanguageBean> list=new ArrayList<LanguageBean>();
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
				LanguageBean bean=new LanguageBean();
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
	
	public boolean insertData(LanguageBean bean)
	{
		boolean flag=false;
		conn=DBConnection.getConnection();
		String query="insert into language values(seq_language.nextval,?,?)";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,bean.getLanguagename());
			pstmt.setString(2, bean.getAdminid());
			
			
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
	
	 public List<LanguageBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<LanguageBean> list=new ArrayList<LanguageBean>();
		  String query="select lg.languageid,lg.languagename,ad.adminid,ad.firstname,ad.lastname from language lg,admin ad where lg.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			LanguageBean bean=null;
			while(rs.next())
			{
				bean=new LanguageBean();
				bean.setAdminid(rs.getString("adminid"));
				bean.setLanguageid(rs.getString("languageid"));
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
	 
	 public boolean deleteData(String languageid)
	 {
		 boolean flag=false;
	      conn=DBConnection.getConnection();
	      String query="delete from language where languageid=?";
		try {
			 pstmt=conn.prepareStatement(query);
			pstmt.setString(1,languageid);
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
	 
	  public LanguageBean selectData(String languageid)
		{
			LanguageBean bean=null;
			conn=DBConnection.getConnection();
			String query="select lg.languageid,lg.languagename,ad.adminid,ad.firstname,ad.lastname from language lg,admin ad where lg.adminid=ad.adminid and lg.languageid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,languageid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new LanguageBean();
					bean.setAdminid(rs.getString("adminid"));
				    bean.setFirstname(rs.getString("firstname"));
				    bean.setLastname(rs.getString("lastname"));
				    bean.setLanguageid(rs.getString("languageid"));
				    bean.setLanguagename(rs.getString("languagename"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
	  public boolean updateData(LanguageBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update language set languagename=?,adminid=? where languageid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getLanguagename());
				pstmt.setString(2,bean.getAdminid());
				pstmt.setString(3,bean.getLanguageid());
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
