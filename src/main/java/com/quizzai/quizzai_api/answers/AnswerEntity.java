package com.quizzai.quizzai_api.answers;

import com.quizzai.quizzai_api.questions.QuestionEntity;
import com.quizzai.quizzai_api.users.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "answers")
public class AnswerEntity {

    @Id
    @SequenceGenerator(name = "answerIdSeq", sequenceName = "answer_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "answerIdSeq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    @Column(name = "answer")
    private String answer;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "correction")
    private String correction;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "userId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false, referencedColumnName = "questionId")
    private QuestionEntity question;
}
