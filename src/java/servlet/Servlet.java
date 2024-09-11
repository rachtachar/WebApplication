package servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Work;
import controller.DBConnection;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String Categories =request.getParameter("Categories");
        String Format = request.getParameter("Format");
        String Description = request.getParameter("Description");
        String Start =  request.getParameter("Start");
        String End =  request.getParameter("End");
        
        Work work = new Work();
        work.setId(id);
        work.setName(name);
        work.setCategories(Categories);
        work.setFormat(Format);
        work.setDescription(Description);
        work.setStart(Start);
        work.setEnd(End);
        
        DBConnection dbConnection = new DBConnection();
        if(!dbConnection.insertNewTask(work)){
            System.out.println("Error");
        }

        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession(true);
        }

        session.setAttribute("work", work);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addNewTaskSuccess.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}