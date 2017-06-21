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

    /**
     * Create 5 users to planmill
     */
    @Test
    public void createFiveRandom() {

        for (int i = 1; i<=5; i++) {
            createUser("Bob", "Awesome", i, null);
        }
    }

    /**
     * Create user object.
     *
     * @param fName
     * @param lName
     * @param i
     * @param email
     * @return
     */
    public User initUser(String fName, String lName, int i, String email) {
        String suffix = i>0?i+"":"";
        User user = new User();
        user.setFirstName(fName+suffix);
        user.setLastName(lName);
        user.setEmail(email);
        user.setRole(User.ROLE_POWER);
        user.setContractType(User.CONTRACT_TYPE_PARTNER);
        user.setAccount(accountService.getFirst().getId());
        user.setUserName(fName.toLowerCase().concat(lName.toLowerCase())+suffix);
        user.setPassword(DEFAULT_PASSWORD);
        user.setConfirmPassword(DEFAULT_PASSWORD);

        return user;
    }

    /**
     * Create user object to planmill.
     *
     * @param fName
     * @param lName
     * @param i
     * @return
     */
    public User createUser(String fName, String lName, int i, String email) {
        User user = initUser(fName,lName,i,email);

        user = userService.addUser(user);

        log.info("user: {}", user.getId());

        return user;
    }

    /**
     * Create few users with email and name with dash to planmill
     */
    @Test
    public void createUserWithEmail() {
        createUser("Data-helper","Support",-1,"data-helper.support@planmill.com");

        createUser("John","the Great",-1,"john.the.great@planmill.eu");
        createUser("Jack","the Great",-1,"jack.the.great@planmill.eu");
        createUser("Jim","the Great",-1,"jim.the.great@planmill.eu");
        createUser("Jax","the Great",-1,"jax.the.great@planmill.eu");
    }
}
