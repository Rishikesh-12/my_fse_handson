package com.cognizant.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "op_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "op_qt_id")
	private Question question;
	@Column(name = "op_score")
	private Double score;
	@Column(name = "op_text")
	private String text;
	@ManyToMany(mappedBy = "options")
	private Set<Attempt> attempts;

	public Options() {
		// TODO Auto-generated constructor stub
	}

	public Options(Integer id, Question question, Double score, String text, Set<Attempt> attempts) {
		super();
		this.id = id;
		this.question = question;
		this.score = score;
		this.text = text;
		this.attempts = attempts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(Set<Attempt> attempts) {
		this.attempts = attempts;
	}

}
