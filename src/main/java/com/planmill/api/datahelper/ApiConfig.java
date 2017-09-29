package com.planmill.api.datahelper;

import com.planmill.api.datahelper.http.PmClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class ApiConfig {

    @Value("${api.tokenUrl}")
    private String tokenUrl;

    @Value("${api.clientId}")
    private String clientId;

    @Value("${api.clientSecret}")
    private String clientSecret;

    @Bean
    public OAuth2RestOperations restTemplate() {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        OAuth2RestTemplate template = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
        //uncomment to see http message content
        //template.getInterceptors().add(new PmClientHttpRequestInterceptor());
        return template;
    }

    @Bean
    protected OAuth2ProtectedResourceDetails resource() {
        ClientCredentialsResourceDetails  resource = new ClientCredentialsResourceDetails ();
        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId(clientId);
        resource.setClientSecret(clientSecret);
        resource.setClientAuthenticationScheme(AuthenticationScheme.form);
        return resource;
    }
}
