package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.ScreenBean;
import dsynhub.ctrs.bean.SeatBean;
import dsynhub.ctrs.bean.ShowBean;
import dsynhub.ctrs.util.DBConnection;

public class SeatDAO {

	Connection conn=null;
	PreparedStatement pstmt=null;
	public List<SeatBean> selectAdmin()
	{
		List<SeatBean> list=new ArrayList<SeatBean>();
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
				SeatBean bean=new SeatBean();
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
	
	public List<SeatBean> selectScreen()
	{
		List<SeatBean> list=new ArrayList<SeatBean>();
		conn=DBConnection.getConnection();
		String query="select sc.screenid,sc.screenno,sh.showdate,mv.moviename,br.branchname,cn.cinemaname,ct.cityname,st.statename from screen sc,show sh,moviebranch mb,movie mv,branch br,cinema cn,city ct,state st where sc.showid=sh.showid and sh.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid and br.cinemaid=cn.cinemaid and cn.cityid=ct.cityid and ct.stateid=st.stateid";
		try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			SeatBean bean=null;
			while(rs.next())
			{
				bean=new SeatBean();
				bean.setScreenid(rs.getString("screenid"));
				bean.setScreenno(rs.getString("screenno"));
				bean.setShowdate(rs.getString("showdate"));
				bean.setMoviename(rs.getString("moviename"));
				bean.setBranchname(rs.getString("branchname"));
				bean.setCinemaname(rs.getString("cinemaname"));
				bean.setCityname(rs.getString("cityname"));
				bean.setStatename(rs.getString("statename"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return list;
	}
	public boolean insertData(SeatBean bean)
	{
		boolean flag=false;
		conn=DBConnection.getConnection();
		
		String query="insert into seat values(seq_seat.nextval,?,?,?)";
		try {
			 pstmt=conn.prepareStatement(query);	
			
			pstmt.setString(1,bean.getSeatno());
			pstmt.setString(2,bean.getScreenid());
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
	
	 public List<SeatBean> selectData()
	  {
		  conn=DBConnection.getConnection();
		  List<SeatBean> list=new ArrayList<SeatBean>();
		  String query="select se.seatid,se.seatno,se.screenid,se.adminid,ad.firstname,ad.lastname,sc.screenno,sh.showdate,mv.moviename,br.branchname,cn.cinemaname,ct.cityname,st.statename from seat se,screen sc,show sh,moviebranch mb,movie mv,branch br,cinema cn,city ct,state st,admin ad where se.adminid=ad.adminid and se.screenid=sc.screenid and sc.showid=sh.showid and sh.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid and br.cinemaid=cn.cinemaid and cn.cityid=ct.cityid and ct.stateid=st.stateid";
		  try {
			pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			SeatBean bean=null;
			while(rs.next())
			{
				bean=new SeatBean();
				bean.setSeatid(rs.getString("seatid"));
				bean.setSeatno(rs.getString("seatno"));
				bean.setScreenid(rs.getString("screenid"));
				bean.setAdminid(rs.getString("adminid"));
				bean.setFirstname(rs.getString("firstname"));
				bean.setLastname(rs.getString("lastname"));
				bean.setScreenno(rs.getString("screenno"));
				bean.setShowdate(rs.getString("showdate"));
				bean.setMoviename(rs.getString("moviename"));
				bean.setBranchname(rs.getString("branchname"));
				bean.setCinemaname(rs.getString("cinemaname"));
				bean.setCityname(rs.getString("cityname"));
				bean.setStatename(rs.getString("statename"));
                
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	  }
	 public boolean deleteData(String seatid)
	 {
		 boolean flag=false;
	      conn=DBConnection.getConnection();
	      String query="delete from seat where seatid=?";
		try {
			 pstmt=conn.prepareStatement(query);
			pstmt.setString(1,seatid);
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
	 
	 public SeatBean selectData(String seatid)
		{
		    SeatBean bean=null;
			conn=DBConnection.getConnection();
			String query="select se.seatid,se.seatno,se.screenid,se.adminid,ad.firstname,ad.lastname,sc.screenno,sh.showdate,mv.moviename,br.branchname,cn.cinemaname,ct.cityname,st.statename from seat se,screen sc,show sh,moviebranch mb,movie mv,branch br,cinema cn,city ct,state st,admin ad where se.adminid=ad.adminid and se.screenid=sc.screenid and sc.showid=sh.showid and sh.moviebranchid=mb.moviebranchid and mb.movieid=mv.movieid and mb.branchid=br.branchid and br.cinemaid=cn.cinemaid and cn.cityid=ct.cityid and ct.stateid=st.stateid and se.seatid=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,seatid);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new SeatBean();
					bean.setSeatid(rs.getString("seatid"));
					bean.setSeatno(rs.getString("seatno"));
					bean.setScreenid(rs.getString("screenid"));
					bean.setAdminid(rs.getString("adminid"));
					bean.setFirstname(rs.getString("firstname"));
					bean.setLastname(rs.getString("lastname"));
					bean.setScreenno(rs.getString("screenno"));
					bean.setShowdate(rs.getString("showdate"));
					bean.setMoviename(rs.getString("moviename"));
					bean.setBranchname(rs.getString("branchname"));
					bean.setCinemaname(rs.getString("cinemaname"));
					bean.setCityname(rs.getString("cityname"));
					bean.setStatename(rs.getString("statename"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
	 
	  public boolean updateData(SeatBean bean)
		 {
			 boolean flag=false;
			 
	         conn=DBConnection.getConnection();
	         String query="update seat set seatno=?,screenid=?,adminid=? where seatid=?";
	         try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getSeatno());
				pstmt.setString(2,bean.getScreenid());
				pstmt.setString(3,bean.getAdminid());
				pstmt.setString(4,bean.getSeatid());
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
