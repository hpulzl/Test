package qb.android.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import qb.entity.Qusbank;
import qb.service.QusandTestService;
/**
 * Android端接口
 * 通过testid获取所有的试题信息
 * @author admin
 *
 */
public class SelectQusByTestidSer extends SuperServlet {
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
		String testid = request.getParameter("testid");
		List<Qusbank> list= qts.storeQusBankByTestid(testid);
		out.print(parseToJsonArray(list));
	}
	/**
	 * 将list集合转换成JsonArray
	 * @param list
	 * @return
	 */
	private String parseToJsonArray(List<Qusbank> list){
		JSONArray json = new JSONArray();
		for(Qusbank qus : list){
			JSONObject jo = new JSONObject();
			jo.put("qusid", qus.getQusid());
			jo.put("qussiue", qus.getQusissue());
			jo.put("qusAnswer", qus.getQusanswer());
			jo.put("qusType", qus.getQustype());
			json.put(jo);
		}
		return json.toString();
	}
}
