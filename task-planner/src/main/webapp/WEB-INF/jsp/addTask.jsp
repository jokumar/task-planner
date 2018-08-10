<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container" style="height:50%">
	<form:form method="post" commandName="task">
		<form:hidden path="taskId" />
		<fieldset class="form-group">
			<form:label path="taskCategory">Task Category</form:label>
			<form:input path="taskCategory" type="text" class="form-control"
				required="required" />
			<form:errors path="taskCategory" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="name">Task Name</form:label>
			<form:input path="name" type="text" class="form-control"
				required="required" />
			<form:errors path="name" cssClass="text-warning" />
		</fieldset>
	
		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="done">Status</form:label>
			<form:select path="done" class="form-control" required="required" >
				<form:option value="Open">Open</form:option>
				<form:option value="Closed">Closed</form:option>
				</form:select>
			<form:errors path="done" cssClass="text-warning" />
		</fieldset>
	
		<fieldset class="form-group">
			<form:label path="targetCompletion">Target Date</form:label>
			<form:input path="targetCompletion" type="text" class="form-control"
				required="required" />
			<form:errors path="targetCompletion" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Save</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>