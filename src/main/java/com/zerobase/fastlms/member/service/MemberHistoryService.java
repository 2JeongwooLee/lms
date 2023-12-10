package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.MemberHistoryDto;

import java.util.List;

public interface MemberHistoryService {
    List<MemberHistoryDto> list(String userId);
    void saveLoginHistory(String userId, String userAgent, String clientIp);
}
