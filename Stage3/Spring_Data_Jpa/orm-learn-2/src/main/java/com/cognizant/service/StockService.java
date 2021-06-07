package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Stock;
import com.cognizant.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	private final StockRepository stockRepository = null;

	@Transactional
	public List<Stock> getFb() {
		return stockRepository.getFb();
	}

	@Transactional
	public List<Stock> getGoogle() {
		return stockRepository.getGoogle();
	}

	@Transactional
	public List<Stock> getHigh() {
		return stockRepository.getHigh();
	}

	@Transactional
	public List<Stock> getNetflix() {
		return stockRepository.getNetflix();
	}
}