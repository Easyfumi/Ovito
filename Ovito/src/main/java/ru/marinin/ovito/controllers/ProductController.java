package ru.marinin.ovito.controllers;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.marinin.ovito.models.Product;
import ru.marinin.ovito.services.ProductService;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/add")
    public String addProductForm() {
        return "add_product";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam String description, @RequestParam String price, @RequestParam String city,
                             @RequestParam String author, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                             @RequestParam("file3") MultipartFile file3, Model model) throws IOException {
        productService.saveProduct(title, description, price , city, author, file1, file2, file3);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("image", productService.getProductById(id).getImages().get(0));
        return "product_details";
    }

    @GetMapping("/products/{id}/edit")
    public String productEdit(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_edit";
    }

    @PostMapping("/products/{id}/edit")
    public String productPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, @RequestParam String price, @RequestParam String city, @RequestParam String author, Model model) {
        productService.productUpdate(id, title, description, price, city, author);
        return "redirect:/products";
    }

    @PostMapping("/products/{id}/remove")
    public String productPostDelete(@PathVariable(value = "id") long id, Model model) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
