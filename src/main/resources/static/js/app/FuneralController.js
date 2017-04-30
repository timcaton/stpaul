'use strict';

angular.module('crudApp').controller('FuneralController',
    ['FuneralService', 'MemberService', '$scope', '$uibModalInstance',  function( FuneralService, MemberService, $scope,  modalInstance) {

        var self = this;
        self.funeral = {};
        self.funerals=[];

        var currentMember = modalInstance.member;
        var currentMemberId = currentMember.id;

        self.submit = submit;
        self.getAllFunerals = getAllFunerals;
        self.createFuneral = createFuneral;
        self.updateFuneral = updateFuneral;
        self.removeFuneral = removeFuneral;
        self.editFuneral = editFuneral;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        init();

        function init() {
            editFuneral(currentMemberId);
        }

        function submit() {
            console.log('Submitting');
            if (self.funeral.id === undefined || self.funeral.id === null) {
                console.log('Saving New Funeral', self.funeral);
                createFuneral(self.funeral);
            } else {
                updateFuneral(self.funeral, self.funeral.id);
                console.log('Funeral updated with id ', self.funeral.id);
            }
        }

        function createFuneral(funeral) {
            console.log('About to create funeral');
            FuneralService.createFuneral(funeral)
                .then(
                    function (response) {
                        console.log('Funeral created successfully');
                        self.successMessage = 'Funeral created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.funeral={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Funeral');
                        self.errorMessage = 'Error while creating Funeral: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateFuneral(funeral, id){
            console.log('About to update funeral');
            FuneralService.updateFuneral(funeral, id)
                .then(
                    function (response){
                        console.log('Funeral updated successfully');
                        self.successMessage='Funeral updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Funeral');
                        self.errorMessage='Error while updating Funeral '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeFuneral(id){
            console.log('About to remove Funeral with id '+id);
            FuneralService.removeFuneral(id)
                .then(
                    function(){
                        console.log('Funeral '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing funeral '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllFunerals(){
            self.funerals = FuneralService.getAllFunerals();
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
                    else {
                        self.errorMessage = 'No Funeral Information For This Member';
                    }
                }
            } else {
                self.errorMessage = 'No Funeral Information For This Member';
            }

            self.funeral.memberId = id;
            self.funeral.memberName = currentMember.name;
            self.funerals = [];
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.funeral={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);