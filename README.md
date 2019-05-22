# RPG-fighter
Its a role playing game where in a fighter fights against all odds to enter the town. For this he has to kill the monster in order to obtain the silver ring after which guard will allow the player/fighter to enter the town 

### Technologies used :
- Java 8
- Junit
- Gradle
- Test Driven Development (TDD)

### How to run
- `./gradlew clean build`
- `java -jar build/libs/cli-rpg-fighter-1.0-SNAPSHOT.jar`
- Now you can choose appropriate actions/choice as available

### Code coverage
- 85% lines have been covered (It has been measured using Intellij built in plugin)

### Implementation details
- To save the current state of the game we are serializing the data in local file system
- Activity : This class is used to save & resume game info
- TownService : This is the first entry point to the town where you'll have different choices available to enter the town
- PlayerService : This service dedicated to user creation & related operation if required in near future
- ResumeService : This service is for resuming the game from where it was saved last
- Action : This is an interface implemented for the actions which user can take once he is on the town gate entry point
- Direction: This is also an interface implemented for the different direction that user may go while he is on the cross road
- FileStore - This class is used to serialize & deserialize the state of the game
- GameService - This service either starts or resume the game(if game was saved) based on user inputs

### Assumptions
- Game can be only be saved when the player is on the town entry point i.e. even if goes around the streets but in order to save he has to come back to town entry point
- Expecting user to enter only numeric while selecting choices

### Future scope
- Exception handling can be improved by using customized exceptions

