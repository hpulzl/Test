package qb.service;

import java.util.List;

import qb.entity.Qusandtest;
import qb.entity.Testpaper;
import qb.entity.TestpaperExample;
import qb.mapper.QusandtestMapper;
import qb.mapper.TestpaperMapper;
import qb.util.MapperInstance;
import qb.util.MyRowBounds;
import qb.util.PageCountUtil;
/**
 * 管理员对试卷的操作
 * 主要功能包括:
 * 管理员通过试卷id删除试卷，通过试卷名称删除试卷（这里考虑试卷名称是唯一的）。
 * 管理员一键生成试卷功能。
 * @author admin
 */
public class AdminTestService extends AdminService<Testpaper>{
	private TestpaperMapper testpaperMapper;
	public AdminTestService(){
		testpaperMapper = MapperInstance.getMappperInstance("testpaperMapper");
	}
	/**
	 * 级联删除
	 * 删除试卷时候，同时也要讲试题试卷中的试卷删除。
	 */
	@Override
	public boolean adminDelete(String id) {
		QusandTestService qts = new QusandTestService();
		if(testpaperMapper.deleteByPrimaryKey(id)>0){
			//同时删除试题试卷表中的数据
			qts.deleteByTestid(id);
			return true;
		}
		return false;
	}
	public boolean deleteByExample(String example){
		TestpaperExample testpaper = new TestpaperExample();
		TestpaperExample.Criteria criteria = testpaper.createCriteria();
		if(example!=null || example!=""){
			criteria.andTestnameLike(example);
			if(testpaperMapper.deleteByExample(testpaper)>0){
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean adminInsert(Testpaper t) {
		if(testpaperMapper.insert(t)>0){
			return true;
		}
		return false;
	}
	//查询全部，根据试卷名查询.
	@Override
	public List<Testpaper> adminSelect(String example) {
		TestpaperExample testpaper = new TestpaperExample();
		TestpaperExample.Criteria criteria = testpaper.createCriteria();
		if(example==null||example ==""){
			return testpaperMapper.selectByExample(testpaper);
		}
		criteria.andTestnameLike(example);
		return testpaperMapper.selectByExample(testpaper);
	}
	//分页查询
	public List<Testpaper> limitByPage(int pageNo,String example){
		TestpaperExample testpaper = new TestpaperExample();
		testpaper.setRowBounds(new MyRowBounds(pageNo,PageCountUtil.pageCount));
		TestpaperExample.Criteria criteria = testpaper.createCriteria();
		if(example==null||example ==""){
			return testpaperMapper.selectByExample(testpaper);
		}
		criteria.andTestnameLike(example);
		return testpaperMapper.selectByExample(testpaper);
	}
	public Testpaper selectTestpaper(String id){
		return testpaperMapper.selectByPrimaryKey(id);
	}
	@Override
	public boolean adminUpdate(Testpaper t) {
		//只更新传入字段不为空的数据。
		if(testpaperMapper.updateByPrimaryKeySelective(t)>0){
			return true;
		}
		return false;
	}
	//获取总页码数
	public int getTotalPage(){
		return PageCountUtil.getTotalPage
		(testpaperMapper.countByExample(new TestpaperExample()));
	}
}
