package co.edu.poli.ces3.momentovalorativo.database;

import co.edu.poli.ces3.momentovalorativo.database.dao.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CRUDtask {

    public List<Task> getTasks() throws SQLException;
    public List<Task> getByProject(int idProject) throws SQLException;
    public Map<Integer, Integer> getTaskQuantityForEachProject() throws SQLException;
}
