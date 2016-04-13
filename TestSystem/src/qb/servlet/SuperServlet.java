package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import qb.service.AdminQusService;
/**
 * 作为管理员servlet类的超类。
 * @author admin
 */
public class SuperServlet extends HttpServlet{
	protected AdminQusService aqs ;
	protected PrintWriter out;
	@Override
	public void init() throws ServletException {
		super.init();
		aqs = new AdminQusService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		setCharacterEncoding(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		setCharacterEncoding(req,resp);
	}
	private void setCharacterEncoding(HttpServletRequest req, HttpServletResponse resp){
		try {
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
				out = resp.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
