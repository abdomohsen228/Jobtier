package com.luv2code.jobportal.entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userId","job"})
})
// enables an object to be converted into a byte stream,
// and later reconstructed from that byte stream.
// This process of converting an object into a format that can be stored or transmitted is called serialization.
// The reverse process, where the byte stream is converted back into the object, is called deserialization.
//Serialization is commonly used when an object needs to be persisted (e.g., saved to a file or database) or transmitted (e.g., sent over a network).

public class JobSeekerApply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId" , referencedColumnName = "user_account_id")
    private JobSeekerProfile jobSeekerProfile;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job",referencedColumnName = "jobPostId")
    private JobPostActivity job;


    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date applyDate;

    private String coverLetter;

    public JobSeekerApply() {

    }

    public JobSeekerApply(Integer id, JobSeekerProfile jobSeekerProfile, JobPostActivity job, Date applyDate, String coverLetter) {
        this.id = id;
        this.jobSeekerProfile = jobSeekerProfile;
        this.job = job;
        this.applyDate = applyDate;
        this.coverLetter = coverLetter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public JobPostActivity getJob() {
        return job;
    }

    public void setJob(JobPostActivity job) {
        this.job = job;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    @Override
    public String toString() {
        return "JobSeekerApply{" +
                "id=" + id +
                ", jobSeekerProfile=" + jobSeekerProfile +
                ", job=" + job +
                ", applyDate=" + applyDate +
                ", coverLetter='" + coverLetter + '\'' +
                '}';
    }
}

