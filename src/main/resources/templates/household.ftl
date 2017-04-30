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
        <div class="panel-heading"><span class="lead">Households</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.household.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Household Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.household.name" id="name"
                                       class="form-control input-sm" placeholder="Enter name of Household" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Household Type</label>
                            <div class="col-md-7">
                                <select required class="form-control" ng-model="ctrl.household.householdType" id="householdType">
                                    <option value="">--Select a Household Type--</option>
                                    <option value="Married">Married</option>
                                    <option value="Single">Single</option>
                                    <option value="Divorced">Divorced</option>
                                    <option value="Widowed">Widowed</option>
                                    <option value="Adult/Children">Adult/Children</option>
                                    <option value="Adult Only">Adult Only</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.household.id ? 'Add' : 'Update'}}"
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
        <div class="panel-heading"><span class="lead">List of Households </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover" ts-wrapper="">
                    <thead>
                    <tr>
                        <th ts-criteria="id">ID</th>
                        <th ts-criteria="name">Household Name</th>
                        <th ts-criteria="householdType">Household Type</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="h in ctrl.getAllHouseholds()" ts-repeat>
                        <td>{{h.id}}</td>
                        <td>{{h.name}}</td>
                        <td>{{h.householdType}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.editHousehold(h.id)" class="btn btn-success custom-width">
                                Edit
                            </button>
                        </td>
                        <td>
                            <button type="button" ng-click="ctrl.removeHousehold(h.id)"
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