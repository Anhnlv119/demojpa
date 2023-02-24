package com.vuanh.demojpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "sub_job")
//@IdClass(IdJobUsers.class)
public class JobUsers {

//    @Id
//    private int userID;
//
//    @Id
//    private  int jobId;

    @EmbeddedId
    IdJobUsers idJobUsers;

}
