var app = angular.module('crudApp',['ui.router','ngStorage', 'ui.bootstrap']);

app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    MEMBER_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/member/',
    BAPTISM_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/baptism/',
    HOUSEHOLD_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/household/',
    CONFIRMATION_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/confirmation/',
    FUNERAL_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/funeral/',
    MARRIAGE_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/marriage/',
    GUEST_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/guest/',
    CONTRIBUTION_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/contribution/',
    COMMUNION_SERVICE_API : 'http://localhost:8080/SpringBootCRUDApp/api/communion/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/home'
            })

            .state('memberLanding', {
                url: '/memberLanding',
                controller:'MemberController',
                controllerAs:'ctrl',
                templateUrl: 'partials/memberLanding',
                resolve: {
                    members: function ($q, MemberService) {
                        console.log('Load all members');
                        var deferred = $q.defer();
                        MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    households: function ($q, HouseholdService) {
                        console.log('Load all households');
                        var deferred = $q.defer();
                        HouseholdService.loadAllHouseholds().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })

            .state('memberCreate', {
            url: '/memberCreate',
            templateUrl: 'partials/memberCreate',
            controller:'MemberController',
            controllerAs:'ctrl',
            resolve: {
                members: function ($q, MemberService) {
                    console.log('Load all members');
                    var deferred = $q.defer();
                    MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                },
                households: function ($q, HouseholdService) {
                    console.log('Load all households');
                    var deferred = $q.defer();
                    HouseholdService.loadAllHouseholds().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })

            .state('memberEdit', {
                url: '/memberEdit',
                templateUrl: 'partials/memberEdit',
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
                households: function ($q, HouseholdService) {
                    console.log('Load all households');
                    var deferred = $q.defer();
                    HouseholdService.loadAllHouseholds().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })

            .state('confirmation', {
            url: '/confirmation',
            templateUrl: 'partials/confirmation',
            controller:'ConfirmationController',
            controllerAs:'ctrl',
            resolve: {
                confirmations: function ($q, ConfirmationService) {
                    console.log('Load all confirmations');
                    var deferred = $q.defer();
                    ConfirmationService.loadAllConfirmations().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })

            .state('funeral', {
            url: '/funeral',
            templateUrl: 'partials/funeral',
            controller:'FuneralController',
            controllerAs:'ctrl',
            resolve: {
                funerals: function ($q, FuneralService) {
                    console.log('Load all funerals');
                    var deferred = $q.defer();
                    FuneralService.loadAllFunerals().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })

            .state('marriage', {
            url: '/marriage',
            templateUrl: 'partials/marriage',
            controller:'MarriageController',
            controllerAs:'ctrl',
            resolve: {
                marriages: function ($q, MarriageService) {
                    console.log('Load all marriages');
                    var deferred = $q.defer();
                    MarriageService.loadAllMarriages().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })

            .state('guest', {
            url: '/guest',
            templateUrl: 'partials/guest',
            controller:'GuestController',
            controllerAs:'ctrl',
            resolve: {
                guests: function ($q, GuestService) {
                    console.log('Load all guests');
                    var deferred = $q.defer();
                    GuestService.loadAllGuests().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })

            .state('contribution', {
            url: '/contribution',
            templateUrl: 'partials/contribution',
            controller:'ContributionController',
            controllerAs:'ctrl',
            resolve: {
                members: function ($q, MemberService) {
                    console.log('Load all members');
                    var deferred = $q.defer();
                    MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                },
                contributions: function ($q, ContributionService) {
                    console.log('Load all contributions');
                    var deferred = $q.defer();
                    ContributionService.loadAllContributions().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })

            .state('serviceContributionReport', {
                url: '/serviceContributionReport',
                templateUrl: 'partials/serviceContributionReport',
                controller:'ReportController',
                controllerAs:'ctrl',
                resolve: {
                    members: function ($q, MemberService) {
                        console.log('Load all members');
                        var deferred = $q.defer();
                        MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    contributions: function ($q, ContributionService) {
                        console.log('Load all contributions');
                        var deferred = $q.defer();
                        ContributionService.loadAllContributions().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })

            .state('monthContributionReport', {
                url: '/monthContributionReport',
                templateUrl: 'partials/monthContributionReport',
                controller:'ReportController',
                controllerAs:'ctrl',
                resolve: {
                    members: function ($q, MemberService) {
                        console.log('Load all members');
                        var deferred = $q.defer();
                        MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    contributions: function ($q, ContributionService) {
                        console.log('Load all contributions');
                        var deferred = $q.defer();
                        ContributionService.loadAllContributions().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })

            .state('communion', {
            url: '/communion',
            templateUrl: 'partials/communion',
            controller:'CommunionController',
            controllerAs:'ctrl',
            resolve: {
                members: function ($q, MemberService) {
                    console.log('Load all members');
                    var deferred = $q.defer();
                    MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                },
                communions: function ($q, CommunionService) {
                    console.log('Load all contributions');
                    var deferred = $q.defer();
                    CommunionService.loadAllCommunions().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
            })


            .state('fullMemberReport', {
                url: '/fullMemberReport',
                templateUrl: 'partials/fullMemberReport',
                controller:'ReportController',
                controllerAs:'ctrl',
                resolve: {
                    members: function ($q, MemberService) {
                        console.log('Load all members');
                        var deferred = $q.defer();
                        MemberService.loadAllMembers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    contributions: function ($q, ContributionService) {
                        console.log('Load all contributions');
                        var deferred = $q.defer();
                        ContributionService.loadAllContributions().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    communions: function ($q, CommunionService) {
                        console.log('Load all contributions');
                        var deferred = $q.defer();
                        CommunionService.loadAllCommunions().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    guests: function ($q, GuestService) {
                        console.log('Load all guests');
                        var deferred = $q.defer();
                        GuestService.loadAllGuests().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    marriages: function ($q, MarriageService) {
                        console.log('Load all marriages');
                        var deferred = $q.defer();
                        MarriageService.loadAllMarriages().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    funerals: function ($q, FuneralService) {
                        console.log('Load all funerals');
                        var deferred = $q.defer();
                        FuneralService.loadAllFunerals().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    confirmations: function ($q, ConfirmationService) {
                        console.log('Load all confirmations');
                        var deferred = $q.defer();
                        ConfirmationService.loadAllConfirmations().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    households: function ($q, HouseholdService) {
                        console.log('Load all households');
                        var deferred = $q.defer();
                        HouseholdService.loadAllHouseholds().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    },
                    baptisms: function ($q, BaptismService) {
                        console.log('Load all baptisms');
                        var deferred = $q.defer();
                        BaptismService.loadAllBaptisms().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })

            .state('report', {
                url: '/report',
                templateUrl: 'partials/report'
            });
        $urlRouterProvider.otherwise('/');
    }]);

