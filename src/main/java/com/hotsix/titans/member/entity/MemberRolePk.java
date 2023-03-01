package com.hotsix.titans.member.entity;

import java.io.Serializable;

/* 복합키 타입을 정의할 때는 Serializable을 반드시 구현 */
public class MemberRolePk implements Serializable {

	private int teamNo;
	private int authorityCode;
	
	public MemberRolePk() {
	}

	public MemberRolePk(int teamNo, int authorityCode) {
		this.teamNo = teamNo;
		this.authorityCode = authorityCode;
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

	@Override
	public String toString() {
		return "MemberRolePk{" +
				"teamNo=" + teamNo +
				", authorityCode=" + authorityCode +
				'}';
	}
}
	
