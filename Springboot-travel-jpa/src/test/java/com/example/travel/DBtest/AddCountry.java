package com.example.travel.DBtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Country;
import com.example.travel.repository.CountryRepository;

@SpringBootTest
public class AddCountry {

		@Autowired
		CountryRepository countryRepository;
		
		@Test
		public void test() {
			try {
				Country country = new Country();
				country.setCountryname("Japan");
				countryRepository.save(country);
				
				Country country1 = new Country();
				country1.setCountryname("Korena");
				countryRepository.save(country1);
				
				Country country2 = new Country();
				country2.setCountryname("Vietnam");
				countryRepository.save(country2);
				
				
				System.out.println("新增完成");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
