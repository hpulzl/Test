package qb.entity;

import java.util.List;
/**
 * 主要是操作试题试卷表的javabean
 * 包含试卷表中的具体信息和试题表中的具体信息
 * @author admin
 *
 */
public class QusTestPaper extends Testpaper{
	private Qusbank qusbank;
	private boolean isCreated;  //是否生成试卷
	private int testCount;  //试卷题量
	
	public QusTestPaper(){
		super();
	}
	public int getTestCount() {
		return testCount;
	}

	public void setTestCount(int testCount) {
		this.testCount = testCount;
	}

	public Qusbank getQusbank() {
		return qusbank;
	}
	public void setQusbank(Qusbank qusbank) {
		this.qusbank = qusbank;
	}
	public void setIsCreated(boolean is){
		this.isCreated = is;
	}
	public boolean getIsCreated(){
		return this.isCreated;
	}
}
