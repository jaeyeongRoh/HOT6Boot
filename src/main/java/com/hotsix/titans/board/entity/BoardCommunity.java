package com.hotsix.titans.board.entity;

import com.hotsix.titans.commons.StringPrefixSequenceGenerator;
import com.hotsix.titans.member.entity.TeamRole;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(
        name = "COMMUNITY_SEQ_GENERATOR",
        sequenceName = "SEQ_BOARD",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "TBL_BOARD")
@DynamicInsert
public class BoardCommunity {

    @Id
    @Column(name = "BOARD_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD") // insert 시 의미있음
    @GenericGenerator(name = "SEQ_BOARD", strategy = "com.hotsix.titans.commons.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER,
                            value = "BN")
            })
    private String boardCode;

    @Column(name = "MEMBER_CODE")
    private String memberCode;

    @Column(name = "BOARD_TITLE")
    private String boardTitle;

    @Column(name = "BOARD_CONTENT")
    private String boardContent;

    @Column(name = "BOARD_INSERT_DATE")
    private LocalDateTime boardInsertDate;

    @Column(name = "BOARD_UPDATE_DATE")
    private LocalDateTime boardUpdateDate;

    @Column(name = "BOARD_COUNT")
    private Integer boardCount;

    @Column(name = "BOARD_DELETE_YN")
    private Character boardDeleteYn;

    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_CODE", insertable = false, updatable = false)
    private BoardNoticeMember member;

    @OneToMany
    @JoinColumn(name = "COMMENT_CODE")
    private List<BoardCommunityComment> boardCommunityComment;

}

