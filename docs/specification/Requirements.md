# Non-functional Requirements

## Open source

End-user will be able to see the source code and build the app locally using the documentation provided.

## Security

User date will be encrypted.

## Reliability

The app the have error handling capabilities.

# Player Performance Tracking

## Actors
1. ESPN's hidden API
2. End-user

## Use case goal
To allow end-users to be able to track the player performance data during a live game using ESPN’s hidden API.

## Primary Actor
The end-user will be the primary actor. Could be a fan or a coach.

## Preconditions
1. ESPN API must be connected to the application
2. The user must have access to the application
3. the game being tracked must ne ongoing or a finished game
   
## Basic flow
1. The user will selects a game they want to track in the application.
2. The application sends a request to ESPN’s hidden API for player performance data.
3. The API retrieves and sends back the data of the player like goals and assists.
4. The application displays the data requested by user.

## Alternative flows

### Alternative flow 1
If the game the user requested has ended, the app will display past records including the recently concluded game.

### Alternative flow 2
If ESPN API is not available, the application will display a message that says "Temporarily unavailable, please try again".

# Match Streaming Resources

## Actors
1. End-user
4. Youtube API
5. ESPN's hidden API

## Use case goal

## Primary Actor

## Preconditions

## Basic flow

## Alternative flows

### Alternative flow 1

### Alternative flow 2

# Sports News Feed

## Actors
1. End-user
2. Google API
3. Facebook API
4. Youtube API
5. ESPN's hidden API

## Use case goal
The goal is to provide the user with real-time sport news feed from the above APIs.
## Primary Actor
End-user(sport fan)

## Preconditions
1. User has internet access
2. All API are accessible and functional
3. User should be logged in
   
## Basic flow
1. The user accesses the sports news feed. (Logs in if required)
2. The system gathers sports news articles, live sports data, video highlights from APIs
3. The sports news feed displays a combination of news articles, social media posts, videos, and live scores/stats in an organized manner for the user.

## Alternative flows

### Alternative flow 1
The end user could customize their feed to display news about their favorite players and sport.

### Alternative flow 2
If a particular API is not functioning, the system detects it and let the user know while displaying other available content from other APIs

# User Authentication System

## Actors
1. End-user
2. Google API
3. Facebook API
4. Youtube API
5. ESPN's hidden API

## Use case goal
Allow users to securely access the application by verifying their identity through a login process, ensuring authorized access to personalized features and data within the system.
## Primary Actor
End-user
## Preconditions
None
## Basic flow
1. The user opens the application and navigates to the login page.
2. The user inputs their username/email and password.
3. The system checks if the entered credentials are valid.
4. If credentials match a registered user, then the system creates a session and grants access.
## invalid credentials
1. If credentials are invalid, an error message is displayed (e.g., "Invalid username or password").
2. The application database logs the authentication event for security and audit purposes.
### Forgotten Password
1. The user selects the "Forgot Password" link on the login page.
2. The app prompts the user to enter their registered email or username.
3. The system sends a password reset email (or SMS) with a secure reset link to the user’s registered email or phone.
4. The user opens the email and clicks on the provided link, which directs them to a secure password reset page
5. The user provides and confirms a new password
6. Upon successful entry, the system updates the password and confirms the reset.

# Social Features

## Actors
1. End-user
2. Facebook API
3. Youtube API


## Use case goal

## Primary Actor

## Preconditions

## Basic flow

## Alternative flows

### Alternative flow 1

### Alternative flow 2

# Ticket Purchasing

## Actors
1. End-user
2. Google API
3. Youtube API
4. Ticketmaster API



## Use case goal

## Primary Actor

## Preconditions

## Basic flow

## Alternative flows

### Alternative flow 1

### Alternative flow 2
