package com.example.board.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostService {
    public String findRecent(
            int limit
    ) {
        try {
            Thread.sleep(120); // 느린 조회를 흉내 냅니다.
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
        }
        log.info("본문 실행: findRecent({})", limit);
        return "게시글 " + limit + "건";
    }
}
