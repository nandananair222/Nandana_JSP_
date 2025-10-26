<%@ page language="java" %>
<html>
<head><title>Attendance Form</title></head>
<body>
  <h2>Student Attendance Portal</h2>
  <form action="AttendanceServlet" method="post">
    Student ID: <input type="text" name="studentId"><br><br>
    Date: <input type="date" name="date"><br><br>
    Status:
    <select name="status">
      <option>Present</option>
      <option>Absent</option>
    </select><br><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
