package com.example.Spring_Boot_JDBC.entity;

import com.example.Spring_Boot_JDBC.dto.CustomerDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Customer {
    private Long phoneNumber;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private Integer planId;

    public static CustomerDTO CustomerdtoEntity(Customer customer){
        CustomerDTO a=new CustomerDTO();
        a.setPhoneNumber(customer.getPhoneNumber());
        a.setName(customer.getName());
        a.setAge(customer.getAge());
        a.setGender(customer.getGender());
        a.setAddress(customer.getAddress());
        a.setPlanId(customer.getPlanId());
        return  a;
    }
}
