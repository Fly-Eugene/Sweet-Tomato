package com.ssafy.study_with_us.controller;

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

    @PostMapping
    public Object create(@RequestBody IdReqDto params){
        return null;
    }
    @PatchMapping
    public Object update(){
        return null;
    }
    @DeleteMapping
    public Object delete(@RequestBody IdReqDto params) {
        return null;
    }
    @GetMapping
    public Object loadComments(@RequestBody IdReqDto params){
        return null;
    }
}
