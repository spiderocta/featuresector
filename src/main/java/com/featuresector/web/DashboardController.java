package com.featuresector.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.featuresector.domain.Product;
import com.featuresector.domain.User;
import com.featuresector.repositories.ProductRepository;

@Controller
public class DashboardController {
 
  @Autowired
  private ProductRepository productRepo;
  
  @GetMapping("/")
  public String rootView () {
    return "index";
  }
  
  @GetMapping("/dashboard")
  public String dashboard(@AuthenticationPrincipal User user, ModelMap model) {
    List<Product> products = productRepo.findByUser(user);
    
    model.put("products", products);
    
    return "dashboard";
  }
}
