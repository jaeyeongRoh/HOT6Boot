package com.hotsix.titans.board.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(
        name = "BOARD_COMMENT_SEQ_GENERATOR",
        sequenceName = "SEQ_BOARD_COMMENT",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "TBL_BOARD_COMMENT")
@DynamicInsert
public class BoardCommunityComment {

    @Id
    @Column(name = "COMMENT_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD_COMMENT") // insert 시 의미있음
    @GenericGenerator(name = "SEQ_BOARD_COMMENT", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER,
                            value = "BCC")
            })
    private String commentCode;

//    @ManyToOne
//    @JoinColumn(name = "BOARD_CODE", insertable = false, updatable = false)
    @Column(name = "BOARD_CODE")
    private String boardCode;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "COMMENT_CONTENT")
    private String commentContent;

    @Column(name = "COMMENT_INSERT_DATE")
    private LocalDateTime commentInsertDate;

    @Column(name = "COMMENT_UPDATE_DATE")
    private LocalDateTime commentUpdateDate;

    @Column(name = "COMMENT_DELETE_YN")
    private Character commentDeleteYn;

    @ManyToOne
    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    private BoardMember member;

}