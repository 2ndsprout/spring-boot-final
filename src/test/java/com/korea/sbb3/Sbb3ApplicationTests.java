package com.korea.sbb3;

import com.korea.sbb3.Answer.AnswerService;
import com.korea.sbb3.Question.Question;
import com.korea.sbb3.Question.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class Sbb3ApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Test
	@Transactional
	@Rollback(false)
	void test () {
		Question question1 = questionService.create("sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.", null);
		Question question2 = questionService.create("스프링부트 모델 질문입니다.","id는 자동으로 생성되나요?", null);

		answerService.create(question1, "알려드릴게요", null);
		answerService.create(question2, "네 자동으로 생성 됩니다.", null);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	void t1 () {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.questionService.create(subject, content, null);
		}
	}
}
