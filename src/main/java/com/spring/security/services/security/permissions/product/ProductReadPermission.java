package com.spring.security.services.security.permissions.product;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProductReadPermission
 * Inside the package - com.spring.security.services.security.permissions
 * Created Date: 3/28/2021
 * Created Time: 7:44 AM
 **/
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('product.read')")
public @interface ProductReadPermission {
}
