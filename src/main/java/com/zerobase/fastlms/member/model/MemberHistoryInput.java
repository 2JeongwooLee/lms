package com.zerobase.fastlms.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberHistoryInput {
    String userId;
    LocalDateTime logDt;
    String ip;
    String agent;
}
