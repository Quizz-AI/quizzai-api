package com.quizzai.quizzai_api.quizes;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.micrometer.common.lang.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizCreationRequestDTO {

    @NonNull
    private String theme;

    @NonNull
    private String difficulty;

    @NonNull
    private Integer numberOfQuestions;
}
