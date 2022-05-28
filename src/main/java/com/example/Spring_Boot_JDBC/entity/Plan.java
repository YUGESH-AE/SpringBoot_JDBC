package com.example.Spring_Boot_JDBC.entity;

import com.example.Spring_Boot_JDBC.dto.PlanDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuppressWarnings("all")
public class Plan {
    private Integer planId;
    private String planName;
    private Integer localRate;
    private Integer nationalRate;

    public static Plan planEntity(PlanDTO planDTO){
        Plan a=new Plan();
        a.setPlanId(planDTO.getPlanId());
        a.setPlanName(planDTO.getPlanName());
        a.setLocalRate(planDTO.getLocalRate());
        a.setNationalRate(planDTO.getNationalRate());
        return a;
    }
}
