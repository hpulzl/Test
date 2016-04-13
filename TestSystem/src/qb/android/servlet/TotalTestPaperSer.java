package qb.android.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qb.service.QusandTestService;
/**
 * Android端接口
 * 获取试卷表中的数据。
 * @author admin
 *
 */
public class TotalTestPaperSer extends SuperServlet {
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
		out.print("{\"totalTestPage\" : "+qts.getPureTotalPage()+"}");
	}
}
