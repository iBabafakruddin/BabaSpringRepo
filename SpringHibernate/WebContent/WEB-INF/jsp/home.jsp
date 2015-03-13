<html>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
<title>Connect me</title>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="${contextPath}/resources/js/plugins/fancybox/source/helpers/jquery.fancybox-thumbs.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${contextPath}/resources/js/plugins/fancybox/source/helpers/jquery.fancybox-buttons.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${contextPath}/resources/js/plugins/fancybox/source/jquery.fancybox.css" type="text/css" media="screen" />

<script type="text/javascript" src="${contextPath}/resources/js/plugins/common/jquery-1.9.0.min.js"></script>
<script src="${contextPath}/resources/js/plugins/angular/angular.min.js" type="text/javascript"> </script>
<script src="${contextPath}/resources/js/plugins/angular/angular-route.min.js" type="text/javascript"> </script>

<!-- Add mousewheel plugin (this is optional) -->
<script type="text/javascript" src="${contextPath}/resources/js/plugins/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>

<!-- Add fancyBox -->
<script type="text/javascript" src="${contextPath}/resources/js/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
<!-- Optionally add helpers - button, thumbnail and/or media -->
<script type="text/javascript" src="${contextPath}/resources/js/plugins/fancybox/source/helpers/jquery.fancybox-buttons.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/plugins/fancybox/source/helpers/jquery.fancybox-media.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/plugins/fancybox/source/helpers/jquery.fancybox-thumbs.js"></script>

<!-- Chat API -->

<script src="${contextPath}/resources/js/home.js" type="text/javascript"> </script>
<script type="text/javascript">

$(document).ready(function() 
{
	$(".fancybox-button").fancybox({
		prevEffect		: 'none',
		nextEffect		: 'none',
		closeBtn		: false,
		autoPlay : true,
		helpers		: {
			title	: { type : 'inside' },
			buttons	: {}
		}
	});
	
});
	
</script>
<style> .glyphicon-thumbs-up { cursor:pointer } </style>
</head>
<body ng-app='MyApp'>


	<div ng-controller='MainCntrl'>
	 	<!--  <input type="text" ng-model='message' placeHolder="Enter your Name"/> -->
	<h1 style="color:green">Hello  ${user} !</h1>
	
<a  href="${contextPath}/login?check=logout" target="_self"><input type="button" value="logout" class="btn "> </a>		
	<div class="row">
	    <div class="col-md-6 col-md-offset-3">
      <div class="page-header">
        <h1>{{message}}</h1>
      </div>
	<div >
			<c:forEach var="i" begin="1" end="9">
				<a class="fancybox-button" rel="fancybox-button" href="${contextPath}/resources/photos/images/baba${i}.jpg" title="Goa Trip">
				<c:if test="${i eq 1 }">
					<img src="${contextPath}/resources/photos/thumbnails/baba${i}.jpg" alt="" />
				</c:if>
				</a>
			</c:forEach>
	</div>
      	
      
		<div ng-repeat="post in posts | orderBy:'-upvotes'">
		<span style="font-size:20px; margin-left:10px;">
			<!-- <a ng-show='post.link' href={{post.link}} target='_blank'>{{post.title}} </a>- upvotes:{{post.upvotes}}  -->
			<span ng-hide='post.title'></span>{{post.title}}  {{post.upvotes}} 
		</span>	
		<span class="glyphicon glyphicon-thumbs-up" ng-click='incrementUpvotes(post)'/>
		</div>
		
	<form ng-submit='addPost()' style="margin-top:30px;">
	<h3>Comment</h3>
	 <div class="form-group">
		<input type='text' ng-model='title' placeHolder=''/>
	</div>
	<div class="form-group">
		<!-- <input type='text'ng-model='link' placeHolder='Enter Link'/> -->
    </div>	
	<button type='submit' class="btn btn-primary">Post</button>
	</form>
 </div>
 </div>
</body>

</html>		