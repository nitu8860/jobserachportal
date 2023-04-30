package com.example.jobserachportal.controller;

import com.example.jobserachportal.model.Job;
import com.example.jobserachportal.model.JobType;
import com.example.jobserachportal.repository.JobRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            return ResponseEntity.ok(job.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(jobs);
        }
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody @Valid Job job) {
        Job savedJob = jobRepository.save(job);
        return ResponseEntity.created(URI.create("/jobs/" + savedJob.getId())).body(savedJob);
    }




    @PutMapping("/jobs/{id}/salary")
    public ResponseEntity<String> updateSalary(@PathVariable Long id, @RequestParam Double salary) {
        jobRepository.updateSalaryById(id, salary);
        return ResponseEntity.ok("Salary updated successfully");
    }

    @DeleteMapping("/jobs")
    public ResponseEntity<String> deleteByCompanyName(@RequestParam String companyName) {
        jobRepository.deleteByCompanyName(companyName);
        return ResponseEntity.ok("Jobs deleted successfully");
    }
    @GetMapping("/findByTitle")
    public ResponseEntity<List<Job>> findJobsByTitle(@RequestParam String title) {
        List<Job> jobs = jobRepository.findByTitleContaining(title);
        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(jobs);
        }
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<List<Job>> getJobsBySalary(@PathVariable Double salary) {
        List<Job> jobs = jobRepository.findBySalaryGreaterThanEqual(salary);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    @GetMapping("/findByJobType")
    public ResponseEntity<List<Job>> findJobsByJobType(@RequestParam JobType jobType) {
        List<Job> jobs = jobRepository.findByJobType(jobType);
        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(jobs);
        }
    }



    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam String query) {
        List<Job> jobs = jobRepository.searchJobs(query);
        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(jobs);
        }
    }
}
