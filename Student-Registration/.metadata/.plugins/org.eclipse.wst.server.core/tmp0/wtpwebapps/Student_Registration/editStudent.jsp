<%@ page import="com.student.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
    if (student == null) {
        response.sendRedirect("students?action=list");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f4f8;
            margin: 0;
            padding: 40px;
            display: flex;
            justify-content: center;
        }
        .form-container {
            background: white;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.15);
            width: 400px;
        }
        h2 {
            text-align: center;
            color: #34495e;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #34495e;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px 14px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 1rem;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 12px 0;
            background-color: #f39c12;
            border: none;
            border-radius: 25px;
            color: white;
            font-size: 1.1rem;
            font-weight: 700;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #d68910;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #3498db;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Edit Student</h2>
        <form action="students" method="post">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="<%= student.getId() %>" />
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%= student.getName() %>" required />
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= student.getEmail() %>" required />
            
            <label for="course">Course:</label>
            <input type="text" id="course" name="course" value="<%= student.getCourse() %>" required />
            
            <button type="submit">Update Student</button>
        </form>
        <a href="students?action=list" class="back-link">Back to Student List</a>
    </div>
</body>
</html>
