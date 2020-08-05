<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Player</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<body><br><br><br><br>


	<center>
		<h1>Adding Players For Wipro Cricket Team</h1>
		<form action="AddPlayer" method='post'>
			<table align="center" = "1" class="table table-striped table-bordered">
				<tr>
					<td>ID</td>
					<td><input type="text" name="ID"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="NAME"></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="AGE"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="EMAIL"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="ADDRESS"></td>
				</tr>
				
				</table>
				<tr>
					<td></td>
					<td><br><input type="submit" value="Add New Player" class="btn btn-primary"></td>
					
				</tr>

				</form>

				<right>

			</center>	
				
				
				
				
			<center>	
				<form action="ShowPlayers.jsp" method='post'>
				
						
						<tr>
							<td></td>

					<td><br><input type="submit" value="Get Player Details" class="btn btn-secondary"></td>
				</tr>
				</form>

				<right>

			
				
				</table>	
			</center>	
				
				<center>
				<form action="Delete.jsp">
					<table>
						
						<tr>
							<td></td>
							<td><br><input type="submit"
								value="Delete The Player" class="btn btn-secondary"></td>
						</tr>

						</form>


						<right>
						</table>
						</center>	
						
						<center>
						
				<form action="Update.jsp">
					<table>
						
						<tr>
							<td></td>
							<td><br><input type="submit"
								value="Update Player Record" class="btn btn-secondary"></td>
						</tr>

						</form>


						<right>
						</table>
						</center>	
</body>
</html>