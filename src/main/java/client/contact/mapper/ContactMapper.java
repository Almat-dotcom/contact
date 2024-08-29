package client.contact.mapper;

import client.contact.dto.ContactCreateDto;
import client.contact.dto.ContactDto;
import client.contact.enums.ContactType;
import client.contact.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {CustomerMapper.class})
public interface ContactMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "type", source = "contactType", qualifiedByName = "stringToContactType")
    Contact toEntity(ContactCreateDto dto);

    ContactDto toDto(Contact entity);

    @Named("stringToContactType")
    default ContactType mapStringToContactType(String contactType) {
        return ContactType.valueOf(contactType.toUpperCase());
    }
}
