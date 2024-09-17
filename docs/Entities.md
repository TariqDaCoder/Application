
# Entities in the Sports App

## 1. **UserInfo**
   - **Description**: Stores information about users registered in the app.
   - **Attributes**:
     - `user_id`: Unique identifier for each user.
     - `firstName`: The user's first name.
     - `lastName`: The user's last name.
     - `email`: The user's email address for login and notifications.
     - `password`: The encrypted password for user authentication.
     - `friendList`: A list of user IDs representing the user's friends.
     - `profilePicture`: A link or path to the user's profile picture.

## 2. **Sports**
   - **Description**: Represents different sports that users can follow or engage with.
   - **Attributes**:
     - `sports_id`: Unique identifier for each sport.
     - `sportsName`: Name of the sport (e.g., Soccer, Basketball).

## 3. **SportsTeams**
   - **Description**: Contains information about sports teams participating in different sports.
   - **Attributes**:
     - `team_id`: Unique identifier for each team.
     - `teamName`: Name of the team.
     - `teamLogo`: The logo associated with the team.
     - `teamRecord`: The team's win-loss record.
     - `teamRoster`: List of player IDs associated with the team.

## 4. **Player**
   - **Description**: Represents individual players in various sports teams.
   - **Attributes**:
     - `player_id`: Unique identifier for each player.
     - `teamName`: Name of the team the player belongs to.
     - `profilePicture`: A link or path to the player's profile picture.
     - `firstName`: The player's first name.
     - `lastName`: The player's last name.
     - `playerNum`: The player's jersey number.
     - `position`: The player's position on the team (e.g., Forward, Goalkeeper).
     - `playerHeight`: The player's height.
     - `playerWeight`: The player's weight.

## 5. **PlayerGameStats**
   - **Description**: Captures a player's performance statistics in a game.
   - **Attributes**:
     - `team_id`: The ID of the team the player represents in the game.
     - `player_id`: The ID of the player.
     - `playerPoints`: Points scored by the player during the game.

## 6. **Game**
   - **Description**: Represents a scheduled game between two teams.
   - **Attributes**:
     - `game_id`: Unique identifier for each game.
     - `team_id`: The ID of the team that is associated with the game.
     - `team1`: The first team participating in the game.
     - `team2`: The second team participating in the game.
     - `gameTimer`: The duration or current time of the game.
     - `roundNum`: The round number or phase of the game.

## 7. **GameScores**
   - **Description**: Holds the score details of a game between two teams.
   - **Attributes**:
     - `team_id`: The ID of the team whose score is being tracked.
     - `game_id`: The ID of the game.
     - `team1Score`: Score of the first team.
     - `team2Score`: Score of the second team.

## 8. **GameStats**
   - **Description**: Captures overall game statistics such as team performance metrics.
   - **Attributes**:
     - `team_id`: The ID of the team in the game.
     - `game_id`: The ID of the game.
     - `teamName`: Name of the team.
     - `teamScore`: The final score of the team.
     - `teamPlusMinus`: A performance metric indicating the score differential while a particular team is on the field.
     - `Field`: Placeholder attributes for future statistical measures related to game performance.
