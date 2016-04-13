package qb.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import qb.entity.Wrongqus;
import qb.entity.WrongqusExample;
import qb.entity.WrongqusExample.Criteria;
import qb.mapper.WrongqusMapper;
import qb.util.MapperInstance;

/**
 * ���⼯�ĵ��ýӿ�
 * @author admin
 *	��Ӵ��⣬ɾ�����⣬���Ҵ���
 */
public class WrongqusService {
	private WrongqusMapper wm;
	public WrongqusService() {
		wm = MapperInstance.getMappperInstance("wrongqusMapper");
	}
	/**
	 * ���������Ϣ
	 * @param wrong
	 * @return
	 */
	public boolean insertWrongQus(Wrongqus wrong){
		if(wm.insertSelective(wrong) > 0){
			return true;
		}
		return false;
	}
	/**
	 * ɾ�����⼯��ͨ����Ӧ��userid��qusid����ɾ����
	 * @param wrong
	 * @return
	 */
	public boolean deleteWrongQus(Wrongqus wrong){
		WrongqusExample example = new WrongqusExample();
		Criteria criteria =  example.createCriteria();
		criteria.andQusidEqualTo(wrong.getQusid());
		criteria.andUseridEqualTo(wrong.getUserid());
		if(wm.deleteByExample(example)>0){
			return true;
		}
			return false;
	}
	/**
	 * ������������idɾ�����ݡ�
	 * @param example
	 * @return
	 */
	public boolean deleteByQusid(String qusid){
		WrongqusExample example = new WrongqusExample();
		Criteria criteria =  example.createCriteria();
		criteria.andQusidEqualTo(qusid);
		if(wm.deleteByExample(example)>0){
			return true;
		}
		return false;
	}
	/**
	 * ͨ��userid���Ҵ��⣬
	 * @param userid
	 * @return
	 */
	public Set<Wrongqus> selectWrongqusList(String userid){
		WrongqusExample example = new WrongqusExample();
		Criteria criteria =  example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Wrongqus> list= wm.selectByExample(example);
		Set<Wrongqus> set = new HashSet<Wrongqus>(); //ȥ���ظ�������
		for(Wrongqus w : list){
			set.add(w);
		}
		return set;
	}
}
