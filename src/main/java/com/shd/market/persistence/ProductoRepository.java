package com.shd.market.persistence;

import com.shd.market.persistence.crud.ProductoCrudRepository;
import com.shd.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Or @Component <-- es una generalizacion de un componente de Spring, pero Repository es mas especifico
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidadStock, boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, estado);
    }

    public Optional<Producto> getProducto (int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void deleteProducto(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
