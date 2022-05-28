package com.example.Spring_Boot_JDBC.dto;

import com.example.Spring_Boot_JDBC.entity.Plan;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuppressWarnings("all")
public class PlanDTO {
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
