package com.cognizant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.Model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
