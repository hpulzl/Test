package qb.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import qb.entity.Testpaper;
import qb.service.AdminTestService;
import qb.util.UUIDUtil;

public class AdminTestServiceTest {
	private AdminTestService ats ;
	private boolean  flag;
	@Before
	public void setUp() throws Exception {
		ats = new AdminTestService();
	}
	@Test
	public void testAdminDelete() {
		flag = ats.adminDelete("9fabc5b5-888f-4d31-bcc2-5355b3b0daad");
//		flag = ats.deleteByExample("信息安全真题二");
		System.out.println("删除状态："+flag);
	}

	@Test
	public void testAdminInsertTestpaper() {
		Testpaper testpaper = new Testpaper();
		testpaper.setTestid(UUIDUtil.getUUId());
		testpaper.setTestdifficult("高等难度");
		testpaper.setTestname("信息安全真题三");
		flag = ats.adminInsert(testpaper);
		System.out.println("插入状态："+flag);
	}

	@Test
	public void testAdminSelectString() {
		String example = "信息安全真题";
		System.out.println(ats.adminSelect(example).size());
	}
	@Test
	public void testLimitByPage(){
		List<Testpaper> list =ats.limitByPage(2, "");
		for(Testpaper t : list){
			System.out.println("信息："+t.getTestname()+"------");
		}
	}
	@Test
	public void testTotalPage(){
		System.out.println("----页数:"+ats.getTotalPage());
	}
	
	//中、低、高等难度分别用字母表示 M、L、H
	@Test
	public void testAdminUpdateTestpaper() {
		Testpaper testpaper = new Testpaper();
		testpaper.setTestid("352e880b-61d1-464f-8e8e-a460b2ccc132");
		testpaper.setTestdifficult("高等难度");
		testpaper.setTestname("信息安全真题十二");
		flag = ats.adminUpdate(testpaper);
		System.out.println("更新状态："+flag);
	}
	
}
