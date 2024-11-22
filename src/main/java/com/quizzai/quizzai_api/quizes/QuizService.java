package com.quizzai.quizzai_api.quizes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.quizzai.quizzai_api.integration.GoogleApiClient;
import com.quizzai.quizzai_api.questions.QuestionEntity;
import com.quizzai.quizzai_api.users.UserEntity;

import org.json.*;

@Service
public class QuizService {

    @Autowired
    private IQuizRepository quizRepository;

    @Autowired
    private GoogleApiClient client;

    public String[] generateQuiz(QuizCreationRequestDTO quizCreationRequestDTO) {

        String prompt = "Gere um quiz com " + quizCreationRequestDTO.getNumberOfQuestions() + " perguntas sobre "
                + quizCreationRequestDTO.getTheme() + " com dificuldade " + quizCreationRequestDTO.getDifficulty()
                + ". Só escreva as perguntas, separadas por linha e sem alternativas.";
        String apiResponse = client.googleApiCall(prompt);

        JSONObject jsonObject = new JSONObject(apiResponse);
        String questions = jsonObject.getJSONArray("candidates").getJSONObject(0).getJSONObject("content")
                .getJSONArray("parts").getJSONObject(0).getString("text");

        String[] questionsArray = questions.split("\n");

        UserEntity owner = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        QuizEntity quizEntity = QuizEntity.builder().theme(quizCreationRequestDTO.getTheme())
                .difficulty(quizCreationRequestDTO.getDifficulty())
                .numberOfQuestions(quizCreationRequestDTO.getNumberOfQuestions()).owner(owner).build();

        List<QuestionEntity> questionEntities = new ArrayList<>();

        for (String question : questionsArray) {
            QuestionEntity questionEntity = new QuestionEntity();
            questionEntity.setQuestion(question);
            questionEntities.add(questionEntity);
            questionEntity.setQuiz(quizEntity);
        }

        quizEntity.setQuestions(questionEntities);
        quizRepository.save(quizEntity);

        return questionsArray;

    }

    public List<QuizEntity> findAll() {
        return quizRepository.findAll();
    }
}
