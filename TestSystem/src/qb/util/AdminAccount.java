package qb.util;
/**
 * 因为管理员账号只有一个，所以不存入数据库中，
 * 而是使用管理员账号类来进行登录与检验。
 * @author admin
 *
 */
public class AdminAccount {
	public static String ADMIN_NAME = "admin";
	public static String ADMIN_PASSWORD = "admin";
	private static String LOGIN_FAILD = "登录失败";
	private static String LOGIN_SUCCESS = "登录成功";
	//这里只返回用户登录成功或者失败，表单的验证用js进行验证。
	public static String validateLogin(String name,String password){
		if(!(name.equals(ADMIN_NAME)&&password.equals(ADMIN_PASSWORD))){
			return LOGIN_FAILD;
		}
		return LOGIN_SUCCESS;
	}
}
