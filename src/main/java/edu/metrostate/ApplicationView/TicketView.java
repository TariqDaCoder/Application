package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.TicketModel;

public class TicketView {
    public void displayTicketDetails(TicketModel ticket) {
        System.out.println("Ticket Details:");
        System.out.println("ID: " + ticket.getId());
        System.out.println("Title: " + ticket.getTitle());
        System.out.println("Description: " + ticket.getDescription());
        System.out.println("Status: " + ticket.getStatus());
        System.out.println("Assignee: " + ticket.getAssignee());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }
}