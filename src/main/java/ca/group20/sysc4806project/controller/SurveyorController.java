package ca.group20.sysc4806project.controller;

import ca.group20.sysc4806project.service.SurveyorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Slf4j
public class SurveyorController {

    private final SurveyorService surveyorService;
}
