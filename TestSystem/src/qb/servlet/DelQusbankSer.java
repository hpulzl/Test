package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.service.AdminQusService;
/**
 * Õ®π˝qusid…æ≥˝ ‘Ã‚
 * @author admin
 *
 */
public class DelQusbankSer extends SuperServlet {
	private AdminQusService aqs;
	@Override
	public void init() throws ServletException {
		super.init();
		aqs = new AdminQusService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		String qusid = request.getParameter("qusid");
		out.print(aqs.adminDelete(qusid));
	}
}
