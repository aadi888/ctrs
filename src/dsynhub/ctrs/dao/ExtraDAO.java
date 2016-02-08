package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.AdminBean;
import dsynhub.ctrs.bean.BookingBean;
import dsynhub.ctrs.bean.BranchBean;
import dsynhub.ctrs.bean.CinemaBean;
import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.bean.EventBean;
import dsynhub.ctrs.bean.EventsBean;
import dsynhub.ctrs.bean.FeedbackBean;
import dsynhub.ctrs.bean.MovieBean;
import dsynhub.ctrs.bean.MovielanguageBean;
import dsynhub.ctrs.bean.NewsBean;
import dsynhub.ctrs.bean.PaymentBean;
import dsynhub.ctrs.bean.UserdetailsBean;
import dsynhub.ctrs.util.DBConnection;

public class ExtraDAO {
	Connection conn=null;
	PreparedStatement pstmt=null;
	  public List<MovielanguageBean> selectMovie(String cityid)
	  {
		  List<MovielanguageBean> list=new ArrayList<MovielanguageBean>();
			conn=DBConnection.getConnection();
			String query="select ml.movieid,ml.movielanguageid,mv.moviename,lg.languagename from movielanguage ml,movie mv,language lg,moviebranch mb,branch br,cinema cn,city ct where ct.cityid=cn.cityid and cn.cinemaid=br.cinemaid and br.branchid(+)=mb.branchid and mb.movieid=ml.movieid and ml.movieid=mv.movieid and ml.languageid=lg.languageid and ct.cityid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1, cityid);
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					MovielanguageBean bean=new MovielanguageBean();
					bean.setMovielanguageid(rs.getString("movielanguageid"));
					bean.setMoviename(rs.getString("moviename"));
					bean.setLanguagename(rs.getString("languagename"));
					bean.setMovieid(rs.getString("movieid"));
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	  }
	  public List<NewsBean> selectNews()
	  {
		  List<NewsBean> list=new ArrayList<NewsBean>();
			conn=DBConnection.getConnection();
			String query="select newstitle from news";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					NewsBean bean=new NewsBean();
					bean.setNewstitle(rs.getString("newstitle"));
				
					
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	  }
	  public MovieBean selectMovieData(String id)
	  {
		  //List<MovieBean> list=new ArrayList<MovieBean>();
		  MovieBean bean=new MovieBean();
			conn=DBConnection.getConnection();
			String query="select mv.movieid,mv.moviename,mv.director,mv.writer,mv.music,mv.releasedate,lg.languagename from movie mv,movielanguage ml,language lg where mv.movieid=ml.movieid and ml.languageid=lg.languageid and moviename=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1,id);
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					bean.setMovieid(rs.getString("movieid"));
					bean.setMoviename(rs.getString("moviename"));
					bean.setDirector(rs.getString("director"));
					bean.setWriter(rs.getString("writer"));
					bean.setMusic(rs.getString("music"));
					bean.setReleasedate(rs.getString("releasedate"));
					bean.setLanguagename(rs.getString("languagename"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
	  }
	  
	  public List<EventsBean> selectEvents()
		{
			List<EventsBean> list=new ArrayList<EventsBean>();
			conn=DBConnection.getConnection();
			String query="select eventid,eventname,eventinfo,eventprice from events";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					EventsBean bean=new EventsBean();
					bean.setEventid(rs.getString("eventid"));
					bean.setEventname(rs.getString("eventname"));
					bean.setEventprice(rs.getString("eventprice"));
					bean.setEventinfo(rs.getString("eventinfo"));
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}

	  
	  public List<BranchBean> selectCinema(String cityid)
		{
			List<BranchBean> list=new ArrayList<BranchBean>();
			conn=DBConnection.getConnection();
			String query="select cn.cinemaid,cn.cinemaname,br.branchname,br.branchaddress from cinema cn,city ct,branch br where ct.cityid=cn.cityid and cn.cinemaid=br.cinemaid and ct.cityid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1, cityid);
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					BranchBean bean=new BranchBean();
					bean.setCinemaid(rs.getString("cinemaid"));
					bean.setCinemaname(rs.getString("cinemaname"));
					bean.setBranchname(rs.getString("branchname"));
					bean.setBranchaddress(rs.getString("branchaddress"));
					list.add(bean);
					
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	  
	  public List<FeedbackBean> selectFeedback()
	  {
		  List<FeedbackBean> list=new ArrayList<FeedbackBean>();
			conn=DBConnection.getConnection();
			String query="select * from feedback";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					FeedbackBean bean=new FeedbackBean();
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
	  
	  
	  public String selectCityname(String cityid)
		{
			conn=DBConnection.getConnection();
			String cityname=null;
			String query="select cityname from city where cityid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,cityid);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					cityname=rs.getString("cityname");
				 	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cityname;
		}
	  
	  public List<BranchBean> selectCinema(String movieid,String cityid)
		{
			List<BranchBean> list=new ArrayList<BranchBean>();
			conn=DBConnection.getConnection();
			String query="select mb.moviebranchid,br.branchname,cn.cinemaname from moviebranch mb,branch br,cinema cn where mb.movieid=? and mb.branchid=br.branchid and br.cinemaid=cn.cinemaid and cn.cityid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,movieid);
				pstmt.setString(2,cityid);
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					BranchBean bean=new BranchBean();
					bean.setMoviebranchid(rs.getString("moviebranchid"));
					bean.setBranchname(rs.getString("branchname"));
					bean.setCinemaname(rs.getString("cinemaname"));
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	  
	  public String selectCinemaId(String moviebranchid)
		{
		  String cinemaid=null;
			conn=DBConnection.getConnection();
			String query="select br.cinemaid from moviebranch mb,branch br where mb.branchid=br.branchid and mb.moviebranchid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1,moviebranchid);
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					cinemaid=rs.getString("cinemaid");
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cinemaid;
		}
	  
	  
	  public String selectScreenId(String showid)
		{
		  String screenid=null;
			conn=DBConnection.getConnection();
			String query="select sc.screenid,sc.screenno from screen sc,show sh where sh.showid=sc.showid and sc.showid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,showid);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					screenid=rs.getString("screenid");
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return screenid;
		}
	  
	  public String selectShowDate(String showid)
		{
		  String showdate=null;
			conn=DBConnection.getConnection();
			String query="select sh.showdate from show sh where sh.showid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,showid);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					showdate=rs.getString("showdate");
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return showdate;
		}
	  
	  public String selectUserId(String email)
		{
		  String userid=null;
			conn=DBConnection.getConnection();
			String query="select userid from userdetails where email=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,email);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					userid=rs.getString("userid");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userid;
		}

	  public String selectCinemaBranch(String moviebranchid)
		{
			conn=DBConnection.getConnection();
			String cinemabranch=null;
			String query="select cn.cinemaname,br.branchname from cinema cn,branch br,moviebranch mb where mb.branchid=br.branchid and br.cinemaid=cn.cinemaid and mb.moviebranchid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,moviebranchid);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					cinemabranch=rs.getString("cinemaname")+"("+rs.getString("branchname")+")";
				 	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cinemabranch;
		}
	  
	  public String selectMovieName(String moviebranchid)
		{
			conn=DBConnection.getConnection();
			String moviename=null;
			String query="select mv.moviename from movie mv,moviebranch mb where mb.movieid=mv.movieid and mb.moviebranchid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,moviebranchid);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					moviename=rs.getString("moviename");
				 	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return moviename;
		}
	  
	  public String selectScreen(String screenid)
		{
			conn=DBConnection.getConnection();
			String screenno=null;
			String query="select screenno from screen where screenid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,screenid);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					screenno=rs.getString("screenno");
				 	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return screenno;
		}
	  
	  
	  public EventsBean selectEventData(String eventid)
		{
         
		    EventsBean bean=null;
		    conn=DBConnection.getConnection();
			String query="select eventid,eventname,eventinfo,eventprice from events where eventid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,eventid);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					
					bean=new EventsBean();
					bean.setEventid(rs.getString("eventid"));
					bean.setEventname(rs.getString("eventname"));
					bean.setEventprice(rs.getString("eventprice"));
					bean.setEventinfo(rs.getString("eventinfo"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
		}
	  
	  public List<PaymentBean> selectPaymentType()
	  {
		  List<PaymentBean> list=new ArrayList<PaymentBean>();
			conn=DBConnection.getConnection();
			String query="select * from payment";
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
					bean.setPaymentid(rs.getString("paymentid"));
					bean.setPaymenttype(rs.getString("paymenttype"));
				    list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	  }

	  public boolean insertData(BranchBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into branch values(seq_branch.nextval,?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getBranchname());
				pstmt.setString(2, bean.getBranchaddress());
				pstmt.setString(3, bean.getCinemaid());
				pstmt.setString(4, bean.getAdminid());
				
				
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
	  public boolean insertData(BookingBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into bookmaster values(seq_bookmaster.nextval,?,?,?,?,?,?,?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getCityid());
				pstmt.setString(2,bean.getCinemaid());
				pstmt.setString(3,bean.getMoviebranchid());
				pstmt.setString(4,bean.getScreenid());
				pstmt.setString(5,bean.getShowid());
				pstmt.setString(6,bean.getShowdate());
				pstmt.setString(7,bean.getPrice1());
				pstmt.setString(8,bean.getUserid());
				pstmt.setString(9,bean.getSeat());
				pstmt.setString(10,bean.getPaymentid());
				
				
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
	  
	  
	  public String selectEventid(String eventname)
		{
			conn=DBConnection.getConnection();
			String eventid=null;
			String query="select eventid from events where eventname=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,eventname);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					eventid=rs.getString("eventid");
				 	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return eventid;
		}
	  
	  public boolean insertEventData(EventBean bean)
		{
			boolean flag=false;
			conn=DBConnection.getConnection();
			String query="insert into eventbooking values(seq_eventbooking.nextval,?,?,?,?,?)";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,bean.getEventid());
				pstmt.setString(2,bean.getNooftickets());
				pstmt.setString(3,bean.getPrice());
				pstmt.setString(4,bean.getUserid());
				pstmt.setString(5,bean.getPaymentid());
				
				
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
	  
	  public List<MovieBean> selectMovies(String cityid)
	  {
		   List<MovieBean> list=new ArrayList<MovieBean>();
		     
			conn=DBConnection.getConnection();
			String query="select mv.movieid,mv.moviename,mv.director,mv.writer,mv.music,mv.releasedate,lg.languagename from movie mv,movielanguage ml,language lg,moviebranch mb,branch br,cinema cn,city ct where mv.movieid=ml.movieid and ml.languageid=lg.languageid and mv.movieid=mb.movieid and mb.branchid=br.branchid and br.cinemaid=cn.cinemaid and cn.cityid=ct.cityid and ct.cityid=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1,cityid);
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					MovieBean bean=new MovieBean();
					bean.setMovieid(rs.getString("movieid"));
					bean.setMoviename(rs.getString("moviename"));
					bean.setDirector(rs.getString("director"));
					bean.setWriter(rs.getString("writer"));
					bean.setMusic(rs.getString("music"));
					bean.setReleasedate(rs.getString("releasedate"));
					bean.setLanguagename(rs.getString("languagename"));
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	  }
	  
	  public AdminBean checkAdmin(String emailid,String password)
	  {

		  AdminBean bean=null;
		  conn=DBConnection.getConnection();
			String query="select * from admin where emailid=? and password=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1,emailid);
				pstmt.setString(2,password);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new AdminBean();
					bean.setAdminid(rs.getString("adminid"));
					bean.setEmailid(rs.getString("emailid"));
					bean.setPassword(rs.getString("password"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
	  }
	  
	  public UserdetailsBean checkRegisteredUsers(String email,String password)
	  {

		  UserdetailsBean bean=null;
		  conn=DBConnection.getConnection();
			String query="select * from userdetails where email=? and password=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				//pstmt.setString(1,"adminid");
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				pstmt.setString(1,email);
				pstmt.setString(2,password);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					bean=new UserdetailsBean();
					bean.setCityid(rs.getString("cityid"));
					bean.setName(rs.getString("name"));
					bean.setEmail(rs.getString("email"));
					bean.setPassword(rs.getString("password"));
					bean.setGender(rs.getString("gender"));
					bean.setMobilenumber(rs.getString("mobilenumber"));
					bean.setUserid(rs.getString("userid"));
					bean.setCityname(rs.getString("cityname"));
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bean;
	  }
	  
	  public String sendPassword(String name,String email,String mobilenumber)
		{
			conn=DBConnection.getConnection();
			String password=null;
			String query="select password from userdetails where name=? and email=? and mobilenumber=?";
			try {
				
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,name);
				pstmt.setString(2,email);
				pstmt.setString(3,mobilenumber);
				//pstmt.setString(2,"firstname");
				//pstmt.setString(3,"middlename");
				//pstmt.setString(4,"lastname");
				ResultSet rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					password=rs.getString("password");
				 	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return password;
		}
	
}
