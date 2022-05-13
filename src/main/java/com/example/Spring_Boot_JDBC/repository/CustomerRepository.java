package com.example.Spring_Boot_JDBC.repository;

import com.example.Spring_Boot_JDBC.entity.Customer;

import java.util.List;

public interface CustomerRepository {
    public void insert(Customer customer);

    public int delete(Long phoneNO);

    public List<Customer> getAll();

    public int getCount();

    public int update(Long phoneNo, String address);

    public Customer get(Long phoneNo);

}
