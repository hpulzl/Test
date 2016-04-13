package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.entity.Testpaper;
import qb.service.AdminTestService;
/**
 * ÐÞ¸ÄÊÔ¾íÄÚÈÝ
 * @author admin
 *
 */
public class AdminUpdateSer extends SuperServlet {
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
		String testName = request.getParameter("testname");
		String testDifficult = request.getParameter("testdifficult");
		String testid = request.getParameter("testid");
		
		System.out.println("testName="+testName+" testDifficult="+testDifficult);
		
		if(testName!=null&& !"".equals(testName)&&
				testDifficult!=null&& !"".equals(testDifficult)){
			Testpaper tp = new Testpaper();
			tp.setTestid(testid);
			tp.setTestdifficult(testDifficult);
			tp.setTestname(testName);
			out.print(ats.adminUpdate(tp));
		}
	}
}
