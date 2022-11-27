package com.ecommerce.items.mapper;

import org.springframework.data.domain.Page;

import java.util.List;

public interface EntityMapper <D, E>{
    D toDto(E e);
    List<D> toDto(Page<E> e);
    E toEntity(D d);
    List<E> toListEntity (List<D> d);
}
