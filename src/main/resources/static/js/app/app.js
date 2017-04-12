var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    MEMBER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/member/',
    BAPTISM_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/baptism/',
    HOUSEHOLD_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/household/'
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
                        console.log('Load all members');
                        var deferred = $q.defer();
                        MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
            .state('baptism', {
            url: '/baptism',
            templateUrl: 'partials/baptism',
            controller:'BaptismController',
            controllerAs:'ctrl',
            resolve: {
                baptisms: function ($q, BaptismService) {
                    console.log('Load all baptisms');
                    var deferred = $q.defer();
                    BaptismService.loadAllBaptisms().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })
            .state('household', {
            url: '/household',
            templateUrl: 'partials/household',
            controller:'HouseholdController',
            controllerAs:'ctrl',
            resolve: {
                baptisms: function ($q, HouseholdService) {
                    console.log('Load all households');
                    var deferred = $q.defer();
                    HouseholdService.loadAllHouseholds().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
        });
        $urlRouterProvider.otherwise('/');
    }]);

