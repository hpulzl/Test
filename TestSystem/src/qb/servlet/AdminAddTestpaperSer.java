package qb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import qb.entity.Testpaper;
import qb.service.AdminTestService;
import qb.util.UUIDUtil;
/**
 * ÃÌº” ‘æÌ
 * @author admin
 *
 */
public class AdminAddTestpaperSer extends SuperServlet {
	private AdminTestService ats ;
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
		String testName = request.getParameter("testname");
		String testDifficult = request.getParameter("testdifficult");
		response.setContentType("text/json");
		if(testName!=null&& !"".equals(testName)&&
				testDifficult!=null&& !"".equals(testDifficult)){
			Testpaper tp = new Testpaper();
			tp.setTestid(UUIDUtil.getUUId());
			tp.setTestdifficult(testDifficult);
			tp.setTestname(testName);
			if(ats.adminInsert(tp)){
				String var =parseToJson(tp.getTestid());
				out.print(var);
			}else{
				out.print(false);
			}
		}
	}
	private String parseToJson(String id){
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("testid", id);
		return json.put(jo).toString();
	}
}
