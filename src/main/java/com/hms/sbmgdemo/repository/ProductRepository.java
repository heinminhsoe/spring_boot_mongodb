package com.hms.sbmgdemo.repository;

import com.hms.sbmgdemo.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

}
