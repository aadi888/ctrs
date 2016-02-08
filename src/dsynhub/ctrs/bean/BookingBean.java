package dsynhub.ctrs.bean;

public class BookingBean {

	String bookid;
	String cityid;
	String cinemaid;
	String moviebranchid;
	String screenid;
	String showid;
	String showdate;
	int price;
	String price1;
	public String getPrice1() {
		return price1;
	}
	public void setPrice1(String price1) {
		this.price1 = price1;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	String userid;
	String seat;
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	String seats[];
	public String[] getSeats() {
		return seats;
	}
	public void setSeats(String[] seats) {
		this.seats = seats;
	}
	String paymentid;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(String cinemaid) {
		this.cinemaid = cinemaid;
	}
	public String getMoviebranchid() {
		return moviebranchid;
	}
	public void setMoviebranchid(String moviebranchid) {
		this.moviebranchid = moviebranchid;
	}
	public String getScreenid() {
		return screenid;
	}
	public void setScreenid(String screenid) {
		this.screenid = screenid;
	}
	public String getShowid() {
		return showid;
	}
	public void setShowid(String showid) {
		this.showid = showid;
	}
	public String getShowdate() {
		return showdate;
	}
	public void setShowdate(String showdate) {
		this.showdate = showdate;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	
}
