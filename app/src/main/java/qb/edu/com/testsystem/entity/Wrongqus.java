package qb.edu.com.testsystem.entity;
/**
 * 错题表
 */
public class Wrongqus {
    private String wqid;

    private String userid;

    private String qusid;

    public String getWqid() {
        return wqid;
    }

    public void setWqid(String wqid) {
        this.wqid = wqid == null ? null : wqid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getQusid() {
        return qusid;
    }

    public void setQusid(String qusid) {
        this.qusid = qusid == null ? null : qusid.trim();
    }

    @Override
    public String toString() {
        return "Wrongqus{" +
                "wqid='" + wqid + '\'' +
                ", userid='" + userid + '\'' +
                ", qusid='" + qusid + '\'' +
                '}';
    }
}