package com.example.Spring_Boot_JDBC.dto;

import com.example.Spring_Boot_JDBC.entity.Customer;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CustomerDTO {
    private Long phoneNumber;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private Integer planId;

    public static Customer CustomerEntity(CustomerDTO customerDTO){
        Customer a=new Customer();
        a.setPhoneNumber(customerDTO.getPhoneNumber());
        a.setName(customerDTO.getName());
        a.setAge(customerDTO.getAge());
        a.setGender(customerDTO.getGender());
        a.setAddress(customerDTO.getAddress());
        a.setPlanId(customerDTO.getPlanId());
        return  a;
    }
}
