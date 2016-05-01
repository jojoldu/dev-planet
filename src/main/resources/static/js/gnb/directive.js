/**
 * Created by jojoldu@zuminternet.com on 2016-04-26.
 */
angular.module('gnb')
    .directive('gnb', function(){
        return {
            restrict: 'E',
            templateUrl: function(){
                return '/js/gnb/gnb.html';
            }
        }
    });