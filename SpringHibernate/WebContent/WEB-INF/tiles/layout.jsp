<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body >
	<div id="wrapper" class="whitebg">
		<div id="header"> <tiles:insertAttribute name="header" /></div>
		<div>
			<div style="height:auto"> <tiles:insertAttribute name="menu" /></div>
			<div class="height100p">
			    
    			<div id="maincontent">
	    			<div id="content" class="contentarea">
						<tiles:insertAttribute name="body" />
					</div>
				</div>	
			</div>
		</div>	
	  <div class="push">
	</div>
	</div>
	<div><tiles:insertAttribute name="footer" /></div>
</body>
</html>
