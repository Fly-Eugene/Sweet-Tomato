package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
    Blacklist save(Blacklist blacklist);
    void deleteById(Long blacklistId);
    List<Blacklist> getByMemberId(Long memberId);
}
