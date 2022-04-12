package com.muratcanabay.controller;

import com.muratcanabay.configuration.ApiLimitConfig;
import com.muratcanabay.model.Limit;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiLimitController {

    private final ApiLimitConfig limitConfig;

    @GetMapping("/limits")
    public Limit getLimits() {
        return Limit.builder()
                .min(limitConfig.getMin())
                .max(limitConfig.getMax())
                .build();
    }
}
