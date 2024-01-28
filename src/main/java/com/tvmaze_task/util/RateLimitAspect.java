package com.tvmaze_task.util;

import com.tvmaze_task.exceptions.RateLimitExceededException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RateLimitAspect {

    private static final ConcurrentHashMap<String, Long> requestTimestamps = new ConcurrentHashMap<>();

    /**
     * Simple rate limit checker which checks that the interval of requests does not exceed the TV Maze api's rate limit.
     *
     * @param rateLimited rateLimited is the annotation which contains the information of the previous time this was called.
     */
    @Before("@annotation(rateLimited)")
    public void rateLimitCheck(RateLimited rateLimited) {
        String key = rateLimited.key();
        long allowedInterval = rateLimited.interval();

        long now = System.currentTimeMillis();
        long lastRequestTime = requestTimestamps.getOrDefault(key, 0L);

        if (now - lastRequestTime < allowedInterval) {
            throw new RateLimitExceededException("429", "Too many requests are made to this endpoint.", HttpStatus.TOO_MANY_REQUESTS);
        }

        requestTimestamps.put(key, now);
    }
}
