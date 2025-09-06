package org.example.controller;

import org.example.model.DiscountResponse;
import org.example.model.Product;
import org.example.service.ProductDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductDiscountController {

    @Autowired
    private ProductDiscountService discountService;

    @PostMapping("/discount")
    public ResponseEntity<DiscountResponse> applyDiscount(@RequestBody Map<String, List<Product>> request) {
        List<Product> products = request.get("products");
        DiscountResponse response = discountService.applyDiscounts(products);
        return ResponseEntity.ok(response);
    }



//    @PostMapping("/discount")
//    public ResponseEntity<DiscountResponse> getHardcodedDiscount() {
//        List<Product> products = Arrays.asList(
//                new Product(1, "item1", "Clothing", 50000, 1),
//                new Product(2, "item2", "Clothing", 1000, 1),
//                new Product(2, "item3", "Clothing", 1000, 1)
//
//        );
//
//
//        DiscountResponse response = discountService.applyDiscounts(products);
//        return ResponseEntity.ok(response);
//    }
}