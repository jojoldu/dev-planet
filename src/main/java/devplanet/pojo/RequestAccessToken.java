package devplanet.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jojoldu on 2016-03-27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestAccessToken {

    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String state;


    public RequestAccessToken() {
    }

    public RequestAccessToken(String clientId, String clientSecret, String code, String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.code = code;
        this.redirectUri = redirectUri;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
