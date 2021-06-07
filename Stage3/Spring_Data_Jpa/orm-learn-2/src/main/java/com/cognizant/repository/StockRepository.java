package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	@Query("select s from Stock s where s.code='FB' and s.date like '2019-09-%'")
	public List<Stock> getFb();

	@Query("select s from Stock s where s.code='GOOGL' and s.close > 1250")
	public List<Stock> getGoogle();
	
	@Query(value = "select * from Stock order by st_volume desc limit 3", nativeQuery = true)
	public List<Stock> getHigh();

	@Query(value = "select * from Stock where st_code='NFLX' order by st_close limit 3", nativeQuery = true)
	public List<Stock> getNetflix();
}