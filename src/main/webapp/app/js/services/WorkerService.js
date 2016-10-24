"use strict";

unityApp.service('WorkerService', function () {
    this.saveWorker = function ($scope, $http, worker) {

        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        };

        $http.post(serverUrl + 'workers', worker, config)
            .success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
    };

    this.getWorkers = function ($scope, $http, callback) {
        $http.get(serverUrl + 'workers').then(function (response) {
            callback(response);
        });
    };
});