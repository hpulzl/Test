package qb.android.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import qb.entity.Qusbank;
import qb.entity.Wrongqus;
import qb.service.AdminQusService;
import qb.service.WrongqusService;
/**
 * Android端接口，
 * 查看某一用户的错题
 * @author admin
 */
public class SelectWrongQusSer extends SuperServlet {
	private WrongqusService ws;
	private AdminQusService aqs;
	@Override
	public void init() throws ServletException {
		super.init();
		ws = new WrongqusService();
		aqs = new AdminQusService();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		String userid = request.getParameter("userid");
		
		out.print(parseToJsonArray(ws.selectWrongqusList(userid)));
	}
	private String parseToJsonArray(Set<Wrongqus> wrongSet ){
		JSONArray json = new JSONArray();
		for(Wrongqus w : wrongSet){
			JSONObject jo = new JSONObject();
			Qusbank qus = aqs.selectQusbank(w.getQusid());
			jo.put("qussiue",qus.getQusissue());
			jo.put("qusAnswer",qus.getQusanswer());
			jo.put("qusType",qus.getQustype());
			jo.put("qusid", qus.getQusid());
			json.put(jo);
		}
		return json.toString();
		
	}
}
