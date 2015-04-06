/**
 * Created by admin on 13-03-2015.
 */
var myapp=angular.module('myAppi',[]);
myapp.controller('ComplainController',['$scope','$http',function($scope,$http){
    $scope.Complain;
    $http({
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        url: 'http://localhost:8080/BLOGS/CategoryServl',
        data: $scope.Complain

    }).success(function(data){
        $scope.Complain=data;
        console.log( $scope.Complain);
    });

}]);
