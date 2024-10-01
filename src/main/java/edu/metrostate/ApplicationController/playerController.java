package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.Player;
import edu.metrostate.ApplicationView.playerView;

import java.io.File;
import java.util.Map;

public class playerController {
    private Player model;
    private playerView view;

    // Constructor
    public playerController(Player model, playerView view) {
        this.model = model;
        this.view = view;
    }

    public void displayProfilePicture() {
        Map<File, Object> profilePicture = model.getProfilePicture();
        view.displayProfilePicture(profilePicture);
    }

    public void displayPlayerDetails() {
        view.displayPlayerDetails(model);
    }

    public void displayPlayerStats() {
        view.displayPlayerStats(model);
    }
}
