<div class="container">
    <div class="row">
        <div class="form-group col-md-12">
            <div>
                <a href="#/"><button class="btn btn-success btn-sm">Home</button></a>
                <button class="btn btn-warning btn-sm" ng-click="ctrl.doTheBack()">Back</button>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Guests</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>GUEST NAME</th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="g in ctrl.getAllGuests()">
                        <td>{{g.name}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.chooseGuest(g.id)" class="btn btn-success custom-width">
                                Choose
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
        <div class="panel-heading"><span class="lead">Contributions</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.contribution.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="guestId">Guest ID</label>
                            <div class="col-md-7">
                                <input readonly type="text" ng-model="ctrl.contribution.guestId" id="guestId" class="form-control input-sm"
                                    placeholder="Enter Guest ID" ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Contribution</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.contribution.contributionDate" id="contributionDate" class="form-control input-sm"
                                       placeholder="Enter Date of Contribution" required ng-minlength="10"
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
                                <input type="number" ng-model="ctrl.contribution.amount" id="amount"
                                       class="form-control input-sm" placeholder="Enter Amount of Contribution" min=".01" step=".01"/>
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
                <table class="table table-hover" ts-wrapper>
                    <thead>
                    <tr>
                        <th ts-criteria="id">ID</th>
                        <th ts-criteria="guestId">GUEST ID</th>
                        <th ts-criteria="purpose">PURPOSE</th>
                        <th ts-criteria="contributionDate">DATE</th>
                        <th ts-criteria="method">METHOD</th>
                        <th ts-criteria="amount">AMOUNT</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="c in ctrl.getAllContributions()">
                        <td>{{c.id}}</td>
                        <td>{{c.guestId}}</td>
                        <td>{{c.purpose}}</td>
                        <td>{{c.contributionDate}}</td>
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