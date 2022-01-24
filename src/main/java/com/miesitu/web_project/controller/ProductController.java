package com.miesitu.web_project.controller;
import java.util.List;

import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Product;
import com.miesitu.web_project.entity.ProductImplmentation;
import com.miesitu.web_project.services.ConsumtionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private ProductRepository productRepository;
    @Autowired 
    private ProductImplmentation productService;

    @Autowired
    private ConsumtionService consServ;

    

    @RequestMapping("/admin/products")
    public String product(Model model){

        model.addAttribute("product", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/admin/product/new")
    public String addProduct(@ModelAttribute("productList") Product product){

        productService.addProduct(product);
        return "products";
    }
    
    @PostMapping("/admin/product/save")
    public String addNewProduct(@ModelAttribute("product") Product product){

        productService.addProduct(product);
        return "redirect:/admin/products";
}

    @GetMapping("/admin/product/new")
    public String showAddNewProduct(Model model)
    {

        Product product = new Product();
        model.addAttribute("product", product);
        return "new_products";

    }

    @GetMapping("admin/product/edit/{productId}")
    public String formUpdate(@PathVariable(value = "productId") long productId,Model model){
        Product product = productService.getProductByProductId(productId);

        model.addAttribute("product", product);
        return "new_products";
    }
    @GetMapping("admin/product/delete/{productId}")
    public String deleteProduct(@PathVariable(value = "productId") long productId,Model model){
        productService.delete(productId);
        return "redirect:/admin/products";
    }

    ///customer Product list

    
    @GetMapping("distr/product")
    public String distProductList(Model model){
        return productList(model);
    }

    @GetMapping("cust/product/{pageNo}")
    public String  custProductPagenated(@PathVariable(value="pageNo") int pageNo, Model model ) {
        return productList(model);  //correct the html
    }
    @GetMapping("distr/product/{pageNo}")
    public String  distProductPagenated(@PathVariable(value="pageNo") int pageNo, Model model ) {
        return productList( model);  //correct the html
    }

    @GetMapping("/productList")
    public String productList(Model model){

        List<Product> product = consServ.activeProducts();
        model.addAttribute("productlist", product);
        return "productlist";

    }

    @GetMapping("/productList/{pageNo}")
    public String  findProductPagenated(@PathVariable(value="pageNo") int pageNo, Model model ) {
        int pageSize = 1;
        Page<Product> page = productService.findProductPaginated(pageNo,pageSize);
        List<Product> productlist = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("productlist", productlist);
        return "productlist";  //correct the html
    }
    
}