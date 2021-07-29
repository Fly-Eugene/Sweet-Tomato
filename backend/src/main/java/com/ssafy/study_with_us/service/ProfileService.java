package com.ssafy.study_with_us.service;

import com.ssafy.study_with_us.domain.entity.StudyProfile;
import com.ssafy.study_with_us.domain.entity.StudyProfileRepository;
import com.ssafy.study_with_us.dto.ProfileDto;
import com.ssafy.study_with_us.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ProfileService {
    private StudyProfileRepository studyProfileRepository;
    private FileUtil fileUtil;

    public ProfileService(StudyProfileRepository studyProfileRepository, FileUtil fileUtil) {
        this.studyProfileRepository = studyProfileRepository;
        this.fileUtil = fileUtil;
    }

    public Object studyProfileCreate(MultipartFile mf) throws IOException {
        File imageFile = fileUtil.setImage(mf);
        studyProfileRepository.save(StudyProfile.builder()
                .id(null)
                .image(imageFile.getName())
                .path(imageFile.getPath())
                .thumbnail(fileUtil.setThumbnail(mf))
                .build());
        return null;
    }
}
