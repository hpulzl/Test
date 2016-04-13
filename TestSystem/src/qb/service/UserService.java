package qb.service;

import java.util.List;

import qb.entity.User;
import qb.entity.UserExample;
import qb.mapper.UserMapper;
import qb.util.MapperInstance;
import qb.util.MyRowBounds;

/**
 * ����Ϊ�û��ṩ���õľ���ʵ�֡�
 * @author admin
 *	��¼��ע�ᣬ��ѯ���У�����id��ѯ���޸ġ�
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
	 * ��ҳ����
	 * @param pageNo ҳ��
	 * @param count һҳ��ʾ�ĸ���
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
	 * ��ȡ���ݿ��е�����
	 * @return
	 */
	public int totalCount(){
		return um.countByExample(new UserExample());
	}
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param key
	 * @return
	 */
	public User selectById(String key){
		return um.selectById(key);
	}
	/**
	 * ��������
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
	 * ��������
	 */
	public boolean updateUser(User user){
		if(um.updateUser(user)>0){
			return true;
		}
		return false;
	}
	/**
	 * �û��ĵ�¼
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean userLogin(String username,String password){
		List<User> list = selectAllUser();
		for(User u : list){
			if(u.getUserid().equals(username)
					&&u.getPassword().equals(password)){  //�Ƚ��û�id������
				return true;
			}
		}
		return false;
	}
}
