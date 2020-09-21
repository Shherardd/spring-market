package com.shd.market.persistence;

import com.shd.market.persistence.crud.ProductoCrudRepository;
import com.shd.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getByStock(int cantidadStock, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, estado);
    }
}
