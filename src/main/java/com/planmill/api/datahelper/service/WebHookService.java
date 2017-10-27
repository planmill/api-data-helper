package com.planmill.api.datahelper.service;

import com.planmill.api.datahelper.model.Hook;
import com.planmill.api.datahelper.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to manage webhooks in planmill.
 *
 * Created by konstantin.petrukhnov@planmill.com on 2017-10-27.
 */
@Slf4j
@Service
public class WebHookService {

    @Value("${api.baseUrl}")
    private String baseUrl;
    private static final String URL_SUFFIX = "/hooks";

    @Autowired
    private OAuth2RestOperations restTemplate;

    public Hook addHook(Hook hook) {
        ResponseEntity<Hook> hookResponseEntity = restTemplate.postForEntity(baseUrl+URL_SUFFIX, hook, Hook.class);
        return hookResponseEntity.getBody();
    }

    public List<Hook> getHooks() {
        ResponseEntity<List<Hook>> hookResponseEntity = restTemplate.exchange(baseUrl+URL_SUFFIX, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hook>>() {});
        return hookResponseEntity.getBody();
    }
}
