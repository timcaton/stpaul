'use strict';

angular.module('crudApp').controller('CommunionController',
    ['CommunionService', 'MemberService', '$scope',  function( CommunionService, MemberService, $scope) {

        var self = this;
        self.communion = {};
        self.communions=[];
        self.membersToSend = [];
        self.members = [];
        self.memberClicked = false;

        self.submit = submit;
        self.getAllCommunions = getAllCommunions;
        self.createCommunion = createCommunion;
        self.updateCommunion = updateCommunion;
        self.removeCommunion = removeCommunion;
        self.editCommunion = editCommunion;
        self.reset = reset;
        self.doTheBack = doTheBack;
        self.getAllMembers = getAllMembers;
        self.setMembers = setMembers;

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

        function setMembers(id) {
            var i = 0;

            self.membersToSend.forEach(function(communion){
                if(communion.memberId == id){
                    i++
                }
            });

            if(i == 0 && self.memberClicked) {
                var memberAndDate = {};
                memberAndDate = {memberId: id, communionDate: self.communion.communionDate};
                self.membersToSend.push(memberAndDate);
            }
        }

        function submit() {
            self.membersToSend.forEach(function(communion) {
                console.log('Submitting');
                if(self.memberClicked)
                if (communion.id === undefined || communion.id === null) {
                    console.log('Saving New Communion', communion);
                    createCommunion(communion);
                } else {
                    updateCommunion(self.communion, self.communion.id);
                    console.log('Communion updated with id ', self.communion.id);
                }
            });
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