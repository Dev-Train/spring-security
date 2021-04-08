package com.spring.security.services.security.permissions.customer;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: CustomerReadPermission
 * Inside the package - com.spring.security.services.security.permissions
 * Created Date: 3/28/2021
 * Created Time: 7:36 AM
 **/
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('customer.read')")
public @interface CustomerReadPermission {
}
