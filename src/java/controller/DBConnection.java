package controller;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import model.Work;

public class DBConnection {

    public boolean insertNewTask(Work work) {
        boolean result = true;
        Connection connection = null;
        Statement statement = null;
        try {
            // โหลดไดรเวอร์ MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/todolist",
                    "root", "");

            statement = connection.createStatement();

//             String updatequery = "UPDATE  work "
//                    + " id='" + work.getId() + "',names="+ "'"+work.getName() + "',Categories="
//                    + "'" +  work.getCategories()+ "',Formats="
//                    + "'" + work.getFormat()+ "',Descriptions="
//                    + "'" + work.getDescription()+ "',Start="
//                    + "'" +  work.getStart() + "',End="
//                    + "'" + work.getEnd() + "'WHERE id="
//                     + "'" + work.getId()+"'"; 
//            System.out.println("........SQL: " + updatequery);
            //สร้าง query
            String query = "INSERT INTO work "
                    + "(id, names, Categories, Formats, Descriptions, Start, End) "
                    + "VALUES('" + work.getId() + "'," + "'"+ work.getName() + "',"
                    + "'" + work.getCategories() + "',"
                    + "'" + work.getFormat() + "',"
                    + "'" + work.getDescription() + "',"
                    + "'" + work.getStart() + "',"
                    + "'" + work.getEnd() + "')" + "ON DUPLICATE KEY UPDATE names = VALUES(names),Categories = VALUES(Categories),Formats = VALUES(Formats),Descriptions = VALUES(Descriptions),Start = VALUES(Start), End = VALUES(End)";
            System.out.println("........SQL: " + query);

            // executeUpdate จะส่งคืนจำนวนแถวที่ถูกอัปเดต
            int i = statement.executeUpdate(query);

            if (i != 0) {

                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ปิด statement และ connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
