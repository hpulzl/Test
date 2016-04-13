package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.entity.Qusbank;
import qb.service.AdminQusService;
/**
 * ��ѯ���е�����
 * @author admin
 */
public class SelectQusbankSer extends SuperServlet {
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
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//��ѯ�������⣬���Դ��������Ϊ��
		List<Qusbank> qusbankList = aqs.limitByPage(pageNo,"");
		request.setAttribute("totalPage", aqs.getTotalPage());
		request.setAttribute("qusbankList", qusbankList);
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("/selectQusbank.jsp").forward(request, response);
	}
}
