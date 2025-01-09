package com.example.travel.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "members")
@Getter
@Setter
public class Members {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20, nullable = false, unique = true)
	private String membername;
	
	@Column(length = 20, nullable = false)
	private String password;
	
	@Column
	@Temporal(TemporalType.DATE) // 僅存日期
	private Date birthday; // 生日 
	
	@Column(length = 20, nullable = true)
	private String address;

	@OneToMany(mappedBy = "members", fetch = FetchType.EAGER)
	private List<Traveltime> Traveltimes;
	
	@OneToOne
	@JoinColumn(name = "cost_id", nullable = true, referencedColumnName = "id")
	private Cost cost;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "member_country",
			joinColumns = @JoinColumn(name = "member_id"),
			inverseJoinColumns = @JoinColumn(name = "country_id")
			)
	private List<Country> countries;

	@Override
	public String toString() {
		return "Members [id=" + id + ", membername=" + membername + ", password=" + password + ", Birthday=" + birthday
				+ ", address=" + address + "]";
	}
	
	
	
}
