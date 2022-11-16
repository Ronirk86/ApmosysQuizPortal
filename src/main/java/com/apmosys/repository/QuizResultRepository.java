package com.apmosys.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.apmosys.model.QuizResult;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long>{

	@Modifying
	@Query(value = "insert into result (qr_id,attempted,correct_answer,marks_got,user_id,time_taken_by_user,is_latest,quest) values(?,?,?,?,?,?,?,?);",nativeQuery = true)
	@Transactional
	public void submitResult(Long qr_id,Integer attempted,Integer correct_answer,Integer marks_got,Integer user_id,Integer timeTakenByUser,Boolean is_latest,Integer quest);

	@Modifying
	@Query(value = "delete from result where user_id=?",nativeQuery = true)
	@Transactional
	public void deleteByUserId(Integer user_id);

	@Query(value = "select * from result where user_id=? and is_latest=1",nativeQuery = true)
	public QuizResult getByUserId(Integer user_id);

	@Query(value = "select time_taken_by_user from result where user_id=? and is_latest=true",nativeQuery = true)
	public Integer getTime(Integer user_id);

	@Modifying
	@Query(value = "update result set is_latest=false where user_id=?",nativeQuery = true)
	@Transactional
	public void updateIsLatestToFalse(Integer user_id);
	
}
