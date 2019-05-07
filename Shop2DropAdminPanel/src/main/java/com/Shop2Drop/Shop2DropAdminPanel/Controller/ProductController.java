package com.Shop2Drop.Shop2DropAdminPanel.Controller;

import com.Shop2Drop.Shop2DropAdminPanel.entity.Product;
import com.Shop2Drop.Shop2DropAdminPanel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @RequestMapping("/add")
    public String addBook(Model model) {
        Product product = new Product();
        model.addAttribute( "product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("product") Product product, HttpServletRequest request){
        productService.save(product);

        MultipartFile productImage=product.getProductImage();
        try {
            byte[] bytes=productImage.getBytes();
            String name=product.getId()+".png";
            BufferedOutputStream stream=new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/image/product/"+name)));
            stream.write(bytes);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:productList";
    }

    @RequestMapping("/productList")
    public String productList(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "productList";
    }

    @RequestMapping("/productInfo")
    public String productInfo(@RequestParam("id") Long id,Model model){
        Product product=productService.findOne(id);
        model.addAttribute("product",product);
        return "ProductInfo";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestParam("id") Long id,Model model){
        Product product=productService.findOne(id);
        model.addAttribute("product",product);
        return "UpdateProduct";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProductPost(@ModelAttribute("product") Product product,HttpServletRequest request){
        productService.save(product);

        MultipartFile productImage=product.getProductImage();
        if(!productImage.isEmpty()){
            try {
                byte[] bytes=productImage.getBytes();
                String name=product.getId()+".png";

                Files.delete(Paths.get("src/main/resources/static/image/product"+name));
                BufferedOutputStream stream=new BufferedOutputStream(
                        new FileOutputStream(new File("src/main/resources/static/image/product/"+name)));
                stream.write(bytes);
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/product/productInfo?id="+product.getId();
    }
}


