## Tank Fighter
A Java Implementation of classic Tank Fighter game, deployable on an OSGi Container.

Project has been created using Maven PAX Plugin.

```
mvn org.ops4j:maven-pax-plugin:create-project \
  -DgroupId=in.shabhushan.tankfighter \
  -DartifactId=tank-fighter \
  -Dversion=1.0-SNAPSHOT
```

The bundle is deployed on a felix container.

## Installation Instructions
To build the project run `mvn clean install`. It will download all the project Dependencies. 

To initialize the felix container and deploy project to felix container run `mvn pax:provision` 

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
