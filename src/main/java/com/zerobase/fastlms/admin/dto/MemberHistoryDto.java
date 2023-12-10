package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.MemberHistory;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberHistoryDto {
    Long id;

    String userId;
    LocalDateTime logDt;
    String ip;
    String agent;

    //추가 컬럼
    long totalCount;
    long seq;

    public static MemberHistoryDto of(MemberHistory memberHistory) {
        return MemberHistoryDto.builder()
                .userId(memberHistory.getUserId())
                .logDt(memberHistory.getLogDt())
                .ip(memberHistory.getIp())
                .agent(memberHistory.getAgent())
                .build();
    }

    public String getLogDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return logDt != null ? logDt.format(formatter) : "";
    }

}
