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
 * 试题试卷表的相关操作
 * 主要是生成试卷、删除试卷。
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
	 * 根据testid去删除试卷试题表中的数据
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
	//通过testid和qusid一键生成试卷试题表。
	@SuppressWarnings("static-access")
	public boolean createTestPaper(String testid){
		cqUtil = cqUtil.SingleInstance();
		List<String> qusidList = cqUtil.selectQusid(); 
		for(String qusid : qusidList){
			Qusandtest qusandtest = new Qusandtest();
			//testid是一个试卷中的外键。
			qusandtest.setQusid(qusid);
			qusandtest.setTestid(testid);
			qusandtestMapper.insert(qusandtest);
		}
		return true;
	}
	/**
	 * 这里的example不需要传入关键字来查询。
	 * 这里是获取试卷中试题和试卷的具体信息，
	 * 并且放入到list集合中。
	 */
	@Override
	public List<QusTestPaper> adminSelect(String example) {
		List<QusTestPaper> allTestpaper = new ArrayList<QusTestPaper>();
		//现在获取试卷表中查询所有的试卷。
		List<Testpaper> testPaperList = ats.adminSelect("");
		//这里是获取所有的试题表中的试卷信息，并且装入到
		for(Testpaper t :testPaperList){
			QusTestPaper qusTest = new QusTestPaper();
			qusTest.setTestid(t.getTestid());
			qusTest.setTestdifficult(t.getTestdifficult());
			qusTest.setTestname(t.getTestname());
			//这里遍历试题试卷表，来判断试卷是否生成了试卷
			for(QusTestPaper qusTestpaper : selectCreateTestPaper()){
				//如果试题试卷表中不存在该试卷的id，表明没有生成试卷
				if(qusTestpaper.getTestid().equals(t.getTestid())){
					qusTest.setIsCreated(true);
				}
			}
			//放入到list中
			allTestpaper.add(qusTest);
		}
		return allTestpaper;
	}
	//进行分页查询
	public List<QusTestPaper> limitByPage(int pageNo,String example){
		List<QusTestPaper> allTestpaper = new ArrayList<QusTestPaper>();
		//现在获取试卷表中查询所有的试卷。
		List<Testpaper> testPaperList = ats.limitByPage(pageNo, example);
		//这里是获取所有的试题表中的试卷信息，并且装入到
		for(Testpaper t :testPaperList){
			QusTestPaper qusTest = new QusTestPaper();
			qusTest.setTestid(t.getTestid());
			qusTest.setTestdifficult(t.getTestdifficult());
			qusTest.setTestname(t.getTestname());
			//这里遍历试题试卷表，来判断试卷是否生成了试卷
			for(QusTestPaper qusTestpaper : selectCreateTestPaper()){
				//如果试题试卷表中不存在该试卷的id，表明没有生成试卷
				if(qusTestpaper.getTestid().equals(t.getTestid())){
					qusTest.setIsCreated(true);
				}
			}
			//放入到list中
			allTestpaper.add(qusTest);
		}
		return allTestpaper;
	}
	/**
	 * 通过pageNo获取试卷以及试题的内容。
	 * @param pageNo
	 * @return
	 */
	public List<QusTestPaper> limitByPageToAndroid(int pageNo){
		List<QusTestPaper> allTestpaper = new ArrayList<QusTestPaper>();
		//现在获取试卷表中查询所有的试卷。
		List<Testpaper> testPaperList = ats.limitByPage(pageNo,"");
		//这里是获取所有的试题表中的试卷信息，并且装入到
		for(Testpaper t :testPaperList){
			QusTestPaper qusTest = new QusTestPaper();
			qusTest.setTestid(t.getTestid());
			qusTest.setTestdifficult(t.getTestdifficult());
			qusTest.setTestname(t.getTestname());
			//这里遍历试题试卷表，来判断试卷是否生成了试卷
			for(QusTestPaper qusTestpaper : selectCreateTestPaper()){
				//如果试题试卷表中不存在该试卷的id，表明没有生成试卷
				if(qusTestpaper.getTestid().equals(t.getTestid())){
					qusTest.setIsCreated(true);
					qusTest.setTestCount(countByExample(t.getTestid()));
					//放入到list中，这里只存储生成了试卷的数据
					allTestpaper.add(qusTest);
				}
			}
		}
		return allTestpaper;
	}
	/**
	 * 通过试题试卷表中的testid，查找生成过的试卷信息。
	 * @return qusTestPaperList
	 */
	public List<QusTestPaper> selectCreateTestPaper(){
		//首先查找试题试卷表中的信息。
		List<Qusandtest> list = 
			qusandtestMapper.selectByExample(new QusandtestExample());
		return getPureList(list);
	}
	/**
	 * 该类用来获取不重复的list数据
	 * @param 
	 * @return
	 */
	private List<QusTestPaper> getPureList(List<Qusandtest> list){
		List<QusTestPaper> qusTestPaperList = new ArrayList<QusTestPaper>();
		HashSet<Testpaper> set = new HashSet<Testpaper>();
		for(Qusandtest qusandtest : list){
			Testpaper t = ats.selectTestpaper(qusandtest.getTestid());
			set.add(t);  //通过set中的add方法可以避免加入重复的数据。
		}
		for(Testpaper tp : set){
			QusTestPaper qusTestPaper = new QusTestPaper();
			//将其装入到试题试卷类中
			qusTestPaper.setTestid(tp.getTestid());
			qusTestPaper.setTestname(tp.getTestname());
			qusTestPaper.setTestdifficult(tp.getTestdifficult());
			qusTestPaper.setIsCreated(true); //在试题试卷表中查询的试卷信息表明已经生成试卷。
			
			qusTestPaperList.add(qusTestPaper);
		}
		return qusTestPaperList; 
	}
	/**
	 * 在试题试卷表中通过testid，获取所有的试题信息
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
	/**通过试卷id
	 * 获取该表中的所有试题id
	 * @param testid
	 * @return
	 */
	public List<String> storeQusid(String testid){
		return qusandtestMapper.selectByTestid(testid);
	}
	/**
	 * 通过qusid删除试题试卷表中的该试题。
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
	 * 通过testid删除试题试卷表中的该试卷。
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
	 * 通过试卷id，计算改试卷有多少试题.
	 * @return
	 */
	public int countByExample(String testid){
		QusandtestExample example = new QusandtestExample();
		Criteria criteria = example.createCriteria();
		criteria.andTestidEqualTo(testid);
		return qusandtestMapper.countByExample(example);
	}
	/**
	 * 获取试题试卷中的试卷到底有多少个。
	 * @return
	 */
	public int getPureTotalPage(){
		return selectCreateTestPaper().size();
	}
}
