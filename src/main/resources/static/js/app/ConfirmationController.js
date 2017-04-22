'use strict';

angular.module('crudApp').controller('ConfirmationController',
    ['ConfirmationService', 'MemberService', '$scope', '$uibModalInstance', function( ConfirmationService, MemberService, $scope, modalInstance) {

        var self = this;
        self.confirmation = {};
        self.confirmations=[];

        var currentMember = modalInstance.member;
        var currentMemberId = currentMember.id;

        self.submit = submit;
        self.getAllConfirmations = getAllConfirmations;
        self.createConfirmation = createConfirmation;
        self.updateConfirmation = updateConfirmation;
        self.removeConfirmation = removeConfirmation;
        self.editConfirmation = editConfirmation;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        init();

        function init() {
            editConfirmation(currentMemberId);
        }

        function submit() {
            console.log('Submitting');
            if (self.confirmation.id === undefined || self.confirmation.id === null) {
                console.log('Saving New Confirmation', self.confirmation);
                createConfirmation(self.confirmation);
            } else {
                updateConfirmation(self.confirmation, self.confirmation.id);
                console.log('Confirmation updated with id ', self.confirmation.id);
            }
        }

        function createConfirmation(confirmation) {
            console.log('About to create confirmation');
            ConfirmationService.createConfirmation(confirmation)
                .then(
                    function (response) {
                        console.log('Confirmation created successfully');
                        self.successMessage = 'Confirmation created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.confirmation={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Confirmation');
                        self.errorMessage = 'Error while creating Confirmation: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateConfirmation(confirmation, id){
            console.log('About to update confirmation');
            ConfirmationService.updateConfirmation(confirmation, id)
                .then(
                    function (response){
                        console.log('Confirmation updated successfully');
                        self.successMessage='Confirmation updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Confirmation');
                        self.errorMessage='Error while updating Confirmation '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeConfirmation(id){
            console.log('About to remove Confirmation with id '+id);
            ConfirmationService.removeConfirmation(id)
                .then(
                    function(){
                        console.log('Confirmation '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing confirmation '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllConfirmations(){
            return ConfirmationService.getAllConfirmations();
        }

        function editConfirmation(id) {
            self.successMessage='';
            self.errorMessage='';
            self.confirmation.memberId = id;
            self.confirmation.memberName = currentMember.name;
            ConfirmationService.getConfirmation(id).then(
                function (confirmation) {
                    self.confirmation = confirmation;
                },
                function (errResponse) {
                    console.error('Error while removing confirmation ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.confirmation={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);