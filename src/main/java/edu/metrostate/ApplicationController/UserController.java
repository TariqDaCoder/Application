package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.User;
import edu.metrostate.ApplicationView.UserView;

public class UserController {

    //declare user model and view variable
    private User user;
    private UserView userView;

    public UserController(User user, UserView userView){
        this.user = user;
        this.userView = userView;
    }


}
