package qb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.entity.QusTestPaper;
import qb.service.QusandTestService;
/**
 * 分页查询
 * 查找试卷试题信息，
 * 主要是显示试卷是否生成过试卷。
 * @author admin
 *
 */
public class selectQusandTestSer extends SuperServlet {
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
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//直接调用生成试卷功能，就可以查找试卷了。
		List<QusTestPaper> list = qts.limitByPage(pageNo, "");
		request.setAttribute("list", list);
		request.setAttribute("totalPage", qts.getTotalPage());
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("/selectTestandQus.jsp").forward(request, response);
	}
}
