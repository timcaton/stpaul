'use strict';

angular.module('crudApp').controller('CommunionController',
    ['CommunionService', 'MemberService', '$scope',  function( CommunionService, MemberService, $scope) {

        var self = this;
        self.communion = {};
        self.communions=[];
        $scope.member = {};

        self.submit = submit;
        self.getAllCommunions = getAllCommunions;
        self.createCommunion = createCommunion;
        self.updateCommunion = updateCommunion;
        self.removeCommunion = removeCommunion;
        self.editCommunion = editCommunion;
        self.reset = reset;
        self.setMember = setMember;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function setMember() {
            console.log("blah");
            $scope.member = {};
            $scope.member = MemberService.getMember(id);
        }

        function submit() {
            console.log('Submitting');
            if (self.communion.id === undefined || self.communion.id === null) {
                console.log('Saving New Communion', self.communion);
                createCommunion(self.communion);
            } else {
                updateCommunion(self.communion, self.communion.id);
                console.log('Communion updated with id ', self.communion.id);
            }
        }

        function createCommunion(communion) {
            console.log('About to create communion');
            CommunionService.createCommunion(communion)
                .then(
                    function (response) {
                        console.log('Communion created successfully');
                        self.successMessage = 'Communion created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.communion={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Communion');
                        self.errorMessage = 'Error while creating Communion: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateCommunion(communion, id){
            console.log('About to update communion');
            CommunionService.updateCommunion(communion, id)
                .then(
                    function (response){
                        console.log('Communion updated successfully');
                        self.successMessage='Communion updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Communion');
                        self.errorMessage='Error while updating Communion '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeCommunion(id){
            console.log('About to remove Communion with id '+id);
            CommunionService.removeCommunion(id)
                .then(
                    function(){
                        console.log('Communion '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing communion '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllCommunions(){
            return CommunionService.getAllCommunions();
        }

        function editCommunion(id) {
            self.successMessage='';
            self.errorMessage='';
            CommunionService.getCommunion(id).then(
                function (communion) {
                    self.communion = communion;
                },
                function (errResponse) {
                    console.error('Error while removing communion ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.communion={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);