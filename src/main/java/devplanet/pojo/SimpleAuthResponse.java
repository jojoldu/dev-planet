package devplanet.pojo;

/**
 * Created by jojoldu@gmail.com on 2016-04-26.
 */
public class SimpleAuthResponse {
    private String userName;
    private boolean authentication;

    public SimpleAuthResponse() {
    }

    public SimpleAuthResponse(String userName, boolean authentication) {
        this.userName = userName;
        this.authentication = authentication;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean getAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }
}
