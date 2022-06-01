package com.mabdullaev.lesson3.controllers;

import com.mabdullaev.lesson3.model.dto.ProductDto;
import com.mabdullaev.lesson3.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/products")
public class MainController {

    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProducts(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/add")
    public String showAddProduct(){
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String name,@RequestParam int price){
        productService.addProduct(new ProductDto(null, name,price));
        return "redirect:";
    }

    @GetMapping("/inc")
    public String inc(@RequestParam Long id){
        productService.inc(id);
        return "redirect:";
    }

    @GetMapping("/dec")
    public String dec(@RequestParam Long id){
        productService.dec(id);
        return "redirect:";
    }

    @GetMapping(value = "/info/{id}")
    public String showProductPageById(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findById(id));
        return "info";
    }

    @PostMapping("/del/{id}")
    public String addProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/api/products";
    }

}
