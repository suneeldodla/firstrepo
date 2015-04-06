var myBlog=angular.module('myBlog',[]);

myBlog.controller('blogController',['$scope','$http',function($scope,$http)
                             {


//------------------------sending written blog t db----------------------------------------------
$scope.addCategory=function() {
    console.log("Category");
    $scope.category;
    $http({
        method: 'GET',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        url: 'TestServlet'
    }).success(function (data) {

        $scope.category = data;
       // console.log(data);

    });
    //---------------------------------------get list of comments---------------------------------------------------------
    
   // ------------------------insert Comment into db----------------------------------------------------------------------
    $scope.comment={
    		commentText:""
        };
        $scope.postComment = function () {
            console.log("comment");
            alert("commented");
            $http({
                method: 'POST',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                url: 'PostCommentServlet',
                data:$scope.comment

           }).success(function(data){
                $scope.comment=data;
               console.log(data);
            });
        }};

    /*----------------------insert blog into db---------------------*/
    $scope.categoryFormObj={
        categoryName:"",blogName:"",blogContent:"",calender:"",blogImage:"",calenderId:""
    };
    $scope.callBlog = function () {
        console.log("Blog");
        alert("blog added successfully");
        $http({
            method: 'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            url: 'BlogServlet',
            data:$scope.categoryFormObj

       }).success(function(data){
            $scope.cat=data;
           console.log(data);
        });
    
    };
    
    
$scope.viewBlogs=function() {
    console.log("view blog");
    $scope.view;
    $http({
        method: 'GET',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        url: 'ViewServlet'
    }).success(function (data) {

        $scope.view = data;
        console.log(data);

    });

}

            }]);
