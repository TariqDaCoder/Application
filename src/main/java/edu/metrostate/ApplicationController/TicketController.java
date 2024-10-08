package edu.metrostate.ApplicationController;
import edu.metrostate.ApplicationModel.TicketModel;
import edu.metrostate.ApplicationView.TicketView;

public class TicketController {
    private final TicketModel model;
    private final TicketView view;

    public TicketController(TicketModel model, TicketView view) {
        this.model = model;
        this.view = view;
    }

    public void setTicketTitle(String title) {
        model.setTitle(title);
    }

    public void setTicketDescription(String description) {
        model.setDescription(description);
    }

    public void setTicketStatus(String status) {
        model.setStatus(status);
    }

    public void setTicketAssignee(String assignee) {
        model.setAssignee(assignee);
    }

    public void updateView() {
        view.displayTicketDetails(
                model.getId(),
                model.getTitle(),
                model.getDescription(),
                model.getStatus(),
                model.getAssignee()
        );
    }
}