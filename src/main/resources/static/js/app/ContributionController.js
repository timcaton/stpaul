'use strict';

angular.module('crudApp').controller('ContributionController',
    ['ContributionService', 'MemberService', 'GuestService', '$scope',  function( ContributionService, MemberService, GuestService, $scope) {

        var self = this;
        self.contribution = {};
        self.contributions = [];
        self.members = [];
        self.guests = [];

        self.submit = submit;
        self.getAllContributions = getAllContributions;
        self.createContribution = createContribution;
        self.updateContribution = updateContribution;
        self.removeContribution = removeContribution;
        self.editContribution = editContribution;
        self.reset = reset;
        self.doTheBack = doTheBack;
        self.chooseMember = chooseMember;
        self.getAllMembers = getAllMembers;
        self.chooseGuest = chooseGuest;
        self.getAllGuests = getAllGuests;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function doTheBack() {
            window.history.back();
        }

        function getAllMembers(){
            return MemberService.getAllMembers();
        }

        function getAllGuests() {
            return GuestService.getAllGuests();
        }

        function chooseMember(id) {
            self.contribution.memberId = id;
        }

        function chooseGuest(id) {
            self.contribution.guestId = id;
        }

        function submit() {
            console.log('Submitting');
            if (self.contribution.id === undefined || self.contribution.id === null) {
                console.log('Saving New Contribution', self.contribution);
                createContribution(self.contribution);
            } else {
                updateContribution(self.contribution, self.contribution.id);
                console.log('Contribution updated with id ', self.contribution.id);
            }
        }

        function createContribution(contribution) {
            console.log('About to create contribution');
            ContributionService.createContribution(contribution)
                .then(
                    function (response) {
                        console.log('Contribution created successfully');
                        self.successMessage = 'Contribution created successfully';
                        self.errorMessage = '';
                        self.done = true;
                        self.contribution = {};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Contribution');
                        self.errorMessage = 'Error while creating Contribution: ' + errResponse.data.errorMessage;
                        self.successMessage = '';
                    }
                );
        }


        function updateContribution(contribution, id) {
            console.log('About to update contribution');
            ContributionService.updateContribution(contribution, id)
                .then(
                    function (response) {
                        console.log('Contribution updated successfully');
                        self.successMessage = 'Contribution updated successfully';
                        self.errorMessage = '';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while updating Contribution');
                        self.errorMessage = 'Error while updating Contribution ' + errResponse.data;
                        self.successMessage = '';
                    }
                );
        }


        function removeContribution(id) {
            console.log('About to remove Contribution with id ' + id);
            ContributionService.removeContribution(id)
                .then(
                    function () {
                        console.log('Contribution ' + id + ' removed successfully');
                    },
                    function (errResponse) {
                        console.error('Error while removing contribution ' + id + ', Error :' + errResponse.data);
                    }
                );
        }


        function getAllContributions() {
            return ContributionService.getAllContributions();
        }

        function editContribution(id) {
            self.successMessage = '';
            self.errorMessage = '';
            ContributionService.getContribution(id).then(
                function (contribution) {
                    self.contribution = contribution;
                    self.contribution.contributionDate = new Date(moment(self.contribution.contributionDate));
                },
                function (errResponse) {
                    console.error('Error while removing contribution ' + id + ', Error :' + errResponse.data);
                }
            );
        }

        function reset() {
            self.successMessage = '';
            self.errorMessage = '';
            self.contribution = {};
            $scope.myForm.$setPristine(); //reset Form
        }
    }

    ]);