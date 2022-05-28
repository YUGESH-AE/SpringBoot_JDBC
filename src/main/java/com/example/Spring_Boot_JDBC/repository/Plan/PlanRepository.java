package com.example.Spring_Boot_JDBC.repository.Plan;

@SuppressWarnings("all")
public interface PlanRepository {
     void transactionalUpdate(Integer planId, Integer localRate, Integer nationalRate);
}
