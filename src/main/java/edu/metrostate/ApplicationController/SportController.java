package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.Sport;
import edu.metrostate.ApplicationView.SportView;

public class SportController {

    private Sport sport;
    private SportView sportView;

    public SportController(Sport sport, SportView sportView) {
        this.sport = sport;
        this.sportView = sportView;
    }

    public void displaySportInfo() {
        sportView.displaySportInfo();
    }
}
