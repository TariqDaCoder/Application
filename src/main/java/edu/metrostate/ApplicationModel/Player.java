package edu.metrostate.ApplicationModel;

public interface Player{
    int getPlayerID();
    String getFirstName();
    String getLastName();
    String getProfilePicture();
    int getHeight();
    String getPosition();
    int getPlayerNum();
    int getAge();
    int getWeight();
}

class FootBallPlayer implements Player{
    private int playerID;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private int playerNum;
    private String team;
    private String position;
    private int height;
    private int weight;
    private int age;
    private int yearsActive;
    private String stats;


    public FootBallPlayer(int playerID, String firstName, String lastName, int playerNum, String team, String position,
                  int height, int weight, int age, int yearsActive,
                  String stats, String profilePicture) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNum = playerNum;
        this.team = team;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.yearsActive = yearsActive;
        this.stats = stats;
        this.profilePicture = profilePicture;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getTeam() {
        return playerNum;
    }

    public String getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int getYearsActive() {
        return yearsActive;
    }

    public String getStats() {
        return stats;
    }
}

class PlayerFilter {
    public static <T extends Player> LinkedNode<T> playerFilterListBySport(Player[] playerList, Class<T> playerType) {
        LinkedNode<T> head = null;
        LinkedNode<T> currNode = null;

        for (int i = 0; i < playerList.length; i++) {
            Player player = playerList[i];
            // Check if the person is an instance of the specified class type
            if (playerType.isInstance(player)) {
                // Cast the person to type T
                T playerTyped = (T) player;
                // Create a new LinkedNode for the filtered person with explicit type declaration
                LinkedNode<T> newNode = new LinkedNode<>(playerTyped, null);
                if (head == null) {
                    head = newNode; // Set head if it's the first node
                    currNode = head;
                } else {
                    currNode.setNext(newNode); // Link the new node
                    currNode = newNode;
                }
            }
        }
        return head; // Return the head of the linked list
    }
}

