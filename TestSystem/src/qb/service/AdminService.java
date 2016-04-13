package qb.service;

import java.util.List;

import qb.util.AdminAccount;

/**
 * �����ǹ���Ա�ĳ����࣬
 * ����Ҫ�������Ա�����в������Է�����
 * ����:
 * ����Ա ��ѯ��������ӷ�����ɾ�����޸ġ�
 * @author admin
 * @param <T>
 */
public abstract class AdminService<T> {
	//��ѯ������������ѯ
	public abstract List<T> adminSelect(String example);
	//���
	public abstract boolean adminInsert(T t);
	//ɾ��
	public abstract boolean adminDelete(String id);
	//�޸�
	public abstract boolean adminUpdate(T t);
	//��¼
	public boolean Login(String name,String password){
		if( AdminAccount.validateLogin(name, password).equals("��¼�ɹ�")){
			return true;
		}
		return false;
	}
}
