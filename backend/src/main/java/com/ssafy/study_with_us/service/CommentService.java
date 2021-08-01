package com.ssafy.study_with_us.service;

import com.ssafy.study_with_us.domain.entity.Comment;
import com.ssafy.study_with_us.domain.repository.CommentRepository;
import com.ssafy.study_with_us.domain.repository.MemberRepository;
import com.ssafy.study_with_us.domain.repository.StudyRepository;
import com.ssafy.study_with_us.dto.CommentDto;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private MemberRepository memberRepository;
    private StudyRepository studyRepository;

    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository, StudyRepository studyRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.studyRepository = studyRepository;
    }

    public Object create(CommentDto params) {
        Comment comment = commentRepository.save(Comment.builder()
                .content(params.getContent())
                .member(memberRepository.getById(params.getMemberId()))
                .study(studyRepository.getById(params.getStudyId()))
                .build());
        return CommentDto.builder().id(comment.getId())
                .content(comment.getContent())
                .memberId(comment.getMember().getId())
                .studyId(comment.getStudy().getId())
                .regTime(comment.getRegTime())
                .build();
    }

}
