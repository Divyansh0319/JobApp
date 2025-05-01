package com.divyansh.spring_boot_rest1.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divyansh.spring_boot_rest1.model.JobPost;
import com.divyansh.spring_boot_rest1.repo.JobRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;


    // method to add a jobPost
    public void addJob(JobPost jobPost) {
        repo.save(jobPost);

    }


    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }
        
     // 
     public void UpdateJob(JobPost jobPost) {
    	 repo.save(jobPost);
     }


	public JobPost getJobById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new JobPost());
	}


	public void deleteJob(int postId) {
		// TODO Auto-generated method stub
		repo.deleteById(postId);
	}


	public void load() {
		// TODO Auto-generated method stub
		List<JobPost> jobs = new ArrayList<>(Arrays.asList(
		
		        new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
		                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
		
		
		        new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
		                List.of("HTML", "CSS", "JavaScript", "React")),
		
		
		        new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
		                List.of("Python", "Machine Learning", "Data Analysis")),
		
		
		        new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
		                List.of("Networking", "Cisco", "Routing", "Switching")),
		
		
		        new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
		                List.of("iOS Development", "Android Development", "Mobile App"))
		));
		repo.saveAll(jobs);
	}


	public List<JobPost> searchByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return repo.findByPostDescContainingOrPostProfileContaining(keyword, keyword);
	}

//    public JobPost GetJob(int jobID) {
//    	return repo.findById(jobID).orElse(new JobPost());
//    }
//    
//    public void DeleteJob(int jobID) {
//    	repo.deleteById(jobID);
//    }


}
