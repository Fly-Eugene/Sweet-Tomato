package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile save(Profile profile);
    Optional<Profile> findById(Long id);
}
