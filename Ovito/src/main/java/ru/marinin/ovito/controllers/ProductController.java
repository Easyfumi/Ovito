package ru.marinin.ovito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.marinin.ovito.models.Product;
import ru.marinin.ovito.repository.ProductRepository;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public String allProducts(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }
@GetMapping("/add")
    public String addProductForm() {
        return "add_product";
    }
    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam String description, @RequestParam String price, @RequestParam String city,  @RequestParam String author, Model model) {
        Product product = new Product(title, description, Integer.parseInt(price), city, author);
        productRepository.save(product);
        return "redirect:/products";
    }
}
