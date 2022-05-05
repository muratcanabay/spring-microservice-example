package com.muratcanabay.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExampleController {

    private final Logger logger = LoggerFactory.getLogger(ExampleController.class);

    /**
     * When annotated method fails, {@link Retry} runs it {@code maxAttempts (default = 3)} times
     * and then {@code fallbackMethod} executed. Waits {@code waitDuration (default = 500 [ms])} between every attempt.
     * <br>
     * See: {@link = https://resilience4j.readme.io/docs/retry}
     *
     * @return A message
     */
    @GetMapping("/sample-api")
    @Retry(name = "get-message", fallbackMethod = "defaultResponse")
    public String getMessage() {
        logger.info("getMessage() method called.");
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://fake-website.com", String.class);
        return response.getBody();
    }

    /**
     * {@link io.github.resilience4j.ratelimiter.annotation.RateLimiter} allows request per {@code limitForPeriod (default = 50)}
     * as many as the {@code limitRefreshPeriod (default = 500 [ns])} parameter.
     * <br>
     * See: {@link = https://resilience4j.readme.io/docs/ratelimiter}
     *
     * @return A message
     */
    @GetMapping("/sample-api-v2")
    @RateLimiter(name = "get-message", fallbackMethod = "defaultRateLimiterResponse")
    public String getMessage2() {
        logger.info("getMessage2() method called.");
        return "Hi!";
    }

    public String defaultResponse(Exception e) {
        return "Something went wrong :(";
    }

    public String defaultRateLimiterResponse(Exception e) {
        return "Please wait! Page is loading...";
    }
}
