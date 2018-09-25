Project created using 
mvn org.ops4j:maven-pax-plugin:create-project \
  -DgroupId=in.shabhushan.tankfighter \
  -DartifactId=tank-fighter \
  -Dversion=1.0-SNAPSHOT
  
To build the project run below command:
mvn clean install 

To initialize the felix container and deploy project to felix container run below command:
mvn pax:provision 

To run the game, type below command in gogo shell of felix container:
tank:startGame
