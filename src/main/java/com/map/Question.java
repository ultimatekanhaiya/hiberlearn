package com.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@Column(name = "question_id")
	private int id;

	private String question;

	@OneToOne
	@JoinColumn(name="ans_id")
	private Answer ans;

	public Question() {
		super();
	}

	public Question(String question, Answer ans) {
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

	public Answer getAns() {
		return ans;
	}

	public void setAns(Answer ans) {
		this.ans = ans;
	}

}
