package qb.entity;

public class Qusandtest {
    private String qtid;

    private String qusid;

    private String testid;

    public String getQtid() {
        return qtid;
    }

    public void setQtid(String qtid) {
        this.qtid = qtid == null ? null : qtid.trim();
    }

    public String getQusid() {
        return qusid;
    }

    public void setQusid(String qusid) {
        this.qusid = qusid == null ? null : qusid.trim();
    }

    public String getTestid() {
        return testid;
    }

    public void setTestid(String testid) {
        this.testid = testid == null ? null : testid.trim();
    }
}