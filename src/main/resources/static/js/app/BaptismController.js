'use strict';

angular.module('crudApp').controller('BaptismController',
    ['BaptismService', 'MemberService', '$scope',  function( BaptismService, MemberService, $scope) {

        var self = this;
        self.baptism = {};
        self.baptisms=[];
        self.memberName = null;

        self.submit = submit;
        self.getAllBaptisms = getAllBaptisms;
        self.createBaptism = createBaptism;
        self.updateBaptism = updateBaptism;
        self.removeBaptism = removeBaptism;
        self.editBaptism = editBaptism;
        self.reset = reset;
        self.getMemberName = getMemberName;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function getMemberName(id) {
            self.memberName = null;
            var member = MemberService.getMember(id);
            self.memberName = member.name;
            return self.memberName;
        }

        function submit() {
            console.log('Submitting');
            if (self.baptism.id === undefined || self.baptism.id === null) {
                console.log('Saving New Baptism', self.baptism);
                createBaptism(self.baptism);
            } else {
                updateBaptism(self.baptism, self.baptism.id);
                console.log('Baptism updated with id ', self.baptism.id);
            }
        }

        function createBaptism(baptism) {
            console.log('About to create baptism');
            BaptismService.createBaptism(baptism)
                .then(
                    function (response) {
                        console.log('Baptism created successfully');
                        self.successMessage = 'Baptism created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.baptism={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Baptism');
                        self.errorMessage = 'Error while creating Baptism: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateBaptism(baptism, id){
            console.log('About to update baptism');
            BaptismService.updateBaptism(baptism, id)
                .then(
                    function (response){
                        console.log('Baptism updated successfully');
                        self.successMessage='Baptism updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Baptism');
                        self.errorMessage='Error while updating Baptism '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeBaptism(id){
            console.log('About to remove Baptism with id '+id);
            BaptismService.removeBaptism(id)
                .then(
                    function(){
                        console.log('Baptism '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing baptism '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllBaptisms(){
            return BaptismService.getAllBaptisms();
        }

        function editBaptism(id) {
            self.successMessage='';
            self.errorMessage='';
            BaptismService.getBaptism(id).then(
                function (baptism) {
                    self.baptism = baptism;
                },
                function (errResponse) {
                    console.error('Error while removing baptism ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.baptism={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);