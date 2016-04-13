package qb.android.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import qb.entity.User;
import qb.service.UserService;
import qb.util.UUIDUtil;
/**
 * Android端接口
 * 用户注册
 * @author admin
 */
public class UserRegisterSer extends SuperServlet {
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
		String userStr = IOUtils.toString(request.getInputStream(), "utf-8");
		System.out.println(userStr.toString());
		JSONObject jo = new JSONObject(userStr);
		User u = new User();
		u.setUsername(jo.getString("name"));
		u.setPassword(jo.getString("password"));
		u.setUserclass(jo.getString("classGrade"));
		u.setUserid(jo.getString("username"));   //学生id
		if(us.insertUser(u)){   //注册成功
			out.print("{\"result\":true}");
		}else{					//注册失败
			out.print("{\"result\":false}");
		}
	}
}
