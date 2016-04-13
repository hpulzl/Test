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
 * Android�˽ӿ�
 * �洢������Ϣ��
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
		//��ȡjson�ַ�
		String wrongQus = IOUtils.toString(request.getInputStream(),"utf-8");
		JSONObject json = new JSONObject(wrongQus);
		String qusid = json.getString("qusid");  //ʵ������userid�����е�¼��
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
