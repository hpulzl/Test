package qb.android.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import qb.service.UserService;
/**Android�˽ӿ�
 * �û���¼
 * @author admin
 */
public class UserLoginSer extends SuperServlet {
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
		//��ȡjson�ַ�
		String userStr = IOUtils.toString(request.getInputStream(),"utf-8");
		JSONObject json = new JSONObject(userStr);
		String username = json.getString("username");  //ʵ������userid�����е�¼��
		String password = json.getString("password");
		if(username==null || username.equals("")||password.equals("")||password == null){
			throw new NullPointerException("�û��������벻��Ϊ��");
		}else{
			if(us.userLogin(username, password)){
				out.print("{\"result\":true}");
			}else{
				out.print("{\"result\":false}");
			}
		}
	}
}
