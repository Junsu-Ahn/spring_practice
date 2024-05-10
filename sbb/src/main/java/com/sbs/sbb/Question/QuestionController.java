package com.sbs.sbb.Question;

import com.sbs.sbb.Answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@Controller
@RequiredArgsConstructor
@Validated  // 생략가능, 유효성 체크하는 애
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.findAll();
        model.addAttribute("questionList", questionList);

        return "question_list";
    }


    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question q = this.questionService.getQuestion(id);
        model.addAttribute("question", q);
        return "question_detail";
    }


    @PostMapping("/createTemp")
    @ResponseBody
    public String temp() {
        return "전송완료";
    }

    // model.addAttribute 없이 바로 접근가능
    // question_form.html에서 questionForm을 받고있다. questionForm이 없으면 실행이 안된다.
    // 그래서 빈 객체라도 만드는 것.
    // 빈 객체 생성
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
    // 비어있지 않은 객체 생성
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        // BindingResult 유효성검사 결과를 저장, 오류 탐색
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}
