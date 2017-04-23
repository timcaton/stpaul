'use strict';

angular.module('crudApp').controller('HouseholdController',
    ['HouseholdService', 'MemberService', '$scope',  function( HouseholdService, MemberService, $scope) {

        var self = this;
        self.household = {};
        self.households=[];
        $scope.member = {};

        self.submit = submit;
        self.getAllHouseholds = getAllHouseholds;
        self.createHousehold = createHousehold;
        self.updateHousehold = updateHousehold;
        self.removeHousehold = removeHousehold;
        self.editHousehold = editHousehold;
        self.doTheBack = doTheBack;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function doTheBack() {
            window.history.back();
        }

        function submit() {
            console.log('Submitting');
            if (self.household.id === undefined || self.household.id === null) {
                console.log('Saving New Household', self.household);
                createHousehold(self.household);
            } else {
                updateHousehold(self.household, self.household.id);
                console.log('Household updated with id ', self.household.id);
            }
        }

        function createHousehold(household) {
            console.log('About to create household');
            HouseholdService.createHousehold(household)
                .then(
                    function (response) {
                        console.log('Household created successfully');
                        self.successMessage = 'Household created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.household={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Household');
                        self.errorMessage = 'Error while creating Household: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateHousehold(household, id){
            console.log('About to update household');
            HouseholdService.updateHousehold(household, id)
                .then(
                    function (response){
                        console.log('Household updated successfully');
                        self.successMessage='Household updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Household');
                        self.errorMessage='Error while updating Household '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeHousehold(id){
            console.log('About to remove Household with id '+id);
            HouseholdService.removeHousehold(id)
                .then(
                    function(){
                        console.log('Household '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing household '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllHouseholds(){
            return HouseholdService.getAllHouseholds();
        }

        function editHousehold(id) {
            self.successMessage='';
            self.errorMessage='';
            HouseholdService.getHousehold(id).then(
                function (household) {
                    self.household = household;
                },
                function (errResponse) {
                    console.error('Error while removing household ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.household={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);