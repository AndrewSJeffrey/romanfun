/**
 * Created by andrewjeffrey on 09/09/15.
 */

angular.module('rentalCarsDirectives').directive('numeralConverter', function () {


    var controller = ['$scope', 'NumeralService', function ($scope, NumeralService) {
        $scope.intValue = 1;
        $scope.romanValue = "I";


        function handleNumeralResponse(data) {

            if (data.data) {
                $scope.romanValue = data.data.numeral;
            } else {
                $scope.romanValue = ""
            }
        }
        function handleIntResponse(data) {
            if (data.data) {
                $scope.intValue = data.data.value;
            } else {
                $scope.intValue = 1;
            }
        }

        $scope.getRomanNumeral = function() {
            NumeralService.getRomanNumeral($scope.intValue, handleNumeralResponse);
        };

        $scope.getIntValue = function() {
            NumeralService.getIntValue($scope.romanValue.toUpperCase(), handleIntResponse);
        }

    }];


    return {
        restrict: 'E',
        replace: 'true',
        scope: true,
        controller: controller,
        templateUrl: '/resources/templates/romanNumerals.html',
        link: function (scope, elem, attrs) {

        },
        compile: function (tElem, attrs) {
        }
    };
});