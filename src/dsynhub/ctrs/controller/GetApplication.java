package dsynhub.ctrs.controller;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


import dsynhub.ctrs.bean.StateBean;
import dsynhub.ctrs.bean.CityBean;
import dsynhub.ctrs.dao.StateDao;;

public class GetApplication extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5529305582961502104L;

	public void init() throws ServletException {

		ServletContext application = getServletContext();
		StateDao countryDao = new StateDao();
		List allStates = new ArrayList();

		try {
			allStates = countryDao.getAllStates();
			application.setAttribute("allStates", allStates);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
