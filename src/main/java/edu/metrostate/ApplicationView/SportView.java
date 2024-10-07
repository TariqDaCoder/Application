package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.Sport;
import edu.metrostate.ApplicationModel.SportsTeam;
import java.util.List;

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

    public void displaySportTeams() {
        List<SportsTeam> sportsTeamList = sport.getSportsTeamList();
        System.out.println("Teams: ");

        if (sportsTeamList.isEmpty()) {
            System.out.println("No teams in this sport");
        } else {
            for (int i = 0; i < sportsTeamList.size(); i++) {
                SportsTeam team = sportsTeamList.get(i);
                System.out.println(", ");
            }
        }

    }

}
