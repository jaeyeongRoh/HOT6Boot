package com.hotsix.titans.rank.entity;

import com.hotsix.titans.member.entity.Member;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TBL_RANK")
public class Rank {

    @Id
    @Column(name = "RANK_CODE")
    private int rankCode;       // 직급 코드 ex) 1~8까지 1 = 사장 8 = 사원

    @Column(name = "RANK_NAME")
    private String rankName;    // 직급명  ex) 사원

    @OneToMany(mappedBy = "rank")
    private List<Member> memberList;    // 사원 테이블과 일대다 매핑
    
    
}
