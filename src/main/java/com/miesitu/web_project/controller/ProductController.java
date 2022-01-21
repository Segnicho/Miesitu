package com.miesitu.web_project.controller;
import com.miesitu.web_project.Repository.ProductRepository;
// import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Product;
import com.miesitu.web_project.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired 
    ProductService productService;
    


    @RequestMapping("/product")
    public String product(Model model){

        model.addAttribute("product", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/addProduct")

    public String addProduct(@ModelAttribute("productList") Product product){

        productService.addProduct(product);
        return "products";
    }

        @GetMapping("/showAddNewProduct")
        
        public String showAddNewProduct(Model model)

        {

            Product product = new Product();
            model.addAttribute("product", product);
            return "new_products";
    
        }
        @PostMapping("/addNewProduct")
        public String addNewProduct(@ModelAttribute("product") Product product){

            productService.addProduct(product);
            return "products";
}
        @GetMapping("/formUpdate/{productId}")
        public String formUpdate(@PathVariable(value = "productId") long productId,Model model){
            Product product = productService.getProductByProductId(productId);

            model.addAttribute("product", product);
            return "updateProduct";
        }
    }


    



