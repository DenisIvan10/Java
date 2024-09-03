package com.ibm.practica.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.practica.shop.model.dto.AddBillDTO;
import com.ibm.practica.shop.model.dto.EditProductDTO;
import com.ibm.practica.shop.model.dto.ProductDTO;
import com.ibm.practica.shop.model.entity.Bill;
import com.ibm.practica.shop.model.entity.Product;
import com.ibm.practica.shop.model.dto.AddProductDTO;
import com.ibm.practica.shop.service.BillService;
import com.ibm.practica.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@Log4j2
public class ProductController {

    private final ProductService productService;
    private final BillService billService;

    private final ObjectMapper mapper;


    @GetMapping("/getall")
    public List<ProductDTO> get() {

//        List<Product> fromService =productService.get();
//        List<ProductDTO> responseList = new ArrayList<>();
//        for (Product p : fromService){
//            ProductDTO dto = mapper.convertValue(p,ProductDTO.class);
//            responseList.add(dto);
//        }
//        return responseList;

        return productService.get()
                .stream()
                .map(product -> mapper.convertValue(product,ProductDTO.class))
                .toList();
    }

    @PostMapping("/add")
    public void add(@RequestBody AddProductDTO newProduct) {
        log.info("adding newly received entity {}", newProduct);
        productService.add(newProduct);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "id") long id){

        try {
            return productService.deleteProduct(id) ? ResponseEntity.accepted().build() :
                    ResponseEntity.notFound().build();
        } catch (NoSuchFieldException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ProductDTO> edit(@RequestParam(name = "id") long id, @RequestBody EditProductDTO newProduct){
        log.info("edit request for productID {} with new details {}", id, newProduct);
        Product edited = productService.editProduct(id, newProduct);

        return ResponseEntity.accepted().body(mapper.convertValue(edited,ProductDTO.class));
    }

    @PostMapping("/addBill")
    public void addBill(@RequestBody AddBillDTO newBill){
        log.info("adding newly received entity {}", newBill);
        billService.addBill(newBill);
    }
}
