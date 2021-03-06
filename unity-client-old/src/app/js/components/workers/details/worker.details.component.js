"use strict";

function WorkerDetailsController($scope, $location, $routeParams, Worker, Image) {

    $scope.worker = Worker.find({id: $routeParams.workerId});

    $scope.submit = function () {
        Worker.update({id: $routeParams.workerId.toString()}, this.worker).$promise.then(
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

    $scope.getImageUrl = function (id) {
        return serverUrl + 'images/' + id;
    };

    $scope.close = function () {
        $location.path('/workers')
    }
}

angular.module('workerDetails').component('workerDetails', {
    templateUrl: "app/js/components/workers/details/worker.details.component.html",
    controller: WorkerDetailsController
});
