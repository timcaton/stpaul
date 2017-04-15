<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Baptisms</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.baptism.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Church Member ID</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.memberId" ng-change="setMember()"  id="memberId" class="form-control input-sm"
                                       placeholder="Enter Church Member ID" required ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Church Member Name</label>
                            <div class="col-md-7">
                                <p>{{member.name}}</p>
                                <#--<input type="text"  ng-model="ctrl.baptism.memberName" id="memberName" class="form-control input-sm"-->
                                       <#--placeholder="getMemberName(memberId)" required ng-minlength="1"/>-->
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Baptism</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.baptismDate" id="dob" class="dob form-control input-sm"
                                       placeholder="Enter Date of Baptism in mm/dd/yyyy format" required ng-minlength="10"
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
                            <label class="col-md-2 control-label" for="address">Sponsor Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.sponsorName" id="sponsorName"
                                       class="form-control input-sm" placeholder="Enter sponsor name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Witness Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.witnessName" id="witnessName"
                                       class="form-control input-sm" placeholder="Enter witness name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Parent Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.baptism.parentName1" id="parentName1"
                                       class="form-control input-sm" placeholder="Enter parent name"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="parentName2">Parent Name</label>
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
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.baptism.id ? 'Add' : 'Update'}}"
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
        <div class="panel-heading"><span class="lead">List of Baptisms </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>CHURCH MEMBER ID</th>
                        <th>NAME</th>
                        <th>LOCATION</th>
                        <th>OFFICIANT</th>
                        <th>SPONSOR</th>
                        <th>WITNESS</th>
                        <th>PARENT</th>
                        <th>PARENT</th>
                        <th>COMMENTS</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="b in ctrl.getAllBaptisms()">
                        <td>{{b.id}}</td>
                        <td>{{b.memberId}}</td>
                        <td>{{getMemberName(b.memberId)}}</td>
                        <td>{{b.baptismLocation}}</td>
                        <td>{{b.baptismOfficiant}}</td>
                        <td>{{b.sponsorName}}</td>
                        <td>{{b.witnessName}}</td>
                        <td>{{b.parentName1}}</td>
                        <td>{{b.parentName2}}</td>
                        <td>{{b.baptismComment}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.editBaptism(b.id)" class="btn btn-success custom-width">
                                Edit
                            </button>
                        </td>
                        <td>
                            <button type="button" ng-click="ctrl.removeBaptism(b.id)"
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