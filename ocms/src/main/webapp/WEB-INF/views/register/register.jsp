<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!--[if lte IE 6]>
  <link rel="stylesheet" type="text/css" media="all" href="ie6.css" />
<![endif]-->
<!-- start page container 2 div-->
<h1>
	<spring:message code="register.register.title" />
</h1>
<script type="text/javascript">
	$(document).ready(function() {
		$("#dateOfBirth").datepicker({
			showOn : "button",
			buttonImage : "resources/images/ico_calendar.gif",
			buttonImageOnly : true,
			appendText : ' yyyy-mm-dd ',
			buttonText : 'Date selector 1',
			align : "middle",
			changeMonth : true,
			changeYear : true,
			defaultDate : null,
			showOn : 'both',
			alt : 'Date Selector 1',
			cursor : 'pointer',
			dateFormat : 'yy-mm-dd',
			beforeShow : function(input, inst) {
				$('ui-widget-header').css({
					"color" : 'red',
					"width" : "100%"
				});
				$('#ui-datepicker-div').css({
					"z-index" : "2"
				});

			}

		});

	});
</script>


<script type="text/javascript">
	$(document).ready(function() {
		$.get("/master/casetypes", function(data, status) {
			$.each(data, function(key, val) {
				//alert('key and values are ' + key + '  ' + val);
			});
		});

	});
</script>

