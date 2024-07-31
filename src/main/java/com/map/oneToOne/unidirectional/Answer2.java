package com.map.oneToOne.unidirectional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Answer2 {

	@Id
	@Column(name = "answer_id")
	private int id;

	private String answer;

	public Answer2() {
		super();
	}

	public Answer2(int id, String answer) {
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
