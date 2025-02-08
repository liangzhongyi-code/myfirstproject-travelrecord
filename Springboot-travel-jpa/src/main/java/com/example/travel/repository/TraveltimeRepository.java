package com.example.travel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.travel.model.entity.Traveltime;

@Repository
public interface TraveltimeRepository extends JpaRepository<Traveltime, Integer>{
	// 查詢某員工的國際紀錄
	// 使用標準 SQL 語言
	// nativeQuery=true 表示是使用標準 sql 語言
	@Query(value = "select * from traveltime where member_id = :membersId", nativeQuery=true)
	List<Traveltime> query1(Integer membersId);
		
	// 使用 JPA 所提供的 JPQL 語言
	@Query("select r from Traveltime r where r.members.id  = :membersId")
	List<Traveltime> query2(Integer membersId);
		
	// 使用 JPA 提供的簡易方法命名(不需要 SQL 或 JPQL)
	List<Traveltime> findBymembersId(Integer membersId);
		
	// 查詢在指定日期間的出國際紀錄
	@Query(value = "select * from traveltime where start_date <= :date2 and end_date >= :date1", nativeQuery=true)
	List<Traveltime> queryByDate(LocalDate date1, LocalDate date2);

}
