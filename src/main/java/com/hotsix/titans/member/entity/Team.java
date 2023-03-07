package com.hotsix.titans.member.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_TEAM")
public class Team {

    @Id
    @Column(name = "TEAM_CODE")
    private int teamCode;

    @Column(name = "TEAM_NAME")
    private String teamName;


}
