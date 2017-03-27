package com.buttershine.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.buttershine.springmvc.model.Product;
import com.buttershine.springmvc.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllproducts() {
        List<Product> products = productService.findAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    
	/**
	 * example: http://localhost:8080/myRetail/product/71547836
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
		Product product = productService.findById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param product
	 * example: 
	 *   {
			"_id": "68c9c71a88eafb0b52b7e742",
		    "index": 2,
		    "productId": 15117729,
		    "name": "Test",
		    "price": "$184.21",
		    "picture": "http://placehold.it/32x32",
		    "insertUser": "Parrish",
		    "desc": "Proident anim aute amet fugiat est Lorem qui irure. Deserunt aliquip laborum eu officia deserunt anim cillum proident. Laborum deserunt reprehenderit excepteur pariatur quis labore commodo ut exercitation cillum laboris ex officia aliquip. Enim enim tempor sunt aliqua consequat mollit id ipsum cillum. Ea aliqua id et et elit exercitation occaecat exercitation. Fugiat commodo nulla aliqua nostrud sit proident in qui duis id dolore voluptate adipisicing proident.\r\n",
		    "insertDate": "2016-03-11T04:14:32 +06:00",
		    "updateDate": "2016-09-03T02:43:45 +05:00"
		 }
	 * @return HTTP Created
	 */
    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        if (productService.doesProductExist(product)) {
           return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        productService.saveProduct(product);
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
        if (productService.doesProductExist(product)) {
           return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        productService.saveProduct(product);
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
}
