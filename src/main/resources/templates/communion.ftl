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
        <div class="panel-heading"><span class="lead">Communions</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.communion.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="dob">Date Of Communion</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.communion.communionDate" id="communionDate" class="form-control input-sm"
                                       placeholder="Enter Date of Communion" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Members</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>MEMBER NAME</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="m in ctrl.getAllMembers()">
                        <td>{{m.name}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.setMembers(m.id)" ng-disabled="ctrl.checkMemberIsChecked(m.id) || !ctrl.communion.communionDate" class="btn btn-success btn-sm">Add To List
                            </button>
                        </td>
                        <td>
                            <button type="button" ng-click="ctrl.removeMember(m.id)" ng-disabled="!ctrl.checkMemberIsChecked(m.id) || !ctrl.communion.communionDate" class="btn btn-danger btn-sm">Remove From List
                            </button>
                        </td>

                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <div class="form-actions floatRight">
                    <button type="button" ng-click="ctrl.submit()" class="btn btn-primary btn-sm"
                            ng-disabled="myForm.$pristine || !ctrl.communion.communionDate">Add Communions
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Communions</span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>CHURCH MEMBER ID</th>
                        <th>DATE OF COMMUNION</th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="c in ctrl.getAllCommunions()">
                        <td>{{c.memberId}}</td>
                        <td>{{c.communionDate}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.removeCommunion(c.id)"
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