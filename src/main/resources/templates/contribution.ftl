<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Contributions</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.contribution.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="memberId">Church Member ID</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.contribution.memberId" id="memberId" class="form-control input-sm"
                                       placeholder="Enter Church Member ID" ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="guestId">Guest ID</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.contribution.guest" id="guestId" class="form-control input-sm"
                                       placeholder="Enter Guest ID" ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Contribution</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.contribution.contributionDate" id="contributionDate" class="form-control input-sm"
                                       placeholder="Enter Date of Contribution in mm/dd/yyyy format" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Purpose</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.contribution.purpose" id="purpose"
                                       class="form-control input-sm" placeholder="Enter Purpose of Contribution" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="method">Method</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.contribution.method" id="method"
                                       class="form-control input-sm" placeholder="Enter Contribution Method"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="amount">Amount</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.contribution.amount" id="amount"
                                       class="form-control input-sm" placeholder="Enter Amount of Contribution"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.contribution.id ? 'Add' : 'Update'}}"
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
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Contributions</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>CHURCH MEMBER ID</th>
                        <th>GUEST ID</th>
                        <th>PURPOSE</th>
                        <th>DATE</th>
                        <th>METHOD</th>
                        <th>AMOUNT</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="c in ctrl.getAllContributions()">
                        <td>{{c.id}}</td>
                        <td>{{c.memberId}}</td>
                        <td>{{c.guestId}}</td>
                        <td>{{c.contributionDate}}</td>
                        <td>{{c.purpose}}</td>
                        <td>{{c.method}}</td>
                        <td>{{c.amount}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.editContribution(c.id)" class="btn btn-success custom-width">
                                Edit
                            </button>
                        </td>
                        <td>
                            <button type="button" ng-click="ctrl.removeContribution(c.id)"
                                    class="btn btn-danger custom-width">Remove
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>