var myApp = angular.module('myApp', []);

myApp.controller('multiAddController', ['$scope', '$http', '$window', function($scope, $http, $window) {
		$scope.customers = [];


		// Initialise table - at least must be one
	    $scope.initAdds = function() {
	    	$scope.addEntry();
	    }

	    $scope.sendMultiAddPost = function() {
	    	// Send the request
	        var data = $scope.customers;

	    	$http.post('/customerform/customers/multiAdd?lang=' + $window.language, data).then(function successCallback(response) {
	    	    // This callback will be called asynchronously when the 
	    		// response is available
	    		$scope.customers = []; // empty new customers
		    	$window.location.href = '/customerform/customers?lang=' + $window.language;
	    	}, function errorCallback(response) {
	    	    // This callback will be called asynchronously an error occurs
	    	    // or server returns response with an error status
	    		$scope.customers = []; // empty new customers
		    	$window.location.href = '/customerform?lang=' + $window.language;
	    	});
	    };
	    
	    $scope.removeEntry = function(index) {
	    	$scope.customers.splice(index, 1);
	    }
	    
	    $scope.addEntry = function() {
	    	var customer = {
	    			id: null,
					firstName: "",
					lastName: ""};

	    	$scope.customers.push(customer);
	    }
	    
	    $scope.isButtonDisable = function() {
	    	for (var i = 0; i < $scope.customers.length; i++) {
	    		var customer = $scope.customers[i];

	    		if (customer.firstName.length > 0 && customer.lastName.length > 0) {
	    			return false;
	    		}
	    	}
	    	
	    	return true;
	    }

}]);

setLanguage = function(language, search, tbId) {
	window.language = language;
	
	if (search) {
		// Input text box will be appended at the end automatically
		$(document).ready(function() {
		  $('#'+tbId).DataTable({
			destroy: true,
			bPaginate: false,
			info: false,
		    oLanguage: {
		      sSearch: search
		    }
		  });
		});
	}
}
