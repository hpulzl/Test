package qb.util;

/**
 * 计算总共的页码
 * @author admin
 *
 */
public class PageCountUtil {
	public static final int pageCount = 7;   //一页显示的个数
	
	public static int getTotalPage(int totalCount){
		//数据库中的总记录数
		int total = totalCount;
		int totalPage = total / pageCount;
		//通过计算得出总页数.
		if(total % pageCount !=0){
			return totalPage+1;
		}
		return totalPage;
	}
}
