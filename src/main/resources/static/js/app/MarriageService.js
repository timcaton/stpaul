'use strict';

angular.module('stPaul').factory('MarriageService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllMarriages: loadAllMarriages,
                getAllMarriages: getAllMarriages,
                getMarriage: getMarriage,
                createMarriage: createMarriage,
                updateMarriage: updateMarriage,
                removeMarriage: removeMarriage
            };

            return factory;

            function loadAllMarriages() {
                console.log('Fetching all marriages');
                var deferred = $q.defer();
                $http.get(urls.MARRIAGE_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all marriages');
                            $localStorage.marriages = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading marriages');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllMarriages(){
                return $localStorage.marriages;
            }

            function getMarriage(id) {
                console.log('Fetching Marriage with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.MARRIAGE_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Marriage with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading marriage with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createMarriage(marriage) {
                console.log('Creating Marriage');
                var deferred = $q.defer();
                $http.post(urls.MARRIAGE_SERVICE_API, marriage)
                    .then(
                        function (response) {
                            loadAllMarriages();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Marriage : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateMarriage(marriage, id) {
                console.log('Updating Marriage with id '+id);
                var deferred = $q.defer();
                $http.put(urls.MARRIAGE_SERVICE_API + id, marriage)
                    .then(
                        function (response) {
                            loadAllMarriages();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Marriage with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeMarriage(id) {
                console.log('Removing Marriage with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.MARRIAGE_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllMarriages();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Marriage with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);