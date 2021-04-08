package com.spring.security.domain.repository;


import com.spring.security.domain.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProfileRepository
 * Inside the package - com.spring.security.domain.repository
 * Created Date: 3/29/2021
 * Created Time: 6:34 AM
 **/
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
