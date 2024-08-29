package client.contact.mapper;

import client.contact.dto.CustomerCreateDto;
import client.contact.dto.CustomerDto;
import client.contact.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerCreateDto dto);

    CustomerDto toDto(Customer entity);
}
