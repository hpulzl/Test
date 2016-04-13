package qb.entity;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qusid == null) ? 0 : qusid.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wrongqus other = (Wrongqus) obj;
		if (qusid == null) {
			if (other.qusid != null)
				return false;
		} else if (!qusid.equals(other.qusid))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
}