package co.edu.poli.ces3.momentovalorativo.database.dao;

import java.util.Date;

public class Task {

    private int id;
    private String title;
    private String status;
    private int priority;
    private int idProject;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public Task(int id, String title, String status, int priority, int idProject, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.priority = priority;
        this.idProject = idProject;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Task(String title, String status, int priority, int idProject) {
        this.title = title;
        this.status = status;
        this.priority = priority;
        this.idProject = idProject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", priority=" + priority +
                ", idProject=" + idProject +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
