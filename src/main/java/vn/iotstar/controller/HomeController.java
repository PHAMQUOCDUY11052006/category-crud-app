package vn.iotstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Khi truy cap http://localhost:8088/ se chuyen huong toi trang danh sach Category
    @GetMapping("/")
    public String home() {
        return "redirect:/admin/categories/searchpaginated";
    }
}
