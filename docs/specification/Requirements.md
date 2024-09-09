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

## Primary Actor

## Preconditions

## Basic flow

## Alternative flows

### Alternative flow 1

### Alternative flow 2

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
