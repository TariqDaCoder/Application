package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.Sport;
import edu.metrostate.ApplicationModel.SportsTeam;
import java.util.List;

public class SportsTeamView {
    private SportsTeam team;

    public SportsTeamView(SportsTeam team){
        this.team = team;
    }

    public void displayTeamInfo(){
        System.out.println("Team ID: " + team.getTeamID());
        System.out.println("Team Name: " + team.getTeamID());
        System.out.println("Team Logo: " + team.getTeamLogo());
        System.out.println("Team Record: " + team.getTeamRecord());
        displayTeamRoster();
    }

    public void displayTeamRoster(){
        List<SportsTeam> roster = team.getTeamRoster();
        System.out.println("Team Roster: ");

        if (roster.isEmpty()){
            System.out.println("No Active players are in this Team");
        }else {
            for (int i = 0; i < roster.size(); i++){
                SportsTeam player = roster.get(i);
                System.out.println(", " );
            }
        }
    }





}
