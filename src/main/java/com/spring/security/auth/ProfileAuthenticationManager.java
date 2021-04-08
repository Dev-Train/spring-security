package com.spring.security.auth;

import com.spring.security.domain.entity.security.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProfileAuthenticationManager
 * Inside the package - com.spring.security.auth
 * Created Date: 3/30/2021
 * Created Time: 6:21 AM
 **/
@Component
@Slf4j
public class ProfileAuthenticationManager {

    public boolean customerIdMatches(Authentication authentication, Long customerId){
        User authenticatedUser = (User) authentication.getPrincipal();
        log.info("Authenticated Customer Id:" + authenticatedUser.getCustomer().getCustomerId() + " Requested Customer Id:" + customerId);
        return authenticatedUser.getCustomer().getCustomerId().equals(customerId);
    }
}
