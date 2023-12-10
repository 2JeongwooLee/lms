package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerDto {
    Long id;

    String bannerName;  //배너명
    String bannerUrl;   //배너 링크 주소

    int openCase;   //오픈 방법
    int sortNum;    //정렬 순서
    boolean showYn; //공개 여부

    LocalDateTime regDt;

    String fileName;
    String urlFileName;

    //추가컬럼
    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .bannerUrl(banner.getBannerUrl())
                .openCase(banner.getOpenCase())
                .sortNum(banner.getSortNum())
                .showYn(banner.isShowYn())
                .regDt(banner.getRegDt())
                .fileName(banner.getFileName())
                .urlFileName(banner.getUrlFileName())
                .build();
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return regDt != null ? regDt.format(formatter) : "";
    }
}