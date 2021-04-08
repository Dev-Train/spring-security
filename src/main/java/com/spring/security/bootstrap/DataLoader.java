package com.spring.security.bootstrap;

import com.spring.security.domain.entity.Customer;
import com.spring.security.domain.entity.Product;
import com.spring.security.domain.entity.Profile;
import com.spring.security.domain.entity.security.Authority;
import com.spring.security.domain.entity.security.Role;
import com.spring.security.domain.entity.security.User;
import com.spring.security.services.CustomerService;
import com.spring.security.services.ProductService;
import com.spring.security.services.ProfileService;
import com.spring.security.services.security.AuthorityService;
import com.spring.security.services.security.RoleService;
import com.spring.security.services.security.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: DataLoader
 * Inside the package - com.spring.security.bootstrap
 * Created Date: 3/15/2021
 * Created Time: 6:15 AM
 **/
@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerService customerService;

    private final ProfileService profileService;

    private final ProductService productService;

    private final UserService userService;

    private final RoleService roleService;

    private final AuthorityService authorityService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DataLoader(CustomerService customerService,
                      ProfileService profileService,
                      UserService userService,
                      RoleService roleService,
                      AuthorityService authorityService,
                      ProductService productService,
                      BCryptPasswordEncoder bCryptPasswordEncoder ){
        this.customerService = customerService;
        this.profileService = profileService;
        this.productService = productService;
        this.authorityService = authorityService;
        this.roleService = roleService;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inside the Data Loader");
        createSecurityData();
        addCustomers();
        addProducts();
        //System.out.println("Admin Authority:"+authorities.stream().filter("ADMIN"::equals).findAny().orElse(null));
        //createUsers(authorities);
        /* BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("password"));
        SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("vara"));
        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        System.out.println(pbkdf2PasswordEncoder.encode("mohana")); */
    }

    private void addCustomers(){
        Role role = roleService.getRoleByName("CUSTOMER").orElseThrow();
        /**
         * Creating user John and setting up the role
         */
        User userJohn = userService.save(User.builder()
                .userName("john")
                .password("{bcrypt}"+bCryptPasswordEncoder.encode("doepwd"))
                .role(role)
                .build());
        Customer john = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .dateOfBirth(LocalDate.of(1983, 05, 21))
                .user(userJohn)
                .build();
        john = customerService.saveCustomer(john);
        profileService.createProfile(Profile.builder()
                .favoriteVacationDestination("Hawaii")
                .paymentName("VISA")
                .customer(john)
                .build());

        /**
         * Creating user Jane and setting up the role
         */
        User userJane = userService.save(User.builder()
                .userName("jane")
                .password("{bcrypt}"+bCryptPasswordEncoder.encode("doepwd"))
                .role(role)
                .build());
        Customer jane = Customer.builder()
                .firstName("Jane")
                .lastName("Doe")
                .dateOfBirth(LocalDate.of(1985, 12, 10))
                .user(userJane)
                .build();
        jane = customerService.saveCustomer(jane);
        profileService.createProfile(Profile.builder()
                .favoriteVacationDestination("Seattle")
                .paymentName("AMEX")
                .customer(jane)
                .build());

        /**
         * Creating user Marty and setting up the role
         */
        User userMarty = userService.save(User.builder()
                .userName("marty")
                .password("{bcrypt}"+bCryptPasswordEncoder.encode("doepwd"))
                .role(role)
                .build());
        Customer marty = Customer.builder()
                .firstName("Marty")
                .lastName("Doe")
                .dateOfBirth(LocalDate.of(1980, 9, 3))
                .user(userMarty)
                .build();
        marty = customerService.saveCustomer(marty);
        profileService.createProfile(Profile.builder()
                .favoriteVacationDestination("Orlando")
                .paymentName("DISCOVER")
                .customer(marty)
                .build());
    }

    private void addProducts(){
        Product product1 = Product.builder()
                .productName("IPhone")
                .build();
        productService.createProduct(product1);
        Product product2 = Product.builder()
                .productName("IPad")
                .build();
        productService.createProduct(product2);
        Product product3 = Product.builder()
                .productName("AirPods")
                .build();
        productService.createProduct(product3);
    }


    private void createSecurityData(){

        /**
         * Setting up authorities for customer entity
         */
        Authority createCustomerAuthority = authorityService.save(Authority.builder()
                .permission("customer.create")
                .build());
        Authority updateCustomerAuthority = authorityService.save(Authority.builder()
                .permission("customer.update")
                .build());
        Authority readCustomerAuthority = authorityService.save(Authority.builder()
                .permission("customer.read")
                .build());
        Authority deleteCustomerAuthority = authorityService.save(Authority.builder()
                .permission("customer.delete")
                .build());

        /**
         * Setting up authorities for Product entity
         */
        Authority createProductAuthority = authorityService.save(Authority.builder()
                .permission("product.create")
                .build());
        Authority updateProductAuthority = authorityService.save(Authority.builder()
                .permission("product.update")
                .build());
        Authority readProductAuthority = authorityService.save(Authority.builder()
                .permission("product.read")
                .build());
        Authority deleteProductAuthority = authorityService.save(Authority.builder()
                .permission("product.delete")
                .build());

        /**
         * Setting up authorities for Profile for Admin Role
         */
        Authority createProfileAuthority = authorityService.save(Authority.builder()
                .permission("profile.create")
                .build());
        Authority updateProfileAuthority = authorityService.save(Authority.builder()
                .permission("profile.update")
                .build());
        Authority readProfileAuthority = authorityService.save(Authority.builder()
                .permission("profile.read")
                .build());
        Authority deleteProfileAuthority = authorityService.save(Authority.builder()
                .permission("profile.delete")
                .build());

        /**
         * Setting up authorities for Profile for Customer Role
         */
        Authority createProfileAuthorityCustomer = authorityService.save(Authority.builder()
                .permission("customer.profile.create")
                .build());
        Authority updateProfileAuthorityCustomer = authorityService.save(Authority.builder()
                .permission("customer.profile.update")
                .build());
        Authority readProfileAuthorityCustomer = authorityService.save(Authority.builder()
                .permission("customer.profile.read")
                .build());
        Authority deleteProfileAuthorityCustomer = authorityService.save(Authority.builder()
                .permission("customer.profile.delete")
                .build());

        /**
         * Setting up roles
         */
        Role admin = roleService.createRole(Role.builder()
                .name("ADMIN")
                .build());
        Role user = roleService.createRole(Role.builder()
                .name("USER")
                .build());
        Role customer = roleService.createRole(Role.builder()
                .name("CUSTOMER")
                .build());

        admin.setAuthorities(Set.of(createCustomerAuthority,
                updateCustomerAuthority, readCustomerAuthority, deleteCustomerAuthority,
                createProductAuthority, updateProductAuthority, readProductAuthority,
                deleteProductAuthority, createProfileAuthority, readProfileAuthority,
                updateProfileAuthority, deleteProfileAuthority));

        user.setAuthorities(Set.of(updateCustomerAuthority, readCustomerAuthority,
                updateProductAuthority, readProductAuthority));

        customer.setAuthorities(Set.of(readCustomerAuthority, readProductAuthority,
                createProfileAuthorityCustomer, readProfileAuthorityCustomer, updateProfileAuthorityCustomer,
                deleteProfileAuthorityCustomer));
        //roleService.createRoles(Arrays.asList(admin,user,customer));

        /**
         * Creating users
         */
        userService.save(User.builder()
                .userName("balaji")
                .password("{bcrypt}"+bCryptPasswordEncoder.encode("vara"))
                .role(admin)
                .build());



        userService.save(User.builder()
                .userName("user")
                .password("{bcrypt}"+bCryptPasswordEncoder.encode("password"))
                .role(user)
                .build());

    }

}
