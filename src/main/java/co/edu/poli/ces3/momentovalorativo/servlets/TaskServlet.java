package co.edu.poli.ces3.momentovalorativo.servlets;

import co.edu.poli.ces3.momentovalorativo.database.TaskJdbc;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "TaskServlet", urlPatterns = {"/tasks", "/tasks-project", "/quantity-tasks-project"})
public class TaskServlet extends HttpServlet {
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        gson = new GsonBuilder().create();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        TaskJdbc task = new TaskJdbc();

        String servletPath = req.getServletPath();

        switch (servletPath) {
            case "/tasks":
                returnAllTasks(task, out, resp);
                break;
            case "/tasks-project":
                String idProjectString = req.getParameter("idProject");
                if (idProjectString != null) {
                    try {
                        int idProject = Integer.parseInt(idProjectString);
                        returnTasksByProject(task, idProject, out, resp);
                    } catch (NumberFormatException e) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid idProject parameter");
                    }
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "idProject parameter is missing");
                }
                break;
            case "/quantity-tasks-project":
                returnQuantityForEachProject(task, out, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid path: " + servletPath);
                break;
        }
    }

    public void destroy() {
    }

    public void returnAllTasks(TaskJdbc task, PrintWriter out, HttpServletResponse resp){
        try {
            out.print(gson.toJson(task.getTasks()));
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Error fetching tasks: " + e.getMessage()));
            e.printStackTrace();
        } finally {
            out.flush();
        }
    }

    public void returnTasksByProject(TaskJdbc task, int idProject, PrintWriter out, HttpServletResponse resp){
        try {
            out.print(gson.toJson(task.getByProject(idProject)));
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Error fetching tasks: " + e.getMessage()));
            e.printStackTrace();
        } finally {
            out.flush();
        }
    }

    public void returnQuantityForEachProject(TaskJdbc task, PrintWriter out, HttpServletResponse resp){
        try {
            out.print(gson.toJson(task.getTaskQuantityForEachProject()));
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print(gson.toJson("Error fetching tasks: " + e.getMessage()));
            e.printStackTrace();
        } finally {
            out.flush();
        }
    }
}
