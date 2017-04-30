'use strict';

angular.module('crudApp').controller('ReportController', ['MemberService', 'HouseholdService', 'BaptismService', 'CommunionService', 'ConfirmationService', 'ContributionService', 'FuneralService', 'GuestService', 'MarriageService', '$scope', '$uibModal',
    function( MemberService, HouseholdService, BaptismService, CommunionService, ConfirmationService, ContributionService, FuneralService, GuestService, MarriageService, $scope, $modal) {

        var self = this;
        self.member = {};
        self.members=[];
        self.household = {};
        self.households=[];
        self.householdId;
        self.baptisms=[];
        self.communions=[];
        self.confirmations=[];
        self.contributions=[];
        self.funerals=[];
        self.guests=[];
        self.marriages=[];
        self.serviceDate={};
        self.serviceContributionList = [];

        self.submit = submit;
        self.getAllMembers = getAllMembers;
        self.getAllHouseholds = getAllHouseholds;
        self.getAllBaptisms = getAllBaptisms;
        self.getAllCommunions = getAllCommunions;
        self.getAllConfirmations = getAllConfirmations;
        self.getAllContributions = getAllContributions;
        self.getAllFunerals = getAllFunerals;
        self.getAllGuests = getAllGuests;
        self.getAllMarriages = getAllMarriages;
        self.doTheBack = doTheBack;
        self.openBaptismModal = openBaptismModal;
        self.openConfirmationModal = openConfirmationModal;
        self.openFuneralModal = openFuneralModal;
        self.openMarriageModal = openMarriageModal;
        self.reset = reset;
        self.editMember = editMember;
        self.editBaptism = editBaptism;
        self.editFuneral = editFuneral;
        self.editConfirmation = editConfirmation;
        self.serviceContributions = serviceContributions;
        self.monthContributions = monthContributions;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function doTheBack() {
            window.history.back();
        }

        function openMarriageModal() {
            var marriageModal = $modal.open({
                templateUrl: 'partials/marriage',
                size: 'lg',
                controller:'MarriageController',
                controllerAs:'ctrl'
            });
            marriageModal.member = self.member;
        }

        function openBaptismModal() {
            var baptismModal = $modal.open({
                templateUrl: 'partials/baptism',
                size: 'lg',
                controller:'BaptismController',
                controllerAs:'ctrl'
            });
            baptismModal.member = self.member;
        }

        function openFuneralModal() {
            var funeralModal = $modal.open({
                templateUrl: 'partials/funeral',
                size: 'lg',
                controller:'FuneralController',
                controllerAs:'ctrl'
            });
            funeralModal.member = self.member;
        }

        function openConfirmationModal() {
            var confirmationModal = $modal.open({
                templateUrl: 'partials/confirmation',
                size: 'lg',
                controller:'ConfirmationController',
                controllerAs:'ctrl'
            });
            confirmationModal.member = self.member;
        }

        function submit() {
            console.log('Submitting');
            if (self.member.id === undefined || self.member.id === null) {
                console.log('Saving New Member', self.member);
                createMember(self.member);
            } else {
                updateMember(self.member, self.member.id);
                console.log('Member updated with id ', self.member.id);
            }
        }

        function getAllMembers(){
            return MemberService.getAllMembers();
        }

        function getAllHouseholds(){
            return HouseholdService.getAllHouseholds();
        }

        function getAllBaptisms(){
            self.baptisms = BaptismService.getAllBaptisms();
        }

        function getAllCommunions(){
            return CommunionService.getAllCommunions();
        }

        function getAllConfirmations(){
            self.confirmations = ConfirmationService.getAllConfirmations();
        }

        function getAllContributions(){
            return ContributionService.getAllContributions();
        }

        function getAllFunerals(){
            self.funerals = FuneralService.getAllFunerals();
        }

        function getAllGuests(){
            return GuestService.getAllGuests();
        }

        function getAllMarriages(){
            return MarriageService.getAllMarriages();
        }

        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.member={};
            $scope.myForm.$setPristine(); //reset Form
        }

        function editMember() {
            self.successMessage='';
            self.errorMessage='';
            MemberService.getMember(self.member.id).then(
                function (member) {
                    self.member = member;
                    self.member.dob = new Date(moment(self.member.dob));
                    HouseholdService.getHousehold(self.member.householdId).then(
                        function (household) {
                            self.member.householdName = household.name;
                            self.member.householdId = household.id;
                        });
                    editBaptism(self.member.id);
                    editFuneral(self.member.id);
                    editConfirmation(self.member.id);
                },
                function (errResponse) {
                    console.error('Error while removing member ' + id + ', Error :' + errResponse.data);
                }
            );
        }

        function editBaptism(id) {
            self.successMessage = '';
            self.errorMessage = '';

            getAllBaptisms();

            if (self.baptisms) {
                for (var i = 0; i < self.baptisms.length; i++) {
                    if (self.baptisms[i].memberId == id) {
                        self.baptism = self.baptisms[i];
                        self.baptism.baptismDate = new Date(moment(self.baptism.baptismDate));
                    }
                }
            }

            self.baptisms = [];
        }

        function editFuneral(id) {
            self.successMessage = '';
            self.errorMessage = '';

            getAllFunerals();

            if (self.funerals) {
                for (var i = 0; i < self.funerals.length; i++) {
                    if (self.funerals[i].memberId == id) {
                        self.funeral = self.funerals[i];
                        self.funeral.funeralDate = new Date(moment(self.funeral.funeralDate));
                        self.funeral.deathDate = new Date(moment(self.funeral.deathDate));
                    }
                }
            }
            self.funerals = [];
        }

        function editConfirmation(id) {
            self.successMessage = '';
            self.errorMessage = '';

            getAllConfirmations();

            if (self.confirmations) {
                for (var i = 0; i < self.confirmations.length; i++) {
                    if (self.confirmations[i].memberId == id) {
                        self.confirmation = self.confirmations[i];
                        self.confirmation.confirmationDate = new Date(moment(self.confirmation.confirmationDate));
                        self.confirmation.examinationDate = new Date(moment(self.confirmation.examinationDate));
                    }
                }
            }

            self.confirmations = [];
        }

        function serviceContributions() {
            self.contributions = [];
            self.serviceContributionList = [];
            self.generalTotal=null;
            self.buildingTotal=null;
            self.otherTotal=null;

            self.contributions = getAllContributions();

            for (var i = 0; i < self.contributions.length; i++) {
                var contributionDate = self.contributions[i].contributionDate;
                var serviceDate = self.serviceDate;
                contributionDate.toString();
                serviceDate.toString();
                if (contributionDate = serviceDate) {
                    self.serviceContributionList.push(self.contributions[i]);
                }
            }

            for (var i = 0; i < self.serviceContributionList.length; i++) {
                if (self.serviceContributionList[i].purpose == 'General') {
                    self.generalTotal += self.serviceContributionList[i].amount;
                }
                if (self.serviceContributionList[i].purpose == 'Building') {
                    self.buildingTotal += self.serviceContributionList[i].amount;
                }
                if(self.serviceContributionList[i].purpose != 'Building' || self.serviceContributionList[i].purpose != 'General') {
                    self.otherTotal += self.serviceContributionList[i].amount;
                }
            }
        }

        function monthContributions() {
            self.contributions = [];
            self.monthContributionList = [];
            self.generalTotal=null;
            self.buildingTotal=null;
            self.otherTotal=null;

            self.contributions = getAllContributions();

            for (var i = 0; i < self.contributions.length; i++) {
                var monthDate = new Date (moment(self.contributions[i].contributionDate));
                var month = monthDate.getMonth();
                var year = monthDate.getYear();

                if (self.month = toString(month)) {
                    if (self.year = toString(year)) {
                        self.monthContributionList.push(self.contributions[i]);
                    }
                }
            }

            for (var i = 0; i < self.monthContributionList.length; i++) {
                if (self.monthContributionList[i].purpose == 'General') {
                    self.generalTotal += self.monthContributionList[i].amount;
                }
                if (self.monthContributionList[i].purpose == 'Building') {
                    self.buildingTotal += self.monthContributionList[i].amount;
                }
                // if(self.monthContributionList[i].purpose != 'Building' || self.monthContributionList[i].purpose != 'General') {
                //     self.otherTotal += self.monthContributionList[i].amount;
                // }
            }
        }
    }
]);