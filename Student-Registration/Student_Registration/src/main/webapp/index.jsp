<!DOCTYPE html>
<html>
<head>
    <title>Student Registration Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #ecf0f1;
            margin: 0;
            padding: 50px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #2c3e50;
        }
        .container {
            text-align: center;
            background: white;
            padding: 40px 60px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            max-width: 500px;
        }
        h1 {
            margin-bottom: 20px;
            font-weight: 700;
        }
        p {
            font-size: 1.2rem;
            margin-bottom: 30px;
        }
        a {
            text-decoration: none;
            background: #27ae60;
            color: white;
            padding: 12px 30px;
            border-radius: 30px;
            font-weight: 600;
            font-size: 1rem;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background: #1e8449;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Student Registration</h1>
        <p>Manage student details easily with CRUD operations.</p>
        <a href="students?action=list">View Students</a>
    </div>
</body>
</html>
