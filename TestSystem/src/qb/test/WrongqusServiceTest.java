package qb.test;

import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import qb.entity.Wrongqus;
import qb.service.WrongqusService;

public class WrongqusServiceTest {
	private WrongqusService ws;
	@Before
	public void setUp() throws Exception {
		ws = new WrongqusService();
	}

	@Test
	public void testWrongqusService() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertWrongQus() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteWrongQus() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByQusid() {
		System.out.println("É¾³ý½á¹û:"+ws.deleteByQusid("04d3785a-37e4-4552-baa0-5506c85ed4f6"));
	}

	@Test
	public void testSelectWrongqusList() {
		fail("Not yet implemented");
	}
	@Test
	public void testselectWrongqusList(){
		Set<Wrongqus> set=ws.selectWrongqusList("311209065");
		System.out.println("set==="+set.size());
		for(Wrongqus w :set){
			System.out.println("---"+w.getQusid());
		}
	}

}
