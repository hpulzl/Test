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
 * ����Ա���Ծ�Ĳ���
 * ��Ҫ���ܰ���:
 * ����Աͨ���Ծ�idɾ���Ծ�ͨ���Ծ�����ɾ���Ծ����￼���Ծ�������Ψһ�ģ���
 * ����Աһ�������Ծ��ܡ�
 * @author admin
 */
public class AdminTestService extends AdminService<Testpaper>{
	private TestpaperMapper testpaperMapper;
	public AdminTestService(){
		testpaperMapper = MapperInstance.getMappperInstance("testpaperMapper");
	}
	/**
	 * ����ɾ��
	 * ɾ���Ծ�ʱ��ͬʱҲҪ�������Ծ��е��Ծ�ɾ����
	 */
	@Override
	public boolean adminDelete(String id) {
		QusandTestService qts = new QusandTestService();
		if(testpaperMapper.deleteByPrimaryKey(id)>0){
			//ͬʱɾ�������Ծ���е�����
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
	//��ѯȫ���������Ծ�����ѯ.
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
	//��ҳ��ѯ
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
		//ֻ���´����ֶβ�Ϊ�յ����ݡ�
		if(testpaperMapper.updateByPrimaryKeySelective(t)>0){
			return true;
		}
		return false;
	}
	//��ȡ��ҳ����
	public int getTotalPage(){
		return PageCountUtil.getTotalPage
		(testpaperMapper.countByExample(new TestpaperExample()));
	}
}
