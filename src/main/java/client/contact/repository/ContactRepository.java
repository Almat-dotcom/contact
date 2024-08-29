package client.contact.repository;

import client.contact.enums.ContactType;
import client.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
    List<Contact> findByCustomerId(UUID customerId);

    List<Contact> findByCustomerIdAndType(UUID customerId, ContactType type);
}