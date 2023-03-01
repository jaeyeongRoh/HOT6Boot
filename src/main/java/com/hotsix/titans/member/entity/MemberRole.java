package com.hotsix.titans.member.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_MEMBER_ROLE")
@IdClass(MemberRolePk.class)
public class MemberRole {

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

	public MemberRole() {
	}

	public MemberRole(int teamNo, int authorityCode, Authority authority) {
		this.teamNo = teamNo;
		this.authorityCode = authorityCode;
		this.authority = authority;
	}

	public int getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}

	public int getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberRole{" +
				"teamNo=" + teamNo +
				", authorityCode=" + authorityCode +
				", authority=" + authority +
				'}';
	}
}
