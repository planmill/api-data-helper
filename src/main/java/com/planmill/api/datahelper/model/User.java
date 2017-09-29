package com.planmill.api.datahelper.model;

import lombok.Data;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Data
public class User {

    public static final int ROLE_POWER = 2;
    public static final int CONTRACT_TYPE_PARTNER = 11;

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer role;
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private Integer account;
    private Integer contractType;
    private Integer operationalId;

}
