package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Country;
import com.cognizant.repository.CountryRepository;
import com.cognizant.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		List<Country> cList = countryRepository.findAll();
		return cList;
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		
		Optional<Country> result = countryRepository.findById(countryCode);
		if(!result.isPresent()) {
			throw new CountryNotFoundException("Country Code Not Found!");
		}else {
			Country country = result.get();
			return country;
		}
		
	}
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	

	@Transactional
	public void updateCountry(String countryCode, String countryName) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Code Not Found!");
		} else {
			Country country = result.get();
			country.setName(countryName);
			countryRepository.save(country);
		}
	}
	
	@Transactional
	public void deleteCountry(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Code Not Found!");
		} else {
			countryRepository.deleteById(countryCode);
		}
	}
	
	@Transactional
	public List<Country> searchByNamePart(String namePart){
//		return countryRepository.searchByNamePart(namePart);
		return countryRepository.findByNameContaining(namePart);
	}
//	
	@Transactional
	public List<Country> searchByNameStart(String namePart){
//		return countryRepository.searchByNameStart(namePart);
		return countryRepository.findByNameStartingWith(namePart);
	}

}
