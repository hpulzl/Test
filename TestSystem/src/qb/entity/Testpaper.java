package qb.entity;

public class Testpaper {
    private String testid;

    private String testname;

    private String testdifficult;

    public String getTestid() {
        return testid;
    }

    public void setTestid(String testid) {
        this.testid = testid == null ? null : testid.trim();
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname == null ? null : testname.trim();
    }

    public String getTestdifficult() {
        return testdifficult;
    }

    public void setTestdifficult(String testdifficult) {
        this.testdifficult = testdifficult == null ? null : testdifficult.trim();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((testdifficult == null) ? 0 : testdifficult.hashCode());
		result = prime * result + ((testid == null) ? 0 : testid.hashCode());
		result = prime * result
				+ ((testname == null) ? 0 : testname.hashCode());
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
		Testpaper other = (Testpaper) obj;
		if (testdifficult == null) {
			if (other.testdifficult != null)
				return false;
		} else if (!testdifficult.equals(other.testdifficult))
			return false;
		if (testid == null) {
			if (other.testid != null)
				return false;
		} else if (!testid.equals(other.testid))
			return false;
		if (testname == null) {
			if (other.testname != null)
				return false;
		} else if (!testname.equals(other.testname))
			return false;
		return true;
	}
}