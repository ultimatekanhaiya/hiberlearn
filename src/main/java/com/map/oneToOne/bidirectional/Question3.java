package com.map.oneToOne.bidirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Question3 {
	@Id
	@Column(name = "question_id")
	private int id;

	private String question;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "asn_id")
	private Answer3 answer;

	public Question3() {
		super();
	}

	public Question3(int id, String question, Answer3 answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer3 getAnswer() {
		return answer;
	}

	public void setAnswer(Answer3 answer) {
		this.answer = answer;
	}

}
