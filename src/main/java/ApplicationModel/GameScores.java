package ApplicationModel;


public class GameScores {
    private int game_id;
    private int team1_id;
    private int team2_id;
    private int team1Score;
    private int team2Score;

    public GameScores(int game_id, int team1_id, int team2_id, int team1Score, int team2Score) {
        this.game_id = game_id;
        this.team1_id = team1_id;
        this.team2_id = team2_id;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    // Getter and Setter methods
    public int getGame_ID() {
        return game_id;
    }

    public void setGame_ID(int id) {
        this.game_id = id;
    }

    public int getTeam1_ID() {
        return team1_id;
    }

    public void setTeam1_ID(int id) {
        this.team1_id = id;
    }

    public int getTeam2_ID() {
        return team2_id;
    }

    public void setTeam2_ID(int id) {

        this.team2_id = id;
    }

    public int getTeam1Score() {

        return team1Score;
    }

    public void setTeam1Score(int score) {

        this.team1Score = score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int score) {
        this.team2Score = score;
    }
}
