<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>Baba Sprinf Demo App</title>
</head>

<body class="login">

<div id="wrapper" class="fullbg_img"> 
	<div id="header"><div class="logo"></div></div>
    <form name="frm" method="post"  action="${contextPath}/j_spring_security_check"  >
    			<div class="gray_txt">User Name</div>
            	<div class="mar_b5 login_txtfld"><input id="j_username" name="j_username" type="text" size="50" maxlength="100" title="Enter user Name" /></div>
            	<div class="gray_txt">Password</div>
                <div class="mar_b5 login_txtfld"><input type="password"  id="j_password" name="j_password" size="50" maxlength="100" title="Eneter Password" /></div>
                <div class="float_r login_btn">
     				<input type="submit" value="Login"></input>&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset"></input>
             	</div>
            	<div class="float_l">
            	<c:choose>
            		<c:when test="${screenMsgType eq 'logout'}">
            			<div id="spanError" name="spanError" class="errormsg-login">
	    					<c:out value="${screenMsg}" />
             			</div>
            		</c:when>
	            	<c:when test="${screenMsgType eq 'invalidCredentials'}">
	            			<div id="spanError" class="errormsg-login" style="color: red">
	    						<c:out value="${screenMsg}" escapeXml="false" />
             				</div>
	            	</c:when>
	            	<c:otherwise>
	            			<div id="spanError" class="errormsg-login" style="color: red">
	    						<c:out value="${screenMsg}" escapeXml="false" />
             				</div>
	            	</c:otherwise>	
            	</c:choose>
    </form>

</body>
</html>
