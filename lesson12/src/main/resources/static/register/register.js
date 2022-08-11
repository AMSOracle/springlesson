angular.module('market-front').controller('registerController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8080/market/api';

    $scope.newUser = function () {
        $http.post(contextPath + '/register', $scope.new_user)
            .then(function successCallback(response) {
                   alert(response.data.message);
                }, function failCallback(response) {
                    alert(response.data.message);
                }
            );

    }

});