package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import qb.entity.Testpaper;
import qb.service.AdminTestService;
import qb.util.JsonParseUtil;
/**分页
 * 查询所有的试卷。
 * @author admin
 *
 */
public class TestPaperSer extends SuperServlet {
	private AdminTestService ats=null;
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
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//获取所有的试卷,分页查询
		List<Testpaper> testPaperList =ats.limitByPage(pageNo,"");
		request.setAttribute("list", testPaperList);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalPage", ats.getTotalPage());
		request.getRequestDispatcher("/selectTestpaper.jsp").forward(request, response);
	}
}
