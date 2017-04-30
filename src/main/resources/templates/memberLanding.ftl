<div class="container">
    <div class="row">
        <div class="form-group col-md-12">
            <div class="row">
                <div class="form-group col-md-12">
                    <div>
                        <a href="#/"><button class="btn btn-success btn-sm">Home</button></a>
                        <button class="btn btn-warning btn-sm" ng-click="ctrl.doTheBack()">Back</button>
                    </div>
                </div>
            </div>
            <div class="floatRight">
                <a href="#/household"><button class="btn btn-warning custom-width">Create a New Household</button></a>
                <a href="#/memberCreate"><button class="btn btn-success custom-width">Create a New Member</button></a>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Members</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover" ts-wrapper>
                    <thead>
                    <tr>
                        <th ts-criteria="householdId">HOUSEHOLD ID</th>
                        <th ts-criteria="id">MEMBER ID</th>
                        <th ts-criteria="name">NAME</th>
                        <th ts-criteria="dob">DATE OF BIRTH</th>
                        <th ts-criteria="memberType">STATUS</th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="m in ctrl.getAllMembers()" ts-repeat>
                        <td>{{m.householdId}}</td>
                        <td>{{m.id}}</td>
                        <td>{{m.name}}</td>
                        <td>{{m.dob}}</td>
                        <td>{{m.memberType}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.editMember(m.id)" class="btn btn-success custom-width">
                                Edit
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Member Information</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.member.id"/>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="title">Title</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.title" id="title">
                                    <option value="">--Select a Title--</option>
                                    <option value="Active">Mr.</option>
                                    <option value="Inactive">Mrs.</option>
                                    <option value="Shut-In">Miss</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="name">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.name" id="name" class="form-control input-sm"
                                       placeholder="Enter name"  ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="title">Suffix</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.suffix" id="suffix" class="form-control input-sm"
                                       placeholder="Enter suffix"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="memberType">Status</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.memberType" id="memberType">
                                    <option value="">--Select a Status--</option>
                                    <option value="Active">Active</option>
                                    <option value="Inactive">Inactive</option>
                                    <option value="Shut-In">Shut-In</option>
                                    <option value="Deceased">Deceased</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="preferredNickname">Nick Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.preferredNickname" id="preferredNickname"
                                       class="form-control input-sm" placeholder="Enter nick name" 
                                       ng-minlength="0"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="dob">Date Of Birth</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.member.dob" id="dob" class="dob form-control input-sm"
                                       placeholder="Enter DOB"  ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="maritalStatus">Marital Status</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.maritalStatus" id="maritalStatus">
                                    <option value="">--Select a Marital Status--</option>
                                    <option value="Single">Single</option>
                                    <option value="Married">Married</option>
                                    <option value="Divorced">Divorced</option>
                                    <option value="Widowed">Widowed</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="envelopeId">Envelope ID</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.envelope" id="envelope"
                                       class="form-control input-sm" placeholder="Enter envelope ID." 
                                       />
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="placeOfBirth">Place of Birth</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.placeOfBirth" id="placeOfBirth"
                                       class="form-control input-sm" placeholder="Enter Place of Birth"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Contact Information</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.member.id"/>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="address">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.address" id="address"
                                       class="address form-control input-sm" placeholder="Enter address"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="city">City</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.city" id="city" class="city form-control input-sm"
                                       placeholder="Enter city"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="stateProvince">State</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.stateProvince" id="stateProvince"
                                       class="stateProvince form-control input-sm" placeholder="Enter state"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="zip">Zip Code</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.zip" id="zip"
                                       class="form-control input-sm" placeholder="Enter zip code." maxlength="5"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="email">Email</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.email" id="email"
                                       class="email form-control input-sm" placeholder="Enter email"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="phoneNumber">Phone Number</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.phoneNumber" id="phoneNumber"
                                       class="form-control input-sm" placeholder="Enter Phone Number"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Spiritual Milestones</span></div>
        <div class="panel-body">
            <div class="row">
                <div>
                    <button class="btn btn-success custom-width" ng-click="ctrl.openBaptismModal()">View Baptism</button>
                    <button class="btn btn-success custom-width" ng-click="ctrl.openConfirmationModal()">View Confirmation</button>
                    <button class="btn btn-success custom-width" ng-click="ctrl.openFuneralModal()">View Funeral</button>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Household</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.member.id"/>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" >Household</label>

                            <div class="col-md-7">
                                <input readonly type="text"  ng-model="ctrl.member.householdName" id="householdName" class="form-control input-sm"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="householdId">Choose New Household</label>
                        <div class="col-md-7">
                                <select class="form-control" ng-model="ctrl.member.householdId" id="householdId"
                                        ng-options="h.name for h in ctrl.getAllHouseholds() track by h.id" >
                                        <option value="">--Select a Household--</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="sequenceInHousehold">Sequence in
                                Household</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.sequenceInHousehold" id="sequenceInHousehold">
                                    <option value="">--Sequence In Household--</option>
                                    <option value="Head of Household">Head of Household</option>
                                    <option value="Spouse">Spouse</option>
                                    <option value="Child">Child</option>
                                    <option value="Other">Other</option>
                                    <option value="Deceased">Deceased</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="numberOfChildren">Number Of Children</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.numberOfChildren" id="numberOfChildren"
                                       class="form-control input-sm" placeholder="Enter Number of Children"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="childrenLiving">Children Living</label>
                            <div class="col-md-7">
                                <input type="number" ng-model="ctrl.member.childrenLiving" id="childrenLiving"
                                       class="form-control input-sm" placeholder="Enter Children Living"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="childrenNames">Children Names</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.childrenNames" id="childrenNames"
                                       class="form-control input-sm" placeholder="Enter Children Names"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" >Parent Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.parentName1" id="parentName1"
                                       class="form-control input-sm" placeholder="Parent Name"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label">Parent Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.parentName2" id="parentName2"
                                       class="form-control input-sm" placeholder="Parent Name"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Other</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.member.id"/>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="gender">Gender</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.gender" id="gender">
                                    <option value="">--Gender--</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="ethnicity">Ethnicity</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.ethnicity" id="ethnicity">
                                    <option value="">--Ethnicity--</option>
                                    <option value="Caucasian">Caucasian</option>
                                    <option value="African American">African American</option>
                                    <option value="Hispanic">Hispanic</option>
                                    <option value="Asian/Pacific">Asian/Pacific</option>
                                    <option value="Native American">Native American</option>
                                    <option value="Other">Other</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="receivedBy">Received By</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.receivedBy" id="receivedBy">
                                    <option value="">--Received By--</option>
                                    <option value="Baptism">Baptism</option>
                                    <option value="Junior Confirmation">Junior Confirmation</option>
                                    <option value="Adult Confirmation">Adult Confirmation</option>
                                    <option value="Affirmation of Faith">Affirmation of Faith</option>
                                    <option value="Other Lutheran">Other Lutheran</option>
                                    <option value="Other Denomination">Other Denomination</option>
                                    <option value="Transfer">Transfer</option>
                                    <option value="Unknown">Unknown</option>
                                    <option value="Other">Other</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="removedBy">Removed By</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.member.removedBy" id="removedBy">
                                    <option value="">--Removed By--</option>
                                    <option value="Death">Death</option>
                                    <option value="Joined Other Church">Joined Other Church</option>
                                    <option value="Inactivity">Inactivity</option>
                                    <option value="Released">Released</option>
                                    <option value="Moved(No Transfer)">Moved(No Transfer)</option>
                                    <option value="Excommunication">Excommunication</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="churchBackground">Church Background</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.churchBackground" id="churchBackground"
                                       class="form-control input-sm" placeholder="Church Background"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="memberInfo">Other Member Info</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.memberInfo" id="memberInfo"
                                       class="form-control input-sm" placeholder="Other Member Info"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{'Update'}}"
                                   class="btn btn-primary btn-sm">
                            <button type="button" ng-click="ctrl.removeMember(m.id)"
                                    class="btn btn-danger btn-sm">Remove
                            </button>
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                    ng-disabled="myForm.$pristine">Reset Form
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>