package com.buttershine.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buttershine.springmvc.dao.ProductDao;
import com.buttershine.springmvc.model.Product;

@Service("productService")
@Transactional
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	private static final AtomicLong counter = new AtomicLong();

	private static List<Product> products;
	
	public List<Product> findAllProducts() {
		products = productDao.findAllProducts();
		return products;
	}
	
	public Product findById(String id) {
		return productDao.getProductById(id);
	}
	
	public boolean doesProductExist(Product product) {
		return false;
	}
	
	public void saveProduct(Product product) {
		productDao.addProduct(product);
	}
	
//	private static List<Product> populateDummyProducts(){
//		List<Product> products = new ArrayList<Product>();
//		products.add(new Product(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com", null, null, null, null, null, null));
//		products.add(new Product(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com", null, null, null, null, null, null));
//		products.add(new Product(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com", null, null, null, null, null, null));
//		return products;
//	}
	
}
