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
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.guest.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="title">Guest Name</label>
                            <div class="col-md-7">
                            <input type="text"  ng-model="ctrl.guest.name" id="name" class="form-control input-sm"
                            placeholder="Enter Guest Name" required ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="address">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.guest.address" id="address"
                                       class="form-control input-sm" placeholder="Enter Address of Guest" required
                                       ng-minlength="1"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="phone">Phone Number</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.guest.phone" id="phone"
                                       class="form-control input-sm" placeholder="Enter Guest Phone"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="homeChurch">Home Church</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.guest.homeChurch" id="homeChurch"
                                       class="form-control input-sm" placeholder="Enter Home Church"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="communionDate">Initial Communion Date</label>
                            <div class="col-md-7">
                                <input type="date" ng-model="ctrl.guest.communionDate" id="communionDate" class="form-control input-sm"
                                       placeholder="Enter Date of Guest Communion" required ng-minlength="10"
                                       ng-maxlength="10"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="guestEmail">Guest Email</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.guest.guestEmail" id="guestEmail"
                                       class="form-control input-sm" placeholder="Enter Email"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-label" for="guestComment">Guest Comment</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.guest.guestComment" id="guestComment"
                                       class="form-control input-sm" placeholder="Enter Guest Comments"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="{{!ctrl.guest.id ? 'Add' : 'Update'}}"
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
        <div class="panel-heading"><span class="lead">List of Guests </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>ADDRESS</th>
                        <th>PHONE</th>
                        <th>HOME CHURCH</th>
                        <th>COMMUNION DATE</th>
                        <th>GUEST EMAIL</th>
                        <th>GUEST COMMENTS</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="g in ctrl.getAllGuests()">
                        <td>{{g.id}}</td>
                        <td>{{g.name}}</td>
                        <td>{{g.address}}</td>
                        <td>{{g.phone}}</td>
                        <td>{{g.homeChurch}}</td>
                        <td>{{g.communionDate}}</td>
                        <td>{{g.guestEmail}}</td>
                        <td>{{g.guestComment}}</td>
                        <td>
                            <button type="button" ng-click="ctrl.editGuest(g.id)" class="btn btn-success custom-width">
                                Edit
                            </button>
                        </td>
                        <td>
                            <button type="button" ng-click="ctrl.removeGuest(g.id)"
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