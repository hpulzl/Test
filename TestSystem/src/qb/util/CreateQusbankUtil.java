package qb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import qb.entity.Qusbank;
import qb.service.AdminQusService;

/**
 * 该类用于获取试题。
 * 设置单例，保证只创建一个对象。
 * @author admin
 */
public class CreateQusbankUtil {
	private static CreateQusbankUtil qusbankUtil;
	private AdminQusService aqs;
	private final String MULTIPLR_CHOOSE = "多选题";
	private final String SINGLE_CHOOSE = "单选题";
	private final String TRUE_OR_FALSE = "判断题";
	private final int MULTIPLR_NUMBER = 5;
	private final int SINGLE_NUMBER = 15;
	private final int TRUE_OR_FALSE_NUMBER = 10;
	private CreateQusbankUtil(){
		
	}
	public static synchronized CreateQusbankUtil SingleInstance(){
		if(qusbankUtil==null){
			qusbankUtil = new CreateQusbankUtil();
		}
		return qusbankUtil; 
	}
	/**
	 * 从数据库的试题库表中随机的获取试题
	 * @return
	 */
	public List<String> selectQusid(){
		List<String> listQusid = new ArrayList<String>();
		aqs = new AdminQusService();
		//这里获取5到多选题，10道选择题，15道单选题.
		listQusid.addAll(getRandomQusid(aqs.adminSelect(MULTIPLR_CHOOSE), MULTIPLR_NUMBER));
		listQusid.addAll(getRandomQusid(aqs.adminSelect(SINGLE_CHOOSE), SINGLE_NUMBER));
		listQusid.addAll(getRandomQusid(aqs.adminSelect(TRUE_OR_FALSE), TRUE_OR_FALSE_NUMBER));
		System.out.println("个数..."+listQusid.size());
		return listQusid;
	}
	/**
	 * 随机获取数据库中的试题的id。
	 * @param qusList
	 * @param num
	 * @return
	 */
	private List<String> getRandomQusid(List<Qusbank> qusList,int num){
		Random random = new Random();
		List<String> qusidList = new ArrayList<String>();
		int n = qusList.size();
		boolean[] bool = new boolean[n];
		int j=0;
		if(qusList.size()-1 >= num ){  //如果数据库中的数据大于指定的num，执行下面代码。
			for(int i=0;i<num;i++){
				do{
					j = random.nextInt(n);  //先产生一条随机数。
				}while(bool[j]);  //如果为true，就再去产生 
				bool[j] = true;
				Qusbank qus = qusList.get(j);
				//将qusid装入到qusidList中.
				qusidList.add(qus.getQusid());
			}
		}else{
			for(Qusbank qus : qusList){
				qusidList.add(qus.getQusid());
			}
		}
		return qusidList;
	}
}
