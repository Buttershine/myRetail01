package com.buttershine.springmvc.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.stereotype.Repository;

import com.buttershine.springmvc.model.Product;

@Repository
public class ProductDao{
    @Autowired
    private MongoTemplate mongoTemplate;
    public static final String COLLECTION_NAME = "product";
    
    public void addProduct(Product product) {
        if (!mongoTemplate.collectionExists(Product.class)) {
            mongoTemplate.createCollection(Product.class);
        }       
        //setProductId
        mongoTemplate.insert(product, COLLECTION_NAME);
    }
    
    public List<Product> findAllProducts() {
    	if(mongoTemplate.collectionExists("product")){
    		mongoTemplate.getCollection("product");
    	}
        return mongoTemplate.findAll(Product.class, COLLECTION_NAME);
    }
    
    public Product getProductById(String id){	
    	BasicQuery productById = new BasicQuery("{productId:"+id+"}");
    	//use the mongotemplate to find a product with ID specified user. .get(0) gets the first result with this Id.
    	return mongoTemplate.find(productById, Product.class).get(0);
    }
    
    public void deleteProduct(Product product) {
        mongoTemplate.remove(product, COLLECTION_NAME);
    }
    
    public void updateProduct(Product product) {
        mongoTemplate.insert(product, COLLECTION_NAME);        
    }
}
