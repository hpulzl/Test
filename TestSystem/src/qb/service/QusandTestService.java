package qb.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import qb.entity.QusTestPaper;
import qb.entity.Qusandtest;
import qb.entity.QusandtestExample;
import qb.entity.Qusbank;
import qb.entity.Testpaper;
import qb.entity.QusandtestExample.Criteria;
import qb.mapper.QusandtestMapper;
import qb.util.CreateQusbankUtil;
import qb.util.MapperInstance;
/**
 * �����Ծ�����ز���
 * ��Ҫ�������Ծ�ɾ���Ծ�
 * @author admin
 */
public class QusandTestService extends AdminService<QusTestPaper>{
	private QusandtestMapper qusandtestMapper;
	private CreateQusbankUtil cqUtil;
	private AdminTestService ats;
	private AdminQusService aqs;

	public QusandTestService(){
		qusandtestMapper = MapperInstance.getMappperInstance("qusandtestMapper");
		ats = new AdminTestService();
		aqs = new AdminQusService();
	}
	/**
	 * ����testidȥɾ���Ծ�������е�����
	 */
	@Override
	public boolean adminDelete(String id) {
		QusandtestExample qusExample = new QusandtestExample();
		Criteria criteria =qusExample.createCriteria();
		criteria.andTestidEqualTo(id);
		if(qusandtestMapper.deleteByExample(qusExample)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean adminInsert(QusTestPaper t) {
		return false;
	}
	//ͨ��testid��qusidһ�������Ծ������
	@SuppressWarnings("static-access")
	public boolean createTestPaper(String testid){
		cqUtil = cqUtil.SingleInstance();
		List<String> qusidList = cqUtil.selectQusid(); 
		for(String qusid : qusidList){
			Qusandtest qusandtest = new Qusandtest();
			//testid��һ���Ծ��е������
			qusandtest.setQusid(qusid);
			qusandtest.setTestid(testid);
			qusandtestMapper.insert(qusandtest);
		}
		return true;
	}
	/**
	 * �����example����Ҫ����ؼ�������ѯ��
	 * �����ǻ�ȡ�Ծ���������Ծ�ľ�����Ϣ��
	 * ���ҷ��뵽list�����С�
	 */
	@Override
	public List<QusTestPaper> adminSelect(String example) {
		List<QusTestPaper> allTestpaper = new ArrayList<QusTestPaper>();
		//���ڻ�ȡ�Ծ���в�ѯ���е��Ծ�
		List<Testpaper> testPaperList = ats.adminSelect("");
		//�����ǻ�ȡ���е�������е��Ծ���Ϣ������װ�뵽
		for(Testpaper t :testPaperList){
			QusTestPaper qusTest = new QusTestPaper();
			qusTest.setTestid(t.getTestid());
			qusTest.setTestdifficult(t.getTestdifficult());
			qusTest.setTestname(t.getTestname());
			//������������Ծ�����ж��Ծ��Ƿ��������Ծ�
			for(QusTestPaper qusTestpaper : selectCreateTestPaper()){
				//��������Ծ���в����ڸ��Ծ��id������û�������Ծ�
				if(qusTestpaper.getTestid().equals(t.getTestid())){
					qusTest.setIsCreated(true);
				}
			}
			//���뵽list��
			allTestpaper.add(qusTest);
		}
		return allTestpaper;
	}
	//���з�ҳ��ѯ
	public List<QusTestPaper> limitByPage(int pageNo,String example){
		List<QusTestPaper> allTestpaper = new ArrayList<QusTestPaper>();
		//���ڻ�ȡ�Ծ���в�ѯ���е��Ծ�
		List<Testpaper> testPaperList = ats.limitByPage(pageNo, example);
		//�����ǻ�ȡ���е�������е��Ծ���Ϣ������װ�뵽
		for(Testpaper t :testPaperList){
			QusTestPaper qusTest = new QusTestPaper();
			qusTest.setTestid(t.getTestid());
			qusTest.setTestdifficult(t.getTestdifficult());
			qusTest.setTestname(t.getTestname());
			//������������Ծ�����ж��Ծ��Ƿ��������Ծ�
			for(QusTestPaper qusTestpaper : selectCreateTestPaper()){
				//��������Ծ���в����ڸ��Ծ��id������û�������Ծ�
				if(qusTestpaper.getTestid().equals(t.getTestid())){
					qusTest.setIsCreated(true);
				}
			}
			//���뵽list��
			allTestpaper.add(qusTest);
		}
		return allTestpaper;
	}
	/**
	 * ͨ��pageNo��ȡ�Ծ��Լ���������ݡ�
	 * @param pageNo
	 * @return
	 */
	public List<QusTestPaper> limitByPageToAndroid(int pageNo){
		List<QusTestPaper> allTestpaper = new ArrayList<QusTestPaper>();
		//���ڻ�ȡ�Ծ���в�ѯ���е��Ծ�
		List<Testpaper> testPaperList = ats.limitByPage(pageNo,"");
		//�����ǻ�ȡ���е�������е��Ծ���Ϣ������װ�뵽
		for(Testpaper t :testPaperList){
			QusTestPaper qusTest = new QusTestPaper();
			qusTest.setTestid(t.getTestid());
			qusTest.setTestdifficult(t.getTestdifficult());
			qusTest.setTestname(t.getTestname());
			//������������Ծ�����ж��Ծ��Ƿ��������Ծ�
			for(QusTestPaper qusTestpaper : selectCreateTestPaper()){
				//��������Ծ���в����ڸ��Ծ��id������û�������Ծ�
				if(qusTestpaper.getTestid().equals(t.getTestid())){
					qusTest.setIsCreated(true);
					qusTest.setTestCount(countByExample(t.getTestid()));
					//���뵽list�У�����ֻ�洢�������Ծ������
					allTestpaper.add(qusTest);
				}
			}
		}
		return allTestpaper;
	}
	/**
	 * ͨ�������Ծ���е�testid���������ɹ����Ծ���Ϣ��
	 * @return qusTestPaperList
	 */
	public List<QusTestPaper> selectCreateTestPaper(){
		//���Ȳ��������Ծ���е���Ϣ��
		List<Qusandtest> list = 
			qusandtestMapper.selectByExample(new QusandtestExample());
		return getPureList(list);
	}
	/**
	 * ����������ȡ���ظ���list����
	 * @param 
	 * @return
	 */
	private List<QusTestPaper> getPureList(List<Qusandtest> list){
		List<QusTestPaper> qusTestPaperList = new ArrayList<QusTestPaper>();
		HashSet<Testpaper> set = new HashSet<Testpaper>();
		for(Qusandtest qusandtest : list){
			Testpaper t = ats.selectTestpaper(qusandtest.getTestid());
			set.add(t);  //ͨ��set�е�add�������Ա�������ظ������ݡ�
		}
		for(Testpaper tp : set){
			QusTestPaper qusTestPaper = new QusTestPaper();
			//����װ�뵽�����Ծ�����
			qusTestPaper.setTestid(tp.getTestid());
			qusTestPaper.setTestname(tp.getTestname());
			qusTestPaper.setTestdifficult(tp.getTestdifficult());
			qusTestPaper.setIsCreated(true); //�������Ծ���в�ѯ���Ծ���Ϣ�����Ѿ������Ծ�
			
			qusTestPaperList.add(qusTestPaper);
		}
		return qusTestPaperList; 
	}
	/**
	 * �������Ծ����ͨ��testid����ȡ���е�������Ϣ
	 * @param testid
	 * @return
	 */
	public List<Qusbank> storeQusBankByTestid(String testid){
		List<Qusbank> qusbankList = new ArrayList<Qusbank>();
		List<String> qusidList = storeQusid(testid);
		for(String qusid : qusidList){
			Qusbank qus = aqs.selectQusbank(qusid);
			qusbankList.add(qus);
		}
		return qusbankList;
	}
	/**ͨ���Ծ�id
	 * ��ȡ�ñ��е���������id
	 * @param testid
	 * @return
	 */
	public List<String> storeQusid(String testid){
		return qusandtestMapper.selectByTestid(testid);
	}
	/**
	 * ͨ��qusidɾ�������Ծ���еĸ����⡣
	 * @param qusid
	 * @return
	 */
	public boolean deleteByQusid(String qusid){
		QusandtestExample example = new QusandtestExample();
		Criteria criteria =example.createCriteria();
		criteria.andQusidEqualTo(qusid);
		if(qusandtestMapper.deleteByExample(example)>0){
			return true;
		}
		return false;
	}
	/**
	 * ͨ��testidɾ�������Ծ���еĸ��Ծ�
	 * @param qusid
	 * @return
	 */
	public boolean deleteByTestid(String testid){
		QusandtestExample example = new QusandtestExample();
		Criteria criteria =example.createCriteria();
		criteria.andTestidEqualTo(testid);
		if(qusandtestMapper.deleteByExample(example)>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean adminUpdate(QusTestPaper t) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getTotalPage(){
		return ats.getTotalPage();
	}
	/**
	 * ͨ���Ծ�id��������Ծ��ж�������.
	 * @return
	 */
	public int countByExample(String testid){
		QusandtestExample example = new QusandtestExample();
		Criteria criteria = example.createCriteria();
		criteria.andTestidEqualTo(testid);
		return qusandtestMapper.countByExample(example);
	}
	/**
	 * ��ȡ�����Ծ��е��Ծ����ж��ٸ���
	 * @return
	 */
	public int getPureTotalPage(){
		return selectCreateTestPaper().size();
	}
}
