package com.luv2code.jobportal.services;

import com.luv2code.jobportal.entity.*;
import com.luv2code.jobportal.repository.JobPostActivityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostActivityService {

    private final JobPostActivityRepository jobPostActivityRepository;

    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }
    public List<RecruiterJobDto> getRecruiterJobs(int recruiter) {
        // get data from I recruiter Job this class access database direct
     List<IRecruiterJobs>recruiterJobsDto =jobPostActivityRepository.getRecruiterJobs(recruiter);
     List<RecruiterJobDto> recruiterJobDtoList = new ArrayList<>();
//        The retrieved data is mapped into RecruiterJobDto objects. The following code converts the query results into DTOs:
     for (IRecruiterJobs recruiterJob : recruiterJobsDto) {
         JobLocation loc = new JobLocation(recruiterJob.getLocationId(),recruiterJob.getCity()
         ,recruiterJob.getState(),recruiterJob.getCountry());
        JobCompany comp=  new JobCompany(recruiterJob.getCompanyId() , recruiterJob.getName(), "");
        recruiterJobDtoList.add(new RecruiterJobDto(recruiterJob.getTotalCandidates() , recruiterJob.getJob_post_id(),
                recruiterJob.getJob_title() , loc , comp));
     }
     return recruiterJobDtoList;
    }

    public JobPostActivity getOne(int id) {
        return jobPostActivityRepository.findById(id).orElseThrow(() ->new RuntimeException("Job not found"));
    }
}