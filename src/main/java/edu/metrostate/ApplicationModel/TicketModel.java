package edu.metrostate.ApplicationModel;

public class TicketModel {
    private final int id;
    private String title;
    private String description;
    private String status;
    private String assignee;

    public TicketModel(int id, String title, String description, String status, String assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignee = assignee;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public String getAssignee() { return assignee; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
}