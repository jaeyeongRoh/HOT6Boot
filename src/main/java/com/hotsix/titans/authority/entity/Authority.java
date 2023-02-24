package com.hotsix.titans.authority.entity;

import com.hotsix.titans.team.entity.Team;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_AUTHORITY")
public class Authority {

    @Id
    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

    @OneToMany(mappedBy = "authority")
    private List<Team> teamList;


}
