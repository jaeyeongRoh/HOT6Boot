package com.hotsix.titans.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberRoleDTO {
	private int memberNo;
	private int authorityCode;		// 엔티티를 작성하고 복합키 설정에 용이하기 위함이자 MemberRole insert나 update에서 필수!
	private AuthorityDTO authority;

}
