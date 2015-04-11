
angular.module('schoolApp.services',[]).factory('School',function($resource){
    return $resource('/schoolApp/api/v1/schools/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});