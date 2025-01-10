package com.example.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travel.model.dto.CountryDTO;
import com.example.travel.service.CountryService;

@Controller
@RequestMapping("/travelrecord/country")
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@GetMapping
	public String findAllCountries(CountryDTO countryDTO, Model model) {
		List<CountryDTO> countriesDTOs = countryService.findAllCountryDTOs();
		model.addAttribute("countriesDTOs", countriesDTOs);
		return "country";
	}
	
	@PostMapping
	public String addCountry(CountryDTO countryDTO) {
		countryService.addCountry(countryDTO);
		return "redirect:/travelrecord/country";
	}
}
