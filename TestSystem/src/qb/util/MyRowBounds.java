package qb.util;

import java.io.Serializable;

/**
 *  ��  org.apache.ibatis.session.RowBounds ���ƣ������pageNumber����
 *  
 * @author alexgaoyh
 *
 */
public class MyRowBounds implements Serializable{
 
    /**
     * 
     */
    private static final long serialVersionUID = -2860692762946249134L;
     
    public final static int NO_ROW_OFFSET = 0;
    public final static int NO_ROW_LIMIT = Integer.MAX_VALUE;
    public final static MyRowBounds DEFAULT = new MyRowBounds();
     
    public final static int NO_PAGENUMBER = 0;
 
    //ƫ����
    private int offset;
    //����
    private int limit;
    //ҳ��
    private int pageNumber;
    private int totalPage ;  //��¼�ܹ���ҳ��
 
    public MyRowBounds() {
        this.offset = NO_ROW_OFFSET;
        this.limit = NO_ROW_LIMIT;
        this.pageNumber = NO_PAGENUMBER;
    }
 
    public MyRowBounds(int offset, int limit, int pageNumber) {
        this.offset = offset;
        this.limit = limit;
        this.pageNumber = pageNumber;
    }
     
    /**
     * ����RowBoundsʵ����Ϣ
     * @param pageNumber ҳ��
     * @param pageSize һҳ����
     */
    public MyRowBounds(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.limit = pageSize;
        this.offset = (pageNumber - 1) * pageSize;
    }
	public int getOffset() {
        return offset;
    }
 
    public int getLimit() {
        return limit;
    }
 
    public int getPageNumber() {
        return pageNumber;
    }
 
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
 
    public void setLimit(int limit) {
        this.limit = limit;
    }

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
    
}
