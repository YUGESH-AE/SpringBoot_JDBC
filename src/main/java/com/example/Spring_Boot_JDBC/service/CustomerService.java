package com.example.Spring_Boot_JDBC.service;

import com.example.Spring_Boot_JDBC.dto.CustomerDTO;
import com.example.Spring_Boot_JDBC.entity.Customer;

import java.util.List;


public interface CustomerService {

    public void insert(CustomerDTO customerDTO);

    public int delete(Long phone);

    public List<Customer> selectAllCustomers();

    public int getNumberOfCustomers();

    public int updateCustomer(Long phoneNo, String address);

    public Customer get(Long phoneNo);
}
