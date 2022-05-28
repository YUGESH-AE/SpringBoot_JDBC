package com.example.Spring_Boot_JDBC.repository.customer;

import com.example.Spring_Boot_JDBC.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
     void insert(Customer customer);

     int delete(Long phoneNO);

     int update(Long phoneNo, String address);

     List<Customer> getAll();

     int getCount();

     Customer get(Long phoneNo);

     void transactionalUpdate(Long phoneNo,String address);

     String inertPrepareCall(Customer customer) throws SQLException;

}
