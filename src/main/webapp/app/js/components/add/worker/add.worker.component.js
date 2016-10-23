"use strict";

function AddWorkerController($scope, $http, $location, WorkerService, ImageService) {
    $scope.worker = $scope.worker || {};

    $scope.submit = function (worker) {
        console.log(worker);
        WorkerService.saveWorker($scope, $http, worker, function (result) {
            console.log(result);
        });

        $location.path('/workers');
    };

    $scope.fileUploaded = function ($file, $message, $flow) {
        $scope.worker.imageId = $message;
    };

    $scope.resetImage = function ($flow) {
        console.log($scope.worker.imageId);
        ImageService.deleteImage($scope, $http, $scope.worker.imageId, function (result) {
            console.log("Reset image with id: ".concat(id));
        });

        $flow.cancel();
    };

    $scope.close = function () {
        $location.path('/workers')
    }
}

angular.module('addWorker').component('addWorker', {
    templateUrl: "app/js/components/add/worker/add.worker.component.html",
    controller: AddWorkerController
});

