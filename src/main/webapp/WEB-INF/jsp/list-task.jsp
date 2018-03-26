<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container" style="height:50%">
		<table class="table table-striped">
			<caption>My Task List </caption>
			<thead>
				<tr>
					<th>Category</th>
					<th>Name</th>
					<th>Description</th>
					<th>Start Date</th>
					<th>Target Date</th>
					<th>Last Updated</th>
					<th>Status</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${taskObj}" var="todo">
					<tr>
						<td>${todo.taskCategory}</td>
						<td>${todo.name}</td>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.createdDate}" pattern="dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${todo.targetCompletion}" pattern="dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${todo.updatedDate}" pattern="dd/MM/yyyy"/></td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-success"
							href="update-task?id=${todo.taskId}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="delete-task/${todo.taskId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-success" href="add-task">Add a Task</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>