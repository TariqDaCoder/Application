package ApplicationView;

import ApplicationModel.User;

import java.util.List;
import java.util.Scanner;

//class which represent user view
public class UserView {
    private User user;

    public UserView(User user){
        this.user = user;
    }

    //method to print user info
    public void displayUserInfo(){
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Profile Picture: " + user.getProfilePicture());
        displayFriendList();
    }

    //method to display friend list
    private void displayFriendList(){
        List<User> friendsList = user.getFriendList();
        System.out.println("Friends: ");

        if (friendsList.isEmpty()){
            System.out.println("This user has not added any friends");
        } else{
            for (int i = 0; i < friendsList.size(); i++) {
                User friend = friendsList.get(i);
                System.out.println("- " + friend.getFirstName() + " " + friend.getLastName());
            }
        }
    }

    //method to update profile picture
    public void updateProfilePicture() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new profile picture URL or path: ");

        String newPicture = scanner.nextLine();
        try {
            user.setProfilePicture(newPicture);
            System.out.println("Profile picture updated successfully");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //method to add a friend
    public void addFriend() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Search User by ID: ");
        int friendUserId = scan.nextInt();
        scan.nextLine();

        // Lookup the friend by ID
        User friend = User.getUserById(friendUserId);
        if (friend != null) {
            user.addFriend(friend);
            System.out.println("Friend " + friend.getFirstName() + " " + friend.getLastName() + " added successfully.");
        } else {
            System.out.println("No user found with ID " + friendUserId + ".");
        }
    }


}
