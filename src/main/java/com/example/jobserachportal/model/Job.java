package com.example.jobserachportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotNull(message = "Salary is mandatory")
    @Min(value = 0, message = "Salary should not be less than 0")
    private Double salary;

    @NotBlank(message = "Company name is mandatory")
    private String companyName;

    @NotBlank(message = "Employer name is mandatory")
    private String employerName;

    @NotNull(message = "Job type is mandatory")
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}
