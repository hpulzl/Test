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
		System.out.println("ɾ�����:"+flag);
	}

	@Test
	public void testAdminQusService() {
	}

	@Test
	public void testAdminInsertQusbank() {
		Qusbank qusbank = new Qusbank();
		qusbank.setQusid(UUIDUtil.getUUId());
		qusbank.setQusissue("Chinese Wall ģ�͵������ּ�ǣ�A���û�ֻ�ܷ�����Щ���Ѿ�ӵ�е���Ϣ����ͻ����Ϣ  B���û����Է���������Ϣ  C���û����Է��������Ѿ�ѡ�����Ϣ		D���û������Է�����Щû��ѡ�����Ϣ");
		qusbank.setQustype("��ѡ��");
		qusbank.setQusanswer("A");
		aqs.adminInsert(qusbank);
		System.out.println("�������ɹ�!");
	}

	@Test
	public void testAdminSelectString() {
		List<Qusbank>  qusList= aqs.adminSelect("");
		for(Qusbank qus : qusList){
			System.out.println("����:"+qus.getQusissue()+" ��:"+qus.getQusanswer());
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
			System.out.println("����:"+qus.getQusissue()+" ��:"+qus.getQusanswer());
		}
	}
	@Test
	public void testgetTotalPage(){
		System.out.println("-----"+aqs.getTotalPage());
	}
}
