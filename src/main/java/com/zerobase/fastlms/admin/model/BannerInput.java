package com.zerobase.fastlms.admin.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerInput {

    Long id;

    String bannerName;  //배너명
    String bannerUrl;   //배너 링크 주소

    int openCase;   //오픈 방법
    int sortNum;    //정렬 순서
    boolean showYn; //공개 여부

    LocalDateTime regDt;

    String fileName;
    String urlFileName;

    //삭제를 위한
    String idList;
}