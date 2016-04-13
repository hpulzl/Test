package qb.android.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import qb.entity.Wrongqus;
import qb.service.WrongqusService;
/**
 * Android端接口
 * 存储错题信息。
 * @author admin
 */
public class SaveWrongQusSer extends SuperServlet {
	private WrongqusService ws;
	@Override
	public void init() throws ServletException {
		super.init();
		ws = new WrongqusService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		//获取json字符
		String wrongQus = IOUtils.toString(request.getInputStream(),"utf-8");
		JSONObject json = new JSONObject(wrongQus);
		String qusid = json.getString("qusid");  //实际是用userid，进行登录的
		String userid = json.getString("userid");
		System.out.println("qusid=="+qusid+"--userid=="+userid);
		Wrongqus wrong = new Wrongqus();
		wrong.setQusid(qusid);
		wrong.setUserid(userid);
		if(ws.insertWrongQus(wrong)){
			out.print("{\"result\":true}");
		}else{
			out.print("{\"result\":false}");
		}
	}
}
