package qb.android.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import qb.entity.User;
import qb.service.UserService;
/**
 * Android端接口
 * 通过用户id获取用户的信息
 * @author admin
 *
 */
public class SelectUserSer extends SuperServlet {
	private UserService us;
	@Override
	public void init() throws ServletException {
		super.init();
		us = new UserService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);
		String userid = IOUtils.toString(request.getInputStream(),"utf-8");
		JSONObject jo = new JSONObject(userid);
		User user =us.selectById(jo.getString("userid"));
		//将user对象解析成JsonObject对象
		out.print(parseToJsonObject(user));
	}
	private String parseToJsonObject(User u){
		JSONObject jo = new JSONObject();
		jo.put("userid", u.getUserid());  //学号
		jo.put("name", u.getUsername());
		jo.put("classGrade", u.getUserclass());
		return jo.toString();
	}
}
