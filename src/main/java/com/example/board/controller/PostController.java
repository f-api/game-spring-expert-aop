package com.example.board.controller;

import com.example.board.service.PostService;
import com.example.board.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final ReportService reportService;

    @GetMapping("/posts")
    public String findRecent() {
        return postService.findRecent(20);
    }

    @GetMapping("/reports")
    public String report() {
        return reportService.summary();
    }
}
