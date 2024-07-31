package com.map.oneToOne.unidirectional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Question2 {

	@Id
	@Column(name = "question_id")
	private int id;

	private String question;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ans_id")
	private Answer2 ans;

	public Question2() {
		super();
	}

	public Question2(String question, Answer2 ans) {
		super();
		this.question = question;
		this.ans = ans;
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

	public Answer2 getAns() {
		return ans;
	}

	public void setAns(Answer2 ans) {
		this.ans = ans;
	}

}
