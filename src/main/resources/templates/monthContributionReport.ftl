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
                            <label class="col-md-2 control-label" for="dob">Year</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.year" id="year">
                                    <option value="">--Select A Year--</option>
                                    <option value="116">2016</option>
                                    <option value="117">2017</option>
                                    <option value="118">2018</option>
                                    <option value="119">2019</option>
                                    <option value="120">2020</option>
                                    <option value="121">2021</option>
                                    <option value="122">2022</option>
                                    <option value="123">2023</option>
                                    <option value="124">2024</option>
                                    <option value="125">2025</option>
                                    <option value="126">2026</option>
                                    <option value="127">2027</option>
                                    <option value="128">2028</option>
                                    <option value="129">2029</option>
                                    <option value="130">2030</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-6">
                            <label class="col-md-2 control-label" for="dob">Month</label>
                            <div class="col-md-7">
                                <select  class="form-control" ng-model="ctrl.month" id="month">
                                    <option value="">--Select A Month--</option>
                                    <option value="0">January</option>
                                    <option value="1">February</option>
                                    <option value="2">March</option>
                                    <option value="3">April</option>
                                    <option value="4">May</option>
                                    <option value="5">June</option>
                                    <option value="6">July</option>
                                    <option value="7">August</option>
                                    <option value="8">September</option>
                                    <option value="9">October</option>
                                    <option value="10">November</option>
                                    <option value="11">December</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <button type="button" ng-click="ctrl.monthContributions()"
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
                    <tr ng-repeat="c in ctrl.monthContributionList">
                        <td>{{c.purpose}}</td>
                        <td>{{c.amount}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>