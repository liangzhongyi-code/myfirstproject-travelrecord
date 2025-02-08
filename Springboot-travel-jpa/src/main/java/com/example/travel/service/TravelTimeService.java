package com.example.travel.service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.model.dto.MembersDTO;
import com.example.travel.model.dto.TraveltimeDTO;
import com.example.travel.model.entity.Members;
import com.example.travel.model.entity.Traveltime;
import com.example.travel.repository.MembersRepository;
import com.example.travel.repository.TraveltimeRepository;

@Service
public class TravelTimeService {
	
	@Autowired
	private TraveltimeRepository traveltimeRepository;
	
	@Autowired
	private MembersRepository membersRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//新增
	public void addTravelTime(TraveltimeDTO traveltimeDTO, Integer membersId) {
		//轉換
		Traveltime traveltime = modelMapper.map(traveltimeDTO, Traveltime.class);
		
		// 根據 membersId 取得 members 物件
		Members members = membersRepository.findById(membersId).get();
		
		//設定會員
		traveltime.setMembers(members);
		
		traveltimeRepository.save(traveltime);
	}
	
	//刪除
	public void deleteTravelTime(Integer id) {
		traveltimeRepository.deleteById(id);
	}
	
	//修改
	public void updateTravelTime(TraveltimeDTO traveltimeDTO, Integer membersId) {
		//轉換
		Traveltime traveltime = modelMapper.map(traveltimeDTO, Traveltime.class);
				
		// 根據 membersId 取得 members 物件
		Members members = membersRepository.findById(membersId).get();
				
		//設定會員
		traveltime.setMembers(members);
				
		traveltimeRepository.save(traveltime);	
	}
	
	//查詢出國紀錄
	public TraveltimeDTO getTravelTimeDTO(Integer id) {
		//取得請假紀錄 Entity
		Traveltime traveltime = traveltimeRepository.findById(id).get();
		//請假紀錄 Entity 轉 DTO
		TraveltimeDTO traveltimeDTO = modelMapper.map(traveltime, TraveltimeDTO.class);
		return traveltimeDTO;
	}
	
	//查詢今日有哪些會員出國
	public List<MembersDTO> getMembersOnTraveltoday(){
		LocalDate today = LocalDate.now();
		return getMembersOnTravel(today);
	}
	
	// 查詢指定日期有哪些會員出國
	public List<MembersDTO> getMembersOnTravel(LocalDate targetDate) {
		return getMembersOnTravel(targetDate, targetDate);
	}
	
	// 查詢指定日期區間有哪些會員出國
	public List<MembersDTO> getMembersOnTravel(LocalDate startDate, LocalDate endDate) {
		// 取得在此區間中有出國的紀錄
		List<Traveltime> Traveltimes = traveltimeRepository
				.queryByDate(startDate, endDate);
				//.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate);
			
		// 收集請假紀錄的員工資料(Member)並轉成(MembersDTO)
		return Traveltimes.stream() // ... LeaveRequest
				.map(Traveltime -> Traveltime.getMembers()) // ... Member
				.distinct() // 避免重複
				.map(Member -> modelMapper.map(Member, MembersDTO.class))
				.toList(); // [... MembersDTO]
			
		}
}
