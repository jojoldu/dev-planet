/**
 * Created by jojoldu@gmail.com on 2016-04-24.
 */
angular.module('index')
    .directive('gnb', function(){
        return {
            restrict: 'E',
            templateUrl: function(){
                return '/js/index/gnb.html';
            }
        }
    });