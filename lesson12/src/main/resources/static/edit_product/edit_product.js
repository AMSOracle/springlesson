angular.module('market-front').controller('editProductController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8080/market/api';


    $scope.prepareForUpdate = function(){
        $http({
            url: contextPath + '/products/'+$routeParams.productId,
            method: 'GET'
        }).then(function (response) {
            $scope.upd_product = response.data;
        });
    }

    $scope.updateProduct = function () {
        $http({
            url: contextPath + '/products',
            method: 'PUT',
            data: $scope.upd_product
        }).then(function successCallback (response) {
            $location.path("/store")
        }, function failCallback (response) {
            alert(response.data.message);
        });

    }

    $scope.prepareForUpdate();
});