package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.Sport;

public class SportView {
    private Sport sport;

    public SportView(Sport sport) {
        this.sport = sport;
    }

    public void displaySportInfo() {
        System.out.println("Sport ID: " + this.sport.getSportID());
        System.out.println("Sport Name: " + this.sport.getSportName());
        System.out.println("Sport Season: " + this.sport.getSeason());
        System.out.println("Sport's Origin Country" + this.sport.getOriginCountry());
    }

}
