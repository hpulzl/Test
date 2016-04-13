package qb.service;

import java.util.List;

import qb.entity.User;
import qb.entity.UserExample;
import qb.mapper.UserMapper;
import qb.util.MapperInstance;
import qb.util.MyRowBounds;

/**
 * 这里为用户提供调用的具体实现。
 * @author admin
 *	登录，注册，查询所有，根据id查询，修改。
 */
public class UserService {
	private UserMapper um;
	public UserService(){
		um = MapperInstance.getMappperInstance("userMapper");
	}
	public List<User> selectUserList(){
		UserExample example = new UserExample();
		return um.selectByExample(example);
	}
	/**
	 * 分页操作
	 * @param pageNo 页码
	 * @param count 一页显示的个数
	 * @return
	 */
	public List<User> userListByPage(int pageNo,int count){
		UserExample example = new UserExample();
		example.setRowBounds(new MyRowBounds(pageNo,count));
		return um.selectByExample(example);
	}
	public List<User> selectAllUser(){
		UserExample example = new UserExample();
		return um.selectByExample(example);
	}
	/**
	 * 获取数据库中的总数
	 * @return
	 */
	public int totalCount(){
		return um.countByExample(new UserExample());
	}
	/**
	 * 根据id查询用户信息
	 * @param key
	 * @return
	 */
	public User selectById(String key){
		return um.selectById(key);
	}
	/**
	 * 插入数据
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user){
		if(um.insertSelective(user)>0){
			return true;
		}
		return false;
	}
	/**
	 * 更新数据
	 */
	public boolean updateUser(User user){
		if(um.updateUser(user)>0){
			return true;
		}
		return false;
	}
	/**
	 * 用户的登录
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean userLogin(String username,String password){
		List<User> list = selectAllUser();
		for(User u : list){
			if(u.getUserid().equals(username)
					&&u.getPassword().equals(password)){  //比较用户id和密码
				return true;
			}
		}
		return false;
	}
}
