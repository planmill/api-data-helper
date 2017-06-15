package com.planmill.api.datahelper.service;

import com.planmill.api.datahelper.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Slf4j
@Service
public class UserService {

    @Value("${api.baseUrl}")
    private String baseUrl;
    private static final String URL_SUFFIX = "/users";

    @Autowired
    private OAuth2RestOperations restTemplate;

    public User addUser(User user) {
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(baseUrl+URL_SUFFIX, user, User.class);
        return userResponseEntity.getBody();
    }

    public User getMe() {
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(baseUrl+"/me", User.class);
        return userResponseEntity.getBody();
    }
}
