package com.shd.market.persistence.crud;

import com.shd.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    // Query Nativo
    //@Query(value = "select * from productos where id_categoria = ?", nativeQuery = true)
    //List<Producto> getByCategoria(int idCategoria); <-- El nombre del metodo puede ser el que sea si definimos un query nativo
    //Query Method
     List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
     Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
