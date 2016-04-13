package qb.service;

import java.util.List;

import qb.util.AdminAccount;

/**
 * 该类是管理员的抽象超类，
 * 里面要定义管理员的所有操作共性方法。
 * 包括:
 * 管理员 查询方法，添加方法，删除，修改。
 * @author admin
 * @param <T>
 */
public abstract class AdminService<T> {
	//查询，包括条件查询
	public abstract List<T> adminSelect(String example);
	//添加
	public abstract boolean adminInsert(T t);
	//删除
	public abstract boolean adminDelete(String id);
	//修改
	public abstract boolean adminUpdate(T t);
	//登录
	public boolean Login(String name,String password){
		if( AdminAccount.validateLogin(name, password).equals("登录成功")){
			return true;
		}
		return false;
	}
}
