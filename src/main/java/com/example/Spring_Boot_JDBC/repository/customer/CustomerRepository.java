package com.example.Spring_Boot_JDBC.repository.customer;

import com.example.Spring_Boot_JDBC.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    public void insert(Customer customer);

    public int delete(Long phoneNO);

    public List<Customer> getAll();

    public int getCount();

    public int update(Long phoneNo, String address);

    public Customer get(Long phoneNo);

    public void transactionalUpdate(Long phoneNo,String address);

    public String inertPrepareCall(Customer customer) throws SQLException;

}
