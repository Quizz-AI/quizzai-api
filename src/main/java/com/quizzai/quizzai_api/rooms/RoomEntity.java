package com.quizzai.quizzai_api.rooms;

import com.quizzai.quizzai_api.quizes.QuizEntity;
import com.quizzai.quizzai_api.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "rooms")
public class RoomEntity {

    @Id
    @SequenceGenerator(name = "roomIdSeq", sequenceName = "room_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "roomIdSeq", strategy = GenerationType.SEQUENCE)
    @Column(name = "roomId", nullable = false)
    private Long roomId;

    @NonNull
    @Column(name = "joinCode", unique = true)
    private String joinCode;

    // Cada sala tem um dono
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "userId", nullable = false)
    private UserEntity owner;

    // Cada sala tem vários jogadores, e um jogador pode estar em uma sala por vez
    @ManyToMany
    @JoinTable(name = "room_players", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> players;

    // Cada sala tem um quiz
    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "quizId", nullable = false)
    private QuizEntity quiz;
}
