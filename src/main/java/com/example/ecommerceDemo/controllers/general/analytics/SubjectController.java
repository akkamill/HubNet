package com.example.ecommerceDemo.controllers.general.analytics;

import com.example.ecommerceDemo.DTO.general.analytics.SubjectDTO;
import com.example.ecommerceDemo.services.general.analytics.SubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/analytics")
public class SubjectController {


    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping("/user/{userId}")
    public List<SubjectDTO> getSubjectsByUserId(@PathVariable Long userId) {
        return subjectService.getSubjectsByUserId(userId);
    }
}
