package com.hotsix.titans.member.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
@Entity
@Table(name = "TBL_PROFILE_IMG")
public class ProfileImage {

    @Id
    @Column(name = "PROFILE_IMG_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROFILE_IMG_CODE")
    @GenericGenerator(name = "SEQ_PROFILE_IMG_CODE", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "IMG")
            })
    private String profileImageCode;

    @Column(name = "PROFILE_IMG_ORIGIN_NAME")
    private String profileImageOriginName;

    @Column(name = "PROFILE_IMG_CHANGE_NAME")
    private String profileImageChangeName;

    @Column(name = "PROFILE_IMG_TYPE")
    private String profileImageType;

    @Column(name = "PROFILE_IMG_LOCATION")
    private String profileImageLocation;

    @Column(name = "PROFILE_IMG_CREATE_DATE")
    private Date profileImageCreateDate;

    @Column(name = "PROFILE_IMG_DELETE_YN")
    private String profileImageDeleteYn;


    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    private Member member;

}
