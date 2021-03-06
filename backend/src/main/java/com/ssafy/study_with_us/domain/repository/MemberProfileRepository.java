package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long> {
    MemberProfile save(MemberProfile memberProfile);
}
