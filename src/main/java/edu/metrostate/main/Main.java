package edu.metrostate.main;

import edu.metrostate.ApplicationController.GameScoresController;
import edu.metrostate.ApplicationController.TicketController;
import edu.metrostate.ApplicationModel.GameScoresModel;
import edu.metrostate.ApplicationModel.TicketModel;
import edu.metrostate.ApplicationView.GameScoresView;
import edu.metrostate.ApplicationView.TicketView;

public class Main {
    public static void main() {
        System.out.println("test");
        GameScoresModel model = new GameScoresModel(1, 101, 102, 0, 0);
        GameScoresView view = new GameScoresView();
        GameScoresController controller = new GameScoresController(model, view);

        controller.updateView(); // Display initial scores
        controller.updateScores(3, 2); // Update and display new scores
        TicketModel model_2 = new TicketModel(1, "Initial Bug", "This is a bug", "Open", "John Doe");

        // Create the view
        TicketView view_2 = new TicketView();

        // Create the controller
        TicketController controller_2 = new TicketController(model_2, view_2);

        // Display initial ticket details
        controller.updateView();

        // Update the ticket
        controller_2.updateTicket("Updated Bug", "This bug has been investigated", "In Progress", "Jane Smith");

    }
}
