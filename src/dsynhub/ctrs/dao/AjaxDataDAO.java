package dsynhub.ctrs.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.bean.ShowBean;
import dsynhub.ctrs.util.DBConnection;

public class AjaxDataDAO {

	public List getAllCity(String stateId) throws SQLException, Exception {

		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List allCities = null;

		CityBean bean = null;

		con = DBConnection.getConnection();

		if (con != null) {

			stmt = con.createStatement();
			String selectSQL = "SELECT * FROM  CITY WHERE STATEID = " + stateId;
			//System.out.println(selectSQL);
			rs = stmt.executeQuery(selectSQL);

			if (rs != null) {
				bean = new CityBean();
				allCities = new ArrayList();
				bean.setCityid("");
				bean.setCityname(" -- Select City -- ");
				allCities.add(bean);
				for (long infinit = 0; infinit <= 400000000; infinit++) {

					/*
					 * This code will generate delay.Remove this for loop for in
					 * project.
					 */
				}
				while (rs.next()) {
					bean = new CityBean();
					bean.setCityid(rs.getString("CITYID"));
					bean.setCityname(rs.getString("CITYNAME"));
					bean.setStateid(rs.getString("STATEID"));
					allCities.add(bean);
				}
			}
		}

		return allCities;
	}
	
	public List getAllShows(String moviebranchid) throws SQLException, Exception {

		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		List allShows = null;

		ShowBean bean = null;
		con = DBConnection.getConnection();

		if (con != null) {

			stmt = con.createStatement();
			String selectSQL = "select showid,showdate,moviebranchid from show where moviebranchid="+moviebranchid;
			//System.out.println(selectSQL);
			rs = stmt.executeQuery(selectSQL);

			if (rs != null) {
				bean = new ShowBean();
				allShows = new ArrayList();
				bean.setShowid("");
				bean.setShowdate("---Select Show Date---");
				allShows.add(bean);
				for (long infinit = 0; infinit <= 400000000; infinit++) {

					/*
					 * This code will generate delay.Remove this for loop for in
					 * project.
					 */
				}
				while (rs.next()) {
					bean = new ShowBean();
					bean.setShowid(rs.getString("showid"));
					bean.setShowdate(rs.getString("showdate"));
					bean.setMoviebranchid(rs.getString("moviebranchid"));
					allShows.add(bean);
				}
			}
		}

		return allShows;
	}
	

}
