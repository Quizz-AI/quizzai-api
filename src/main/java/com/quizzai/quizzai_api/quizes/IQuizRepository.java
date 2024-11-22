package com.quizzai.quizzai_api.quizes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuizRepository extends JpaRepository<QuizEntity, Long> {

}
