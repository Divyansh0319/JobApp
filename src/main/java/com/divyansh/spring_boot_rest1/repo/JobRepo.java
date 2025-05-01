package com.divyansh.spring_boot_rest1.repo;

import com.divyansh.spring_boot_rest1.model.JobPost;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface JobRepo extends JpaRepository<JobPost , Integer>{

	List<JobPost> findByPostDescContainingOrPostProfileContaining(String postDesc,String postProfile);

}

//List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//
//        new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//
//
//        new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
//                List.of("HTML", "CSS", "JavaScript", "React")),
//
//
//        new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                List.of("Python", "Machine Learning", "Data Analysis")),
//
//
//        new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
//                List.of("Networking", "Cisco", "Routing", "Switching")),
//
//
//        new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
//                List.of("iOS Development", "Android Development", "Mobile App"))
//));
//
//// ArrayList to store JobPost objec
//// method to return all JobPosts
//public List<JobPost> getAllJobs() {
//    return jobs;
//}
//
//// method to save a job post object into arrayList
//public void addJob(JobPost job) {
//    jobs.add(job);
//    System.out.println(jobs);
//
//}
//
//
//
//public Object findById(int jobID) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//public JobPost getJobById(int id) {
//	// TODO Auto-generated method stub
//	for(JobPost jobPost: jobs) {
//		if(jobPost.getPostId()==id) {
//			return jobPost;
//		}
//	}
//	return null;
//}
//
//public void updateJob(JobPost jobPost) {
//	// TODO Auto-generated method stub
//	for(JobPost job: jobs) {
//		if(jobPost.getPostId()==job.getPostId()) {
//			job.setPostDesc(jobPost.getPostDesc());
//			job.setPostId(jobPost.getPostId());
//			job.setPostProfile(jobPost.getPostProfile());
//			job.setPostTechStack(jobPost.getPostTechStack());
//			job.setReqExperience(jobPost.getReqExperience());
//		}
//	}
//}
//
//public void deleteJob(int postId) {
//	// TODO Auto-generated method stub
//	for(JobPost job:jobs) {
//		if(job.getPostId()==postId) {
//			jobs.remove(job);
//		}
//	}
//}

