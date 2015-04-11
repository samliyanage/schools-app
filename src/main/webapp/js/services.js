angular.module('schoolWebApp.services', []).factory('School', function($resource) {
  return $resource('/schoolWebApp/api/v1/schools/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
});