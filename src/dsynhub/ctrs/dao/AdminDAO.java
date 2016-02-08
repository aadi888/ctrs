package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.AdminBean;

import dsynhub.ctrs.util.DBConnection;

public class AdminDAO {

	
	
	
	Connection conn=null;
	Statement stmt=null;
	public boolean insertData(AdminBean bean)
	{
		boolean flag=false;
		
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			
			String query="insert into admin values(seq_admin.nextval,'"+bean.getEmailid()+"','"+bean.getPassword()+"','"+bean.getFirstname()+"','"+bean.getMiddlename()+"','"+bean.getLastname()+"','"+bean.getAddress()+"')";
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
	
	public List<AdminBean> selectData()
	{
		Connection conn=null;
		Statement stmt=null;
		List<AdminBean> list=new ArrayList<AdminBean>();
		conn=DBConnection.getConnection();
		try {
			stmt=conn.createStatement();
			String query="select * from admin";
			AdminBean bean=null;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				bean=new AdminBean();
				bean.setAdminid(rs.getString("adminid"));
				bean.setEmailid(rs.getString("emailid"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setMiddlename(rs.getString("middlename"));
				bean.setLastname(rs.getString("lastname"));
				bean.setAddress(rs.getString("address"));
				bean.setPassword(rs.getString("password"));
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
			String query="delete from admin where adminid="+id;
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
	
	public AdminBean selectData(String id)
	{
		AdminBean bean=new AdminBean();
		Connection conn=null;
		Statement stmt=null;
		conn=DBConnection.getConnection();
		try {
			stmt=conn.createStatement();
			String query="select emailid,password,firstname,middlename,lastname,address from admin where adminid="+id;
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				bean.setAdminid(id);
				bean.setEmailid(rs.getString("emailid"));
				bean.setPassword(rs.getString("password"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setMiddlename(rs.getString("middlename"));
				bean.setLastname(rs.getString("lastname"));
				bean.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	public boolean updateData(AdminBean bean)
	{
boolean flag=false;
		
		try {
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			String id=bean.getAdminid();
			
			String query="update admin set emailid='"+bean.getEmailid()+"',password='"+bean.getPassword()+"',firstname='"+bean.getFirstname()+"',middlename='"+bean.getMiddlename()+"',lastname='"+bean.getLastname()+"',address='"+bean.getAddress()+"' where adminid="+id;
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
