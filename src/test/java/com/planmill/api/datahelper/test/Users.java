package com.planmill.api.datahelper.test;

import com.planmill.api.datahelper.model.User;
import com.planmill.api.datahelper.service.AccountService;
import com.planmill.api.datahelper.service.UserService;
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
public class Users {

    private static final String DEFAULT_PASSWORD = "A1b2C3d4E5";

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Test
    public void createFiveRandom() {

        for (int i = 1; i<=5; i++) {
            createUser("Bob", "Awesome", i);
        }
    }

    public User createUser(String fName, String lName, int i) {
        User user = new User();
        user.setFirstName(fName+i);
        user.setLastName(lName);
        user.setRole(User.ROLE_POWER);
        user.setContractType(User.CONTRACT_TYPE_PARTNER);
        user.setAccount(accountService.getFirst().getId());
        user.setUserName(fName.toLowerCase().concat(lName.toLowerCase())+i);
        user.setPassword(DEFAULT_PASSWORD);
        user.setConfirmPassword(DEFAULT_PASSWORD);

        user = userService.addUser(user);

        log.info("user: {}", user.getId());

        return user;
    }
}
