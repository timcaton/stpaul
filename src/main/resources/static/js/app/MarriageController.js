'use strict';

angular.module('crudApp').controller('MarriageController',
    ['MarriageService', 'MemberService', '$scope',  function( MarriageService, MemberService, $scope) {

        var self = this;
        self.marriage = {};
        self.marriages=[];
        $scope.member = {};

        self.submit = submit;
        self.getAllMarriages = getAllMarriages;
        self.createMarriage = createMarriage;
        self.updateMarriage = updateMarriage;
        self.removeMarriage = removeMarriage;
        self.editMarriage = editMarriage;
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
            if (self.marriage.id === undefined || self.marriage.id === null) {
                console.log('Saving New Marriage', self.marriage);
                createMarriage(self.marriage);
            } else {
                updateMarriage(self.marriage, self.marriage.id);
                console.log('Marriage updated with id ', self.marriage.id);
            }
        }

        function createMarriage(marriage) {
            console.log('About to create marriage');
            MarriageService.createMarriage(marriage)
                .then(
                    function (response) {
                        console.log('Marriage created successfully');
                        self.successMessage = 'Marriage created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.marriage={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Marriage');
                        self.errorMessage = 'Error while creating Marriage: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateMarriage(marriage, id){
            console.log('About to update marriage');
            MarriageService.updateMarriage(marriage, id)
                .then(
                    function (response){
                        console.log('Marriage updated successfully');
                        self.successMessage='Marriage updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Marriage');
                        self.errorMessage='Error while updating Marriage '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeMarriage(id){
            console.log('About to remove Marriage with id '+id);
            MarriageService.removeMarriage(id)
                .then(
                    function(){
                        console.log('Marriage '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing marriage '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllMarriages(){
            return MarriageService.getAllMarriages();
        }

        function editMarriage(id) {
            self.successMessage='';
            self.errorMessage='';
            MarriageService.getMarriage(id).then(
                function (marriage) {
                    self.marriage = marriage;
                },
                function (errResponse) {
                    console.error('Error while removing marriage ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.marriage={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);