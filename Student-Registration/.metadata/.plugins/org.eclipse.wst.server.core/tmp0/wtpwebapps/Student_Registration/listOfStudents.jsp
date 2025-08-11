<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f2f5;
            padding: 30px 15px;
            color: #333;
        }
        h2 {
            text-align: center;
            color: #34495e;
            margin-bottom: 30px;
            font-weight: 700;
        }
        .btn-add {
            display: block;
            width: max-content;
            margin: 0 auto 30px auto;
            background: #27ae60;
            padding: 12px 28px;
            color: white;
            font-weight: 600;
            border-radius: 25px;
            text-decoration: none;
            box-shadow: 0 6px 12px rgba(39, 174, 96, 0.3);
            transition: background-color 0.3s ease;
        }
        .btn-add:hover {
            background: #1e8449;
        }
        table {
            width: 90%;
            max-width: 900px;
            margin: 0 auto 50px auto;
            border-collapse: separate;
            border-spacing: 0 12px;
            background: white;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            border-radius: 12px;
            overflow: hidden;
        }
        th, td {
            padding: 16px 22px;
            text-align: left;
            color: #34495e;
        }
        th {
            background: #34495e;
            color: white;
            font-weight: 600;
            letter-spacing: 0.8px;
            font-size: 1rem;
        }
        tr {
            background: #fafafa;
            border-radius: 12px;
            box-shadow: inset 0 -1px 0 rgba(0,0,0,0.05);
            transition: background-color 0.25s ease;
        }
        tr:hover {
            background: #d5f0e1;
        }
        td:last-child {
            display: flex;
            gap: 15px;
        }
        .btn {
            padding: 8px 18px;
            border-radius: 20px;
            color: white;
            font-size: 0.9rem;
            font-weight: 600;
            text-decoration: none;
            box-shadow: 0 3px 6px rgba(0,0,0,0.15);
            transition: background-color 0.3s ease;
            cursor: pointer;
            white-space: nowrap;
        }
        .btn-edit {
            background: #f39c12;
            box-shadow: 0 4px 8px rgba(243, 156, 18, 0.3);
        }
        .btn-edit:hover {
            background: #d68910;
        }
        .btn-delete {
            background: #e74c3c;
            box-shadow: 0 4px 8px rgba(231, 76, 60, 0.3);
        }
        .btn-delete:hover {
            background: #c0392b;
        }
        @media (max-width: 600px) {
            table, th, td {
                font-size: 0.85rem;
            }
            td:last-child {
                flex-direction: column;
                gap: 8px;
            }
            .btn {
                width: 100%;
                text-align: center;
            }
            .btn-add {
                width: 100%;
                padding: 14px 0;
            }
        }
    </style>
</head>
<body>
    <h2>Student List</h2>
    <a href="students?action=new" class="btn-add">Add New Student</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Actions</th>
        </tr>
        <% if (students != null && !students.isEmpty()) {
            for (Student s : students) { %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCourse() %></td>
                <td>
                    <a href="students?action=edit&id=<%= s.getId() %>" class="btn btn-edit">Edit</a>
                    <a href="students?action=delete&id=<%= s.getId() %>" class="btn btn-delete" onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
                </td>
            </tr>
        <%  }
          } else { %>
            <tr><td colspan="5" style="text-align:center;">No students found.</td></tr>
        <% } %>
    </table>
</body>
</html>