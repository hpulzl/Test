package qb.util;
/**
 * ��Ϊ����Ա�˺�ֻ��һ�������Բ��������ݿ��У�
 * ����ʹ�ù���Ա�˺��������е�¼����顣
 * @author admin
 *
 */
public class AdminAccount {
	public static String ADMIN_NAME = "admin";
	public static String ADMIN_PASSWORD = "admin";
	private static String LOGIN_FAILD = "��¼ʧ��";
	private static String LOGIN_SUCCESS = "��¼�ɹ�";
	//����ֻ�����û���¼�ɹ�����ʧ�ܣ�������֤��js������֤��
	public static String validateLogin(String name,String password){
		if(!(name.equals(ADMIN_NAME)&&password.equals(ADMIN_PASSWORD))){
			return LOGIN_FAILD;
		}
		return LOGIN_SUCCESS;
	}
}
