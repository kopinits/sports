# Sportium

A simple SpringMVC application to "translate" sports results input into a json format

The development environment configuration was:

##JDK8 (jdk1.8.0_91)
##Apache Maven 3.3.9
##Tomcat (apache-tomcat-9.0.0.M9)

Usage Examples:

##Input: "F.C. Barcelona 3-2 Real Madrid"
##Output: { "teamAName": "F.C. Barcelona", "teamBName": "Real Madrid", "teamAScore": "3", "teamBScore": "2" }
 
##Input: Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko
##Output: { "teamAName": "Anna Karolina Schmiedlova", "teamBName": "Varvara Lepchenko", "teamAScore": "40", "teamBScore": "Adv", "teamAGames": "1", "teamBGames": "1", "teamBServing": true, "scoreboard": { "elements": [ { "title": "Sets", "teamAScore": "1", "teamBScore": "0" } ] } } 
 
##Input: Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter
##Output: { "teamAName": "Pittsburgh Steelers", "teamBName": "Minnesota Vikings", "teamAScore": "3", "teamBScore": "7", "currentPeriod": "3rd Quarter" }
