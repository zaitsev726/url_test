package org.example.url.test.service;


import org.example.url.test.entity.TodayHtmlInfo;
import org.example.url.test.entity.YesterdayHtmlInfo;
import org.example.url.test.repository.TodayHtmlInfoRepository;
import org.example.url.test.repository.YesterdayHtmlInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HtmlInfoService {
    private final TodayHtmlInfoRepository todayHtmlInfoRepository;
    private final YesterdayHtmlInfoRepository yesterdayHtmlInfoRepository;

    @Autowired
    public HtmlInfoService(TodayHtmlInfoRepository todayHtmlInfoRepository,
                           YesterdayHtmlInfoRepository yesterdayHtmlInfoRepository) {
        this.todayHtmlInfoRepository = todayHtmlInfoRepository;
        this.yesterdayHtmlInfoRepository = yesterdayHtmlInfoRepository;
    }

    public List<YesterdayHtmlInfo> getDeletedHtmlInfo() {
        List<YesterdayHtmlInfo> yesterdayHtmlInfos = yesterdayHtmlInfoRepository.findAll();
        List<TodayHtmlInfo> todayHtmlInfos = todayHtmlInfoRepository.findAll();

        return yesterdayHtmlInfos.stream()
                .filter(yesterdayHtmlInfo -> todayHtmlInfos.stream()
                        .noneMatch(todayHtmlInfo -> todayHtmlInfo
                                .getUrl()
                                .equals(yesterdayHtmlInfo.getUrl())))
                .collect(Collectors.toList());
    }

    public List<TodayHtmlInfo> getNewHtmlInfo() {
        List<YesterdayHtmlInfo> yesterdayHtmlInfos = yesterdayHtmlInfoRepository.findAll();
        List<TodayHtmlInfo> todayHtmlInfos = todayHtmlInfoRepository.findAll();

        return todayHtmlInfos.stream()
                .filter(todayHtmlInfo -> yesterdayHtmlInfos.stream()
                        .noneMatch(yesterdayHtmlInfo -> yesterdayHtmlInfo
                                .getUrl()
                                .equals(todayHtmlInfo.getUrl())))
                .collect(Collectors.toList());

    }

    public List<YesterdayHtmlInfo> getChangedHtmlInfoList() {
        List<YesterdayHtmlInfo> yesterdayHtmlInfos = yesterdayHtmlInfoRepository.findAll();
        List<TodayHtmlInfo> todayHtmlInfos = todayHtmlInfoRepository.findAll();

        return yesterdayHtmlInfos.stream()
                .filter(yesterdayHtmlInfo -> todayHtmlInfos.stream()
                        .anyMatch(todayHtmlInfo -> todayHtmlInfo
                                .getUrl()
                                .equals(yesterdayHtmlInfo.getUrl())
                                && !todayHtmlInfo
                                .getHtmlCode()
                                .equals(yesterdayHtmlInfo.getUrl())))
                .collect(Collectors.toList());

    }
}
