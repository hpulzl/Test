package qb.edu.com.testsystem.shareprefrence;

/**
 * Created by wjb on 2015/12/13.
 */
public class Account {

    private String account;
    private String password;

    public void setAccount(String account){
        this.account=account;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getAccount(){
        return account;
    }

    public String getPassword(){
        return password;
    }
}