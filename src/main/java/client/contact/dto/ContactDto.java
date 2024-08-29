package client.contact.dto;

import client.contact.enums.ContactType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContactDto {
    private UUID id;
    private ContactType type;
    private String value;
    private CustomerDto customer;
}
