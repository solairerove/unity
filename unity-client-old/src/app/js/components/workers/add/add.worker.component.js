"use strict";

function AddWorkerController($scope, $location, Worker, Image) {
    $scope.worker = {
        birthday:new Date()
    };

    $scope.submit = function () {
        console.log("Saving: " + this.worker);
        Worker.save(this.worker).$promise.then(
            function () {
                $location.path('/workers');
            }
        );
    };

    $scope.fileUploaded = function ($file, $message) {
        $scope.worker.imageId = $message;
    };

    $scope.resetImage = function ($flow) {
        console.log($scope.worker.imageId);
        Image.delete({id: $scope.worker.imageId}, function () {
            console.log("Reset image with id: ".concat(id));
        });

        $flow.cancel();
    };

    $scope.close = function () {
        $location.path('/workers')
    }
}

angular.module('addWorker').component('addWorker', {
    templateUrl: "app/js/components/workers/add/add.worker.component.html",
    controller: AddWorkerController
});
