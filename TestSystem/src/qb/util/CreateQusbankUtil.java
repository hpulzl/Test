package qb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import qb.entity.Qusbank;
import qb.service.AdminQusService;

/**
 * �������ڻ�ȡ���⡣
 * ���õ�������ֻ֤����һ������
 * @author admin
 */
public class CreateQusbankUtil {
	private static CreateQusbankUtil qusbankUtil;
	private AdminQusService aqs;
	private final String MULTIPLR_CHOOSE = "��ѡ��";
	private final String SINGLE_CHOOSE = "��ѡ��";
	private final String TRUE_OR_FALSE = "�ж���";
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
	 * �����ݿ��������������Ļ�ȡ����
	 * @return
	 */
	public List<String> selectQusid(){
		List<String> listQusid = new ArrayList<String>();
		aqs = new AdminQusService();
		//�����ȡ5����ѡ�⣬10��ѡ���⣬15����ѡ��.
		listQusid.addAll(getRandomQusid(aqs.adminSelect(MULTIPLR_CHOOSE), MULTIPLR_NUMBER));
		listQusid.addAll(getRandomQusid(aqs.adminSelect(SINGLE_CHOOSE), SINGLE_NUMBER));
		listQusid.addAll(getRandomQusid(aqs.adminSelect(TRUE_OR_FALSE), TRUE_OR_FALSE_NUMBER));
		System.out.println("����..."+listQusid.size());
		return listQusid;
	}
	/**
	 * �����ȡ���ݿ��е������id��
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
		if(qusList.size()-1 >= num ){  //������ݿ��е����ݴ���ָ����num��ִ��������롣
			for(int i=0;i<num;i++){
				do{
					j = random.nextInt(n);  //�Ȳ���һ���������
				}while(bool[j]);  //���Ϊtrue������ȥ���� 
				bool[j] = true;
				Qusbank qus = qusList.get(j);
				//��qusidװ�뵽qusidList��.
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
