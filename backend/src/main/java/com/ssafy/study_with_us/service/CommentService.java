package com.ssafy.study_with_us.service;

import com.ssafy.study_with_us.domain.entity.Comment;
import com.ssafy.study_with_us.domain.repository.CommentRepository;
import com.ssafy.study_with_us.domain.repository.MemberRepository;
import com.ssafy.study_with_us.domain.repository.StudyRepository;
import com.ssafy.study_with_us.dto.CommentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Comment save = commentRepository.save(Comment.builder()
                .content(params.getContent())
                .member(memberRepository.getById(params.getMemberId()))
                .study(studyRepository.getById(params.getStudyId()))
                .build());
        return save.entityToDto();
    }

    // 세상에.. spring data jpa로 save()할 때 pk 같으면 update 되는거 까먹고 있었다
    @Transactional
    public Object update(CommentDto params) {
        Comment comment = commentRepository.getById(params.getId());
        Comment save = commentRepository.save(Comment.builder()
                .id(params.getId())
                .content(params.getContent() == null ? comment.getContent() : params.getContent())
                .build());
        return save.entityToDto();
    }

    @Transactional
    public void delete(CommentDto params) {
        commentRepository.delete(commentRepository.getById(params.getId()));
    }

    public Object getComments(Long studyId){
        return commentRepository.getByStudy(studyRepository.getById(studyId));
    }
}
