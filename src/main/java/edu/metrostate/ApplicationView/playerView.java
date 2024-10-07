package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.Player;

import java.io.File;
import java.util.Map;

public class playerView implements Player{

    public void displayProfilePicture(Map<File, Object> profilePicture) {
        for (File file : profilePicture.keySet()) {
            // This would be code to render the profile picture on the UI.
            // For simplicity, we're printing the file path.
            System.out.println("Profile picture file: " + file.getPath());
        }
    }


    public void displayPlayerDetails(Player player) {
        System.out.println("Player Name: " + player.getFirstName() + " " + player.getLastName());
        System.out.println("Position: " + player.getPosition());
        System.out.println("Number: " + player.getPlayerNum());
        System.out.println("Height: " + player.getHeight() + " cm");
        System.out.println("Weight: " + player.getWeight() + " kg");
        System.out.println("Age: " + player.getAge());
    }



    @Override
    public int getPlayerID() {
        return 0;
    }

    @Override
    public String getFirstName() {
        return "";
    }

    @Override
    public String getLastName() {
        return "";
    }

    @Override
    public String getProfilePicture() {
        return "";
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public String getPosition() {
        return "";
    }

    @Override
    public int getPlayerNum() {
        return 0;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public int getWeight() {
        return 0;
    }
}
