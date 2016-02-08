package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.PaymentBean;
import dsynhub.ctrs.util.DBConnection;

public class PaymentDAO {

	
	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<PaymentBean> selectAdmin()
	{
		List<PaymentBean> list=new ArrayList<PaymentBean>();
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
				PaymentBean bean=new PaymentBean();
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
	
	  public boolean insertData(PaymentBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into payment values(seq_payment.nextval,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getPaymenttype());
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
	  
	  public List<PaymentBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<PaymentBean> list=new ArrayList<PaymentBean>();
		  String query="select pt.paymentid,pt.paymenttype,pt.adminid,ad.firstname,ad.lastname from payment pt,admin ad where pt.adminid=ad.adminid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			PaymentBean bean=null;
			while(rs.next())
			{
				bean=new PaymentBean();
				bean.setPaymentid(rs.getString("paymentid"));
				bean.setPaymenttype(rs.getString("paymenttype"));
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
	  
	  public boolean deleteData(String paymentid)
		 {
			 boolean flag=false;
		      conn=DBConnection.getConnection();
		      String query="delete from payment where paymentid=?";
			try {
				 pstmt=conn.prepareStatement(query);
				pstmt.setString(1,paymentid);
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
	  
	  public PaymentBean selectData(String paymentid)
		{
		  PaymentBean bean=null;
			conn=DBConnection.getConnection();
			String query="select pt.paymentid,pt.paymenttype,pt.adminid,ad.firstname,ad.lastname from payment pt,admin ad where pt.adminid=ad.adminid and pt.paymentid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,paymentid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new PaymentBean();
					bean.setPaymentid(rs.getString("paymentid"));
					bean.setPaymenttype(rs.getString("paymenttype"));
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
	  
	  public boolean updateData(PaymentBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update payment set paymenttype=?,adminid=? where paymentid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getPaymenttype());
				pstmt.setString(2,bean.getAdminid());
				pstmt.setString(3,bean.getPaymentid());
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
