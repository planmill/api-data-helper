package com.planmill.api.datahelper.webhooks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * Endpoint that waits for incoming requests.
 *
 * Created by konstantin.petrukhnov@planmill.com on 2017-10-26.
 */
@Slf4j
@RestController
@RequestMapping(value = "/webhooks")
public class WebHookListener {


    @RequestMapping(value = "/account/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String accountUpdate(@RequestBody String body) {

        log.info("accountUpdate: {}", body);

        return "ok";
    }

}
