package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.Theme;
import com.ssafy.study_with_us.dto.StudyDto;

import java.util.List;

public interface StudyRepositoryCustom {
    List<Theme> getThemes();
    Object update(StudyDto params);
}
