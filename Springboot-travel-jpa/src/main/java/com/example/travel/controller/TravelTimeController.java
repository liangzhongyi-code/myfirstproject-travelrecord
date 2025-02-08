package com.example.travel.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.travel.model.dto.MembersDTO;
import com.example.travel.model.dto.TraveltimeDTO;
import com.example.travel.model.entity.Members;
import com.example.travel.service.TravelTimeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/traveltime")
public class TravelTimeController {

	@Autowired
	private TravelTimeService travelTimeService;
	
	//查詢出國資訊
	@GetMapping("/find")
	public String findTravelTime(@RequestParam(name = "startDate", required = false) LocalDate startDate,
								@RequestParam(name = "endDate", required = false) LocalDate endDate,
								Model model) {
		
		List<MembersDTO> membersDTOs = null; // 出國會員集合
		//若 startDate 與 endDate 都為空，表示要取得今日出國會員
		if(startDate == null && endDate == null) { // 今日
			startDate = LocalDate.now();
			membersDTOs = travelTimeService.getMembersOnTraveltoday();
		}else if(startDate != null && endDate == null) { // 指定日期
			membersDTOs = travelTimeService.getMembersOnTravel(startDate);
		}else { // 指定日期區間
			membersDTOs = travelTimeService.getMembersOnTravel(startDate, endDate);
		}
		
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("membersDTOs", membersDTOs);
		
		return "traveltime";
		
	}
	
	//取得出國資訊
	@GetMapping
	public String getTravelTime(@RequestParam(name = "_method") String _method,
								@RequestParam(name = "id", required = false) Integer id,
								Model model, HttpSession session) {
		TraveltimeDTO traveltimeDTO = null; // 出遊DTO
		switch(_method) {
			
		case "POST": //新增
			traveltimeDTO = new TraveltimeDTO();
			traveltimeDTO.setAirline("China Airlines");
			break;
		case "PUT":  // 修改
		case "DELETE":  // 刪除
			//根據id找到出遊紀錄
			traveltimeDTO = travelTimeService.getTravelTimeDTO(id);
			break;
		}
		
		String submitButtonName = _method.equals("POST") ? "新增" : _method.equals("PUT") ? "修改" : "刪除";
		String[] airlineInfo = {"China Airlines","EVA Air","STARLUX Airlines","T'way Airlines"};
		String[] countryInfo = {"Japan","Korena","Vietnam","Taiwan"};
		
		model.addAttribute("_method",_method);
		model.addAttribute("submitButtonName",submitButtonName);
		model.addAttribute("airlineInfo",airlineInfo);
		model.addAttribute("countryInfo",countryInfo);
		model.addAttribute("traveltimeDTO",traveltimeDTO);
		return "members_travel_time";
 	}
	
	// 新增出國資訊
	@PostMapping
	public String addTravelTime(TraveltimeDTO traveltimeDTO, HttpSession session) {
		MembersDTO membersDTO = (MembersDTO)session.getAttribute("membersDTO");
		travelTimeService.addTravelTime(traveltimeDTO, membersDTO.getId());
		return "redirect:/members";
	}
	
	//修改出國資訊
	@PutMapping
	public String updateTravelTime(TraveltimeDTO traveltimeDTO, HttpSession session) {
		System.out.println("修改 LeaveRequestDTO.id = " + traveltimeDTO.getId());
		MembersDTO membersDTO = (MembersDTO)session.getAttribute("membersDTO");
		travelTimeService.updateTravelTime(traveltimeDTO, membersDTO.getId());
		return "redirect:/members";
	}
	
	//刪除出國資訊
	@DeleteMapping
	public String deleteTravelTime(@RequestParam(name = "id") Integer id) {
		travelTimeService.deleteTravelTime(id);
		return "redirect:/members";
	}
}
