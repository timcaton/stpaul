var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    USER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/member/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/member',
                controller:'MemberController',
                controllerAs:'ctrl',
                resolve: {
                    members: function ($q, MemberService) {
                        console.log('Load all member');
                        var deferred = $q.defer();
                        MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

