'use strict';

angular.module('crudApp').factory('GuestService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllGuests: loadAllGuests,
                getAllGuests: getAllGuests,
                getGuest: getGuest,
                createGuest: createGuest,
                updateGuest: updateGuest,
                removeGuest: removeGuest
            };

            return factory;

            function loadAllGuests() {
                console.log('Fetching all guests');
                var deferred = $q.defer();
                $http.get(urls.GUEST_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all guests');
                            $localStorage.guests = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading guests');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllGuests(){
                return $localStorage.guests;
            }

            function getGuest(id) {
                console.log('Fetching Guest with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.GUEST_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Guest with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading guest with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createGuest(guest) {
                console.log('Creating Guest');
                var deferred = $q.defer();
                $http.post(urls.GUEST_SERVICE_API, guest)
                    .then(
                        function (response) {
                            loadAllGuests();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Guest : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateGuest(guest, id) {
                console.log('Updating Guest with id '+id);
                var deferred = $q.defer();
                $http.put(urls.GUEST_SERVICE_API + id, guest)
                    .then(
                        function (response) {
                            loadAllGuests();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Guest with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeGuest(id) {
                console.log('Removing Guest with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.GUEST_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllGuests();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Guest with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);