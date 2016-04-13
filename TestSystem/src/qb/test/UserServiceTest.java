package qb.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import qb.entity.User;
import qb.service.UserService;

public class UserServiceTest {
	private UserService us;
	@Before
	public void setUp() throws Exception {
		us = new UserService();
	}

	@Test
	public void testSelectUserList() {
		List<User> listUser = us.selectUserList();
		for(User u : listUser){
			System.out.println("u:"+u.getUsername()+" u "+u.getUserid());
		}
	}
	@Test
	public void testuserListByPage(){
		List<User> listUser = us.userListByPage(2, 3);
		System.out.println("个数:"+listUser.size());
		for(User u : listUser){
			System.out.println("u:"+u.getUsername()+" u "+u.getUserid());
		}
	}
	@Test
	public void testselectById(){
		User u = us.selectById("00feb9a1-f216-4000-817c-5e76af57ced4");
		System.out.println(u.getUsername()+"---"+u.getUserclass());
	}
	@Test
	public void testUpdateUser(){
		User u = new User();
		u.setUserid("16ec080f-d9d3-4528-9f2f-3c220f30ce09");
		u.setUsername("去...");
		u.setUserclass("高三");
		u.setPassword("33333");
		System.out.println("修改结果:"+us.updateUser(u));
		
	}
	@Test
	public void selectUserService(){
		List<User> list= us.selectAllUser();
		for(User u : list){
			System.out.println("--"+u.getUsername());
		}
	}
	@Test
	public void testInsert(){
		User u = new User();
		u.setUsername("username");
		u.setPassword("password");
		u.setUserclass("classGrade");
		u.setUserid("name");
		us.insertUser(u);
	}
}
