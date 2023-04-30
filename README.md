# Job Search Portal
This is a Java Spring Boot REST API project for a job search portal.

## Frameworks and language used
- Java 11
- Spring Boot
- Spring Data JPA
- Jakarta Bean Validation
- H2 Database

## Data flow 
- **Controller -** Handles incoming requests and returns responses.
- **Repository -** Provides various query methods to retrieve and manipulate data from the database.
- **Model -** Defines the Job class used to represent a job posting.
- **Enums -** Defines the JobType enum used in the Job class to represent the type of job.

## Data structure used
- Model: Job
- Enum: JobType

## Endpoints
- **GET /jobs/{id} -** Get a specific job by ID
- **GET /jobs -** Get all jobs
- **POST /jobs -** Create a new job
- **PUT /jobs/{id}/salary -** Update the salary of a job by ID
- **DELETE /jobs -** Delete jobs by company name
- **GET /jobs/findByTitle -** Find jobs by title
- **GET /jobs/salary/{salary} -** Find jobs with salary greater than or equal to the specified amount
- **GET /jobs/findByJobType -** Find jobs by job type
- **GET /jobs/search -** Search jobs by a query string

## Project Summary
This project provides a REST API for a job search portal that allows users to perform various CRUD operations on job postings and search for jobs based on various parameters. The API can retrieve a job by ID, retrieve all jobs, create a new job, update the salary of a job by ID, delete jobs by company name, find jobs by title, find jobs with salary greater than or equal to a specified amount, find jobs by job type, and search jobs by a query string. The Job class represents a job posting with properties such as title, description, location, salary, companyName, employerName, jobType, and appliedDate, and the JobType enum is used to represent the type of job. The JobRepository interface extends the JpaRepository interface provided by Spring Data JPA and includes various query methods to retrieve data from the database.
