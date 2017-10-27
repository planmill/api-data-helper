package com.planmill.api.datahelper.webhooks;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Content sent from Planmill service to provided hook url.
 *
 * Created by konstantin.petrukhnov@planmill.com on 2017-10-27.
 */
@Data
public class WebHook {

    @JsonProperty("Id")
    private Integer id;

    private String hook;

    private Integer eventUser;
}
