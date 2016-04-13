package qb.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import qb.entity.Qusbank;
import qb.entity.QusbankExample;
import qb.service.AdminQusService;
import qb.util.UUIDUtil;

public class AdminQusServiceTest {
	private AdminQusService aqs;
	boolean flag;
	@Before
	public void setUp() throws Exception {
		aqs = new AdminQusService(); 
	}
	public void testLogin(){
	}
	@Test
	public void testAdminDelete() {
		flag = aqs.adminDelete("2e05d492-9c1b-4128-bf4b-ecb3af188cba");
		System.out.println("删除结果:"+flag);
	}

	@Test
	public void testAdminQusService() {
	}

	@Test
	public void testAdminInsertQusbank() {
		Qusbank qusbank = new Qusbank();
		qusbank.setQusid(UUIDUtil.getUUId());
		qusbank.setQusissue("Chinese Wall 模型的设计宗旨是：A、用户只能访问哪些与已经拥有的信息不冲突的信息  B、用户可以访问所有信息  C、用户可以访问所有已经选择的信息		D、用户不可以访问哪些没有选择的信息");
		qusbank.setQustype("单选题");
		qusbank.setQusanswer("A");
		aqs.adminInsert(qusbank);
		System.out.println("试题插入成功!");
	}

	@Test
	public void testAdminSelectString() {
		List<Qusbank>  qusList= aqs.adminSelect("");
		for(Qusbank qus : qusList){
			System.out.println("问题:"+qus.getQusissue()+" 答案:"+qus.getQusanswer());
		}
	}
	@Test
	public void testSelect(){
	}
	@Test
	public void testAdminUpdateQusbank() {
	}
	@Test
	public void testLimitPage(){
		List<Qusbank> list = aqs.limitByPage(1, "");
		for(Qusbank qus : list){
			System.out.println("问题:"+qus.getQusissue()+" 答案:"+qus.getQusanswer());
		}
	}
	@Test
	public void testgetTotalPage(){
		System.out.println("-----"+aqs.getTotalPage());
	}
}
