package qb.android.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import qb.entity.QusTestPaper;
import qb.service.QusandTestService;
/**
 * Android端接口
 * 分页获取所有的试卷，这里的试卷是已经有试题的试卷。
 * @author admin
 */
public class SelectAllTestPaperSer extends SuperServlet {
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
		List<QusTestPaper> list = qts.limitByPageToAndroid(pageNo);
		//将list集合转换成json
		out.print(parseToJsonArray(list));
	}
	/**
	 * 将list集合转换成JsonArray数据
	 * @param list
	 * @return
	 */
	private String parseToJsonArray(List<QusTestPaper> list){
		JSONArray json = new JSONArray();
		for(QusTestPaper qtp : list){
			JSONObject jo = new JSONObject();
			//只传输试卷信息。试卷id/试卷名/难易程度/题量
			jo.put("testid", qtp.getTestid());
			jo.put("testName", qtp.getTestname());
			jo.put("testDifficult", qtp.getTestdifficult());
			jo.put("testNum", qtp.getTestCount());
			json.put(jo);
		}
		return json.toString();
	}
}
