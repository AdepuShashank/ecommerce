package controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Services.ProductService;
import models.Product;


@RestController
public class ProductController {
	//ecom project
	//added line 1
	//added line 2

	ProductService ProductService;
	
	@GetMapping("/product/{id}")
	public Product GetProduct(@PathVariable("id") int id)
	{
		Product prfdb = ProductService.GetProduct(id);
		
		return prfdb;
		 
		
	}  
	
	@GetMapping("/products")
	public List<Product> GetAllProducts(){
		List<Product> profdb;
		profdb = ProductService.GetAllProductsoducts();
		System.out.println("ystgdf");
		return profdb;
	}
	
	
//	@PostMapping("/products")
//	public Product CreateProduct(@RequestBody Product productFromUser) {
//		Product savedproduct;
//		savedproduct = ProductService.Createproduct(productFromUser);
//		
//		return savedproduct;
//	}
	
}
