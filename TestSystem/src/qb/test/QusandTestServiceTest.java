package qb.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import qb.entity.QusTestPaper;
import qb.entity.Qusandtest;
import qb.entity.Qusbank;
import qb.service.QusandTestService;

public class QusandTestServiceTest {
	private QusandTestService qts;
	@Before
	public void setUp() throws Exception {
		qts = new QusandTestService();
	}

	@Test
	public void testAdminDelete() {
		boolean flag = qts.adminDelete("9c94f006-b65d-4ee6-a6ea-da616b2217dc");
		System.out.println("删除结果..."+flag);
	}

	@Test
	public void testQusandTestService() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdminInsertQusTestPaper() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateTestPaper() {
		fail("Not yet implemented");
	}

	@Test
	public void testadminSelect(){
		List<QusTestPaper> list =qts.adminSelect("");
		System.out.println("获取的list个数:"+list.size());
		for(QusTestPaper qtPaper : list){
			System.out.println("数据:"+qtPaper.getTestid()+" name="
					+qtPaper.getTestname()+" 是否生成试卷:"+qtPaper.getIsCreated());
		}
	}
	@Test
	public void testSelectCreateTestPaper() {
		List<QusTestPaper> list= qts.limitByPage(1,"");
		System.out.println("试卷个数:"+list.size());
		for(QusTestPaper qt : list){
			System.out.println("试卷信息:"+qt.getTestname());
		}
	}
	@Test
	public void testLimitByPage(){
		List<QusTestPaper> list= qts.selectCreateTestPaper();
		System.out.println("试卷个数:"+list.size());
		for(QusTestPaper qt : list){
			System.out.println("试卷信息:"+qt.getTestname());
		}
	}
	@Test
	public void testAdminUpdateQusTestPaper() {
		fail("Not yet implemented");
	}
	@Test
	public void testlimitByPageToAndroid(){
		List<QusTestPaper>  qusTestList =qts.limitByPageToAndroid(1);
		for(QusTestPaper qtp : qusTestList){
			System.out.println(qtp.getTestname()+"-------"+qtp.getTestdifficult()+"题量："+qtp.getTestCount());
		}
	}
	@Test
	public void teststoreQusBankByTestid(){
		List<Qusbank> list= qts.storeQusBankByTestid("9c94f006-b65d-4ee6-a6ea-da616b2217dc");
		System.out.println("个数:"+list.size());
		for(Qusbank qus : list){
			System.out.println(qus.getQusanswer());
		}
	}
	@Test
	public void testdeleteByQusid(){
		System.out.println("删除结果:"+qts.deleteByQusid("8f1222ab-890b-464a-9ba0-8d04c77ba70e"));
	}
	@Test
	public void testdeleteByTestid(){
		System.out.println("删除结果:"+qts.deleteByTestid("15adab62-a47f-4cfe-90e9-12fa03eb12a3"));
	}
	@Test
	public void testcountByExample(){
		System.out.println("试卷题量:"+qts.countByExample("2364b47a-9396-42d7-ac4d-c80f1e1e2931"));
	}
	@Test
	public void testgetPureTotalPage(){
		System.out.println("总共的数据:"+qts.getPureTotalPage());
	}
}
