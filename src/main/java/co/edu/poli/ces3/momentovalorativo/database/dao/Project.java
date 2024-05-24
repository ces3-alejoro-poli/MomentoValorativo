package co.edu.poli.ces3.momentovalorativo.database.dao;

import java.util.Date;

public class Project {

    private int id;
    private String projectName;
    private String manager;
    private String details;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public Project(int id, String projectName, String manager, String details, Date createdAt, Date updatedAt, Date deletedAt) {
        this.id = id;
        this.projectName = projectName;
        this.manager = manager;
        this.details = details;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Project(String projectName, String manager, String details) {
        this.projectName = projectName;
        this.manager = manager;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
}
