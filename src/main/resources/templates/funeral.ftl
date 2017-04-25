<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Funeral</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.funeral.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Church Member ID</label>
                            <div class="col-md-7">
                                <input readonly type="text" ng-model="ctrl.funeral.memberId" id="memberId" class="form-control input-sm"
                                       placeholder="Enter Church Member ID" required ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Church Member Name</label>
                            <div class="col-md-7">
                                <p>{{member.name}}</p>
                            <#--<input type="text"  ng-model="ctrl.funeral.memberName" id="memberName" class="form-control input-sm"-->
                            <#--placeholder="getMemberName(memberId)" required ng-minlength="1"/>-->
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

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.funeral.id ? 'Add' : 'Update'}}"
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
    <#--<div class="panel panel-default">-->
        <#--<!-- Default panel contents &ndash;&gt;-->
        <#--<div class="panel-heading"><span class="lead">List of Funerals</span></div>-->
        <#--<div class="panel-body">-->
            <#--<div class="table-responsive">-->
                <#--<table class="table table-hover">-->
                    <#--<thead>-->
                    <#--<tr>-->
                        <#--<th>ID</th>-->
                        <#--<th>CHURCH MEMBER ID</th>-->
                        <#--<th>NAME</th>-->
                        <#--<th>FUNERAL DATE</th>-->
                        <#--<th>DEATH DATE</th>-->
                        <#--<th>FUNERAL PLACE</th>-->
                        <#--<th>FUNERAL OFFICIANT</th>-->
                        <#--<th>BURIAL LOCATION</th>-->
                        <#--<th>PALL BEARERS</th>-->
                        <#--<th>FUNERAL COMMENT</th>-->
                        <#--<th width="100"></th>-->
                        <#--<th width="100"></th>-->
                    <#--</tr>-->
                    <#--</thead>-->
                    <#--<tbody>-->
                    <#--<tr ng-repeat="f in ctrl.getAllFunerals()">-->
                        <#--<td>{{f.id}}</td>-->
                        <#--<td>{{f.memberId}}</td>-->
                        <#--<td>{{getMemberName(b.memberId)}}</td>-->
                        <#--<td>{{f.funeralDate}}</td>-->
                        <#--<td>{{f.deathDate}}</td>-->
                        <#--<td>{{f.funeralPlace}}</td>-->
                        <#--<td>{{f.funeralOfficiant}}</td>-->
                        <#--<td>{{f.burialLocation}}</td>-->
                        <#--<td>{{f.pallBearers}}</td>-->
                        <#--<td>{{f.funeralComment}}</td>-->
                        <#--<td>-->
                            <#--<button type="button" ng-click="ctrl.editFuneral(b.id)" class="btn btn-success custom-width">-->
                                <#--Edit-->
                            <#--</button>-->
                        <#--</td>-->
                        <#--<td>-->
                            <#--<button type="button" ng-click="ctrl.removeFuneral(b.id)"-->
                                    <#--class="btn btn-danger custom-width">Remove-->
                            <#--</button>-->
                        <#--</td>-->
                    <#--</tr>-->
                    <#--</tbody>-->
                <#--</table>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
</div>