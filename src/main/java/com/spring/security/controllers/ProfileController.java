package com.spring.security.controllers;

import com.spring.security.domain.entity.Customer;
import com.spring.security.domain.entity.Profile;
import com.spring.security.domain.entity.security.User;
import com.spring.security.services.CustomerService;
import com.spring.security.services.ProfileService;
import com.spring.security.services.security.permissions.profile.ProfileCreatePermission;
import com.spring.security.services.security.permissions.profile.ProfileReadPermission;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProfileController
 * Inside the package - com.spring.security.controllers
 * Created Date: 3/29/2021
 * Created Time: 6:43 AM
 **/
@RestController
@RequestMapping("/api/v1/security/customers/")
public class ProfileController {

    private final ProfileService profileService;

    private final CustomerService customerService;

    public ProfileController(ProfileService profileService,
                             CustomerService customerService){
        this.profileService = profileService;
        this.customerService = customerService;
    }

    @GetMapping("{customerId}/profile")
    @ProfileReadPermission
    public ResponseEntity getProfile(@PathVariable Long customerId){
        Customer customer = customerService.getCustomerById(customerId).orElseThrow();
        return new ResponseEntity(customer.getProfile(), HttpStatus.OK);
    }

    @GetMapping("profile")
    @PreAuthorize("hasAuthority('profile.create') " +
            "OR hasAuthority('customer.profile.create')")
    public ResponseEntity getProfile(@AuthenticationPrincipal User user){
        Customer customer;
        if(user.getCustomer()!=null){
            customer = customerService.getCustomerById(user.getCustomer().getCustomerId()).orElseThrow();
            return new ResponseEntity(customer.getProfile(), HttpStatus.OK);
        }else{
            return new ResponseEntity(profileService.getAllProfiles(), HttpStatus.OK);
        }

    }

    @PostMapping
    @ProfileCreatePermission
    public ResponseEntity createProfile(@RequestBody Profile profile){
        profileService.createProfile(profile);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
