package com.cognizant.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attempt")
public class Attempt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "at_id")
	private Integer id;
	@Column(name = "at_date")
	private Date date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "at_us_id")
	private User user;
	@Column(name = "at_score")
	private Double score;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "aq_qt_id")
	private Set<Question> question;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Options> options;

	public Attempt() {
		// TODO Auto-generated constructor stub
	}

	public Attempt(Integer id, Date date, User user, Double score) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}

	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}

}
