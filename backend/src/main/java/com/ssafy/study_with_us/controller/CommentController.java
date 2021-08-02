package com.ssafy.study_with_us.controller;

import com.ssafy.study_with_us.dto.CommentDto;
import com.ssafy.study_with_us.dto.IdReqDto;
import com.ssafy.study_with_us.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // studyId는 받아야함
    // memberId는 보내주면 받고, 아니면 token으로 직접 찾기
    @PostMapping
    public Object create(@RequestBody CommentDto params){
        return commentService.create(params);
    }
    @PatchMapping
    public Object update(@RequestBody CommentDto params)
    {
        return commentService.update(params);
    }
    @DeleteMapping
    public Object delete(@RequestBody CommentDto params) {
        return null;
    }
    @GetMapping
    public Object loadComments(@RequestBody IdReqDto params){
        return null;
    }
}
