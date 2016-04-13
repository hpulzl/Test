package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import qb.service.AdminTestService;
/**
 * É¾³ýÊÔ¾í
 * @author admin
 *
 */
public class AdminDelSer extends SuperServlet {
	private AdminTestService ats;
	@Override
	public void init() throws ServletException {
		super.init();
		ats = new AdminTestService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		String testid = request.getParameter("testid");
		PrintWriter out = response.getWriter();
		boolean flag = false;
		if(testid!=null&&!testid.equals("")){
			flag = ats.adminDelete(testid);
			out.print(flag);
		}else{
			out.print(flag);
		}
	}
}
