package edu.metrostate.ApplicationModel;

import java.util.List;
import java.util.ArrayList;

public class Sport {

    //attributes
    private int sportID;
    private String sportName;
    private String season;
    private String originCountry;
    private List<SportsTeam> teamList;

    //constructor
    public Sport(int sportID, String sportName, String season, String originCountry) {
        this.sportID = sportID;
        this.sportName = sportName;
        this.season = season;
        this.originCountry = originCountry;
    }

    //getter and setter for ID
    public void setID(int sportID) {
        this.sportID = sportID;
    }

    public int getSportID() {
        return this.sportID;
    }

    //getter and setter for sportName
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportName() {
        return this.sportName;
    }

    //getter and setter for season
    public  void setSeason(String season) {
        this.season = season;
    }

    public String getSeason() {
        return this.season;
    }

    //getter and setter for originCountry
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginCountry() {
        return this.originCountry;
    }

    //getter and setter for team list
    public List<SportsTeam> getSportsTeamList() {
        return this.teamList;
    }

    public void setSportsTeamList(List<SportsTeam> teamList) {
        this.teamList = teamList;
    }

    //methods to add and remove teams from the teams lists
    public void addTeam(SportsTeam team) {
        if (!teamList.contains(team)) {
            this.teamList.add(team);
        }
    }

    public void removeTeam(SportsTeam team) {
        this.teamList.remove(team);
    }

    //Will do more later have questions on if sports news should be a subclass of sport or not.
}
