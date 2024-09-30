package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.SportsTeam;
import edu.metrostate.ApplicationView.SportsTeamView;

public class SportsTeamController {

    private SportsTeam team;
    private SportsTeamView teamView;

    // Constructor
    public SportsTeamController(SportsTeam team, SportsTeamView teamView) {
        this.team = team;
        this.teamView = teamView;
    }

    public void displayTeamInfo() {
        teamView.displayTeamInfo();
    }

    public void displayTeamRoster() {
        teamView.displayTeamRoster();
    }
}
