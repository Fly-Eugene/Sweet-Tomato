package com.ssafy.study_with_us.service;

import com.ssafy.study_with_us.domain.entity.Study;
import com.ssafy.study_with_us.domain.repository.MemberRepository;
import com.ssafy.study_with_us.domain.repository.StudyRepository;
import com.ssafy.study_with_us.dto.StudyDto;
import com.ssafy.study_with_us.util.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyService {
    private StudyRepository studyRepository;
    private MemberRepository memberRepository;

    public StudyService(StudyRepository studyRepository, MemberRepository memberRepository) {
        this.studyRepository = studyRepository;
        this.memberRepository = memberRepository;
    }

    public Object create(StudyDto params){
        Study study = studyRepository.save(Study.builder()
                .id(null)
                .studyName(params.getStudyName())
                .studyIntro(params.getStudyIntro())
                .studyLeader(getMemberId(SecurityUtil.getCurrentUsername()))
                .security(params.getSecurity())
                .build());
        return study;
    }

    private Long getMemberId(Optional<String> currentUsername) {
        String s = currentUsername.get();
        return memberRepository.findByEmail(s).get().getId();
    }
}
