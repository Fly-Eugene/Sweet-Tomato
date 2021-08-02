package com.ssafy.study_with_us.domain.repository;

import com.ssafy.study_with_us.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);
    Comment getById(Long id);
}
