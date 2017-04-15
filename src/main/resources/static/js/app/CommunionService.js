'use strict';

angular.module('crudApp').factory('CommunionService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllCommunions: loadAllCommunions,
                getAllCommunions: getAllCommunions,
                getCommunion: getCommunion,
                createCommunion: createCommunion,
                updateCommunion: updateCommunion,
                removeCommunion: removeCommunion
            };

            return factory;

            function loadAllCommunions() {
                console.log('Fetching all communions');
                var deferred = $q.defer();
                $http.get(urls.COMMUNION_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all communions');
                            $localStorage.communions = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading communions');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllCommunions(){
                return $localStorage.communions;
            }

            function getCommunion(id) {
                console.log('Fetching Communion with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.COMMUNION_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Communion with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading communion with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createCommunion(communion) {
                console.log('Creating Communion');
                var deferred = $q.defer();
                $http.post(urls.COMMUNION_SERVICE_API, communion)
                    .then(
                        function (response) {
                            loadAllCommunions();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Communion : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateCommunion(communion, id) {
                console.log('Updating Communion with id '+id);
                var deferred = $q.defer();
                $http.put(urls.COMMUNION_SERVICE_API + id, communion)
                    .then(
                        function (response) {
                            loadAllCommunions();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Communion with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeCommunion(id) {
                console.log('Removing Communion with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.COMMUNION_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllCommunions();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Communion with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);