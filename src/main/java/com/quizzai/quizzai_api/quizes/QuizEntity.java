package com.quizzai.quizzai_api.quizes;

import com.quizzai.quizzai_api.questions.QuestionEntity;
import com.quizzai.quizzai_api.rooms.RoomEntity;
import com.quizzai.quizzai_api.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "quizes")
public class QuizEntity {

    @Id
    @SequenceGenerator(name = "quizIdSeq", sequenceName = "quiz_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "quizIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "quizId", nullable = false)
    private Long quizId;

    @NonNull
    @Column(name = "theme", nullable = false)
    private String theme;

    @NonNull
    @Column(name = "difficulty", nullable = false)
    private String difficulty;

    @NonNull
    @Column(name = "number_of_questions", nullable = false)
    private Integer numberOfQuestions;
    // Um quiz só tem um dono
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "userId", nullable = false)
    private UserEntity owner;

    // Um quiz pode estar em várias salas
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomEntity> rooms;

    // Um quiz tem várias perguntas
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionEntity> questions;
}
