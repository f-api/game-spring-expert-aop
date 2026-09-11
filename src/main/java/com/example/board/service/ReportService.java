package com.example.board.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReportService {
    public String summary() {
        try {
            Thread.sleep(130); // 느린 집계를 흉내 냅니다.
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
        }
        log.info("본문 실행: summary()");
        return "리포트 요약";
    }
}
