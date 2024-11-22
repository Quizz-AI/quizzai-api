package com.quizzai.quizzai_api.questions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quizzai.quizzai_api.quizes.QuizEntity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @SequenceGenerator(name = "questionIdSeq", sequenceName = "question_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "questionIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "questionId")
    private Long questionId;

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "quizId", nullable = false)
    @JsonIgnore
    private QuizEntity quiz;
}
