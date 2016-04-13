package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.entity.Qusbank;
import qb.service.AdminQusService;
import qb.util.UUIDUtil;
/**
 * ÃÌº” ‘Ã‚
 * @author admin
 *
 */
public class AddQusbankSer extends SuperServlet {
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
		String qusissue = request.getParameter("qusissue");
		String qusType = request.getParameter("qusType");
		String qusanswer = request.getParameter("qusanswer");
		System.out.println("qusissue="+qusissue+" qusType="+qusType+" qusanswer="+qusanswer);
		Qusbank qus = new Qusbank();
		qus.setQusid(UUIDUtil.getUUId());
		qus.setQusissue(qusissue);
		qus.setQusanswer(qusanswer);
		qus.setQustype(qusType);
		out.print(aqs.adminInsert(qus));
	}
}
