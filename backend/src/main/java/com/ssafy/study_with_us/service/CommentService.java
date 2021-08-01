package com.ssafy.study_with_us.service;

import com.ssafy.study_with_us.domain.repository.CommentRepository;

public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

}
