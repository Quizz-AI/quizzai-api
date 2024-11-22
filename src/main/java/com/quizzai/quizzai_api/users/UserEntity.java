package com.quizzai.quizzai_api.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quizzai.quizzai_api.quizes.QuizEntity;
import com.quizzai.quizzai_api.rooms.RoomEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "userIdSeq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "userIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "userId", nullable = false)
    private Long userId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Email(message = "Email should be valid")
    @Column(name = "email", unique = true)
    private String email;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "totalPoints")
    private Long totalPoints;

    @NonNull
    @Column(name = "quizCount")
    private Long quizCount;

    @NonNull
    @Column(name = "rightCount")
    private Long rightCount;

    @NonNull
    @Column(name = "country")
    private String country;

    // Um usuário pode ser o dono de várias salas
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomEntity> ownedRooms;

    // Um usuário pode ter vários quizzes
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<QuizEntity> quizzes;
}
