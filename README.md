## Tank Fighter
A Java Implementation of classic Tank Fighter game

Scaffolding for the project has been generated using maven quickstart archetype

```
mvn archetype:generate \
  -DarchetypeArtifactId=maven-archetype-quickstart
  -DgroupId=in.shabhushan.tankfighter \
  -DartifactId=tank-fighter \
  -Dversion=1.0-SNAPSHOT
```

## Run Instructions
There are multiple ways to run the game.
### Run on Terminal
First, we need to compile the game and then we could run it on terminal
> `mvn compile && mvn exec:java -D exec.mainClass="in.shabhushan.tankfighter.game.TankFighter"`

Here, `in.shabhushan.tankfighter.game.TankFighter` is the Main class.

### Run with install phase
run `mvn install` to run game with install phase.

### Run with profile
run `mvn compile -P run-game` to run game via maven profile.


This will start a new window, where game could be started using `New Game` button.

## Pre-requisite
- Java-8

## Game Screenshot
The player is on bottom left corner. 

Enemy Player tanks have a health bar on top and are moving towards the player tank.

![Game Screenshot](http://shabhushan.in/blog/wp-content/uploads/2019/07/TankFighterScreenshot.png)

## Contributions
Contributions are wholehearted welcome. Please provide a brief description of the change along with Contributions. :) 
Enjoy.
