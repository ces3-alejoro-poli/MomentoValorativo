package co.edu.poli.ces3.momentovalorativo.database;

import co.edu.poli.ces3.momentovalorativo.database.dao.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskJdbc implements CRUDtask {

    private final conexionMySQL connMySQL;

    public TaskJdbc() {
        connMySQL = new conexionMySQL("localhost");
    }

    @Override
    public List<Task> getTasks() throws SQLException {
        Connection con = connMySQL.conexion();
        Statement sts = con.createStatement();
        ResultSet rs = sts.executeQuery("SELECT * FROM tasks");
        List<Task> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new Task(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("status"),
                    rs.getInt("priority"),
                    rs.getInt("id_project"),
                    rs.getDate("createdAt"),
                    rs.getDate("updatedAt"),
                    rs.getDate("deletedAt")
            ));
        }
        rs.close();
        sts.close();
        con.close();

        return list;
    }

    @Override
    public List<Task> getByProject(int idProject) throws SQLException {
        Connection con = connMySQL.conexion();
        PreparedStatement sts = con.prepareStatement("SELECT * FROM tasks WHERE id_project = ?");
        sts.setInt(1, idProject);
        ResultSet rs = sts.executeQuery();
        List<Task> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new Task(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("status"),
                    rs.getInt("priority"),
                    rs.getInt("id_project"),
                    rs.getDate("createdAt"),
                    rs.getDate("updatedAt"),
                    rs.getDate("deletedAt")
            ));
        }
        rs.close();
        sts.close();
        con.close();

        return list;
    }

    @Override
    public Map<Integer, Integer> getTaskQuantityForEachProject() throws SQLException {
        Connection con = null;
        Statement sts = null;
        ResultSet rs = null;
        Map<Integer, Integer> taskQuantities = new HashMap<>();

        con = connMySQL.conexion();
        sts = con.createStatement();
        String query = "SELECT id_project, COUNT(*) AS total_tasks FROM tasks GROUP BY id_project";
        rs = sts.executeQuery(query);
        while (rs.next()) {
            int idProject = rs.getInt("id_project");
            int quantity = rs.getInt("total_tasks");
            taskQuantities.put(idProject, quantity);
        }
        rs.close();
        sts.close();
        con.close();

        return taskQuantities;
    }
}
