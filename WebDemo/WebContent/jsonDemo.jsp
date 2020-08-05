<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"> </script>
 <script>
  $(function() {
  var people = [];
   $.getJSON("/Users/krishnamurthypatil/SDETSelenium/WebDemo/WebContent/test.json", function(data) {
     $.each(data.records, function(i, f) {
       var tblRow = "<tr>" + "<td><c:out value=" + f.vEmail + "/></td>" + "<td>" + f.vUserName +  "</td>" + "<td>" + f.nDepartmentId + "</td>" + "<td>" + f.nEnabled + "</td>" + "<td>" + f.department + "</td>" + "<td>" + f.vFatherName + "</td>" + "<td>" + f.vSurname + "</td>" + "<td>" + f.vAfm + "</td>" + "<td>" + f.vUsertype + "</td>" + "<td>" + f.vName + "</td>" + "<td>" + f.nId + "</td>" + "<td>" + f.rolesDesc + "</td>" + "</tr>"
       $(tblRow).appendTo("#userdata tbody");
    });
   });
  });
  </script>
 </head>
 <body>
 <div class="wrapper">
 <div class="profile">
 <table id= "userdata" border="2">
 <thead>
        <th>Email</th>
        <th>User Name</th>
        <th>Department Id</th>
        <th>Enabled</th>
        <th>Department</th>
        <th>Father Name</th>
        <th>Surname</th>
        <th>Afm</th>
        <th>User Type</th>
        <th>Name</th>
        <th>Id</th>
        <th>Roles Desc</th>
    </thead>
    <tbody>
    <c:forEach items="/Users/krishnamurthypatil/SDETSelenium/WebDemo/WebContent/test.json" var="pp">
                <tr>
                    <td><c:out value="${pp.Email}" /></td>
                    <td><c:out value="${pp.vUserName}" /></td>
                   
                </tr>
        </c:forEach>

    </tbody>
   </table>
 </div>
 </div>
 </body>
 </html>