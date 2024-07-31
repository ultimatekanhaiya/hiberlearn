package com.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int id;

	private String answer;

	public Answer() {
		super();
	}

	public Answer(int id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnwser() {
		return answer;
	}

	public void setAnwser(String answer) {
		this.answer = answer;
	}

}
