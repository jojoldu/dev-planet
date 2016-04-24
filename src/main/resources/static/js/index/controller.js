/**
 * Created by jojoldu@gmail.com on 2016-04-24.
 */

angular.module("index", []).controller("Index", function($scope, $http) {
    $http.get("/info").success(function(data) {
        $scope.user = data.userAuthentication.details.name;
        $scope.authenticated = true;
    }).error(function() {
        $scope.user = "N/A";
        $scope.authenticated = false;
    });
});