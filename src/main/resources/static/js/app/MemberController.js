'use strict';

angular.module('crudApp').controller('MemberController', ['MemberService', 'HouseholdService', '$scope', '$uibModal',
    function( MemberService, HouseholdService, $scope, $modal) {

        var self = this;
        self.member = {};
        self.members=[];
        self.household = {};
        self.households=[];
        self.householdId;

        self.submit = submit;
        self.getAllMembers = getAllMembers;
        self.createMember = createMember;
        self.updateMember = updateMember;
        self.removeMember = removeMember;
        self.editMember = editMember;
        self.getAllHouseholds = getAllHouseholds;
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

        function createMember(member) {
            console.log('About to create member');
            member.householdId = member.householdId.id;
            MemberService.createMember(member)
                .then(
                    function (response) {
                        console.log('Member created successfully');
                        self.successMessage = 'Member created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.member={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Member');
                        self.errorMessage = 'Error while creating Member: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateMember(member, id){
            console.log('About to update member');
            MemberService.updateMember(member, id)
                .then(
                    function (response){
                        console.log('Member updated successfully');
                        self.successMessage='Member updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Member');
                        self.errorMessage='Error while updating Member '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeMember(id){
            console.log('About to remove Member with id '+id);
            MemberService.removeMember(id)
                .then(
                    function(){
                        console.log('Member '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing member '+id +', Error :'+errResponse.data);
                    }
                );
        }

        function getAllMembers(){
            return MemberService.getAllMembers();
        }

        function getAllHouseholds(){
            return HouseholdService.getAllHouseholds();
        }

        function editMember(id) {
            self.successMessage='';
            self.errorMessage='';
            MemberService.getMember(id).then(
                function (member) {
                    self.member = member;
                    HouseholdService.getHousehold(self.member.householdId).then(
                        function (household) {
                            self.member.householdName = household.name;
                        });
                },
                function (errResponse) {
                    console.error('Error while removing member ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.member={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);