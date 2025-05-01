package com.divyansh.spring_boot_rest1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.divyansh.spring_boot_rest1.model.JobPost;
import com.divyansh.spring_boot_rest1.service.JobService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestController {
	@Autowired
	private JobService service;
	
	@GetMapping("/jobPosts")
	public List<JobPost> getAlljobs() {
		return service.getAllJobs();
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
		return service.getJobById(postId);
	}
	
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
		return service.getJobById(jobPost.getPostId());
	}
	
	@PutMapping("/jobPost/{postId}")
	public JobPost updateJob(@PathVariable int postId, @RequestBody JobPost jobPost) {
	    jobPost.setPostId(postId);  // Ensure the ID is set in the JobPost object
	    service.UpdateJob(jobPost);  // Update the job post in the service layer
	    return service.getJobById(postId);  // Return the updated job post
	}

	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId) {
		service.deleteJob(postId);
		return "success";
	}
	
	@GetMapping("load")
	public String loadData() {
		 service.load();
		 return "success";
	}
	
	
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable ("keyword") String keyword){
		return service.searchByKeyword(keyword);
	}
	
}
