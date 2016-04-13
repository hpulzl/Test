package qb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * �����Ǳ�ʾjson������util�ࡣ(��ʱ����)
 * @author admin
 *
 * @param <T> ��ʾ��Ҫ�������������
 */
public class JsonParseUtil {
	/**
	 * @param map Ҫ�����ɵ����͡�
	 * @return json����
	 */
	private String parseToJsonArray(List<JSONObject> joList){
		JSONArray json = new JSONArray();
		for(JSONObject jo : joList){
			json.put(jo);
		}
		return json.toString();
	}
	/**
	 * @param map Ҫ�����ɵ����͡�
	 * @return json����
	 */
	public String parseToJsonArray(Map<String,String> map){
		Set<String> keyset = map.keySet();
		List<JSONObject> joList = new ArrayList<JSONObject>();
		for(String key : keyset){
			JSONObject jo = new JSONObject();
			jo = new JSONObject();
			jo.put(key, map.get(key));
			joList.add(jo);
		}
		System.out.println("����..."+joList.size());
		parseToJsonArray(joList);
		return parseToJsonArray(joList);
	}
}
