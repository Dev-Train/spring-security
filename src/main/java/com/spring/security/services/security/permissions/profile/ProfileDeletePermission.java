package com.spring.security.services.security.permissions.profile;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProfileDeletePermission
 * Inside the package - com.spring.security.services.security.permissions.profile
 * Created Date: 3/30/2021
 * Created Time: 6:47 AM
 **/
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority('profile.create') " +
        "OR hasAuthority('customer.profile.create') " +
        "AND @profileAuthenticationManager.customerIdMatches(authentication,#customerId)")
public @interface ProfileDeletePermission {
}
