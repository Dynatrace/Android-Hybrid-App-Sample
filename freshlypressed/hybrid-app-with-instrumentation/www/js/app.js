var App = angular.module("App", ["ionic"]);

App.service("FreshlyPressed", ["$http", "$log", FreshlyPressed]);
App.controller("AppCtrl", ["$scope", "FreshlyPressed", "$log", AppCtrl]);

function AppCtrl($scope, FreshlyPressed, $log){
	$scope.posts = [];
	$scope.refresh = function(){
		FreshlyPressed.getBlogs($scope);
	}
}

function FreshlyPressed($http, $log){
	this.getBlogs = function($scope) {
	        //In stead of JSONP to public API, a regular GET request to our own backend.
	        $http.get("http://192.168.56.1:81/stories")
		.success(function(result){
			$scope.posts = result.posts;
		});
	}
}
