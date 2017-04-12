var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    MEMBER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/member/',
    BAPTISM_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/baptism/',
    HOUSEHOLD_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/household/',
    CONFIRMATION_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/confirmation/',
    FUNERAL_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/funeral/',
    MARRIAGE_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/marriage/'
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
        }).state('confirmation', {
            url: '/confirmation',
            templateUrl: 'partials/confirmation',
            controller:'ConfirmationController',
            controllerAs:'ctrl',
            resolve: {
                baptisms: function ($q, ConfirmationService) {
                    console.log('Load all confirmations');
                    var deferred = $q.defer();
                    ConfirmationService.loadAllConfirmations().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
        }).state('funeral', {
            url: '/funeral',
            templateUrl: 'partials/funeral',
            controller:'FuneralController',
            controllerAs:'ctrl',
            resolve: {
                baptisms: function ($q, FuneralService) {
                    console.log('Load all funerals');
                    var deferred = $q.defer();
                    FuneralService.loadAllFunerals().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
        }).state('marriage', {
            url: '/marriage',
            templateUrl: 'partials/marriage',
            controller:'MarriageController',
            controllerAs:'ctrl',
            resolve: {
                baptisms: function ($q, MarriageService) {
                    console.log('Load all marriages');
                    var deferred = $q.defer();
                    MarriageService.loadAllMarriages().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
        });
        $urlRouterProvider.otherwise('/');
    }]);

