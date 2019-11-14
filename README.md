Ball-ieve in your speed
==============================
##Team: Rebekah Hale, Kat Sotelo, Zac Foteff

#Project Description
To play 1v1 with another person in a game that requires little skill and a lot of speed. Anyone can play this game 
because there is no outside knowledge that is needed. Stakeholders interested in this project would be people who like 
visual simple games, or app development companies for small indie games. We are also stakeholders in the project as we 
are invested in completing it for the final presentation to have a fun, simple and engaging game. Sources needed for 
this project will be based off of the new concepts like sound 
(https://docs.oracle.com/javase/8/docs/api/index.html?javax/sound/sampled/package-summary.html), the timer 
(https://docs.oracle.com/javase/tutorial/uiswing/misc/timer.html), and key listener 
(https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html). 
The impact is to make a fun and simple game, that anybody can play to pass the time. There can be a competitive aspect 
to it, or just a fun game to the finish. 

#Implementation


#Use
1. Message modal opens up on two different screens and prompts the users on each screen to enter their names.
1. Once the users have entered their names, a confirmation modal appears asking the users if they are ready to play
 the game.
1. Once both players select that they are ready, the game screen will appear with player 1 and player 2’s stats.
1. The screen will also display two characters one for each player.
1. On the screen there will be a countdown from 3 to signal to the users that the game is starting.
1. At zero the players will repeatedly press the spacebar to advance their character to the opposite players screen. 
1. After one user has “knocked” the other user off the screen they have won the game.
1. The game will then prompt both users if they want to play again.
1. If the user selects yes the game will start again, whereas if the user selects no the game will close.


# Databases and Libraries implemented
Database structures that we will be using is excel or SQL.We will use excel/ SQL to store the highest score of all the 
games played. The library dependencies that we have been using to think we will implement Package javax.sound.sampled, 
javafx.animation.Animation, java.util.Arrays, java.util.Scanner, java.util.Random, and public interface KeyListener, 
and java.util.Timer. New GUI topics for the project we will implement simple animation for our clicker game, making it 
seem like two dogs are flying at each other and trying to knock the other off the screen. We will also implement 
keyboard listeners so that when the user presses the spacebar the dog will move slightly to the other side. When the 
spacebar is also pressed the dog will make a loving fun sound.

#Project Demo and Description
This app allows two computers to connect over a socket connection to play a competitive clicker game. The main game loop 
consists of players pressing their spacebar as fast as they can to try and move their token to the other side of the 
bar. Every space button press moves a player’s token forward one unit, but for every opposing player’s spacebar press 
the player’s token moves back one unit and the opponent’s moves forward one unit. The game is a virtual form of 
tug-of-war, ultimately the winner will come down to whoever can press their spacebar faster and overwhelm their 
opponent. Users will be able to connect to a server with their name and after another player connects to the same ip and 
port, the game will begin. After the game is over, if one of the players defeated the other players in a good time, they 
will be prompted to enter their name and their time into a high score list. By the mid project-demo, we will have a 
program which allows two players to connect to the same host, and have the same game display on their screens. To 
achieve this, we will have to create a socket connection between the two players and the host, display a GUI that is 
visually identical to each player, and display some sort of notification that both players have connected to each other 
and the game is ready to play.