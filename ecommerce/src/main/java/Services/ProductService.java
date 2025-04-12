package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import models.Product;
@Service
public class ProductService {
	
	//ecom project
	public Product GetProduct(int id){
		Product prfdb = new Product ("keyboards",1,234, "iodevices");
		
		return prfdb;
	}
	
	public List<Product> GetAllProductsoducts(){
		List<Product> allproducts = new ArrayList<Product>();
		
		Product p1 = new Product();
		p1.setName("keyboard");
		p1.setId(1);
		p1.setPrice(54);
		p1.setImage("IO devices");
		
		Product p2 = new Product();
		p2.setName("printer");
		p2.setId(2);
		p1.setPrice(54);
		p2.setImage("external");
		
		Product p3 = new Product();
		p3.setName("tables");
		p3.setId(3);
		p1.setPrice(54);
		p3.setImage("hardware");
		
		allproducts.add(p1);
		allproducts.add(p2);
		allproducts.add(p3);
		
		return allproducts;
	}
	
	public Product Createproduct(Product Product) {
		Product savedProduct = Product;
		
		return savedProduct;
	}

}
