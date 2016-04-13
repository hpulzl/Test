package qb.edu.com.testsystem.entity;

/**
 * Created by admin on 2016/4/7.
 * 试题试卷类
 * 主要是存储试卷的详细信息，
 * 以及试卷id
 */
public class QusTestPaper extends Testpaper{
    private int testCount;  //试卷题量

    public int getTestCount() {
        return testCount;
    }

    public void setTestCount(int testCount) {
        this.testCount = testCount;
    }

    @Override
    public String toString() {
        return "QusTestPaper{" +
                "testCount=" + testCount +
                '}';
    }
}
