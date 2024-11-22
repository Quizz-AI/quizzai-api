package com.quizzai.quizzai_api.quizes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController()
@RequestMapping("/quiz")
@Tag(name = "Quiz")
public class QuizController {

    // @Autowired
    // private GoogleApiClient client;

    // @GetMapping("/teste")
    // public String getMethodName() {
    // return client.gerarConteudo();
    // }

    @Autowired
    private QuizService quizService;

    @PostMapping("/generate")
    public String[] generateQuiz(@Valid @RequestBody QuizCreationRequestDTO quizCreationRequestDTO) {
        return quizService.generateQuiz(quizCreationRequestDTO);
    }

    @GetMapping("/")
    public List<QuizEntity> getAllQuizzes() {
        return quizService.findAll();
    }

}
