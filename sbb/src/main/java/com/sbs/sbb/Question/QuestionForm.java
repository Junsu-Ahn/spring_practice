package com.sbs.sbb.Question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotBlank(message="제목은 필수항목입니다.")
    @Size(max=200)
    private String subject;

    @NotBlank(message="내용은 필수항목입니다.")
    @Size(max=20000, message="내용을 20,000자 이하로 입력해주세요")
    private String content;
}
