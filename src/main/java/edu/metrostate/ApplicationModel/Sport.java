package edu.metrostate.ApplicationModel;

public class Sport {

    //attributes
    private int sportID;
    private String sportName;
    private String season;
    private String originCountry;

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

    //Will do more later have questions on if sports news should be a subclass of sport or not.
}
