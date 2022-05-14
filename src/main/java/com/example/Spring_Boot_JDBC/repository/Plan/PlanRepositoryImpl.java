package com.example.Spring_Boot_JDBC.repository.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PlanRepositoryImpl implements PlanRepository{

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void transactionalUpdate(Integer planId, Integer localRate, Integer nationalRate) {
        String sql="update plan set national_Rate=:nationalRate, local_rate=:localRate where plan_id=:planId";
        SqlParameterSource name= new MapSqlParameterSource()
                .addValue("planId",planId)
                .addValue("localRate",localRate)
                .addValue("nationalRate",nationalRate);

    }
}
