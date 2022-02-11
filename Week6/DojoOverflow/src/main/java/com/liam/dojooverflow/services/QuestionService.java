package com.liam.dojooverflow.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.dojooverflow.models.Answer;
import com.liam.dojooverflow.models.Question;
import com.liam.dojooverflow.models.Tag;
import com.liam.dojooverflow.repositories.AnswerRepository;
import com.liam.dojooverflow.repositories.QuestionRepository;
import com.liam.dojooverflow.repositories.TagRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository mainRepo;
	
	@Autowired
	private TagRepository secondRepo;
	
	@Autowired
	private AnswerRepository sideRepo;
	
	public List<Question> getAll() {
        return mainRepo.findAll();
    }
    
    public Question getOne(Long id) {
    	return mainRepo.findById(id).orElse(null);

    }
    
    // Get all Mains that Serf doesn't belong to
    public List<Question> findByTagsNotContains(Tag tag) {
    	return mainRepo.findByTagsNotContains(tag);
    }
    
  

    public Question create(Question dommod) {
        return mainRepo.save(dommod);
    }
    


    
    public Question update(Question dommod) {
        return mainRepo.save(dommod);
    }

    	

    
    public void delete(Long Id) {
    	mainRepo.deleteById(Id);
    	}
    
    // MANY TO MANY
    
    // Create New Serf
    
    public Tag createSerf(Tag dommod) {
        return secondRepo.save(dommod);
    }
    
    // Find all Serfs
	public List<Tag> getAllSerfs() {
        return secondRepo.findAll();
    }
	
	// Delete Serf
    public void deleteSerf(Long Id) {
    	secondRepo.deleteById(Id);
    }
    
    // Get one Serf
    public Tag getOneSerf(Long id) {
    	return secondRepo.findById(id).orElse(null);

    }
    
    // Get all Serfs that Main doesn't belong to
    public List<Tag> findByQuestionsNotContains(Question question) {
    	return secondRepo.findByQuestionsNotContains(question);
    }
    
    // Edit Serf
    public Tag updateSerf(Tag dommod) {
        return secondRepo.save(dommod);
    }
    
    
    // MANY TO MANY
    
    
	// Add Serf to Main
	public void addSerfToMain(Tag tag, Question question) {
		question.getTags().add(tag);
		
		this.mainRepo.save(question);
	}
	
	// Remove Serf from Main
	public void removeSerfFromMain(Tag tag, Question question) {
		question.getTags().remove(tag);
		
		this.mainRepo.save(question);
	}
	

    
    
	// Add Main to Serf
	public void addMainToSerf(Question question, Tag tag) {
		tag.getQuestions().add(question);

		this.secondRepo.save(tag);
	}
	
	// Remove Main from Serf
	public void removeMainFromSerf(Question question, Tag tag) {
		tag.getQuestions().add(question);

		this.secondRepo.save(tag);
	}
	
	
	
	// ONE to MANY
	
	
    // Create New Side (with MAIN)
    
    public Answer createSide(Answer dommod) {
        return sideRepo.save(dommod);
    }
    
    // Find all Sides
	public List<Answer> getAllSides() {
        return sideRepo.findAll();
    }
	
	// Delete Side
    public void deleteSide(Long Id) {
    	sideRepo.deleteById(Id);
    }
    
    // Get one Side
    public Answer getOneSide(Long id) {
    	return sideRepo.findById(id).orElse(null);

    }
    
    // Get all Mains that Side belong to
    public List<Answer> findByQuestionNotContainsSide(Question question) {
    	return sideRepo.findByQuestionNotContains(question);
    }
    
//	// Add Side to Main
//	public void addSideToMain(Answer answer, Question question) {
//		question.getAnswers().add(answer);
//		
//		this.mainRepo.save(question);
//	}
//	
//	// Remove Side from Main
//	public void removeSideFromMain(Answer answer, Question question) {
//		question.getAnswers().remove(answer);
//		
//		this.mainRepo.save(question);
//	}
	
	
    
    


//	// Remove Main from Side
//	public void removeMainFromSide(Question question, Answer answer) {
//		answer.getQuestion().remove(question);
//
//		this.sideRepo.save(answer);
//	}
    
    
	// Add Main AAANNNDDDD Serf
	public void addMainAndSerf(Tag tag, Question question) {

		question.getTags().add(tag);
//		tag.getQuestions().add(question);
//		List<Question> newQuestions = tag.getQuestions();
//		newQuestions.add(question);
//		question.getTags().add(tag);
//		tag.getQuestions().add(question);
		secondRepo.save(tag);
		mainRepo.save(question);
		

	}
	
//	// Add Main AAANNNDDDD Serf
//	public void addMainAndSerf(Question question) {
//		List<Tag> questionsTags = new ArrayList<Tag>();
//		for(String subject: question.splitTags()) {
//			Tag tag = this.secondRepo.findBySubject(subject).orElse(null);
//			if(tag == null) {
//				tag = new Tag(subject, null);
//				this.secondRepo.save(tag);
//			}
//			// prevent dupe tags
//			if(!questionsTags.contains(tag))
//				questionsTags.add(tag);
//		}
//		Question newQuestion = new Question(question.getNewQuestion(), questionsTags);
//
//		this.mainRepo.save(newQuestion);
//	}
	
	
	
	
	
	
	

}
