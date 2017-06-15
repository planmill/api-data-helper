package com.planmill.api.datahelper.test;

import com.planmill.api.datahelper.service.UserService;
import com.planmill.api.datahelper.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectionTest {

    @Autowired
    private UserService userService;

    @Test
    public void testConnection() {
        User user = userService.getMe();
        log.info("id: {}", user.getId());
    }
}
