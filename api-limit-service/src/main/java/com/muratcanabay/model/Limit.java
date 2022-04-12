package com.muratcanabay.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Limit {

    private int min;
    private int max;
}
