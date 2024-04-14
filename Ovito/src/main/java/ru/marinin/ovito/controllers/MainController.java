package ru.marinin.ovito.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.marinin.ovito.services.ProductService;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainController(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }
}
