package com.hotsix.titans.member.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_TEAM_ROLE")
@IdClass(TeamRolePk.class)
public class TeamRole {

	@Id
	@Column(name = "TEAM_CODE")
	private int teamNo;

	@Id
	@Column(name = "AUTHORITY_CODE")
	private int authorityCode;

	/* Authority 타입의 속성은 조회할 때 Join용으로는 쓰지만 insert나 update할 때는 무시하라고 설정하자. */
	@ManyToOne
	@JoinColumn(name = "AUTHORITY_CODE", insertable = false, updatable = false)
	private Authority authority;

	public TeamRole(int teamNo, int authorityCode) {
		this.teamNo = teamNo;
		this.authorityCode = authorityCode;
	}

	@Override
	public String toString() {
		return "TeamRole{" +
				"teamNo=" + teamNo +
				", authorityCode=" + authorityCode +
				", authority=" + authority +
				'}';
	}
}

