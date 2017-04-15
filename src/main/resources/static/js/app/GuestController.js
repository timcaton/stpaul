'use strict';

angular.module('crudApp').controller('GuestController',
    ['GuestService', 'MemberService', '$scope',  function( GuestService, MemberService, $scope) {

        var self = this;
        self.guest = {};
        self.guests=[];
        $scope.member = {};

        self.submit = submit;
        self.getAllGuests = getAllGuests;
        self.createGuest = createGuest;
        self.updateGuest = updateGuest;
        self.removeGuest = removeGuest;
        self.editGuest = editGuest;
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
            if (self.guest.id === undefined || self.guest.id === null) {
                console.log('Saving New Guest', self.guest);
                createGuest(self.guest);
            } else {
                updateGuest(self.guest, self.guest.id);
                console.log('Guest updated with id ', self.guest.id);
            }
        }

        function createGuest(guest) {
            console.log('About to create guest');
            GuestService.createGuest(guest)
                .then(
                    function (response) {
                        console.log('Guest created successfully');
                        self.successMessage = 'Guest created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.guest={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Guest');
                        self.errorMessage = 'Error while creating Guest: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateGuest(guest, id){
            console.log('About to update guest');
            GuestService.updateGuest(guest, id)
                .then(
                    function (response){
                        console.log('Guest updated successfully');
                        self.successMessage='Guest updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Guest');
                        self.errorMessage='Error while updating Guest '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeGuest(id){
            console.log('About to remove Guest with id '+id);
            GuestService.removeGuest(id)
                .then(
                    function(){
                        console.log('Guest '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing guest '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllGuests(){
            return GuestService.getAllGuests();
        }

        function editGuest(id) {
            self.successMessage='';
            self.errorMessage='';
            GuestService.getGuest(id).then(
                function (guest) {
                    self.guest = guest;
                },
                function (errResponse) {
                    console.error('Error while removing guest ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.guest={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);