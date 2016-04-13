package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import qb.entity.User;
import qb.service.UserService;
/**
 * π‹¿Ì‘±µ«¬º
 * @author admin
 *
 */
public class AdminLoginSer extends SuperServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		String adminName = request.getParameter("adminName");
		String adminPassword = request.getParameter("adminPassword");
		if((adminName!=null||adminName!="") && (adminPassword!=null||adminPassword!="")){
			adminName=new String(adminName.getBytes("iso8859-1"),"utf-8");
			PrintWriter out = response.getWriter();
			if(aqs.Login(adminName, adminPassword)){
				out.print(true);
			}else{
				out.print(false);
			}
		}
	}
}
