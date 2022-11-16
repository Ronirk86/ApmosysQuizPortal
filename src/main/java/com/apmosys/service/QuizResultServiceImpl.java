package com.apmosys.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apmosys.model.QuizResult;
import com.apmosys.model.Rank;
import com.apmosys.repository.QuizResultRepository;
import com.apmosys.repository.RankRepository;

@Service
public class QuizResultServiceImpl implements QuizResultServiceI {

	@Autowired
	private QuizResultRepository  quizResultRepository;
	
	int i=0;
	
	@Override
	public void submitResult(Long qr_id,Integer attempted,Integer correct_answer,Integer marks_got,Integer user_id,Integer timeTakenByUser,Integer quest) {
		
		
		
		if(i==3) {
		  this.quizResultRepository.deleteByUserId(user_id);
		  i=0;
		}
		i++;
		//add time
		Integer timeTaken=this.quizResultRepository.getTime(user_id);
		//update is_latest to false of specific user
	    this.quizResultRepository.updateIsLatestToFalse(user_id);
	    
		System.out.println("Time Taken "+timeTaken);
		System.out.println("timeTakenByUser "+timeTakenByUser);
		if(timeTaken!=null) {
		  timeTakenByUser=timeTakenByUser+timeTaken;
		}
		Boolean is_latest=true;
		this.quizResultRepository.submitResult(qr_id,attempted, correct_answer, marks_got, user_id, timeTakenByUser,is_latest,quest);
		
	}

	@Override
	public QuizResult getQuizResult(Integer user_id) {
		return this.quizResultRepository.getByUserId(user_id);
	}

	
	public List<Rank> getAllQuizResult() throws SQLException {
		
		List<Rank> list=new ArrayList<Rank>();
		String query="select u.first_name,r.time_taken_by_user from result r join users u on r.user_id=u.id where r.is_latest=1 order by r.time_taken_by_user asc";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","password");
		PreparedStatement stm=conn.prepareStatement(query);
		ResultSet rs=stm.executeQuery();
		while(rs.next()) {
			Rank rank=new Rank();
			rank.setFirsName(rs.getString(1));
			rank.setTimeTakenByUser(rs.getInt(2));
			list.add(rank);
		}
		System.out.println("size========="+list.size());
		return list;
	}

	public List<Rank> getAllQuizResultOfFirstQuestion() throws SQLException {
		List<Rank> list=new ArrayList<Rank>();
		String query="select u.first_name,r.time_taken_by_user from result r join users u on r.user_id=u.id where r.quest=1 order by r.time_taken_by_user asc";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","password");
		PreparedStatement stm=conn.prepareStatement(query);
		ResultSet rs=stm.executeQuery();
		while(rs.next()) {
			Rank rank=new Rank();
			rank.setFirsName(rs.getString(1));
			rank.setTimeTakenByUser(rs.getInt(2));
			list.add(rank);
		}
		System.out.println("size========="+list.size());
		return list;
	}
    
	public List<Rank> getAllQuizResultOfSecondQuestion() throws SQLException {
		List<Rank> list=new ArrayList<Rank>();
		String query="select u.first_name,r.time_taken_by_user from result r join users u on r.user_id=u.id where r.quest=2 order by r.time_taken_by_user asc";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","password");
		PreparedStatement stm=conn.prepareStatement(query);
		ResultSet rs=stm.executeQuery();
		while(rs.next()) {
			Rank rank=new Rank();
			rank.setFirsName(rs.getString(1));
			rank.setTimeTakenByUser(rs.getInt(2));
			list.add(rank);
		}
		System.out.println("size========="+list.size());
		return list;
	}

	

}
