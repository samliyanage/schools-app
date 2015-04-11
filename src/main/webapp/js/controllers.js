
angular.module('schoolApp.controllers',[]).controller('SchoolListController',function($scope,$state,popupService,$window,School){

    $scope.schools=School.query();

    $scope.deleteStudent=function(school){
        if(popupService.showPopup('Really want to delete this record?')){
        	student.$delete(function(){
                $window.location.href='/schoolApp';
            });
        }
    }

}).controller('SchoolViewController',function($scope,$stateParams,School){

    $scope.school=School.get({id:$stateParams.id});

}).controller('SchoolCreateController',function($scope,$state,$stateParams,School){

    $scope.school=new School();

    $scope.addSchool=function(){
        $scope.school.$save(function(){
            $state.go('schools');
        });
    }

}).controller('SchoolEditController',function($scope,$state,$stateParams,School){

    $scope.updateSchool=function(){
        $scope.school.$update(function(){
            $state.go('schools');
        });
    };

    $scope.loadStudent=function(){
        $scope.school=School.get({id:$stateParams.id});
    };

    $scope.loadSchool();
});