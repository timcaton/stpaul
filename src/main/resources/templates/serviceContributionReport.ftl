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
                        <div class="form-group col-md-6">
                            <label class="col-md-2 control-label" for="dob">Date Of Service</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.serviceDate" id="serviceDate" class="form-control input-sm"
                                       placeholder="Enter Date of Service" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <button type="button" ng-click="ctrl.serviceContributions()"
                                    class="btn btn-success custom-width floatRight">Select
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Totals</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.contribution.id"/>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-2 control-label" >General</label>
                            <div class="col-md-7">
                                <input readonly type="text" ng-model="ctrl.generalTotal" id="generalTotal"
                                       class="form-control input-sm"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-2 control-label" >Building</label>
                            <div class="col-md-7">
                                <input readonly type="text" ng-model="ctrl.buildingTotal" id="buildingTotal"
                                       class="form-control input-sm"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-2 control-label" >Other</label>
                            <div class="col-md-7">
                                <input readonly type="text" ng-model="ctrl.otherTotal" id="otherTotal"
                                       class="form-control input-sm"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>PURPOSE</th>
                        <th>AMOUNT</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="c in ctrl.serviceContributionList">
                        <td>{{c.purpose}}</td>
                        <td>{{c.amount}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>