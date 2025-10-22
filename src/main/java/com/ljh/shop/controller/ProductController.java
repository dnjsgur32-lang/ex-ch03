package com.ljh.shop.controller;

import com.ljh.shop.domain.Product;
import com.ljh.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

//    목록 화면 : GET / products
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", productService.findAll());
        return "product/list";
    }

//    등록 폼 : GET /products/new
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

//    등록 저장 : POST /products
    @PostMapping
    public String create(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/products";
    }

//    수정 폼 : GET /products/{id}/edit
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getOne(id));
        return "product/form";
    }

//    수정 저장 : POST /products/{id}
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productService.update(product);
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }



}
