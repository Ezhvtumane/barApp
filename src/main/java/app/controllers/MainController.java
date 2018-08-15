package app.controllers;

import app.model.Beverage;
import app.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private BeverageService beverageService;

    @Autowired
    public MainController(BeverageService beverageService) {
        this.beverageService = beverageService;
    }

    @GetMapping("/beverage")
    public String beverageForm(Model model) {
        model.addAttribute("beverage", new Beverage());
        return "beverage";
    }

    @PostMapping("/beverage")
    public String beverageSubmit(@ModelAttribute Beverage beverage) {
        beverageService.save(beverage);
        return "result";
    }

}
