package com.shd.market.persistence;

import com.shd.market.domain.Product;
import com.shd.market.domain.repository.ProductRepository;
import com.shd.market.persistence.crud.ProductoCrudRepository;
import com.shd.market.persistence.entity.Producto;
import com.shd.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Or @Component <-- es una generalizacion de un componente de Spring, pero Repository es mas especifico
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
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
