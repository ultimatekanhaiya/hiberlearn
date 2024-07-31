package com.map.oneToOne.bidirectional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer3 {

	@Id
	@Column(name = "answer_id")
	private int id;

	private String answer;

	@OneToOne(mappedBy = "answer")
	private Question3 question;

	public Answer3() {
		super();
	}

	public Answer3(int id, String answer, Question3 question) {
		super();
		this.id = id;
		this.answer = answer;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question3 getQuestion() {
		return question;
	}

	public void setQuestion(Question3 question) {
		this.question = question;
	}

}
