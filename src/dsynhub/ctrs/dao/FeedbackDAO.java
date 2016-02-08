package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import dsynhub.ctrs.bean.FeedbackBean;
import dsynhub.ctrs.util.DBConnection;

public class FeedbackDAO {

	
	
	
	Connection conn=null;
	Statement stmt=null;
	public boolean insertData(FeedbackBean bean)
	{
		boolean flag=false;
		
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			
			String query="insert into feedback values(seq_feedback.nextval,'"+bean.getEmailid()+"','"+bean.getMsg()+"')";
			int a=stmt.executeUpdate(query);
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
	
	public List<FeedbackBean> selectData()
	{
		Connection conn=null;
		Statement stmt=null;
		List<FeedbackBean> list=new ArrayList<FeedbackBean>();
		conn=DBConnection.getConnection();
		try {
			stmt=conn.createStatement();
			String query="select * from feedback";
			FeedbackBean bean=null;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				bean=new FeedbackBean();
				bean.setFeedbackid(rs.getString("feedbackid"));
				bean.setEmailid(rs.getString("emailid"));
				bean.setMsg(rs.getString("msg"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean deleteData(String id)
	{
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		conn=DBConnection.getConnection();
		try {
			stmt=conn.createStatement();
			String query="delete from feedback where feedbackid="+id;
			int a=stmt.executeUpdate(query);
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
	
	public FeedbackBean selectData(String id)
	{
		FeedbackBean bean=new FeedbackBean();
		Connection conn=null;
		Statement stmt=null;
		conn=DBConnection.getConnection();
		try {
			stmt=conn.createStatement();
			String query="select emailid,msg from feedback where feedbackid="+id;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				bean.setFeedbackid(id);
				bean.setEmailid(rs.getString("emailid"));
				bean.setMsg(rs.getString("msg"));
                  			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	public boolean updateData(FeedbackBean bean)
	{
boolean flag=false;
		
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			String id=bean.getFeedbackid();
			
			String query="update feedback set emailid='"+bean.getEmailid()+"',msg='"+bean.getMsg()+"' where feedbackid="+id;
			int a=stmt.executeUpdate(query);
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