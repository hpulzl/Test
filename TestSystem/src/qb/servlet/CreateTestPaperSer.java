package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.service.QusandTestService;
/**
 * Ò»¼üÉú³ÉÊÔ¾í
 * @author admin
 */
public class CreateTestPaperSer extends SuperServlet {
	private QusandTestService qts;
	@Override
	public void init() throws ServletException {
		super.init();
		qts = new QusandTestService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		String jsonTestid = request.getParameter("jsonTestid");
		System.out.println("jsonTestid="+jsonTestid);
		out.print(qts.createTestPaper(jsonTestid));
	}
}
