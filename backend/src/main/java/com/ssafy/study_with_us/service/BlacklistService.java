package com.ssafy.study_with_us.service;

import com.ssafy.study_with_us.domain.entity.Blacklist;
import com.ssafy.study_with_us.domain.repository.BlacklistRepository;
import com.ssafy.study_with_us.domain.repository.MemberRepository;
import com.ssafy.study_with_us.domain.repository.StudyRepository;
import com.ssafy.study_with_us.dto.IdReqDto;
import org.springframework.stereotype.Service;

@Service
public class BlacklistService {
    private final BlacklistRepository blacklistRepository;
    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;

    public BlacklistService(BlacklistRepository blacklistRepository, StudyRepository studyRepository, MemberRepository memberRepository) {
        this.blacklistRepository = blacklistRepository;
        this.studyRepository = studyRepository;
        this.memberRepository = memberRepository;
    }

    public Object addBlacklist(IdReqDto params) {
        return blacklistRepository.save(Blacklist.builder()
                .member(memberRepository.getById(params.getMemberId()))
                .study(studyRepository.getById(params.getStudyId())).build()).entityToDto();
    }

}
