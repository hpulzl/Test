package qb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.entity.QusTestPaper;
import qb.service.QusandTestService;
/**
 * ��ҳ��ѯ
 * �����Ծ�������Ϣ��
 * ��Ҫ����ʾ�Ծ��Ƿ����ɹ��Ծ�
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
		//ֱ�ӵ��������Ծ��ܣ��Ϳ��Բ����Ծ��ˡ�
		List<QusTestPaper> list = qts.limitByPage(pageNo, "");
		request.setAttribute("list", list);
		request.setAttribute("totalPage", qts.getTotalPage());
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("/selectTestandQus.jsp").forward(request, response);
	}
}
