package com.mabdullaev.lesson3.controllers;

import com.mabdullaev.lesson3.model.Product;
import com.mabdullaev.lesson3.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/products")
public class MainController {

    private final ProductRepository repository;

    public MainController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String showProducts(Model model){
        model.addAttribute("products", repository.getProductList());
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam int id, @RequestParam String name,@RequestParam int price){
        repository.addProduct(new Product(id,name,price));
        return "redirect:";
    }

}
