package com.hotsix.titans.board.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_MEMBER")
public class BoardMember {

    @Id
    @Column(name = "MEMBER_CODE")
    private String memberCode;
    @Column(name = "MEMBER_NAME")
    private String memberName;
}