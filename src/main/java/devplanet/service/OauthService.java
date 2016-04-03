package devplanet.service;

import devplanet.model.User;

/**
 * Created by jojoldu on 2016-03-27.
 */
public interface OauthService {
    User getAuth(String code);
}
