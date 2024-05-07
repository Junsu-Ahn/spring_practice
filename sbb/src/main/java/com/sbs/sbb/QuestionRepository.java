package com.sbs.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // JPA에 리포지터리의 메서드명을 분석하여 쿼리를 만들고 실행하는 기능
    Question findBySubject(String s);

    Question findBySubjectAndContent(String s, String s1);
}
