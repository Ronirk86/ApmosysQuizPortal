package com.apmosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apmosys.model.Rank;

public interface RankRepository extends JpaRepository<Rank, Long> {
    
	@Query(value="select u.first_name,r.marks_got from result r join users u on r.user_id=u.id order by r.marks_got desc",nativeQuery = true)
	public List<Rank> getRank();
}
