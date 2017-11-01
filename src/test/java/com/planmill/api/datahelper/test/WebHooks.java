package com.planmill.api.datahelper.test;

import com.planmill.api.datahelper.model.Hook;
import com.planmill.api.datahelper.service.WebHookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Creating and retrieving WebHooks example. User need to have access to api hooks (OFF by default for all users).
 *
 * Created by konstantin.petrukhnov@planmill.com on 2017-10-27.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebHooks {

    @Autowired
    private WebHookService webHookService;

    @Test
    public void addHookAccountUpdate() {
        Hook hook = new Hook();
        hook.setHook(Hook.ACCOUNT_UPDATE);
        hook.setUrl("http://localhost:9080/webhooks/account/update");

        Hook newHook = webHookService.addHook(hook);
        log.info("hookId: {}", newHook.getId());
    }

    @Test
    public void addHookRequestUpdate() {
        Hook hook = new Hook();
        hook.setHook(Hook.REQUEST_UPDATE);
        hook.setUrl("http://localhost:9080/webhooks/request/update");

        Hook newHook = webHookService.addHook(hook);
        log.info("hookId: {}", newHook.getId());
    }

    /**
     * Request will return 404 if no hooks exist in system.
     */
    @Test
    public void getHooks() {
        List<Hook> hooks = webHookService.getHooks();
        log.info("hooks: {}", hooks.size());
    }
}
