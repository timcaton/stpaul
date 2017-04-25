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
            return BaptismService.getAllBaptisms();
        }

        function getAllCommunions(){
            return CommunionService.getAllCommunions();
        }

        function getAllConfirmations(){
            return ConfirmationService.getAllConfirmations();
        }

        function getAllContributions(){
            return ContributionService.getAllContributions();
        }

        function getAllFunerals(){
            return FuneralService.getAllFunerals();
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
    }


]);