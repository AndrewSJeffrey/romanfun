
angular.module('rentalCarsServices').service('NumeralService',  ['DAOAbstract', function (DAOAbstract) {

    var dao = DAOAbstract.createDAO('/romanNumeralConverter');

    function getRomanNumeral(intValue, callback) {
        dao.query("/fromInt?value=" + intValue , function (result) {
            callback(result)
        });
    }

    function getIntValue(intValue, callback) {
        dao.query("/fromNumeral?value=" + intValue , function (result) {
            callback(result)
        });
    }


    return ({
        getRomanNumeral: getRomanNumeral,
        getIntValue : getIntValue
    })
}]);