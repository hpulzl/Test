package qb.entity;

import java.util.List;
/**
 * ��Ҫ�ǲ��������Ծ���javabean
 * �����Ծ���еľ�����Ϣ��������еľ�����Ϣ
 * @author admin
 *
 */
public class QusTestPaper extends Testpaper{
	private Qusbank qusbank;
	private boolean isCreated;  //�Ƿ������Ծ�
	private int testCount;  //�Ծ�����
	
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
