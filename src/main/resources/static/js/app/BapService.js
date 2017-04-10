'use strict';

angular.module('crudApp').factory('BaptismService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllBaptisms: loadAllBaptisms,
                getAllBaptisms: getAllBaptisms,
                getBaptism: getBaptism,
                createBaptism: createBaptism,
                updateBaptism: updateBaptism,
                removeBaptism: removeBaptism
            };

            return factory;

            function loadAllBaptisms() {
                console.log('Fetching all baptisms');
                var deferred = $q.defer();
                $http.get(urls.BAPTISM_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all baptisms');
                            $localStorage.baptisms = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading baptisms');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllBaptisms(){
                return $localStorage.baptisms;
            }

            function getBaptism(id) {
                console.log('Fetching Baptism with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.BAPTISM_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Baptism with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading baptism with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createBaptism(baptism) {
                console.log('Creating Baptism');
                var deferred = $q.defer();
                $http.post(urls.BAPTISM_SERVICE_API, baptism)
                    .then(
                        function (response) {
                            loadAllBaptisms();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Baptism : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateBaptism(baptism, id) {
                console.log('Updating Baptism with id '+id);
                var deferred = $q.defer();
                $http.put(urls.BAPTISM_SERVICE_API + id, baptism)
                    .then(
                        function (response) {
                            loadAllBaptisms();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Baptism with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeBaptism(id) {
                console.log('Removing Baptism with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.BAPTISM_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllBaptisms();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Baptism with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);