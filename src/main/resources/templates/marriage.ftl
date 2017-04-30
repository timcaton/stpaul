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
        <div class="panel-heading"><span class="lead">Marriages</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.marriage.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="spouse1">Spouse Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.spouse1" id="spouse1" class="form-control input-sm"
                                       placeholder="Enter Spouse Name" required ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="spouse2">Spouse Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.spouse2" id="spouse2" class="form-control input-sm"
                                       placeholder="Enter Spouse Name" required ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Marriage</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.marriage.marriageDate" id="marriageDate" class="form-control input-sm"
                                       placeholder="Enter Date of Marriage" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="ethnicity">Location of Marriage</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.marriagePlace" id="marriagePlace"
                                       class="form-control input-sm" placeholder="Enter location of Marriage" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="email">Marriage Officiant</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.marriageOfficiant" id="marriageOfficiant"
                                       class="form-control input-sm" placeholder="Enter Marriage Officiant"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Witness Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.witnessName1" id="witnessName1"
                                       class="form-control input-sm" placeholder="Enter Witness Name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Witness Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.witnessName2" id="witnessName2"
                                       class="form-control input-sm" placeholder="Enter Witness Name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="parentName2">License Number</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.licenseNumber" id="licenseNumber"
                                       class="form-control input-sm" placeholder="Enter License Number"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Return Date</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.marriage.returnDate" id="returnDate" class="form-control input-sm"
                                       placeholder="Enter Return Date of Marriage in mm/dd/yyyy format" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Marriage Comment</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.marriage.marriageComment" id="marriageComment"
                                       class="form-control input-sm" placeholder="Enter Marriage Comment"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.marriage.id ? 'Add' : 'Update'}}"
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
        <div class="panel-heading"><span class="lead">List of Marriages</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover" ts-wrapper>
                    <thead>
                    <tr>
                        <th ts-criteria="id">ID</th>
                        <th ts-criteria="spouse1">SPOUSE</th>
                        <th ts-criteria="spouse2">SPOUSE</th>
                        <th ts-criteria="marriageDate">MARRIAGE DATE</th>
                        <th ts-criteria="marriagePlace">MARRIAGE LOCATION</th>
                        <th ts-criteria="marriageOfficiant">OFFICIANT</th>
                        <th ts-criteria="witnessName1">WITNESS</th>
                        <th ts-criteria="witnessName2">WITNESS</th>
                        <th ts-criteria="licenseNumber">LICENSE NUMBER</th>
                        <th ts-criteria="returnDate">RETURN DATE</th>
                        <th ts-criteria="marriageComment">COMMENT</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="m in ctrl.getAllMarriages()">
                        <td>{{m.id}}</td>
                        <td>{{m.spouse1}}</td>
                        <td>{{m.spouse2}}</td>
                        <td>{{m.marriageDate}}</td>
                        <td>{{m.marriagePlace}}</td>
                        <td>{{m.marriageOfficiant}}</td>
                        <td>{{m.witnessName1}}</td>
                        <td>{{m.witnessName2}}</td>
                        <td>{{m.licenseNumber}}</td>
                        <td>{{m.returnDate}}</td>
                        <td>{{m.marriageComment}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.editMarriage(m.id)" class="btn btn-success custom-width">
                                Edit
                            </button>
                        </td>
                        <td>
                            <button type="button" ng-click="ctrl.removeMarriage(m.id)"
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