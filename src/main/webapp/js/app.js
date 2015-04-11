
angular.module('schoolApp',['ui.router','ngResource','schoolApp.controllers','schoolApp.services']);

angular.module('schoolApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('schools',{
        url:'/schools',
        templateUrl:'schoolWebApp/partials/schools.html',
        controller:'SchoolListController'
    }).state('viewSchool',{
       url:'/schools/:id/view',
       templateUrl:'schoolWebApp/partials/school-view.html',
       controller:'SchoolViewController'
    }).state('newSchool',{
        url:'/schools/new',
        templateUrl:'schoolWebApp/partials/school-add.html',
        controller:'SchoolCreateController'
    }).state('editSchool',{
        url:'/schools/:id/edit',
        templateUrl:'schoolWebApp/partials/school-edit.html',
        controller:'SchoolEditController'
    });
}).run(function($state){
   $state.go('schools');
});