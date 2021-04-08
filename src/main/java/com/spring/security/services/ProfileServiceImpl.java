package com.spring.security.services;

import com.spring.security.domain.entity.Profile;
import com.spring.security.domain.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProfileServiceImpl
 * Inside the package - com.spring.security.services
 * Created Date: 3/29/2021
 * Created Time: 6:41 AM
 **/
@Service
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> getProfile(Long profileId) {
        return profileRepository.findById(profileId);
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}
