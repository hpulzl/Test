package qb.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qb.entity.Testpaper;
import qb.service.AdminService;
import qb.service.AdminTestService;

/**
 * 该类是用于快速生成试卷的工具类。
 * 首先是查找testid，然后是获取qusid的List集合。
 * 然后将调用试题试卷表的插入功能。
 * @author admin
 */
public class QusandTestUtil {
	private static AdminService<Testpaper> qtService = new AdminTestService(); 
	/*//通过试卷id来。
	public static Map<String,List<String>> getQusandTestMap(String testid){
		Map<String,List<String>> idMap = new HashMap<String, List<String>>();
		
		return idMap;
	}*/
}
