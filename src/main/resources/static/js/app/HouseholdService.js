'use strict';

angular.module('stPaul').factory('HouseholdService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllHouseholds: loadAllHouseholds,
                getAllHouseholds: getAllHouseholds,
                getHousehold: getHousehold,
                createHousehold: createHousehold,
                updateHousehold: updateHousehold,
                removeHousehold: removeHousehold
            };

            return factory;

            function loadAllHouseholds() {
                console.log('Fetching all households');
                var deferred = $q.defer();
                $http.get(urls.HOUSEHOLD_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all households');
                            $localStorage.households = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading households');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllHouseholds(){
                return $localStorage.households;
            }

            function getHousehold(id) {
                console.log('Fetching Household with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.HOUSEHOLD_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Household with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading household with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createHousehold(household) {
                console.log('Creating Household');
                var deferred = $q.defer();
                $http.post(urls.HOUSEHOLD_SERVICE_API, household)
                    .then(
                        function (response) {
                            loadAllHouseholds();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Household : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateHousehold(household, id) {
                console.log('Updating Household with id '+id);
                var deferred = $q.defer();
                $http.put(urls.HOUSEHOLD_SERVICE_API + id, household)
                    .then(
                        function (response) {
                            loadAllHouseholds();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Household with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeHousehold(id) {
                console.log('Removing Household with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.HOUSEHOLD_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllHouseholds();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Household with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);