<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String strD,strE,strF,strG;
 strD=request.getParameter("id1");
 strE=request.getParameter("id2");
 strF=request.getParameter("id3");
 strG=request.getParameter("id4");
 %>
<form action="update.do" method="post" style="width: 500px" >
			<table>
				<h2 align="center">Update Librarian</h2>
				<tr>
				<td><input type="hidden" name="strid" value="<%= strD%>"/></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" value="<%= strE%>" required /></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type="text" name="salary"  value="<%= strF%>" required /></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><input type="text" name="designation" value="<%= strG%>" required /></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Update" /></td>
				</tr>
			</table>
			
		</form>
</body>
</html>