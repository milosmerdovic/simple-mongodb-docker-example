package com.ecommerce.items.mapper;

import com.ecommerce.items.dto.ItemDto;
import com.ecommerce.items.resource.Item;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper extends EntityMapper<ItemDto, Item>{
    // TO DTO
    @Override
    @Named("toDto")
    ItemDto toDto(Item item);
    @Override
    @IterableMapping(qualifiedByName = {"toDto"})
    List<ItemDto> toDto(Page<Item> e);
    // TO ENTITY
    @Override
    Item toEntity(ItemDto itemDto);
    @Override
    List<Item> toListEntity(List<ItemDto> d);
}
