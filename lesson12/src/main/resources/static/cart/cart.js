angular.module('market-front').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/market/api';

    let currentPageIndex = 1;

    $scope.loadProducts = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + '/cart',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
        });
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.nextPage = function () {
        currentPageIndex++;
        if (currentPageIndex > $scope.productsPage.totalPages) {
            currentPageIndex = $scope.productsPage.totalPages;
        }
        $scope.loadProducts(currentPageIndex);
    }

    $scope.prevPage = function () {
        currentPageIndex--;
        if (currentPageIndex < 1) {
            currentPageIndex = 1;
        }
        $scope.loadProducts(currentPageIndex);
    }

    $scope.deleteProduct = function(id){
        $http({
            url: contextPath + '/cart/'+id,
            method: 'DELETE'
        }).then(function successCallback (response) {
            console.log(response);
            $scope.loadProducts(currentPageIndex);
        }, function failCallback (response) {
            alert(response.data.message);
        });
    }

    $scope.inc = function(id){
        $http({
            url: contextPath + '/cart/inc?id='+id,
            method: 'PUT'
        }).then(function successCallback (response) {
            $scope.loadProducts(currentPageIndex);
        }, function failCallback (response) {
            alert(response.data.message);
        });
    }
    $scope.dec = function(id){
        $http({
            url: contextPath + '/cart/dec?id='+id,
            method: 'PUT'
        }).then(function successCallback (response) {
            $scope.loadProducts(currentPageIndex);
        }, function failCallback (response) {
            alert(response.data.message);
        });
    }

    $scope.loadProducts(1);


});