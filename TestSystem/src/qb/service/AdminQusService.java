package qb.service;

import java.util.List;

import qb.entity.Qusbank;
import qb.entity.QusbankExample;
import qb.mapper.QusbankMapper;
import qb.util.AdminAccount;
import qb.util.MapperInstance;
import qb.util.MyRowBounds;
import qb.util.PageCountUtil;
/**
 * ����Ա��service��
 * ����Ա�������Ĺ������:
 * ����ֻ�ṩ����Ա�ĵ�¼��֤���ݡ�
 * ����Ա������⡢�޸����⡢ɾ�����⡢��ѯ���⡣
 * ��ѯ��������ѯ��������Ͱ��չ����ѯ���⡣
 * @author admin
 */
public class AdminQusService extends AdminService<Qusbank>{
	private QusbankMapper qusbankMapper;
	private WrongqusService ws;
	private QusandTestService qts;
	public AdminQusService(){
		qusbankMapper = MapperInstance.getMappperInstance("qusbankMapper");
	}
	/**
	 * ���ڱ�Ĺ����ԣ�ɾ������ʱ����Ҫͬʱɾ�������Ծ���еĸ����⣬
	 * �Լ�������еĸ�����
	 */
	@Override
	public boolean adminDelete(String id) {
		ws = new WrongqusService();
		qts = new QusandTestService();
		if(qusbankMapper.deleteByPrimaryKey(id)>0){
			//ɾ�����⼯�и����ݣ��������ڣ�����false
			ws.deleteByQusid(id);
			//ɾ�������Ծ��и����ݡ�
			qts.deleteByQusid(id);
			return true;
		}
		return false;
	}
	@Override
	public boolean adminInsert(Qusbank t) {
		if(qusbankMapper.insert(t)>0){
			return true;
		}
		return false;
	}
	@Override
	public List<Qusbank> adminSelect(String example) {
		QusbankExample qusbankExample = new QusbankExample();
		QusbankExample.Criteria criteria = qusbankExample.createCriteria();
		if(example == "" || example==null){
			return qusbankMapper.selectByExample(qusbankExample);
		}
		//����Ļ�ִ������ĸ�����Ŀ���Ͳ�ѯ��
		criteria.andQustypeEqualTo(example);
		return qusbankMapper.selectByExample(qusbankExample);
	}
	/**
	 * ��ҳ
	 * @param pageNo ֻͨ��ҳ����д���
	 * @return
	 */
	public List<Qusbank> limitByPage(int pageNo,String example){
		System.out.println("pageNo===="+pageNo);
		QusbankExample qusbankExample = new QusbankExample();
		QusbankExample.Criteria criteria = qusbankExample.createCriteria();
		qusbankExample.setRowBounds(new MyRowBounds(pageNo,PageCountUtil.pageCount));
		if(example == "" || example==null){
			return qusbankMapper.selectByExample(qusbankExample);
		}
		//����Ļ�ִ������ĸ�����Ŀ���Ͳ�ѯ��
		criteria.andQustypeEqualTo(example);
		return qusbankMapper.selectByExample(qusbankExample);
	}
	@Override
	public boolean adminUpdate(Qusbank t) {
		//ֻ���´����ֶβ�Ϊ�յ����ݡ�
		if(qusbankMapper.updateByPrimaryKeySelective(t)>0){
			return true;
		}
		return false;
	}
	public Qusbank selectQusbank(String qusid){
		return qusbankMapper.selectByPrimaryKey(qusid);
	}
	//��ȡ���ݿ��иñ�ĸ���..
	public int getTotalPage(){
		return PageCountUtil.getTotalPage
					(qusbankMapper.countByExample(new QusbankExample()));
	}
}
