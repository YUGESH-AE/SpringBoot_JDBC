package com.example.Spring_Boot_JDBC.repository.Plan;

public interface PlanRepository {
    public void transactionalUpdate(Integer planId, Integer localRate, Integer nationalRate);
}