package qb.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qb.entity.Testpaper;
import qb.service.AdminService;
import qb.service.AdminTestService;

/**
 * ���������ڿ��������Ծ�Ĺ����ࡣ
 * �����ǲ���testid��Ȼ���ǻ�ȡqusid��List���ϡ�
 * Ȼ�󽫵��������Ծ��Ĳ��빦�ܡ�
 * @author admin
 */
public class QusandTestUtil {
	private static AdminService<Testpaper> qtService = new AdminTestService(); 
	/*//ͨ���Ծ�id����
	public static Map<String,List<String>> getQusandTestMap(String testid){
		Map<String,List<String>> idMap = new HashMap<String, List<String>>();
		
		return idMap;
	}*/
}
