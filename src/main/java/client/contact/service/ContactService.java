package client.contact.service;

import client.contact.dto.ContactCreateDto;
import client.contact.dto.ContactDto;
import client.contact.enums.ContactType;
import client.contact.mapper.ContactMapper;
import client.contact.model.Contact;
import client.contact.model.Customer;
import client.contact.repository.ContactRepository;
import client.contact.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final CustomerRepository customerRepository;
    private final ContactMapper contactMapper;

    public ContactDto addContact(ContactCreateDto dto) {
        Optional<Customer> customer = customerRepository.findById(dto.getCustomerId());
        if (customer.isPresent()) {
            Contact contact = contactMapper.toEntity(dto);
            contact.setCustomer(customer.get());
            return contactMapper.toDto(contactRepository.save(contact));
        }
        return null;
    }

    public List<ContactDto> getContactsByCustomerId(UUID customerId) {
        return contactRepository.findByCustomerId(customerId).stream()
                .map(contactMapper::toDto)
                .toList();
    }

    public List<ContactDto> getContactsByCustomerIdAndType(UUID customerId, ContactType type) {
        return contactRepository.findByCustomerIdAndType(customerId, type).stream()
                .map(contactMapper::toDto)
                .toList();
    }
}