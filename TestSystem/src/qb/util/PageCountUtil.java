package qb.util;

/**
 * �����ܹ���ҳ��
 * @author admin
 *
 */
public class PageCountUtil {
	public static final int pageCount = 7;   //һҳ��ʾ�ĸ���
	
	public static int getTotalPage(int totalCount){
		//���ݿ��е��ܼ�¼��
		int total = totalCount;
		int totalPage = total / pageCount;
		//ͨ������ó���ҳ��.
		if(total % pageCount !=0){
			return totalPage+1;
		}
		return totalPage;
	}
}
