package com.example.travel.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.travel.model.entity.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer>{
		// 根據 membername 取得 Members, 使用 JPQL 語法 (entity 結合 sql)
		@Query("select e from Members where e.membername = :membername")
		Members findByMembername(@Param("membername") String membername);
}
