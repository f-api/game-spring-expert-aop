package com.example.board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ExecutionTimeAspect {
    // board 아래 service 패키지와 그 하위의 public 메서드에 적용합니다. (포인트컷)
    @Around("execution(public * com.example.board..service..*.*(..))")
    public Object measure(
            ProceedingJoinPoint joinPoint
    ) throws Throwable {
        long start = System.nanoTime();
        try {
            return joinPoint.proceed(); // 다음 부가 기능 또는 대상 메서드를 실행합니다.
        } finally {
            long tookMs = (System.nanoTime() - start) / 1_000_000;
            if (tookMs >= 100) {
                log.warn("느린 호출 {} — {}ms", joinPoint.getSignature().toShortString(), tookMs);
            }
        }
    }
}
