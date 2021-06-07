package com.cognizant.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qt_id")
	private Integer id;
	@Column(name = "qt_text")
	private String text;
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	private Set<Options> options;
	@ManyToMany(mappedBy = "questions", fetch = FetchType.EAGER)
	private Set<Attempt> attempts;

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}

	public Set<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(Set<Attempt> attempts) {
		this.attempts = attempts;
	}

}
