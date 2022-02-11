package com.liam.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.liam.dojooverflow.models.Answer;
import com.liam.dojooverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	
	List<Answer> findAll();
	

//    List<Answer> findAllByQuestions(Question question);



    List<Answer> findByQuestionNotContains(Question question);

}
