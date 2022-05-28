package com.example.Spring_Boot_JDBC.service;

import com.example.Spring_Boot_JDBC.dto.CustomerDTO;
import com.example.Spring_Boot_JDBC.entity.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public interface CustomerService {

     void insert(CustomerDTO customerDTO);

     int delete(Long phone);

     List<Customer> selectAllCustomers();

     int getNumberOfCustomers();

     int updateCustomer(Long phoneNo, String address);

     Customer get(Long phoneNo);


     int TransactionalUpdateCustomer(Customer customer, Integer localRate, Integer nationalRate);

     String inertPrepareCall(CustomerDTO customer) throws SQLException;

     Customer getCustomerStoredProcedure(Long phoneNo);
}
