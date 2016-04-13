package qb.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import qb.util.CreateQusbankUtil;

public class CreateQusbankUtilTest {
	private CreateQusbankUtil cqUtil;
	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		cqUtil = cqUtil.SingleInstance();
	}

	@Test
	public void testSelectQusid() {
		List<String> strList = cqUtil.selectQusid();
		for(String str : strList){
			System.out.println("str="+str);
		}
	}

}
