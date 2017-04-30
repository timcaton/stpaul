'use strict';

angular.module('stPaul').factory('FuneralService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllFunerals: loadAllFunerals,
                getAllFunerals: getAllFunerals,
                getFuneral: getFuneral,
                createFuneral: createFuneral,
                updateFuneral: updateFuneral,
                removeFuneral: removeFuneral
            };

            return factory;

            function loadAllFunerals() {
                console.log('Fetching all funerals');
                var deferred = $q.defer();
                $http.get(urls.FUNERAL_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all funerals');
                            $localStorage.funerals = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading funerals');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllFunerals(){
                return $localStorage.funerals;
            }

            function getFuneral(id) {
                console.log('Fetching Funeral with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.FUNERAL_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Funeral with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading funeral with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createFuneral(funeral) {
                console.log('Creating Funeral');
                var deferred = $q.defer();
                $http.post(urls.FUNERAL_SERVICE_API, funeral)
                    .then(
                        function (response) {
                            loadAllFunerals();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Funeral : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateFuneral(funeral, id) {
                console.log('Updating Funeral with id '+id);
                var deferred = $q.defer();
                $http.put(urls.FUNERAL_SERVICE_API + id, funeral)
                    .then(
                        function (response) {
                            loadAllFunerals();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Funeral with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeFuneral(id) {
                console.log('Removing Funeral with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.FUNERAL_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllFunerals();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Funeral with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);