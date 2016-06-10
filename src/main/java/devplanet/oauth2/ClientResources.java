package devplanet.oauth2;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

/**
 * Created by jojoldu@zuminternet.com on 2016-04-21.
 */
public class ClientResources {
    private OAuth2ProtectedResourceDetails client;
    private ResourceServerProperties resource;

    public ClientResources() {
        this.client = new AuthorizationCodeResourceDetails();
        this.resource = new ResourceServerProperties();
    }

    public OAuth2ProtectedResourceDetails getClient() {
        return client;
    }

    public ResourceServerProperties getResource() {
        return resource;
    }
}
