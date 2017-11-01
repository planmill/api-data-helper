package com.planmill.api.datahelper.model;

import lombok.Data;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-10-27.
 */
@Data
public class Hook {

    //small subset of available hook types
    public final static String ACCOUNT_UPDATE = "account.update";
    public final static String ACCOUNT_CREATE = "account.create";
    public final static String REQUEST_ADD = "request.add";
    public final static String REQUEST_UPDATE = "request.update";
    public final static String TIMEREPORT_DELETE = "timereport.delete";


    private Integer id;
    private Integer eventUser;
    private Integer eventProject;
    private String hook; //type
    private String url;

}
