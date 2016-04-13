package qb.entity;

public class User {
    private String userid;

    private String username;

    private String password;

    private String userclass;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserclass() {
        return userclass;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass == null ? null : userclass.trim();
    }
}