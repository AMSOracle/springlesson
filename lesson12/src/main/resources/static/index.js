(function () {
    angular
        .module('market-front', ['ngRoute','ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/store', {
                templateUrl: 'store/store.html',
                controller: 'storeController'
            })
            .when('/edit_product/:productId', {
                templateUrl: 'edit_product/edit_product.html',
                controller: 'editProductController'
            })
            .when('/create_product', {
                templateUrl: 'create_product/create_product.html',
                controller: 'createProductController'
            })
            .when('/cart', {
                templateUrl: 'cart/cart.html',
                controller: 'cartController'
            })
            .when('/register', {
                templateUrl: 'register/register.html',
                controller: 'registerController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
        if ($localStorage.webMarketUser){
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.webMarketUser.token;
        }
    }
})();

angular.module('market-front').controller('indexController', function ($rootScope, $scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8080/market/api';

    $scope.tryToAuth =  function(){
        $http.post(contextPath + '/auth', $scope.user)
            .then(function successCallback(response){
                if (response.data.token){
                    $http.defaults.headers.common.Authorization ='Bearer ' +response.data.token;
                    $localStorage.webMarketUser = {username:$scope.user.username,token: response.data.token};

                    $scope.user.usernmae = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(response){

            });
    };

    $scope.tryToLogout = function(){
        $scope.clearUser();
        if ($scope.user.username) {
            $scope.user.username = null;
        }
        if ($scope.user.password) {
            $scope.user.password = null;
        }
    }

    $scope.clearUser = function () {
        delete $localStorage.webMarketUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $rootScope.isUserLoggedIn = function () {
        if ($localStorage.webMarketUser) {
            return true;
        } else {
            return false;
        }
    };

});