package com.ssafy.study_with_us.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TomatoSumDto {
    private Integer totalSum;
    private Integer relevantSum;

    public TomatoSumDto() {
    }
    @Builder
    public TomatoSumDto(Integer totalSum, Integer relevantSum) {
        this.totalSum = totalSum;
        this.relevantSum = relevantSum;
    }

    @Override
    public String toString() {
        return "TomatoSumDto{" +
                "totalSum=" + totalSum +
                ", relevantSum=" + relevantSum +
                '}';
    }
}
