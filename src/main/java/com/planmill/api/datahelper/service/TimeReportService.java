package com.planmill.api.datahelper.service;

import com.planmill.api.datahelper.model.TimeReport;
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
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Slf4j
@Service
public class TimeReportService {

    @Value("${api.baseUrl}")
    private String baseUrl;
    private static final String URL_SUFFIX = "/timereports";

    @Autowired
    private OAuth2RestOperations restTemplate;

    public List<TimeReport> getList() {
        ResponseEntity<List<TimeReport>> responseEntity = restTemplate.exchange(baseUrl+URL_SUFFIX, HttpMethod.GET, null, new ParameterizedTypeReference<List<TimeReport>>() {});
        return responseEntity.getBody();
    }
}
