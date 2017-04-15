'use strict';

angular.module('crudApp').factory('ContributionService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllContributions: loadAllContributions,
                getAllContributions: getAllContributions,
                getContribution: getContribution,
                createContribution: createContribution,
                updateContribution: updateContribution,
                removeContribution: removeContribution
            };

            return factory;

            function loadAllContributions() {
                console.log('Fetching all contributions');
                var deferred = $q.defer();
                $http.get(urls.CONTRIBUTION_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all contributions');
                            $localStorage.contributions = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading contributions');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllContributions(){
                return $localStorage.contributions;
            }

            function getContribution(id) {
                console.log('Fetching Contribution with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.CONTRIBUTION_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Contribution with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading contribution with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createContribution(contribution) {
                console.log('Creating Contribution');
                var deferred = $q.defer();
                $http.post(urls.CONTRIBUTION_SERVICE_API, contribution)
                    .then(
                        function (response) {
                            loadAllContributions();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while creating Contribution : '+errResponse.data.errorMessage);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateContribution(contribution, id) {
                console.log('Updating Contribution with id '+id);
                var deferred = $q.defer();
                $http.put(urls.CONTRIBUTION_SERVICE_API + id, contribution)
                    .then(
                        function (response) {
                            loadAllContributions();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Contribution with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeContribution(id) {
                console.log('Removing Contribution with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.CONTRIBUTION_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllContributions();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Contribution with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);