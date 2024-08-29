package client.contact.controller;

import client.contact.dto.ContactCreateDto;
import client.contact.dto.ContactDto;
import client.contact.enums.ContactType;
import client.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contacts")
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactDto> addContact(@RequestBody ContactCreateDto dto) {
        ContactDto createdContact = contactService.addContact(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    @GetMapping(value = "/{customerId}")
    public List<ContactDto> getContacts(@PathVariable UUID customerId) {
        return contactService.getContactsByCustomerId(customerId);
    }

    @GetMapping("/{customerId}/type/{type}")
    public List<ContactDto> getContactsByType(@PathVariable UUID customerId, @PathVariable ContactType type) {
        return contactService.getContactsByCustomerIdAndType(customerId, type);
    }
}