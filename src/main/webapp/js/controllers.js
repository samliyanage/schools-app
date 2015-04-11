angular.module('schoolWebApp.controllers',[]).controller('SchoolListController',function($scope,$state,popupService,$window,School){

    $scope.schools=School.query();

    $scope.deleteSchool=function(school){
        if(popupService.showPopup('Really want to delete this school?')){
        	school.$delete(function(){
                $window.location.href='';
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

    $scope.loadSchool=function(){
        $scope.school=School.get({id:$stateParams.id});
    };

    $scope.loadSchool();
});