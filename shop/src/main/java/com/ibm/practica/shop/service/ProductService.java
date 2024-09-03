package com.ibm.practica.shop.service;

import com.ibm.practica.shop.model.dto.EditProductDTO;
import com.ibm.practica.shop.model.entity.Product;
import com.ibm.practica.shop.model.dto.AddProductDTO;
import com.ibm.practica.shop.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> get() {

            return productRepository.findAll();
    }

    public void add(AddProductDTO product) {

        Product toBeSaved = Product.builder()
                .description(product.getDescription())
                .name(product.getName())
                .build();
        log.info("The product is: {}", productRepository.save(toBeSaved));
    }

    public boolean deleteProduct(long id) throws NoSuchFieldException {
        log.info("Delete request for productID {}", id);
// not ok -> we do not know if the id exists or not.
//        productRepository.deleteById(id);

        // method 1
//        Product fromDB = productRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("ID " + id + "not found in DB. Nothing to delete."));

//        Optional<Product> fromDB = productRepository.findById(id);
//        Product fromDB1 = null;
//        if(fromDB.isEmpty())
//            throw new EntityNotFoundException("ID " + id + "not found in DB. Nothing to delete.");
//        else
//            fromDB1 = fromDB.get();
//        productRepository.delete(fromDB);

        // method 2
        Optional<Product> fromDB = productRepository.findById(id);

        if (fromDB.isEmpty()){
            log.warn("ID {} not found in DB. Nothing to delete.",id);
            return false;
        }
        productRepository.delete(fromDB.get());
        log.info("productID {} deleted", id);
        return true;
    }

    public Product editProduct(long id, EditProductDTO newProduct){
        log.info("edit request for productID {}", id);
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()){
            log.warn("ID {} not found in DB. Nothing to update.",id);
            throw new EntityNotFoundException("ID " + id + "not found in DB. Nothing to update.");
        }
        byId.get().setName(newProduct.getName());
        byId.get().setDescription(newProduct.getDescription());
        return productRepository.save(byId.get());
    }
}
