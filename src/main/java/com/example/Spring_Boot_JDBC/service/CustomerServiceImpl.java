package com.example.Spring_Boot_JDBC.service;

import com.example.Spring_Boot_JDBC.dto.CustomerDTO;
import com.example.Spring_Boot_JDBC.entity.Customer;
import com.example.Spring_Boot_JDBC.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepositoryImpl customerRepository;

    @Override
    public void insert(CustomerDTO customerDTO) {
        customerRepository.insert(CustomerDTO.CustomerEntity(customerDTO));
    }

    @Override
    public int delete(Long phone) {
        return customerRepository.delete(phone);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.getAll();
    }

    @Override
    public int getNumberOfCustomers() {
        return customerRepository.getCount();
    }

    @Override
    public int updateCustomer(Long phoneNo, String address) {
        return customerRepository.update(phoneNo, address);
    }

    @Override
    public Customer get(Long phoneNo) {
        return customerRepository.get(phoneNo);
    }
}
