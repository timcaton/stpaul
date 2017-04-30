<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Member</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.member.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="name">Member</label>
                            <div class="col-md-7">
                                <select class="form-control" ng-model="ctrl.member" id="member"
                                        ng-options="m.name for m in ctrl.getAllMembers() track by m.id" ng-change="ctrl.editMember()" required>
                                    <option value="">--Select a Member--</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="nickname">Nick Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.nickname" id="nickname"
                                       class="form-control input-sm" placeholder="Enter nick name" required
                                       ng-minlength="0"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="status">Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.status" id="status"
                                       class="form-control input-sm"
                                       placeholder="Enter status Active, Inactive, or Shut-In" required
                                       ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="gender">Gender</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.gender" id="gender"
                                       class="gender form-control input-sm" placeholder="Enter M or F for gender" required
                                       ng-minlength="1" ng-maxlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Title</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.title" id="title" class="form-control input-sm"
                                       placeholder="Enter title Mr, Mrs, or Miss" required ng-minlength="2"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Birth</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.member.dob" id="dob" class="dob form-control input-sm"
                                       placeholder="Enter DOB in mm/dd/yyyy format" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Ethnicity</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.ethnicity" id="ethnicity"
                                       class="ethnicity form-control input-sm" placeholder="Enter ethnicity" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="sequenceInHousehold">Sequence in
                                Household</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.sequenceInHousehold" id="sequenceInHousehold"
                                       class="form-control input-sm" placeholder="Enter sequence in household." required
                                       ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.address" id="address"
                                       class="address form-control input-sm" placeholder="Enter address"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="city">City</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.city" id="city" class="city form-control input-sm"
                                       placeholder="Enter city"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="state">State</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.state" id="state"
                                       class="state form-control input-sm" placeholder="Enter state"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="zipCode">Zip Code</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.zipCode" id="zipCode"
                                       class="form-control input-sm" placeholder="Enter zip code."
                                       ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="email">Email</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.email" id="email"
                                       class="email form-control input-sm" placeholder="Enter email"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="phoneNumber">Phone Number</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.phoneNumber" id="phoneNumber"
                                       class="form-control input-sm" placeholder="Enter Phone Number"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="receivedBy">Received By</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.receivedBy" id="receivedBy"
                                       class="receivedBy form-control input-sm" placeholder="Enter Received By"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="removedBy">Removed By</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.removedBy" id="removedBy"
                                       class="form-control input-sm" placeholder="Enter Removed By"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="maritalStatus">Marital Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.maritalStatus" id="maritalStatus"
                                       class="form-control input-sm" placeholder="Enter Marital Status"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="placeOfBirth">Place of Birth</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.placeOfBirth" id="placeOfBirth"
                                       class="form-control input-sm" placeholder="Enter Place of Birth"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="numberOfChildren">Number Of Children</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.numberOfChildren" id="numberOfChildren"
                                       class="form-control input-sm" placeholder="Enter Number of Children"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="childrenLiving">Children Living</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.childrenLiving" id="childrenLiving"
                                       class="form-control input-sm" placeholder="Enter Children Living"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="childrenNames">Children Names</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.childrenNames" id="childrenNames"
                                       class="form-control input-sm" placeholder="Enter Children Names"/>
                            </div>
                        </div>
                    </div>

                   <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="memberInfo">Other Member Info</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.memberInfo" id="memberInfo"
                                       class="form-control input-sm" placeholder="Other Member Info"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Baptism</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.baptism.baptismDate" id="dob" class="dob form-control input-sm"
                                       placeholder="Enter Date of Baptism" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Location of Baptism</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.baptismLocation" id="baptismLocation"
                                       class="form-control input-sm" placeholder="Enter location of Baptism" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="email">Baptism Officiant</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.baptismOfficiant" id="baptismOfficiant"
                                       class="form-control input-sm" placeholder="Enter Baptism Officiant"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Baptism Sponsor Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.sponsorName" id="sponsorName"
                                       class="form-control input-sm" placeholder="Enter sponsor name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Baptism Witness Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.witnessName" id="witnessName"
                                       class="form-control input-sm" placeholder="Enter witness name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">First Parent Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.parentName1" id="parentName1"
                                       class="form-control input-sm" placeholder="Enter parent name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="parentName2">Second Parent Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.parentName2" id="parentName2"
                                       class="form-control input-sm" placeholder="Enter parent name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Baptism Comment</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.baptismComment" id="baptismComment"
                                       class="form-control input-sm" placeholder="Enter baptism comments"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Confirmation</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.confirmation.confirmationDate" id="confirmationDate" class="form-control input-sm"
                                       placeholder="Enter Date of Confirmation in mm/dd/yyyy format" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Location of Confirmation</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.confirmation.confirmationLocation" id="confirmationLocation"
                                       class="form-control input-sm" placeholder="Enter location of Confirmation" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="email">Confirmation Officiant</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.confirmation.confirmationOfficiant" id="confirmationOfficiant"
                                       class="form-control input-sm" placeholder="Enter Confirmation Officiant"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Confirmation Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.confirmation.confirmationStatus" id="confirmationStatus"
                                       class="form-control input-sm" placeholder="Enter Confirmation Status"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Confirmation Verse</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.confirmation.confirmationVerse" id="confirmationVerse"
                                       class="form-control input-sm" placeholder="Enter Confirmation Verse"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="parentName2">Examination Date</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.confirmation.examinationDate" id="examinationDate"
                                       class="form-control input-sm" placeholder="Enter Examination Date"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Confirmation Comment</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.confirmation.confirmationComment" id="confirmationComment"
                                       class="form-control input-sm" placeholder="Enter Confirmation Comment"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Funeral</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.funeral.funeralDate" id="dob" class="form-control input-sm"
                                       placeholder="Enter Date of Funeral" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Death</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.funeral.deathDate" id="deathDate" class="form-control input-sm"
                                       placeholder="Enter Date of Funeral" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Place of Funeral</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.funeral.funeralPlace" id="funeralLocation"
                                       class="form-control input-sm" placeholder="Enter place of Funeral" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="email">Funeral Officiant</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.funeral.funeralOfficiant" id="funeralOfficiant"
                                       class="form-control input-sm" placeholder="Enter Funeral Officiant"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Burial Location</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.funeral.burialLocation" id="burialLocation"
                                       class="form-control input-sm" placeholder="Enter Burial Location"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Pall Bearers</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.funeral.pallBearers" id="pallBearers"
                                       class="form-control input-sm" placeholder="Enter Pall Bearers"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Funeral Comment</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.funeral.funeralComment" id="funeralComment"
                                       class="form-control input-sm" placeholder="Enter Funeral Comment"/>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>