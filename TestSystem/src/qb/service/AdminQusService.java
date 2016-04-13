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
 * 管理员的service类
 * 管理员对试题库的管理操作:
 * 这里只提供管理员的登录验证数据。
 * 管理员添加试题、修改试题、删除试题、查询试题。
 * 查询包括：查询所有试题和按照规则查询试题。
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
	 * 由于表的关联性，删除试题时候，需要同时删除试题试卷表中的该试题，
	 * 以及错题表中的该试题
	 */
	@Override
	public boolean adminDelete(String id) {
		ws = new WrongqusService();
		qts = new QusandTestService();
		if(qusbankMapper.deleteByPrimaryKey(id)>0){
			//删除错题集中该数据，若不存在，返回false
			ws.deleteByQusid(id);
			//删除试题试卷中该数据。
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
		//否则的话执行下面的根据题目类型查询。
		criteria.andQustypeEqualTo(example);
		return qusbankMapper.selectByExample(qusbankExample);
	}
	/**
	 * 分页
	 * @param pageNo 只通过页码进行传递
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
		//否则的话执行下面的根据题目类型查询。
		criteria.andQustypeEqualTo(example);
		return qusbankMapper.selectByExample(qusbankExample);
	}
	@Override
	public boolean adminUpdate(Qusbank t) {
		//只更新传入字段不为空的数据。
		if(qusbankMapper.updateByPrimaryKeySelective(t)>0){
			return true;
		}
		return false;
	}
	public Qusbank selectQusbank(String qusid){
		return qusbankMapper.selectByPrimaryKey(qusid);
	}
	//获取数据库中该表的个数..
	public int getTotalPage(){
		return PageCountUtil.getTotalPage
					(qusbankMapper.countByExample(new QusbankExample()));
	}
}
