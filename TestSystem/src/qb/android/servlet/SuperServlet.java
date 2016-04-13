package qb.android.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 为android端提供的servlet超类
 * @author admin
 *
 */
public class SuperServlet extends HttpServlet {
	protected PrintWriter out;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setCharacterEncoding(request,response);
	}
	private void setCharacterEncoding(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json");
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
