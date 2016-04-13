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
//		flag = ats.deleteByExample("��Ϣ��ȫ�����");
		System.out.println("ɾ��״̬��"+flag);
	}

	@Test
	public void testAdminInsertTestpaper() {
		Testpaper testpaper = new Testpaper();
		testpaper.setTestid(UUIDUtil.getUUId());
		testpaper.setTestdifficult("�ߵ��Ѷ�");
		testpaper.setTestname("��Ϣ��ȫ������");
		flag = ats.adminInsert(testpaper);
		System.out.println("����״̬��"+flag);
	}

	@Test
	public void testAdminSelectString() {
		String example = "��Ϣ��ȫ����";
		System.out.println(ats.adminSelect(example).size());
	}
	@Test
	public void testLimitByPage(){
		List<Testpaper> list =ats.limitByPage(2, "");
		for(Testpaper t : list){
			System.out.println("��Ϣ��"+t.getTestname()+"------");
		}
	}
	@Test
	public void testTotalPage(){
		System.out.println("----ҳ��:"+ats.getTotalPage());
	}
	
	//�С��͡��ߵ��Ѷȷֱ�����ĸ��ʾ M��L��H
	@Test
	public void testAdminUpdateTestpaper() {
		Testpaper testpaper = new Testpaper();
		testpaper.setTestid("352e880b-61d1-464f-8e8e-a460b2ccc132");
		testpaper.setTestdifficult("�ߵ��Ѷ�");
		testpaper.setTestname("��Ϣ��ȫ����ʮ��");
		flag = ats.adminUpdate(testpaper);
		System.out.println("����״̬��"+flag);
	}
	
}
