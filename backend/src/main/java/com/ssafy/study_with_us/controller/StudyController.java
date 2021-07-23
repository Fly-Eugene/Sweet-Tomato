package com.ssafy.study_with_us.controller;

<<<<<<< HEAD
public class StudyController {
=======
import com.ssafy.study_with_us.dto.StudyDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study")
public class StudyController {

    @PostMapping
    public Object create(StudyDto params) {
        return null;
    }
>>>>>>> feature/study_CRUD
}
