package com.planmill.api.datahelper.model;

import lombok.Data;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Data
public class TimeReport {

    private Integer id;
    private Integer person;
    private Integer project;
    private Integer task;

    private Integer dutyType;
    private Integer status;
    private Integer amount;

    private String comment;
    private String billingComment;
    private String overtimeComment;
    private String travelComment;

    private String start; //fixme
    private String finish; //fixme

    private Integer billableStatus;
    private Integer overtimeAmount;
    private Integer travelAmount;

}
