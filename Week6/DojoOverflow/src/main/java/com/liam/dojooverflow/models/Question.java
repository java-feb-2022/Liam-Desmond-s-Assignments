package com.liam.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2)
	private String newQuestion;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
    
	public Question() {
	}
    
    
	public Question(String string, List<Tag> questionsTags) {
	}

	
	
	
	public Question(String newQuestion, List<Tag> tags, List<Answer> answers) {
		this.newQuestion = newQuestion;
		this.tags = tags;
		this.answers = answers;
	}




	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNewQuestion() {
		return newQuestion;
	}




	public void setNewQuestion(String newQuestion) {
		this.newQuestion = newQuestion;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	public List<Tag> getTags() {
		return tags;
	}




	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}




	public List<Answer> getAnswers() {
		return answers;
	}




	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}



	public String[] splitTags() {
		return ((Tag) this.tags).split("\\s*,\\s*");
	}



	
	

}
