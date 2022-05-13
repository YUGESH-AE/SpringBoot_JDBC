package com.example.Spring_Boot_JDBC.repository;

import com.example.Spring_Boot_JDBC.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Customer customer) {
        String query = "INSERT INTO customer(phone_no,name,age,gender,address,plan_id) Values (?,?,?,?,?,?)";
        jdbcTemplate.update(query,customer.getPhoneNumber(),customer.getName(),customer.getAge(),customer.getGender(),customer.getAddress(),customer.getPlanId());
    }

    @Override
    public int delete(Long phoneNO) {
        return jdbcTemplate.update("delete from customer where phone_no = ? ", phoneNO);
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
    public int update(Long phoneNo, String address) {
        String query = "update customer set address = ? " + " where phone_no = ?";
        return jdbcTemplate.update(query,address,phoneNo);
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
}
