package com.divyansh.spring_boot_rest1.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Component
@Entity
public class JobPost {

	@Id
	private int postId;

	private String postProfile; 
	private String postDesc;
	private Integer reqExperience;
	@ElementCollection
	private List<String> postTechStack;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostProfile() {
		return postProfile;
	}
	public void setPostProfile(String postProfile) {
		this.postProfile = postProfile;
	}
	public String getPostDesc() {
		return postDesc;
	}
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
	public Integer getReqExperience() {
		return reqExperience;
	}
	public void setReqExperience(Integer reqExperience) {
		this.reqExperience = reqExperience;
	}
	public List<String> getPostTechStack() {
		return postTechStack;
	}
	public void setPostTechStack(List<String> postTechStack) {
		this.postTechStack = postTechStack;
	}
	public JobPost(int postId, String postProfile, String postDesc, Integer reqExperience, List<String> postTechStack) {
		super();
		this.postId = postId;
		this.postProfile = postProfile;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.postTechStack = postTechStack;
	}
	public JobPost() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JobPost [postId=" + postId + ", postProfile=" + postProfile + ", postDesc=" + postDesc
				+ ", reqExperience=" + reqExperience + ", postTechStack=" + postTechStack + "]";
	}
	
	
	
	
	

}
