package com.example.travel.model.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "traveltime")
@Getter
@Setter
public class Traveltime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Members members;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 指定只有日期
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 指定只有日期
	private LocalDate endDate;
	
	@Column(nullable = false)
	private String airline; //航空公司

	@Column(nullable = false)
	private String country; //出遊地點
	
	@Override
	public String toString() {
		return "traveltime [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", airline=" + airline
				+ "]";
	}
	
	
}
