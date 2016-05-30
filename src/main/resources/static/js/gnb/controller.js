/**
 * Created by jojoldu@zuminternet.com on 2016-04-26.
 */
angular.module("gnb", [])
    .controller("GnbController", function($scope, $http) {
    $http.get('/info').then(function(response){
        $scope.user = response.data.userName;
        $scope.authenticated = response.data.authentication;
    }, function(){
        $scope.user = "";
        $scope.authenticated = false;
    });
});