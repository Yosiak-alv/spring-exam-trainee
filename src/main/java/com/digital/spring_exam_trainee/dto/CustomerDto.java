package com.digital.spring_exam_trainee.dto;

import com.digital.spring_exam_trainee.models.Customer;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CustomerDto {
    private Long id;

    private String name;

    private String email;

    private String address;

    public CustomerDto(Customer customer){
       this.id = customer.getId();
       this.name = customer.getName();
       this.email = customer.getEmail();
       this.address = customer.getAddress();
    }

    public Customer toEntity(){
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setName(this.name);
        customer.setEmail(this.email);
        customer.setAddress(this.address);
        return customer;
    }
}
