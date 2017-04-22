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
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>HOUSEHOLD ID</th>
                        <th>MEMBER ID</th>
                        <th>TITLE</th>
                        <th>NAME</th>
                        <th>DATE OF BIRTH</th>
                        <th>STATUS</th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="m in ctrl.getAllMembers()">
                        <td>{{m.householdId}}</td>
                        <td>{{m.id}}</td>
                        <td>{{m.title}}</td>
                        <td>{{m.name}}</td>
                        <td>{{m.dob}}</td>
                        <td>{{m.status}}</td>
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
                                <input type="text" ng-model="ctrl.member.title" id="title" class="form-control input-sm"
                                       placeholder="Enter title Mr, Mrs, or Miss" required ng-minlength="2"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="name">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.name" id="name" class="form-control input-sm"
                                       placeholder="Enter name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="status">Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.status" id="status"
                                       class="form-control input-sm"
                                       placeholder="Enter status Active, Inactive, Deceased, or Shut-In" required
                                       ng-minlength="3"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="nickname">Nick Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.nickname" id="nickname"
                                       class="form-control input-sm" placeholder="Enter nick name" required
                                       ng-minlength="0"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="dob">Date Of Birth</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.dob" id="dob" class="dob form-control input-sm"
                                       placeholder="Enter DOB in mm/dd/yyyy format" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="maritalStatus">Marital Status</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.maritalStatus" id="maritalStatus"
                                       class="form-control input-sm" placeholder="Enter Marital Status"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="envelopeId">Envelope ID</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.envelopeId" id="envelopeId"
                                       class="form-control input-sm" placeholder="Enter envelope ID." required
                                       ng-pattern="ctrl.onlyIntegers"/>
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
                            <label class="col-md-4 control-label" for="state">State</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.state" id="state"
                                       class="state form-control input-sm" placeholder="Enter state"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="zipCode">Zip Code</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.zipCode" id="zipCode"
                                       class="form-control input-sm" placeholder="Enter zip code."
                                       ng-pattern="ctrl.onlyIntegers"/>
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
                                <input type="text" ng-model="ctrl.member.phoneNumber" id="phoneNumber"
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
                <div >
                    <button class="btn btn-success custom-width" ng-click="ctrl.openMarriageModal()">View Marriage</button>
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
                            <label class="col-md-4 control-label" for="householdId">Household ID</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.householdId" id="householdId"
                                       class="form-control input-sm" placeholder="Enter household ID." required
                                       ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="householdId">Household Name</label>
                            <div class="col-md-7">
                                <input readonly type="text" ng-model="ctrl.member.householdName" id="householdName"
                                       class="form-control input-sm" placeholder="Household Name."/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="sequenceInHousehold">Sequence in
                                Household</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.sequenceInHousehold" id="sequenceInHousehold"
                                       class="form-control input-sm" placeholder="Enter sequence in household." required
                                       ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="numberOfChildren">Number Of Children</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.numberOfChildren" id="numberOfChildren"
                                       class="form-control input-sm" placeholder="Enter Number of Children"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="childrenLiving">Children Living</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.childrenLiving" id="childrenLiving"
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
                                <input type="text" ng-model="ctrl.member.gender" id="gender"
                                       class="gender form-control input-sm" placeholder="Enter M or F for gender" required
                                       ng-minlength="1" ng-maxlength="1"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="ethnicity">Ethnicity</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.ethnicity" id="ethnicity"
                                       class="ethnicity form-control input-sm" placeholder="Enter ethnicity" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="receivedBy">Received By</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.receivedBy" id="receivedBy"
                                       class="receivedBy form-control input-sm" placeholder="Enter Received By"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="removedBy">Removed By</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.removedBy" id="removedBy"
                                       class="form-control input-sm" placeholder="Enter Removed By"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="memberInfo">Other Member Info</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.memberInfo" id="memberInfo"
                                       class="form-control input-sm" placeholder="Other Member Info"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label class="col-md-4 control-label" for="carrierDate">Carrier Date</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.member.carrierDate" id="carrierDate"
                                       class="form-control input-sm"
                                       placeholder="Enter Carrier Date in mm/dd/yyyy format" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{'Update'}}"
                                   class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
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