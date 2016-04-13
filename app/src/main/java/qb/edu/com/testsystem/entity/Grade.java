package qb.edu.com.testsystem.entity;

/**
 * Created by admin on 2016/4/9.
 * 成绩类
 * 试卷名，用户名，做题时间，分数
 *  mBundle.putString("testid",testid);
 mBundle.putString("testName",testName);
 mBundle.putString("userName",u.getName());
 */
public class Grade {
    private int gradeScore;
    private String username;
    private String testName;
    private String time;
    private String userid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getGradeScore() {
        return gradeScore;
    }

    public void setGradeScore(int gradeScore) {
        this.gradeScore = gradeScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeScore=" + gradeScore +
                ", username='" + username + '\'' +
                ", testName='" + testName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
