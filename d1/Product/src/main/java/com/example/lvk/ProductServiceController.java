package com.example.lvk;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@RequestMapping("/lvk")
public class ProductServiceController {

	private static Map<String, Product> productDatabase = new HashMap();
	static {

		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productDatabase.put(honey.getId(), honey);
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productDatabase.put(almond.getId(), almond);
		}

	public Object delete(String id) {
		productDatabase.remove(id);
		return "Product is deleted successsfully";
		}
		public Object updateProduct(String id, Product product) {
		productDatabase.remove(id);
		product.setId(id);
		productDatabase.put(id, product);
		return "Product is updated successsfully";
		}
		public Object createProduct(Product product) {
		productDatabase.put(product.getId(), product);
		return "Product is created successfully";
		}
		
		public Object getProduct(String id) {
		return productDatabase.get(id);
		}
		
		@RequestMapping(value = "/products")
		public ResponseEntity<Product> getProduct() {
			
			ResponseEntity<Product> returnValue = new ResponseEntity(productDatabase.values(),HttpStatus.OK);	
		return returnValue;
		}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceController.class, args);
	}

}
