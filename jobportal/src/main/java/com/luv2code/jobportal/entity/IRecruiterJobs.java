package com.luv2code.jobportal.entity;

//IRecruiterJobs is a projection interface.
// It is used to map specific columns from the result set of the native SQL query into a Java object without needing to map the entire entity.
// Instead of returning full JobPostActivity objects (which would involve loading entire entities from the database),
// this interface is designed to retrieve only the required fields (like job post ID, title, location, etc.).


//via projection
public interface IRecruiterJobs {
    Long getTotalCandidates();
    int getJob_post_id();
    String getJob_title();
    int getLocationId();
    String getCity();
    String getState();
    String getCountry();
    int getCompanyId();
    String getName();

}
