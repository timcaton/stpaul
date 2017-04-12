<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
    </head>
    <body>

        <div ui-view></div>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/MemberService.js"></script>
        <script src="js/app/MemberController.js"></script>
        <script src="js/app/BapService.js"></script>
        <script src="js/app/BaptismController.js"></script>
        <script src="js/app/HouseholdService.js"></script>
        <script src="js/app/HouseholdController.js"></script>
        <script src="js/app/ConfirmationService.js"></script>
        <script src="js/app/ConfirmationController.js"></script>
        <script src="js/app/FuneralService.js"></script>
        <script src="js/app/FuneralController.js"></script>
        <script src="js/app/MarriageService.js"></script>
        <script src="js/app/MarriageController.js"></script>
    </body>
</html>