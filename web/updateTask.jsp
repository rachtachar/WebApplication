<%-- 
    Document   : updateTask
    Created on : Jul 18, 2024, 4:05:41 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Work" %>
<!DOCTYPE html>
<html>
    <body>
        <% Work work = (Work) session.getAttribute("work");%>
        <p>แก้ไขข้อมูล</p>
        <form action="Servlet" method="POST">
            ID: <input type="text" name="id" required><br/>

            ชื่องาน:  <input type="text" name="name" required><br/>

            <label for="Categories">หมวดหมู่งาน: </label>
            <select id="Categories" name="Categories" required>
                <option value="งานบ้าน">งานบ้าน</option>
                <option value="งานที่ทำงาน">งานที่ทำงาน</option>
                <option value="งานส่วนตัว">งานส่วนตัว</option>
                <option value="โปรเจคต์">โปรเจคต์</option>
                <option value="ประชุม">ประชุม</option>    
            </select>

            <br/>รูปแบบงาน: 
            <input type="radio" id="งานกลุ่ม" name="Format" value="งานกลุ่ม" required>
            <label for="notSalty">กลุ่ม</label>
            <input type="radio" id="งานเดี่ยว" name="Format" value="งานเดี่ยว">
            <label for="littleSalty">เดี่ยว</label>

            <br/>รายละเอียด:
            <input type="text" name="Description" >

            <br/>วันที่เริ่ม:
            <input type="text" name="Start" >

            <br/>วันครบกำหนด: 
            <input type="text" name="End" >

            <br/><input type="submit" value="ยืนยัน">
        </form>
        <% session.removeAttribute("work");%>
    </body>
</html>
