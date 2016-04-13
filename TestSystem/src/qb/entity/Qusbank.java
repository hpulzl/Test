package qb.entity;

public class Qusbank {
    private String qusid;

    private String qustype;

    private String qusanswer;

    private String qusissue;

    public String getQusid() {
        return qusid;
    }

    public void setQusid(String qusid) {
        this.qusid = qusid == null ? null : qusid.trim();
    }

    public String getQustype() {
        return qustype;
    }

    public void setQustype(String qustype) {
        this.qustype = qustype == null ? null : qustype.trim();
    }

    public String getQusanswer() {
        return qusanswer;
    }

    public void setQusanswer(String qusanswer) {
        this.qusanswer = qusanswer == null ? null : qusanswer.trim();
    }

    public String getQusissue() {
        return qusissue;
    }

    public void setQusissue(String qusissue) {
        this.qusissue = qusissue == null ? null : qusissue.trim();
    }
}