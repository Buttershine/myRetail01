'use strict';

App.controller('ItemListController', ['async', '$scope', 'productFactory', function(async, $scope, productFactory) {
      var self = this;
      self.items=async;
      
  	//Create Requests
  	$scope.nameLookup = function() {
  		productFactory.nameLookup().then(function(response){
  			$scope.data = response;
  		});
  					
  	};
  	
  	$scope.submit = function() {
  		if($scope.product.productId){
  	  		productFactory.saveProduct($scope.product.productId).then(function(response){
  	  			$scope.data = response;
  	  		});
  		}
  	};
  	
}]);
