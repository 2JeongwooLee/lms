package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.admin.dto.MemberHistoryDto;
import com.zerobase.fastlms.member.entity.MemberHistory;
import com.zerobase.fastlms.member.repository.MemberHistoryRepository;
import com.zerobase.fastlms.member.service.MemberHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberHistoryServiceImpl implements MemberHistoryService {
    private final MemberHistoryRepository memberHistoryRepository;

    @Override
    public List<MemberHistoryDto> list(String userId) {
        long totalCount = this.memberHistoryRepository.countByUserId(userId);

        List<MemberHistory> historyList
                = this.memberHistoryRepository.findByUserId(userId);

        List<MemberHistoryDto> dtoList = new ArrayList<>();
        for (MemberHistory history : historyList) {
            dtoList.add(MemberHistoryDto.of(history));
        }

        if (!CollectionUtils.isEmpty(historyList)) {
            int i = 0;

            for(MemberHistoryDto x : dtoList) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - i);
                i++;
            }
        }

        return dtoList;
    }

    @Override
    public void saveLoginHistory(String userId, String userAgent, String clientIp) {
        this.memberHistoryRepository.save(MemberHistory.builder()
                .userId(userId)
                .agent(userAgent)
                .ip(clientIp)
                .logDt(LocalDateTime.now())
                .build());
    }
}
