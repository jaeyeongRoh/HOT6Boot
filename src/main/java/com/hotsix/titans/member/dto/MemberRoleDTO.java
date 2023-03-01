package com.hotsix.titans.member.dto;

public class MemberRoleDTO {
	private int teamNo;
	private int authorityCode;		// 엔티티를 작성하고 복합키 설정에 용이하기 위함이자 MemberRole insert나 update에서 필수!

	private TeamDTO team;
	private AuthorityDTO authority;

	public MemberRoleDTO() {
	}

	public MemberRoleDTO(int teamNo, int authorityCode, TeamDTO team, AuthorityDTO authority) {
		this.teamNo = teamNo;
		this.authorityCode = authorityCode;
		this.team = team;
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

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public AuthorityDTO getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityDTO authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberRoleDTO{" +
				"teamNo=" + teamNo +
				", authorityCode=" + authorityCode +
				", team=" + team +
				", authority=" + authority +
				'}';
	}
}
