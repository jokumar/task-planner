<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container" style="height:50%">



		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
	<form:form name='loginForm' method="post">
		<table>
				<tr>
					<td style="padding-right:20px">User:</td>
					<td><input type='text' name='username' style="margin-bottom:10%" ></td>
				</tr>
				<tr/>
				<tr>
					<td style="padding-right:20px">Password:</td>
					<td><input type='password' name='password' style="margin-bottom:10%" /></td>
				</tr>
				<tr>
					<td colspan='2'>
						<button type="submit" class="btn btn-success" style="margin-top:20%">Submit</button>
					</td>
				</tr>
			</table>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>