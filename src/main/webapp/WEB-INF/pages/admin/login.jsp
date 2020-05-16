<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

${message}
<br>
<hr>
<br>
	<form:form action="loginprocess" modelAttribute="userobj">
		Username:<form:input path ="username"/><br><br>
		Password:<form:input path ="password"/><br><br>
		
		<input type ="submit"/>
	</form:form>
	<a href="/spring-mvc-hibernate-xml/users">Get Users</a>