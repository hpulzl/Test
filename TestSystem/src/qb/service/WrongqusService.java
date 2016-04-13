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
 * 错题集的调用接口
 * @author admin
 *	添加错题，删除错题，查找错题
 */
public class WrongqusService {
	private WrongqusMapper wm;
	public WrongqusService() {
		wm = MapperInstance.getMappperInstance("wrongqusMapper");
	}
	/**
	 * 插入错题信息
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
	 * 删除错题集，通过对应的userid和qusid进行删除。
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
	 * 按照条件试题id删除数据。
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
	 * 通过userid查找错题，
	 * @param userid
	 * @return
	 */
	public Set<Wrongqus> selectWrongqusList(String userid){
		WrongqusExample example = new WrongqusExample();
		Criteria criteria =  example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Wrongqus> list= wm.selectByExample(example);
		Set<Wrongqus> set = new HashSet<Wrongqus>(); //去掉重复的数据
		for(Wrongqus w : list){
			set.add(w);
		}
		return set;
	}
}
