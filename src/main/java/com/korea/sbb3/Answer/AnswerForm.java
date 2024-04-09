package com.korea.sbb3.Answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

    @NotEmpty(message = "답변은 필수입력 항목입니다.")
    private String content;
}
