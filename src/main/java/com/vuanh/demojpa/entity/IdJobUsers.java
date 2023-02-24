package com.vuanh.demojpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IdJobUsers implements Serializable {
    @Column(name = "user_id")
    private int userID;

    @Column(name = "job_id")
    private int jobId;

    public IdJobUsers() {
    }

    public IdJobUsers(int userID, int jobId) {
        this.userID = userID;
        this.jobId = jobId;
    }
}
