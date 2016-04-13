package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.entity.Qusbank;
import qb.service.AdminQusService;
/**
 * 修改试题时获取修改试题的具体信息
 * @author admin
 *
 */
public class UpdateQusbankSer extends SuperServlet {
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
		Qusbank qusbank = aqs.selectQusbank(qusid);
		request.setAttribute("qusbank", qusbank);
		request.getRequestDispatcher("/updateQusbank.jsp").forward(request, response);
	}
}
