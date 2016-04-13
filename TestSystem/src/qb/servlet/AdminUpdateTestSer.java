package qb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.entity.Testpaper;
import qb.service.AdminTestService;
/**
 * 修改试卷内容。
 * 修改时，需要根据id查找试卷内容
 * @author admin
 *
 */
public class AdminUpdateTestSer extends SuperServlet {
	private AdminTestService ats;
	@Override
	public void init() throws ServletException {
		super.init();
		ats = new AdminTestService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		String testid = request.getParameter("testid");
		Testpaper tp = (Testpaper) ats.selectTestpaper(testid);
		request.setAttribute("testpaper", tp);
		request.getRequestDispatcher("/updateTestpaper.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
	}
}
