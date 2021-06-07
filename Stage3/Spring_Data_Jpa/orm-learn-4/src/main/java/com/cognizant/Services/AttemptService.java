package com.cognizant.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Model.Attempt;
import com.cognizant.Repository.AttemptRepository;

@Service
public class AttemptService {
	@Autowired
	private static final AttemptRepository attemptRepository = null;

	@Transactional
	public Attempt getAttempyById(int userId,int attemptId) {
		return attemptRepository.getAttempt(userId, attemptId);
	}
}
