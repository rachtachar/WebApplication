<%@page import="model.Work"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Added Successfully</title>
</head>
<body>
<% Work work = (Work) session.getAttribute("work"); %>
<h1>Task added successfully!</h1>
<p>ID:  <%= work.getId() %></p>
<p>ชื่องาน: <%= work.getName() %></p>
<p>หมวดหมู่งาน: <%= work.getCategories() %></p>
<p>รูปแบบงาน: <%= work.getFormat() %>:</p>
<p>รายละเอียด: <%= work.getDescription() %></p>
<p>วันที่เริ่ม: <%= work.getStart() %></p>
<p>วันครบกำหนด: <%= work.getEnd() %></p>
<a href="updateTask.jsp">แก้ไขข้อมูล</a>
</body>
</html>