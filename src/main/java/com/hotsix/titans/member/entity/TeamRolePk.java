package com.hotsix.titans.member.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Getter
@Setter
/* 복합키 타입을 정의할 때는 Serializable을 반드시 구현 */
public class TeamRolePk implements Serializable {

	private int teamNo;
	private int authorityCode;

}
