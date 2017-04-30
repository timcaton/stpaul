<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">St. Paul's Lutheran Church</span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.home.id"/>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <div class="col-md-7">
                                <a href="#/memberLanding">Members</a>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <div class="col-md-7">
                                <a href="#/guest">Guests</a>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <div class="col-md-7">
                                <a href="#/marriage">Marriage</a>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <div class="col-md-7">
                                <a href="#/contributionsLanding">Contributions</a>
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <div class="col-md-7">
                            <a href="#/communion">Communion</a>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <div class="col-md-7">
                            <a href="#/report">Reports</a>
                        </div>
                    </div>
            </div>
            </div>

                </form>
            </div>
        </div>
    </div>
</div>