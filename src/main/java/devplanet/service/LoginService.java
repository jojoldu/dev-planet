package devplanet.service;

import devplanet.model.User;

import javax.servlet.http.HttpSession;

/**
 * Created by jojoldu on 2016-03-27.
 */
public interface LoginService {
    User getAuth(HttpSession session, String code);
}
