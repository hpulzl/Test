package qb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * 该类是表示json解析的util类。(暂时不用)
 * @author admin
 *
 * @param <T> 表示想要传入的类型数据
 */
public class JsonParseUtil {
	/**
	 * @param map 要解析成的类型。
	 * @return json数据
	 */
	private String parseToJsonArray(List<JSONObject> joList){
		JSONArray json = new JSONArray();
		for(JSONObject jo : joList){
			json.put(jo);
		}
		return json.toString();
	}
	/**
	 * @param map 要解析成的类型。
	 * @return json数据
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
		System.out.println("个数..."+joList.size());
		parseToJsonArray(joList);
		return parseToJsonArray(joList);
	}
}
