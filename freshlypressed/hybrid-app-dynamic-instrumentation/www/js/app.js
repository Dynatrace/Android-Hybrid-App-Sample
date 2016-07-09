var App = angular.module("App", ["ionic"]);

App.service("FreshlyPressed", ["$http", "$log", FreshlyPressed]);
App.controller("AppCtrl", ["$scope", "FreshlyPressed", "$log", AppCtrl]);

function AppCtrl($scope, FreshlyPressed, $log){
	$scope.posts = [];
	$scope.refresh = function(){
		FreshlyPressed.getBlogs($scope);
	}
	
	//imitating requireJS
	var scriptTag = angular.element(document.createElement("script"));
	scriptTag.attr("type", "text/javascript");
	scriptTag.attr("src", "js/dtagent635_gjpqtx_1025.js");
	angular.element(document.getElementsByTagName("head")).append(scriptTag);
	
	//Callback for requireJS once script element is created. Since attributes on script tag are important.
	var scriptTagLookup = angular.element(document.querySelector("script[src*='dt']"));
	scriptTagLookup.attr("data-dtconfig", "tp=500,50,0|reportUrl=http://192.168.56.1:81/dynaTraceMonitor");
}

function FreshlyPressed($http, $log){
	this.getBlogs = function($scope) {
		$http.get("http://192.168.56.1:81/stories")
		.success(function(result){
			$scope.posts = result.posts;
		});
	}
}
