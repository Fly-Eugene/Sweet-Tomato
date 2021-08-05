package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.Tomato;
import com.ssafy.study_with_us.dto.StudyDto;
import com.ssafy.study_with_us.dto.TomatoDto;

public interface TomatoRepositoryCustom {
    Tomato addTomato(TomatoDto params);
    Integer getTotalSum();
    Integer getRelevantSum(StudyDto params);
    Integer getRelevantSum(Long memberId);
}
