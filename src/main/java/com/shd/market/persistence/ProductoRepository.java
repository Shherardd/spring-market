package com.shd.market.persistence;

import com.shd.market.persistence.crud.ProductoCrudRepository;
import com.shd.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
