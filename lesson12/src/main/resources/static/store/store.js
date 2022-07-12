angular.module('market-front').controller('storeController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8080/market/api';

    let currentPageIndex = 1;

    $scope.loadProducts = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + '/products',
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


    $scope.showInfo = function (product) {
        alert(product.name);
    }

    $scope.createNewProduct = function () {
        $http.post(contextPath + '/products', $scope.new_product)
            .then(function successCallback(response) {
                    $scope.loadProducts(currentPageIndex);
                    $scope.new_product = null;
                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );
    }

    $scope.prepareForUpdate = function(id){
        $http({
            url: contextPath + '/products/'+id,
            method: 'GET'
        }).then(function (response) {
            $scope.upd_product = response.data;
        });
    }
    $scope.addToCart = function(id){
        $http.put(contextPath + '/cart/inc?productId='+id)
                .then(function successCallback(response) {
                       alert("Product added  to cart");
                    }, function failCallback(response) {
                        alert(response.data.message);
                    }
                );
    }

    $scope.navToEditProductPage = function (productId){
        $location.path('/edit_product/'+ productId);
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



    $scope.loadProducts(1);


});