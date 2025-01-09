package com.example.travel.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date startDate; //出發日期
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(nullable = false)
	private String airline; //航空公司

	@Override
	public String toString() {
		return "traveltime [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", airline=" + airline
				+ "]";
	}
	
	
}
