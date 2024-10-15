package edu.metrostate.ApplicationController;
import edu.metrostate.ApplicationModel.FootBallTeam;

import edu.metrostate.ApplicationModel.Sport;
import edu.metrostate.ApplicationView.SportView;

public class SportController {

    private Sport model;
    private SportView sportView;

    public SportController(Sport model, SportView sportView) {
        this.model = model;
        this.sportView = sportView;
        initialize();
    }

    private void initialize() {
        // Populate the view with team data
        sportView.setTeamList(model.getTeams().stream()
                .map(team -> team.getTeamName()) // Assuming each team has a getTeamName() method
                .toList());
    }

}
