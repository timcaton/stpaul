<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Confirmations</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.confirmation.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Church Member ID</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.confirmation.memberId" ng-change="setMember()"  id="memberId" class="form-control input-sm"
                                       placeholder="Enter Church Member ID" required ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Church Member Name</label>
                            <div class="col-md-7">
                                <input readonly type="text"  ng-model="ctrl.confirmation.memberName" id="memberName" class="form-control input-sm"/>
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
                            <label class="col-md-2 control-label" for="address">Confirmation Comment</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.confirmation.confirmationComment" id="confirmationComment"
                                       class="form-control input-sm" placeholder="Enter Confirmation Comment"/>
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
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.confirmation.id ? 'Add' : 'Update'}}"
                                   class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
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