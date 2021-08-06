package com.ssafy.study_with_us.service;

import com.ssafy.study_with_us.domain.entity.DataRoom;
import com.ssafy.study_with_us.domain.repository.DataRoomRepository;
import com.ssafy.study_with_us.domain.repository.MemberRepository;
import com.ssafy.study_with_us.domain.repository.StudyRepository;
import com.ssafy.study_with_us.dto.DataRoomDto;
import com.ssafy.study_with_us.dto.FileDto;
import com.ssafy.study_with_us.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DataRoomService {
    private final DataRoomRepository dataRoomRepository;
    private final MemberRepository memberRepository;
    private final StudyRepository studyRepository;
    private final FileService fileService;

    public DataRoomService(DataRoomRepository dataRoomRepository, MemberRepository memberRepository, StudyRepository studyRepository, FileService fileService) {
        this.dataRoomRepository = dataRoomRepository;
        this.memberRepository = memberRepository;
        this.studyRepository = studyRepository;
        this.fileService = fileService;
    }

    public DataRoomDto create(DataRoomDto params, List<MultipartFile> files) throws IOException {
        // 자료실(글) 저장
        DataRoom dataRoom = dataRoomRepository.save(DataRoom.builder()
                .id(params.getId()).subject(params.getSubject()).content(params.getContent())
                .member(memberRepository.getById(getMemberId()))
                .study(studyRepository.getById(params.getStudyId())).build());
        // 파일 저장
        fileService.create(files, dataRoom);
        return DataRoomDto.builder().id(dataRoom.getId()).subject(dataRoom.getSubject()).content(dataRoom.getContent())
                .memberId(dataRoom.getMember().getId()).studyId(dataRoom.getStudy().getId())
                .build();
    }

    private Long getMemberId() {
        String s = SecurityUtil.getCurrentUsername().get();
        return memberRepository.findByEmail(s).get().getId();
    }
}
