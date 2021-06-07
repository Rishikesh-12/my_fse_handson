/**
 * 
 */
package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Country;

/**
 * @author Rishikesh
 *
 */
public interface CountryRepository extends JpaRepository<Country, String> {

	List<Country> findByNameStartingWith(String namePart);

	List<Country> findByNameContaining(String namePart);

}
