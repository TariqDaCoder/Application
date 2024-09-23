package ApplicationModel;

import java.util.ArrayList;
import java.util.List;

public class User {
    //Attributes
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<User> friendList;
    private String profilePicture;

    //constructor
    public User(int userID, String firstName, String lastName, String email, String password, String profilePicture){
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
    }


}
