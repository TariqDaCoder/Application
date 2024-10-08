package edu.metrostate.ApplicationView;

public class TicketView {
    public void displayTicketDetails(int id, String title, String description, String status, String assignee) {
        System.out.println("Ticket Details:");
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Assignee: " + assignee);
    }

    public void displayTicketCreated() {
        System.out.println("Ticket created successfully.");
    }

    public void displayTicketUpdated() {
        System.out.println("Ticket updated successfully.");
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }
}
