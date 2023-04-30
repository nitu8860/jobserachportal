package com.example.jobserachportal.repository;
import com.example.jobserachportal.model.Job;
import com.example.jobserachportal.model.JobType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyName(String companyName);

    List<Job> findBySalaryGreaterThanEqual(Double salary);

    List<Job> findByJobType(JobType jobType);

    List<Job> findByTitleContaining(String title);

    @Query("SELECT j FROM Job j WHERE j.title LIKE %:query% OR j.description LIKE %:query%")
    List<Job> searchJobs(@Param("query") String query);

    @Modifying
    @Transactional
    @Query("UPDATE Job SET salary = :salary WHERE id = :jobId")
    void updateSalaryById(@Param("jobId") Long jobId, @Param("salary") Double salary);

    @Modifying
    @Transactional
    @Query("DELETE FROM Job WHERE companyName = :companyName")
    void deleteByCompanyName(@Param("companyName") String companyName);
}
