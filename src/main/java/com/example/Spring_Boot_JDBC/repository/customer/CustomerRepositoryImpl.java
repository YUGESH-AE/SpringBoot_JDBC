package com.example.Spring_Boot_JDBC.repository.customer;

import com.example.Spring_Boot_JDBC.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    SimpleJdbcCall simpleJdbcCall;

    @Override
    public void insert(Customer customer) {
      String query = "INSERT INTO customer(phone_no,name,age,gender,address,plan_id) Values (:phoneNo,:name,:age,:gender,:address,:planID)";
       // String query = "INSERT INTO customer(phone_no,name,age,gender,address,plan_id) Values (?,?,?,?,?,?)";
       // jdbcTemplate.update(query,customer.getPhoneNumber(),customer.getName(),customer.getAge(),customer.getGender(),customer.getAddress(),customer.getPlanId());
        SqlParameterSource name=new MapSqlParameterSource("phoneNo",customer.getPhoneNumber())
                .addValue("name",customer.getName())
                .addValue("age",customer.getAge())
                .addValue("gender",customer.getGender())
                .addValue("address",customer.getAddress())
                .addValue("planID",customer.getPlanId());

        namedParameterJdbcTemplate.update(query,name);
    }

    @Override
    public int delete(Long phoneNO) {
        //return jdbcTemplate.update("delete from customer where phone_no = ? ", phoneNO);
        String sql="delete from customer where phone_no =:phoneNo";
        SqlParameterSource name=new MapSqlParameterSource("phoneNo",phoneNO);
        return namedParameterJdbcTemplate.update(sql,name);
    }

    @Override
    public int update(Long phoneNo, String address) {
        //String query = "update customer set address = ? " + " where phone_no = ?";
        //return jdbcTemplate.update(query,address,phoneNo);
        String sql="update customer set address =:address " + " where phone_no =:phoneNo";
        SqlParameterSource name=new MapSqlParameterSource("address",address)
                .addValue("phoneNo",phoneNo);
        return namedParameterJdbcTemplate.update(sql,name);
    }

    @Override
    public List<Customer> getAll() {
        String sql = "select phone_no, name ,age, gender, address, plan_id from customer";
        return jdbcTemplate.query(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer=new Customer();
                customer.setPhoneNumber(rs.getLong(1));
                customer.setName(rs.getString(2));
                customer.setAge(rs.getInt(3));
                customer.setGender(rs.getString(4));
                customer.setAddress(rs.getString(5));
                customer.setPlanId(rs.getInt(6));
                return customer;
            }
        });
    }

    @Override
    public int getCount() {
        String sql = "Select count(*) from customer";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public Customer get(Long phoneNo) {
        String sql = "select * from customer where phone_no = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{phoneNo}, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer=new Customer();
                customer.setPhoneNumber(rs.getLong(1));
                customer.setName(rs.getString(2));
                customer.setAge(rs.getInt(3));
                customer.setGender(rs.getString(4));
                customer.setAddress(rs.getString(5));
                customer.setPlanId(rs.getInt(6));
                return customer;
            }
        });
    }

    @Override
    public void transactionalUpdate(Long phoneNo, String address) {
        String sql="update customer set address=:address where phone_no=:phoneNo";
        SqlParameterSource name=new MapSqlParameterSource("address",address)
                .addValue("phoneNo",phoneNo);
        namedParameterJdbcTemplate.update(sql,name);

    }

    @Override
    public String inertPrepareCall(Customer customer) throws SQLException {
        Connection con=jdbcTemplate.getDataSource().getConnection();
        CallableStatement callStmt = con.prepareCall("{ call INSERTDATA(?,?,?,?,?,?,?,?)}");
        callStmt.setLong(1,customer.getPhoneNumber());
        callStmt.setString(2,customer.getName());
        callStmt.setInt(3,customer.getAge());
        callStmt.setString(4,customer.getGender());
        callStmt.setString(5,customer.getAddress());
        callStmt.setInt(6,customer.getPlanId());
        callStmt.setString(7,"success");
        callStmt.registerOutParameter(8, Types.INTEGER);
        callStmt.execute();
        String s=callStmt.getString(8);
        return "successfully updated"+s;
    }

    @Override
    public Customer getcustomerStoredProcedure(Long phoneNo) {
        simpleJdbcCall.withProcedureName("fetch_Customer");

        SqlParameterSource in=new MapSqlParameterSource()
                .addValue("in_phone",phoneNo);

        Map<String,Object>out=simpleJdbcCall.execute(in);
        Customer customer=new Customer();
        customer.setPhoneNumber(phoneNo);
        customer.setName((String) out.get("out_name"));
        customer.setAge((Integer) out.get("out_age"));
        customer.setGender((String) out.get("out_gender"));
        customer.setAddress((String) out.get("out_address"));
        customer.setPlanId((Integer) out.get("out_plan_id"));
        return customer;
    }
}
