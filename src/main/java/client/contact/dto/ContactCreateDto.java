package client.contact.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContactCreateDto {
    private UUID customerId;
    private String contactType;
    private String value;
}
