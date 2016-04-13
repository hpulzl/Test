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
 * 获取jsp页面的修改数据，去执行修改。
 * @author admin
 *
 */
public class ToUpdateQusbankSer extends SuperServlet {
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
		String qusid = request.getParameter("qusid");
		
		System.out.println("qusid="+qusid+" qusType="+
				qusType+" qusanswer="+qusanswer+" qusissue="+qusissue);
		Qusbank qusbank = new Qusbank();
		qusbank.setQusid(qusid);
		qusbank.setQustype(qusType);
		qusbank.setQusissue(qusissue);
		qusbank.setQusanswer(qusanswer);
		out.print(aqs.adminUpdate(qusbank));
	}

}
