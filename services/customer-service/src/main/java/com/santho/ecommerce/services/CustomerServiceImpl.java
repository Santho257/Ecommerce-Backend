package com.santho.ecommerce.services;

import com.ctc.wstx.util.StringUtil;
import com.santho.ecommerce.dtos.CustomerRequestDto;
import com.santho.ecommerce.dtos.CustomerResponseDto;
import com.santho.ecommerce.exceptions.CustomerNotFoundException;
import com.santho.ecommerce.mappers.CustomerMapper;
import com.santho.ecommerce.models.Customer;
import com.santho.ecommerce.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponseDto> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toCustomerResponse)
                .toList();
    }

    @Override
    public String add(CustomerRequestDto request) {
        return customerRepository.save(CustomerMapper.toCustomer(request)).getId();
    }

    @Override
    public void update(String id, CustomerRequestDto request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found With Id: " + id));
        merge(customer,request);
        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        if(!customerRepository.existsById(id)){
            throw new CustomerNotFoundException("Customer Not found with Id: " + id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponseDto findById(String id) {
        return CustomerMapper.toCustomerResponse(customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not found with id " + id)));
    }


    private void merge(Customer customer, CustomerRequestDto request){
        if(StringUtils.isNotBlank(request.getFirstName()))
            customer.setFirstName(request.getFirstName());
        if(StringUtils.isNotBlank(request.getLastName()))
            customer.setLastName(request.getLastName());
        if(StringUtils.isNotBlank(request.getEmail()))
            customer.setEmail(request.getEmail());
        if(request.getAddress() != null)
            customer.setAddress(request.getAddress());
    }
}
