package qb.test;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.easymock.EasyMock.*;  
import org.junit.Before;
import org.junit.Test;

import qb.servlet.AdminLoginSer;

public class AdminLoginSerTest {
	private AdminLoginSer login;
    private HttpServletRequest mockRequest;  
    private HttpServletResponse mockResponse;  
	@Before
	public void setUp() throws Exception {
		login = new AdminLoginSer();
        mockRequest = createMock(HttpServletRequest.class);         //加载  
        mockResponse = createMock(HttpServletResponse.class);  
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
          
        try {
        	  mockRequest.getParameter("adminName");         //传入参数  
              expectLastCall().andReturn("1");  
                
              mockRequest.getParameter("adminPassword");       //传入参数  
              expectLastCall().andReturn("chevy");  
                
              replay(mockRequest);                    //回放  
              replay(mockResponse);
			login.doPost(mockRequest, mockResponse);
//              login.doGet(mockRequest, mockResponse);
			}
		catch (Exception e) {
			e.printStackTrace();
		}  
	}
}
