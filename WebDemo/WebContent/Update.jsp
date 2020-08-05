<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Player</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>

<body><br><br><br><br>


	<center>
		<h1>Updating Player From The List</h1>
		<br>
						
				<form action="UpdatePlayer" method='post'>
					<table>
						<tr>
							<td>Player ID</td>
							<td><input type="text" name="ID" placeholder="Enter Player ID"></td>
							
						</tr>
						
						<tr>
							<td align="center"></td>
							
							<td colspan="5" allign="center"><br><br><input type="submit"
								value="Update Player" class="btn btn-primary"></td>
						</tr>
	
					</form>

	</center>
						
</body>
</html>