/**
 * Created by jojoldu@zuminternet.com on 2016-04-26.
 */
angular.module("gnb", [])
    .controller("GnbController", function($scope, $http) {
    $http.get('/info').then(function(data){
        $scope.user = data.userName;
        $scope.authenticated = true;
    }, function(){
        $scope.user = "";
        $scope.authenticated = false;
    });
});