<div id="page-container" class="resize">
	<div id="page-content-inner" class="resize">

		<!-- start col-main -->

		
			<!-- start main content  -->
			<div class="main-content resize">

				<div class="action-container" style="display: none;"></div>

                
				<h1>Signup form</h1>
				<p></p>
				<br clear="all" />
		
					<div id="error">
						<spring:hasBindErrors name="user">
							<font color="red"> <c:forEach items="${errors.allErrors}"
									var="error">
									<spring:message code="${error.code}"
										text="${error.defaultMessage}" />
									<br />
								</c:forEach>
							</font>
						</spring:hasBindErrors>
					</div>
					<form:form method="post" action="register" id="signUpForm"
						modelAttribute="user">
						<!-- <form id="signUpForm" type="actionForm" commandName="user" action="register"
								method="post">
 -->

						<div class="error" style="display: none;">
							<img src="resources/images/warning.gif" alt="Warning!" width="24"
								height="24" style="float: left; margin: -5px 10px 0px 0px;" />
							<span></span>.<br clear="all" />
						</div>


						<table width="90%">
							<tr>
								<td class="label"><label for="emailId">Email Id:</label></td>
								<td class="field"><form:input path="emailId" type="email"
										class="required email" value="user@careerscale.in"
										tabindex="1" /></td>
							</tr>
							<tr>
								<td class="label"><label for="password">Password:</label></td>

								<td class="field"><form:input path="password"
										type="password" class="password" value="test123" tabindex="2"
										maxlength="40" /></td>
							</tr>
							<tr>
								<td class="label"><label for="confirmPassword">Retype
										Password:</label></td>
								<td class="field"><input id="confirmPassword"
									class="required" equalTo="#password" maxlength="40"
									name="password2" size="20" type="password" tabindex="3"
									value="test123" />
									<div class="formError"></div></td>
							</tr>
							<tr>
								<td class="label"><label for="firstName">First
										Name:</label></td>
								<td class="field"><form:input path="firstName" type="text"
										class="required" value="FirstName" tabindex="4" maxlength="40" />
								</td>
							</tr>
							<tr>
								<td class="label"><label for="lastName">Last Name:</label></td>
								<td class="field"><form:input path="lastName" type="text"
										class="required" value="lastName" tabindex="5" maxlength="40" />
								</td>
							</tr>
							<tr>
								<td class="label"><label for="dateOfBirth">Birth
										Date:</label></td>
								<td class="field"><form:input path="dateOfBirth"
										type="text" class="required date" tabindex="6" maxlength="15"
										value="1980-01-01" />
							</tr>
							
							
							<tr>
								<td class="label"><label for="caseTypes" title='Please select all type of cases that you want to informed about'>Case Types </label></td>
								<td class="field">
								 	 <form:select path="caseTypes" multiple="true">
                				    	<form:options items="${user.caseMasterTypes}"  itemValue="id" itemLabel="name" />
                					</form:select>
            					</td>
							</tr>
							
								<tr>
								<td class="label"><label for="helpTypes" title='Please select how many ways you want to help others'>Help Category Types </label></td>
								<td class="field">
								 	 <form:select path="helpTypes" multiple="true">
                				    	<form:options items="${user.helpMasterTypes}"  itemValue="id" itemLabel="name" />
                					</form:select>
            					</td>
							</tr>
							
							<tr>
								<td></td>
								<td>
									<div class="buttonSubmit">
										<span></span> <input class="formButton" type="submit"
											value="Signup" style="width: 140px" tabindex="14" />
									</div>

								</td>

							</tr>
						</table>
						<br />
						<br />
					</form:form>
					<!-- </form> -->
					<br clear="all" />


			</div>
			<!-- end main content  -->
			<br />
		
		<!-- end col-main -->

		<!-- <!-- start left col
		<div id="col-left" class="nav-left-back empty resize"
			style="position: absolute; min-height: 400px;">
			<div class="col-left-header-tab" style="position: absolute;">Signup</div>
			<div class="nav-left"></div>


			<div class="left-nav-callout png"
				style="top: 15px; margin-bottom: 100px;">
				<img src="resources/images/left-nav-callout-long.png" class="png"
					alt="" />
				<h6>Sign Up Process</h6>
				<a
					style="background-image: url(resources/images/step1-24.gif); font-weight: normal; text-decoration: none; cursor: default;">Provide
					your basic information.</a> <a
					style="background-image: url(resources/images/step2-24.gif); font-weight: normal; text-decoration: none; cursor: default;">Chose
					the type of cases you are interested in.</a> <a
					style="background-image: url(resources/images/step3-24.gif); font-weight: normal; text-decoration: none; cursor: default;">Complete
					registration, validate your email/phone to get updates.</a>
			</div>


			<br clear="all" />
		</div>
		end left col --> 
		<div id="col-left" >
		
    <nav>
      <ul id="nav">
        <li><a href="#">Animation</a>
          <ul>
            <li><a href="http:/www.google.com/search?q=design+cartoons+animation">Cartoons</a></li>
            <li><a href="http:/www.google.com/search?q=design+comic+strips+inspiration">Comic Strips</a></li>
            <li><a href="http:/www.google.com/search?q=how+to+clip+video+footage">Video Clips</a></li>
            <li><a href="http:/www.google.com/search?q=design+create+animated+gifs">Web GIFs</a></li>
          </ul>
        </li>
        <li><a href="#">Graphic Design</a>
          <ul>
            <li><a href="http:/www.google.com/search?q=photoshop+tutorials+graphics+design">Adobe Photoshop</a></li>
            <li><a href="http:/www.google.com/search?q=digital+branding+graphics+logos">Branding &amp; Logos</a></li>
            <li><a href="http:/www.google.com/search?q=graphics+design+marketing">Digital Marketing</a></li>
            <li><a href="http:/www.google.com/search?q=graphic+design+illustrations">Illustrations</a></li>
            <li><a href="http:/www.google.com/search?q=infographics+inspiration">Infographics</a></li>
            <li><a href="http:/www.google.com/search?q=product+design+inspiration">Product Design</a></li>
          </ul>
        </li>
        <li><a href="#">Digital Photography</a>
          <ul>
            <li><a href="http:/www.google.com/search?q=cityscape+photography">Cityscapes</a></li>
            <li><a href="http:/www.google.com/search?q=water+ocean+photography">Oceans</a></li>
            <li><a href="http:/www.google.com/search?q=wide+angle+lens+photography">Wide-Angle Lens</a></li>
            <li><a href="http:/www.google.com/search?q=wildlife+photography">Wildlife</a></li>
          </ul>
        </li>
        <li><a href="#">Print &amp; Identity</a>
          <ul>
            <li><a href="http:/www.google.com/search?q=branding+identity+print+design">Branding</a></li>
            <li><a href="http:/www.google.com/search?q=business+cards+design">Business Cards</a></li>
            <li><a href="http:/www.google.com/search?q=print+design+letterpress">Letterpress</a></li>
            <li><a href="http:/www.google.com/search?q=print+poster+artwork">Poster Art</a></li>
          </ul>
        </li>
        <li><a href="#">Programming</a>
          <ul>
            <li><a href="http:/www.google.com/search?q=learn+css3+web+development">CSS3</a></li>
            <li><a href="http:/www.google.com/search?q=learn+html5+web+development">HTML5</a></li>
            <li><a href="http:/www.google.com/search?q=javascript+jquery+tutorials">JavaScript &amp; jQuery</a></li>
            <li><a href="http:/www.google.com/search?q=web+development+mysql">MySQL Databases</a></li>
            <li><a href="http:/www.google.com/search?q=wordpress+programming">Wordpress CMS</a></li>
          </ul>
        </li>
        <li><a href="#">Web Design</a>
          <ul>
            <li><a href="http:/www.google.com/search?q=web+design+icons">Icons</a></li>
            <li><a href="http:/www.google.com/search?q=web+design+tutorials">Tutorials</a></li>
            <li><a href="http:/www.google.com/search?q=web+design+user+interface">User Interfaces</a></li>
            <li><a href="http:/www.google.com/search?q=web+design">Website Layouts</a></li>
          </ul>
        </li>
      </ul>
    </nav>
  </div>

	</div>
</div>
<!-- end page container 2 divs-->


