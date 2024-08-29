package client.contact.service;

import client.contact.dto.CustomerCreateDto;
import client.contact.dto.CustomerDto;
import client.contact.mapper.CustomerMapper;
import client.contact.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDto addCustomer(CustomerCreateDto dto) {
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(dto)));
    }

    public Page<CustomerDto> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable)
                .map(customerMapper::toDto);
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return customerMapper.toDto(customerRepository.findById(customerId).orElse(null));
    }
}