package com.quizzai.quizzai_api.quizes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizzai.quizzai_api.integration.GoogleApiClient;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
