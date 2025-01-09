package com.example.travel.DBtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Country;
import com.example.travel.model.entity.Members;
import com.example.travel.repository.CountryRepository;
import com.example.travel.repository.MembersRepository;

@SpringBootTest
public class AddMember_Country {
	
	@Autowired
	MembersRepository membersRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Test
	public void test() {
		try {
			//取得國家
			Country Japan = countryRepository.findById(5).get();
			Country Korena = countryRepository.findById(6).get();
			Country Vietnam = countryRepository.findById(7).get();
			
			//取得會員
			Members Andy = membersRepository.findById(1).get();
			Members Jimmy = membersRepository.findById(2).get();
			Members Michael = membersRepository.findById(3).get();
			Members Daisy = membersRepository.findById(4).get();
			
			//將會員與旅遊地點組合
			Andy.getCountries().add(Japan);
			membersRepository.save(Andy);
			
			Jimmy.getCountries().add(Japan);
			Jimmy.getCountries().add(Korena);
			Jimmy.getCountries().add(Vietnam);
			membersRepository.save(Jimmy);
			
			Michael.getCountries().add(Japan);
			Michael.getCountries().add(Korena);
			membersRepository.save(Michael);
			
			Daisy.getCountries().add(Japan);
			Daisy.getCountries().add(Korena);
			membersRepository.save(Daisy);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
