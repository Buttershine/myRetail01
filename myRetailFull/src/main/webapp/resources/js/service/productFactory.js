'use strict';

App.factory('myApp.services').factory("productFactory", ['$http', '$q', function productFactory($http, $q) {

//API
let productUrl = 'http://redsky.target.com/v1/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics';
let saveProductUrl = 'http://localhost:8080/myRetail/products/';
//Factory Instantiation
let productFactory = {};
//Variables
let promises = [];

let dataPromise;
	
	productFactory.nameLookup = function() {
		let products = {};		
		let dataPromise = 
			$http.get(productUrl).then(function(response){
			    products = response.data;
				return products;
			});
		return dataPromise;	
	};
	
	productFactory.saveProduct = function(productId) {
		let products = {};		
		let dataPromise = 
			$http.put(saveProductUrl + productId).then(function(response){
			    products = response.data;
				return products;
			});
		return dataPromise;	
	};
	
	return productFactory;
}]);	

