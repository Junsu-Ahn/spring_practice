package com.sbs.sbb.Question;

import com.sbs.sbb.Answer.Answer;
import com.sbs.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy="question", cascade = CascadeType.REMOVE)
    // lazy 추가
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
}