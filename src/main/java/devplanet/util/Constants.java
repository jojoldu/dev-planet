package devplanet.util;

/**
 * Created by jojoldu on 2016-03-27.
 */
public interface Constants {
   String URL_GET_ACCESS_TOKEN = "https://github.com/login/oauth/access_token";
   String URL_GET_USER_INFO = "https://api.github.com/user?access_token=";
   String URL_GET_REPOS = "https://api.github.com/users/:id/repos?access_token=";
   String DOMAIN = "http://localhost:8080";
   String OAUTH_REDIRECT_URI = DOMAIN + "/oauth/auth";
   String KEY_ACCESS_TOKEN = "access_token";
}
