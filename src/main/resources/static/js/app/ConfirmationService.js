'use strict';

angular.module('crudApp').factory('ConfirmationService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllConfirmations: loadAllConfirmations,
                getAllConfirmations: getAllConfirmations,
                getConfirmation: getConfirmation,
                createConfirmation: createConfirmation,
                updateConfirmation: updateConfirmation,
                removeConfirmation: removeConfirmation
            };

            return factory;

            function loadAllConfirmations() {
                console.log('Fetching all confirmations');
                var deferred = $q.defer();
                $http.get(urls.CONFIRMATION_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all confirmations');
                            $localStorage.confirmations = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading confirmations');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllConfirmations(){
                return $localStorage.confirmations;
            }

            function getConfirmation(id) {
                console.log('Fetching Confirmation with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.CONFIRMATION_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Confirmation with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading confirmation with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createConfirmation(confirmation) {
                console.log('Creating Confirmation');
                var deferred = $q.defer();
                $http.post(urls.CONFIRMATION_SERVICE_API, confirmation)
                    .then(
                        function (response) {
                            loadAllConfirmations();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Confirmation : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateConfirmation(confirmation, id) {
                console.log('Updating Confirmation with id '+id);
                var deferred = $q.defer();
                $http.put(urls.CONFIRMATION_SERVICE_API + id, confirmation)
                    .then(
                        function (response) {
                            loadAllConfirmations();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Confirmation with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeConfirmation(id) {
                console.log('Removing Confirmation with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.CONFIRMATION_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllConfirmations();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Confirmation with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);