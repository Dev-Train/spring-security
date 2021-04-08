package com.spring.security.services;

import com.spring.security.domain.entity.Profile;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProfileService
 * Inside the package - com.spring.security.services
 * Created Date: 3/29/2021
 * Created Time: 6:39 AM
 **/
public interface ProfileService {

    Optional<Profile> getProfile(Long profileId);

    Profile createProfile(Profile profile);

    List<Profile> getAllProfiles();
}
